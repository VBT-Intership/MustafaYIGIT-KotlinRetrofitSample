package com.mustafayigit.kotlinrestexample.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mustafayigit.kotlinrestexample.R
import com.mustafayigit.kotlinrestexample.adapter.HomeRecyclerAdapter
import com.mustafayigit.kotlinrestexample.data.ApiClient
import com.mustafayigit.kotlinrestexample.data.service.VersionService
import com.mustafayigit.kotlinrestexample.repository.VersionRepository
import com.mustafayigit.kotlinrestexample.util.Status
import com.mustafayigit.kotlinrestexample.util.extStartActivity
import com.mustafayigit.kotlinrestexample.viewmodel.HomeViewModel
import com.mustafayigit.kotlinrestexample.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = ApiClient.getClient().create(VersionService::class.java)
        val repository = VersionRepository(service)
        val viewModel = ViewModelFactory(repository).create(HomeViewModel::class.java)

        recyclerHome.adapter = HomeRecyclerAdapter {
            val bundle = Bundle().apply { putParcelable("version", it) }
            extStartActivity(EditActivity::class.java, bundle)
        }
        observeData(viewModel, recyclerHome.adapter as HomeRecyclerAdapter)

    }

    private fun observeData(
        viewModel: HomeViewModel,
        adapter: HomeRecyclerAdapter
    ) {
        viewModel.versionList.observe(this, {
            when (it.status) {
                Status.LOADING -> {
                    Log.i("TAG", "observeData - loading: ${it.status}")
                    setVisibility(View.GONE, View.VISIBLE, View.GONE)
                }
                Status.ERROR -> {
                    Log.i("TAG", "observeData - error: ${it.message}")
                    txtErrorHome.text = it.message
                    setVisibility(View.VISIBLE, View.GONE, View.GONE)
                }
                Status.SUCCESS -> {
                    Log.i("TAG", "observeData - success: ${it.data}")
                    setVisibility(View.GONE, View.GONE, View.VISIBLE)
                    adapter.submitList(it.data)
                }
            }
        })
    }

    private fun setVisibility(txtError: Int, progressbar: Int, recyclerview: Int) {
        txtErrorHome.visibility = txtError
        progressHome.visibility = progressbar
        recyclerHome.visibility = recyclerview
    }
}
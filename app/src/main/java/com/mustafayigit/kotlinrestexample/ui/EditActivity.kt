package com.mustafayigit.kotlinrestexample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.mustafayigit.kotlinrestexample.R
import com.mustafayigit.kotlinrestexample.data.response.Version
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val targetVersion = intent.getBundleExtra("bundle")?.getParcelable<Version>("version")

        targetVersion?.let {
            txtVersionName.editText?.setText(it.name)
            txtVersionNumber.editText?.setText("${it.number}")
            Glide.with(this)
                .load(it.image)
                .into(imgVersionPhoto)
        }

    }
}
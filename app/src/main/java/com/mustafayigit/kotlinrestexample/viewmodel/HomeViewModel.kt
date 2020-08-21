package com.mustafayigit.kotlinrestexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafayigit.kotlinrestexample.data.response.Version
import com.mustafayigit.kotlinrestexample.repository.VersionRepository
import com.mustafayigit.kotlinrestexample.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: VersionRepository
) : ViewModel() {

    init {
        fetchVersion()
    }

    private val _versionList = MutableLiveData<Resource<List<Version>>>()
    val versionList: LiveData<Resource<List<Version>>> = _versionList

    fun fetchVersion() {
        viewModelScope.launch(Dispatchers.IO) {
            _versionList.postValue(Resource.Loading())
            try {
                val dataFromRemote = repository.getVersions()
                _versionList.postValue(Resource.Success(dataFromRemote))
            } catch (e: Exception) {
                _versionList.postValue(Resource.Error("Something went wrong :( $e"))
            }
        }
    }
}
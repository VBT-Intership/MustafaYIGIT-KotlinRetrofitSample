package com.mustafayigit.kotlinrestexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mustafayigit.kotlinrestexample.repository.VersionRepository

class ViewModelFactory(
    private val repository: VersionRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(repository) as T
            }
            else -> {
                throw IllegalArgumentException("Not Assignable Class!")
            }
        }
    }
}
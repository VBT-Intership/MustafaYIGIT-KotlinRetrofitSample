package com.mustafayigit.kotlinrestexample.data.service

import com.mustafayigit.kotlinrestexample.data.response.ResponseVersion
import retrofit2.http.GET

interface VersionService {

    @GET("/")
    fun getVersions(): ResponseVersion

}
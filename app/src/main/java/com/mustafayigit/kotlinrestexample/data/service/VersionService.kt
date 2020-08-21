package com.mustafayigit.kotlinrestexample.data.service

import com.mustafayigit.kotlinrestexample.data.response.Version
import retrofit2.http.GET

interface VersionService {

    @GET("/.json")
    suspend fun getVersions(): List<Version>


}
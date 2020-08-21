package com.mustafayigit.kotlinrestexample.repository

import com.mustafayigit.kotlinrestexample.data.service.VersionService

class VersionRepository(
    private val service: VersionService
) {

    suspend fun getVersions() = service.getVersions()

}
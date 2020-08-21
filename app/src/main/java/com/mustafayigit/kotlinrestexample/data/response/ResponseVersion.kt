package com.mustafayigit.kotlinrestexample.data.response


import com.google.gson.annotations.SerializedName

class ResponseVersion : ArrayList<ResponseVersion.Version>() {
    data class Version(
        @SerializedName("id")
        val id: String,
        @SerializedName("image")
        val image: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("number")
        val number: Double
    )
}
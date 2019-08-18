package com.example.testhci.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface NetworkAPI {
    @GET("/home")
    fun getHome() : Call<Response>
}
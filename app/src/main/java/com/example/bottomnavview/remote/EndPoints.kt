package com.example.bottomnavview.remote

import com.example.bottomnavview.model.Category
import com.example.bottomnavview.model.User
import com.example.bottomnavview.requests.SignUpRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface EndPoints {
    @POST("signup")
    suspend fun signUp(@Body signUpRequest : SignUpRequest) : Response<User>

    @GET("categories")
    suspend fun getCatagories() : Response<List<Category>>
}
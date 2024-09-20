package com.example.ameriabanktask.network


import com.example.ameriabanktask.data.UserDto
import com.example.ameriabanktask.data.UsersDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductDataSource {


    @GET("users/{username}")
    suspend fun getUserByName(@Path("username") name: String): Response<UserDto>


    @GET("users")
    suspend fun getAllUsers(): Response<UsersDto>



}
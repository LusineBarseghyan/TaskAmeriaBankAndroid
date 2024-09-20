package com.example.ameriabanktask.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UsersDto(
    @SerializedName("users")
    val users: List<UserDto>
) : Serializable

data class UserDto(
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("followers_url")
    val followers: Int,
    @SerializedName("following_url")
    val following: Int,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("gists_url")
    val gists: Int,
    @SerializedName("repos_url")
    val repository: Int,
    @SerializedName("received_events_url")
    val update: Int

) : Serializable

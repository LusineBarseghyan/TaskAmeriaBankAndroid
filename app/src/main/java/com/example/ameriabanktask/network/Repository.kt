package com.example.ameriabanktask.network

import com.example.ameriabanktask.data.UserDto
import com.example.ameriabanktask.data.UsersDto



interface Repository {

    suspend fun getUsers(resultCallback: ApiResultCallback<UsersDto>?)
    suspend fun getUserByName(resultCallback: ApiResultCallback<UserDto>?,name: String)

}

class RepositoryImplementation(private val dataSource: ProductDataSource) : Repository {


    override suspend fun getUsers(resultCallback: ApiResultCallback<UsersDto>?) {
        dataSource.getAllUsers()
    }

    override suspend fun getUserByName(resultCallback: ApiResultCallback<UserDto>?, name: String) {
       dataSource.getUserByName(name)
    }
}
package com.example.ameriabanktask.network

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ameriabanktask.data.UserDto
import com.example.ameriabanktask.data.UsersDto
import kotlinx.coroutines.launch


class UserProfileViewModel(private val repository: Repository) : ViewModel() {
    private val _userLiveData: MutableLiveData<UserDto?> = MutableLiveData()
    val userLiveData: LiveData<UserDto?>
        get() = _userLiveData

    private val _userErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val userErrorLiveData: LiveData<String?>
        get() = _userErrorLiveData

     fun getUserProfile(name:String) {
         viewModelScope.launch {
             repository.getUserByName(object : ApiResultCallback<UserDto> {
                 override fun onSuccess(response: UserDto) {
                     _userLiveData.value = response
                 }

             }, name)
         }


     }
}


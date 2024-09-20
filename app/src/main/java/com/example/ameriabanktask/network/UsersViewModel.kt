package com.example.ameriabanktask.network

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ameriabanktask.data.UserDto
import com.example.ameriabanktask.data.UsersDto
import kotlinx.coroutines.launch

class UsersViewModel(private val repository: Repository) : ViewModel() {
    private val _usersLiveData: MutableLiveData<List<UserDto>?> = MutableLiveData()
    val usersLiveData: LiveData<List<UserDto>?>
        get() = _usersLiveData

    private val _usersErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val userErrorLiveData: LiveData<String?>
        get() = _usersErrorLiveData

    fun getAllUser() {
        viewModelScope.launch {
            repository.getUsers(object : ApiResultCallback<UsersDto> {
                override fun onSuccess(response: UsersDto) {
                   _usersLiveData.value=response.users
                }

                @SuppressLint("SuspiciousIndentation")
                override fun onError(): Boolean {
                  _usersErrorLiveData.value="Error data"
                    return true
                }

            })
    }


}
}
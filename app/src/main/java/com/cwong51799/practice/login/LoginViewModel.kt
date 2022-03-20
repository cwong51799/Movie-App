package com.cwong51799.practice.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _liveEvent = MutableLiveData<LoginEvent>()
    val liveEvent : LiveData<LoginEvent> = _liveEvent


    fun handleLogin(username: String, password: String) {
        _liveEvent.postValue(LoginEvent.NavigateAfterSuccess(username))
    }

    sealed class LoginEvent {

        class NavigateAfterSuccess(val username: String) : LoginEvent()

    }



}
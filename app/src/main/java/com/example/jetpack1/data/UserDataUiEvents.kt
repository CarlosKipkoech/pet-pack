package com.example.jetpack1.data

sealed class UserDataUiEvents {
    data class userNameEntered(val name: String) : UserDataUiEvents()
    data class userPetSelected(val selection: String) : UserDataUiEvents()
}
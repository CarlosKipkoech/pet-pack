package com.example.jetpack1.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.jetpack1.data.UserDataUiEvents
import com.example.jetpack1.data.UserInputScreenState

class UserInputViewModel : ViewModel() {
    var uiState = mutableStateOf(UserInputScreenState())

    // perform actions based on the event by user on the UI

    fun onEvent(event: UserDataUiEvents) {

        when (event) {
            is UserDataUiEvents.userNameEntered -> {

                /** If the user enters a name, it updates the uiState by
                 * copying the current state
                 * and replacing the nameEntered field with the entered name. */

                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
            }

            is UserDataUiEvents.userPetSelected -> {  //user selects a pet

                uiState.value = uiState.value.copy(
                    petSelected = event.selection
                )
            }

        }

    }
}


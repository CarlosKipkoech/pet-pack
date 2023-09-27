package com.example.jetpack1.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.jetpack1.R
import com.example.jetpack1.data.UserDataUiEvents
import com.example.jetpack1.ui.theme.UserInputViewModel

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel) {
    Surface(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            TopBar("Hi there")

            TextComponent(textValue = "Let's Learn about You !", textSize = 24.sp)

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "The app will provide you a details page based on the details that you will provide",
                textSize = 16.sp
            )
            Spacer(modifier = Modifier.size(40.dp))
            TextComponent(textValue = "Name", textSize = 18.sp)
            Spacer(modifier = Modifier.size(5.dp))
            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(UserDataUiEvents.userNameEntered(it))
            })
            Spacer(modifier = Modifier.size(20.dp))
            TextComponent(textValue = "What do you Like", textSize = 18.sp)

            Row(modifier = Modifier.fillMaxWidth()) {

                AnimalCard(image = R.drawable.cat, animalSelected = {
                    userInputViewModel.onEvent(UserDataUiEvents.userPetSelected(it))
                }, selected = userInputViewModel.uiState.value.petSelected == "cat")
                AnimalCard(image = R.drawable.dog,animalSelected = {
                    userInputViewModel.onEvent(UserDataUiEvents.userPetSelected(it))
                }, selected = userInputViewModel.uiState.value.petSelected == "Dog")

            }
        }

    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(viewModel())
}

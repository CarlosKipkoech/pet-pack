package com.example.jetpack1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.jetpack1.screens.FunFactsNavGraph
import com.example.jetpack1.screens.UserInputScreen
import com.example.jetpack1.ui.theme.Jetpack1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack1Theme {
              FunFactsApp()
            }
        }
    }

    @Composable
    fun FunFactsApp(){
        // navigation
        FunFactsNavGraph()
    }



}


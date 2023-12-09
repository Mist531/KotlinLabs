package com.example.kotlinlabs.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.kotlinlabs.navigation.Screens
import com.example.kotlinlabs.ui.components.ButtonWithText

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onGoToLab: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Screens.LAB_SCREENS.forEach { screen ->
            ButtonWithText(
                text = screen.screenName,
                onClick = {
                    onGoToLab(screen.route)
                }
            )
        }
    }
}
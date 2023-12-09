package com.example.kotlinlabs.ui.screens.labs

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinlabs.ui.components.ButtonWithText
import com.example.kotlinlabs.ui.theme.KotlinLabsTheme

@Composable
fun LabSecondScreen(
    modifier: Modifier = Modifier,
    onGoBack: () -> Unit,
) {
    BackHandler(onBack = onGoBack)

    var textFieldValue by remember {
        mutableStateOf("")
    }

    var textValue by remember {
        mutableStateOf("")
    }

    fun saveText() {
        if (textFieldValue.isNotEmpty()) {
            textValue = textFieldValue
            textFieldValue = ""
        }
    }

    Column(
        modifier = modifier
            .imePadding()
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            space = 20.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "savingText = $textValue"
        )

        TextField(
            label = {
                Text(
                    text = "Enter text for saving"
                )
            },
            placeholder = {
                Text(
                    text = "Enter text"
                )
            },
            value = textFieldValue,
            onValueChange = { str ->
                textFieldValue = str
            }
        )

        ButtonWithText(
            onClick = ::saveText,
            text = "Save entering text"
        )
    }
}

@Preview
@Composable
fun PreviewLabSecondScreen() {
    KotlinLabsTheme {
        LabSecondScreen(
            onGoBack = {}
        )
    }
}
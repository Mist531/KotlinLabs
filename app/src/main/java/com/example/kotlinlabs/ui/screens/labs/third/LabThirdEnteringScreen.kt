package com.example.kotlinlabs.ui.screens.labs.third

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinlabs.ui.theme.KotlinLabsTheme

@Composable
fun LabThirdEnteringScreen(
    modifier: Modifier = Modifier,
    onGoScrollScreen: (Int) -> Unit,
    onGoBack: () -> Unit
) {
    BackHandler(onBack = onGoBack)

    var countValue by remember {
        mutableStateOf<Int?>(null)
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
        Button(
            onClick = {
                countValue?.let(onGoScrollScreen)
            }
        ) {
            Text(
                modifier = Modifier
                    .sizeIn(maxWidth = 200.dp),
                text = "Go to ScrollScreen\nOr you can press done button on you keyboard",
                textAlign = TextAlign.Center
            )
        }

        TextField(
            label = {
                Text(
                    text = "Enter count text"
                )
            },
            placeholder = {
                Text(
                    text = "Enter count"
                )
            },
            value = countValue?.toString() ?: "",
            onValueChange = { str ->
                countValue = str.toIntOrNull()
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    countValue?.let(onGoScrollScreen)
                }
            )
        )
    }
}

@Preview
@Composable
fun PreviewLabThirdEnteringScreen() {
    KotlinLabsTheme {
        LabThirdEnteringScreen(
            onGoScrollScreen = {},
            onGoBack = {}
        )
    }
}
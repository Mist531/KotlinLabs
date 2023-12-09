package com.example.kotlinlabs.ui.screens.labs

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinlabs.ui.components.ButtonWithText
import com.example.kotlinlabs.ui.theme.KotlinLabsTheme

@Composable
fun LabFirstScreen(
    modifier: Modifier = Modifier,
    onGoBack: () -> Unit,
) {
    BackHandler(onBack = onGoBack)

    val context = LocalContext.current

    fun doToast(text: String) {
        Toast.makeText(
            context,
            text,
            Toast.LENGTH_LONG
        ).show()
    }

    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ButtonWithText(
            onClick = {
                doToast(text = "Example Toast")
            },
            text = "Press Button for show Toast"
        )
    }
}

@Preview
@Composable
fun PreviewLabFirstScreen() {
    KotlinLabsTheme {
        LabFirstScreen(
            onGoBack = {}
        )
    }
}
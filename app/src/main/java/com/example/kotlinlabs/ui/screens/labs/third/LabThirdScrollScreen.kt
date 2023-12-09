package com.example.kotlinlabs.ui.screens.labs.third

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinlabs.ui.components.ButtonWithText
import com.example.kotlinlabs.ui.theme.KotlinLabsTheme

@Composable
fun LabThirdScrollScreen(
    modifier: Modifier = Modifier,
    countText: Int,
    onGoBack: () -> Unit,
) {
    BackHandler(onBack = onGoBack)

    Box(
        modifier = modifier
            .fillMaxSize(),
    ) {
        LazyColumn(
            modifier = modifier
                .align(Alignment.TopStart)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            items(
                count = countText + 1,
                key = { it }
            ) { index ->
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 20.dp,
                            vertical = 10.dp
                        ),
                    text = "Text number = $index",
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
            }
        }

        ButtonWithText(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(
                    horizontal = 20.dp,
                )
                .padding(
                    bottom = 20.dp
                )
                .fillMaxWidth(),
            onClick = onGoBack,
            text = "Go back"
        )
    }
}

@Preview
@Composable
fun PreviewLabThirdScrollScreen() {
    KotlinLabsTheme {
        LabThirdScrollScreen(
            countText = 100,
            onGoBack = {}
        )
    }
}
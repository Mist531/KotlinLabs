package com.example.kotlinlabs.navigation

sealed class Screens(
    val route: String,
    val screenName: String = ""
) {
    data object FirstLab : Screens(
        route = "first_lab",
        screenName = "First Lab"
    )

    data object SecondLab : Screens(
        route = "second_lab",
        screenName = "Second Lab"
    )

    data object ThirdLab : Screens(
        route = "third_lab",
        screenName = "Third Lab"
    ) {
        data object EnteringScreen : Screens(route = "third_lab_entering_screen")

        data object ScrollScreen : Screens(route = "third_lab_scroll_screen")
    }

    data object MainScreen : Screens(
        route = "main_screen",
        screenName = ""
    )

    companion object {
        const val KEY_COUNT_TEXT = "key_count_text"

        val LAB_SCREENS = listOf(
            FirstLab,
            SecondLab,
            ThirdLab
        )
    }
}
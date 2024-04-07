package com.example.ibustartup.data

sealed class Screens(val screen: String) {
    data object Home: Screens("Home")
    data object Startups: Screens("Startups")
    data object Friends: Screens("Friends")
    data object Activity: Screens("Activity")
    data object Investors: Screens("Investors")
}
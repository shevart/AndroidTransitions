package com.shevart.androidtransitions.util

import com.shevart.androidtransitions.R

const val longText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor" +
        " incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud " +
        "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure " +
        "dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
        "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit " +
        "anim id est laborum."

val stockImagesMap: Map<Int, Int> = HashMap<Int, Int>().apply {
    put(0, R.drawable.stock_bus_1)
    put(1, R.drawable.stock_bus_2)
    put(2, R.drawable.stock_bus_3)
    put(3, R.drawable.stock_bus_4)
    put(4, R.drawable.stock_bus_5)
    put(5, R.drawable.stock_bus_6)
    put(6, R.drawable.stock_bus_7)
}

val titlesList = listOf(
        "Important news",
        "Great news",
        "Uninteresting news",
        "Daily News",
        "Incredible news")
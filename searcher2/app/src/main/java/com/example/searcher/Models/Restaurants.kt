package com.example.restaurantsearcher.Models

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class Restaurants(
    @StringRes val name: Int,
    @StringRes val Description: Int,
    @IntegerRes val cost: Int,
    @StringRes val rating: Int,
    @DrawableRes val imageResourceId: Int
)
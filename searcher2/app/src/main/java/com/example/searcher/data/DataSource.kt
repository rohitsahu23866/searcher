package com.example.restaurantsearcher.data

import com.example.restaurantsearcher.Models.Restaurants
import com.example.searcher.R

class DataSource() {
    fun loadRestaurants(): List<Restaurants> {
        return listOf<Restaurants> (
            Restaurants(R.string.download,R.string.download_Description,R.integer.download_cost,R.string.download_rating, R.drawable.download),
            )
    }
}
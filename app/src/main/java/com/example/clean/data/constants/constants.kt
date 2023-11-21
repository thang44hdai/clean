package com.example.clean.data.constants

import com.example.clean.domain.entities.Page


class constants {
    companion object {
        val link: String = "https://newsapi.org/v2/everything?q=Apple&from=2023-11-21&sortBy=popularity&apiKey="
        val api_key: String = "b57bf1ebd5f04ad58934ab3ba6316401"
        var page = Page("", "", "")
    }
}
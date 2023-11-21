package com.example.clean.data.api

data class news(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
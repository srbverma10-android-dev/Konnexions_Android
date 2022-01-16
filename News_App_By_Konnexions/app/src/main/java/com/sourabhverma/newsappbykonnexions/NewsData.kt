package com.sourabhverma.newsappbykonnexions

data class NewsData(
    val articles: ArrayList<Article>,
    val status: String,
    val totalResults: Int
)
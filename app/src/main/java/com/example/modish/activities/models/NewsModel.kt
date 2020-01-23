package com.example.modish.activities.models

class NewsModel{
    lateinit var newsTitle : String
    lateinit var newsDetails : String
    lateinit var newsImg : String

    constructor(newsTitle: String, newsDetails: String, newsImg: String) {
        this.newsTitle = newsTitle
        this.newsDetails = newsDetails
        this.newsImg = newsImg
    }
}
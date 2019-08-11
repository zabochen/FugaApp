package com.zabochen.data.network.model.random

import com.google.gson.annotations.SerializedName

// http://fucking-great-advice.ru/api/random

data class RandomAdviceResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("sound")
    val sound: String,
    @SerializedName("text")
    val text: String
)
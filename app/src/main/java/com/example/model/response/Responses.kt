package com.example.model.response

import com.google.gson.annotations.SerializedName

data class PhraseResponses(
    @SerializedName("author") val name: String,
    @SerializedName("quote") val phrase: String
)

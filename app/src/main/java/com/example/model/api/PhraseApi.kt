package com.example.model.api

import com.example.model.response.PhraseResponses
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class PhraseWebService {
    private lateinit var api: PhraseApi
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://programming-quotesapi.vercel.app/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(PhraseApi::class.java)

    }
    suspend fun getPhrases() : List<PhraseResponses> {
        return api.getPhrases()
    }
    interface PhraseApi {
        @GET("bulk")
        suspend fun getPhrases(): List<PhraseResponses>
    }
}
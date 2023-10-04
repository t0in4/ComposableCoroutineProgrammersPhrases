package com.example.model

import com.example.model.api.PhraseWebService
import com.example.model.response.PhraseResponses

class PhrasesRepository (private val webService: PhraseWebService = PhraseWebService()) {
    suspend fun getPhrases(): List<PhraseResponses> {
        return webService.getPhrases()
    }
}
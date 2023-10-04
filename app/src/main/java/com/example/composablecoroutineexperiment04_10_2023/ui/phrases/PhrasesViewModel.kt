package com.example.composablecoroutineexperiment04_10_2023.ui.phrases

import androidx.lifecycle.ViewModel
import com.example.model.PhrasesRepository
import com.example.model.response.PhraseResponses

class PhrasesViewModel(private val repository: PhrasesRepository = PhrasesRepository()) : ViewModel() {
    suspend fun getPhrases(): List<PhraseResponses> {
        return repository.getPhrases()
    }
}
package com.example.composablecoroutineexperiment04_10_2023.ui.phrases

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composablecoroutineexperiment04_10_2023.ui.theme.ComposableCoroutineExperiment04_10_2023Theme
import com.example.model.response.PhraseResponses
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhrasesListScreen()
        }
    }
}
@Composable
fun PhrasesListScreen() {
    val viewModel: PhrasesViewModel = viewModel()
    val rememberedPhrases: MutableState<List<PhraseResponses>> = remember {
        mutableStateOf(emptyList<PhraseResponses>())
    }
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = "GET_PHRASES"){
        coroutineScope.launch(Dispatchers.IO) {
           val phrases = viewModel.getPhrases()
           rememberedPhrases.value = phrases
        }
    }
    LazyColumn{
        items(rememberedPhrases.value) {
           phrase ->
           Text(phrase.phrase)
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposableCoroutineExperiment04_10_2023Theme {
        Greeting("Android")
    }
}
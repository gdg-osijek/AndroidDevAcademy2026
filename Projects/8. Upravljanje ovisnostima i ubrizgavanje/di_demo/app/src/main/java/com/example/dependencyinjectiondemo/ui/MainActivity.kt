package com.example.dependencyinjectiondemo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.dependencyinjectiondemo.data.repository.model.Country
import com.example.dependencyinjectiondemo.domain.viewmodel.CountriesViewModel
import com.example.dependencyinjectiondemo.ui.theme.DependencyInjectionDemoTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // TODO 5 - inject necessary components
            val viewModel = koinViewModel<CountriesViewModel>()
            val countries = viewModel.getAllCountries().collectAsState(emptyList()).value
            DependencyInjectionDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    Column(modifier = Modifier.padding(paddingValues)) {
                        ToolbarText()
                        CountriesGrid(countries = countries)
                    }
                }
            }
        }
    }
}

@Composable
fun ToolbarText(modifier: Modifier = Modifier) {
    Text(
        text = "All countries",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(start = 16.dp)
    )
}

@Composable
fun CountriesGrid(
    countries: List<Country>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 3),
        modifier = modifier,
    ) {
        items(countries) { country ->
            CountryCard(country = country, modifier = Modifier.padding(4.dp))
        }
    }
}

@Composable
fun CountryCard(
    country: Country,
    modifier: Modifier = Modifier
) {
    with(country) {
        Card(modifier = modifier) {
            AsyncImage(
                model = flagUrl,
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterHorizontally).size(40.dp)
            )
            Text(
                text = name,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp),
            )
        }
    }
}
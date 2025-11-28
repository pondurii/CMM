package org.example.cmm.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.example.cmm.viewmodel.HomeViewModel
import org.koin.compose.getKoin

@Composable
fun HomeScreen(){
    val viewModel: HomeViewModel = getKoin().get()
    val homeScreenState by viewModel.homeViewState.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getProducts()
    }
    when (homeScreenState) {
        is HomeViewModel.HomeScreenState.Loading -> {
            PiProgressIndicator()
        }
        is HomeViewModel.HomeScreenState.Success -> {
            val products = (homeScreenState as HomeViewModel.HomeScreenState.Success).responseData.list
            ProductCard(products)
        }
        is HomeViewModel.HomeScreenState.Error -> {
            //show Error
        }
    }
}
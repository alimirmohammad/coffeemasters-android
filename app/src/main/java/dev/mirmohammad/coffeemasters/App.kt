package dev.mirmohammad.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import dev.mirmohammad.coffeemasters.pages.InfoPage
import dev.mirmohammad.coffeemasters.pages.MenuPage
import dev.mirmohammad.coffeemasters.pages.OffersPage
import dev.mirmohammad.coffeemasters.pages.OrdersPage

@Composable
fun App(dataManager: DataManager) {
    val selectedRoute = remember {
        mutableStateOf(Routes.MenuPage.route)
    }
    Scaffold(topBar = {
        TopAppBar {
            AppTitle()
        }
    }, bottomBar = {
        NavBar(
            selectedRoute.value,
            onChange = { newRoute ->
                selectedRoute.value = newRoute
            })
    }) {
        when (selectedRoute.value) {
            Routes.MenuPage.route -> MenuPage(dataManager)
            Routes.OffersPage.route -> OffersPage()
            Routes.OrdersPage.route -> OrdersPage(dataManager)
            Routes.InfoPage.route -> InfoPage()
        }
    }
}

@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Coffee Masters Logo"
        )
    }
}
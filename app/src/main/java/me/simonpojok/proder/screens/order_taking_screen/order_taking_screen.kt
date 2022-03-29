package me.simonpojok.proder.screens.order_taking_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import me.simonpojok.proder.model.ProductUiModel
import me.simonpojok.proder.screens.components.Toolbar
import me.simonpojok.proder.screens.order_taking_screen.components.ProductListItem

val cartItems = listOf(
    ProductUiModel(
        id = 1,
        name = "Product 1",
        price = 1540
    ),
    ProductUiModel(
        id = 2,
        name = "Product 2",
        price = 1540
    ),
    ProductUiModel(
        id = 3,
        name = "Product 3",
        price = 1540
    ),
    ProductUiModel(
        id = 4,
        name = "Product 4",
        price = 1540
    )
)

@Composable
fun OrderTakingScreen(navController: NavHostController) {
    var products by remember { mutableStateOf(cartItems) }
    Scaffold(
        topBar = {
            Toolbar(
                onNavigationIconClicked = { navController.popBackStack() },
                title = "Take Order"
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(products.size) { index ->
                val product = products[index]
                Column {
                    Divider(
                        modifier = Modifier.padding(
                            bottom = 8.dp,
                            top = if (index == 0) 0.dp else 8.dp
                        )
                    )
                    ProductListItem(
                        name = product.name,
                        price = product.price,
                        count = product.count,
                        onIncreaseValue = {
                            products = products.map { item ->
                                if (product.id == item.id) {
                                    return@map item.copy(
                                        count = item.count + 1
                                    )
                                }
                                item
                            }
                        },
                        onDecreaseValue = {
                            products = products.map { item ->
                                if (product.id == item.id) {
                                    return@map item.copy(
                                        count = if (item.count > 1) item.count - 1 else 0
                                    )
                                }
                                item
                            }
                        }
                    )
                }

            }

        }
    }
}

@Preview
@Composable
fun OrderTakingScreenPreview() {
    OrderTakingScreen(navController = rememberNavController())
}
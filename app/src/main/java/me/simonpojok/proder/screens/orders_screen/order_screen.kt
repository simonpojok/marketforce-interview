package me.simonpojok.proder.screens.orders_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import me.simonpojok.proder.MainActivity
import me.simonpojok.proder.model.OrderUiModel
import me.simonpojok.proder.screens.Screen
import me.simonpojok.proder.screens.components.Toolbar
import me.simonpojok.proder.screens.orders_screen.components.OrderItem

val orders = listOf(
    OrderUiModel(
        key = 1,
        id = "xxxxxxx",
        customerName = "Customer Name",
        totalPrice = 450,
        dateTime = "dhdhhdhd",
        syncStatus = false
    ),
    OrderUiModel(
        key = 1,
        id = "xxxxxxx",
        customerName = "Customer Name",
        totalPrice = 450,
        dateTime = "dhdhhdhd",
        syncStatus = false
    ),
    OrderUiModel(
        key = 1,
        id = "xxxxxxx",
        customerName = "Customer Name",
        totalPrice = 450,
        dateTime = "dhdhhdhd",
        syncStatus = false
    ),
    OrderUiModel(
        key = 1,
        id = "xxxxxxx",
        customerName = "Customer Name",
        totalPrice = 450,
        dateTime = "dhdhhdhd",
        syncStatus = false
    ),
)

@Composable
fun OrderScreen(navController: NavHostController) {
    val context = LocalContext.current as MainActivity


    Scaffold(
        topBar = {
            Toolbar(
                onNavigationIconClicked = {},
                title = "Orders",
            ) { }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.OrderTakingScreen.name) },
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null, tint = Color.White)
            }
        }
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 12.dp)
                    .height(54.dp),
                color = Color.Black.copy(alpha = 0.05f)
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxSize(),
                    value = "",
                    onValueChange = { },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray,
                        focusedLabelColor = Color.Gray,
                        cursorColor = Color.Gray,
                        backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.3f)
                    ),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = null
                        )
                    },
                    placeholder = { Text(text = "Search") }
                )
            }

            LazyColumn(modifier = Modifier.padding(top = 20.dp).weight(3f)) {
                items(orders.size) { index ->
                    val order = orders[index]
                    Column {
                        Divider(
                            modifier = Modifier.padding(
                                bottom = 12.dp,
                                top = if (index == 0) 0.dp else 12.dp
                            )
                        )
                        OrderItem(orderItem = order)
                    }
                }
            }
        }
    }
}
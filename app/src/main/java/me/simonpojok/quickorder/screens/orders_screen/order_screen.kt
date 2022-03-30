package me.simonpojok.quickorder.screens.orders_screen

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import me.simonpojok.presentation.viewModel.OrdersViewModel
import me.simonpojok.quickorder.MainActivity
import me.simonpojok.quickorder.getUserName
import me.simonpojok.quickorder.saveUserName
import me.simonpojok.quickorder.screens.Screen
import me.simonpojok.quickorder.screens.components.Toolbar
import me.simonpojok.quickorder.screens.orders_screen.components.NameRequestDialog
import me.simonpojok.quickorder.screens.orders_screen.components.OrderItem
import me.simonpojok.quickorder.screens.orders_screen.components.UserGreedDialog

@Composable
fun OrderScreen(
    navController: NavHostController,
    viewModel: OrdersViewModel = hiltViewModel()
) {
    val context = LocalContext.current as MainActivity
    val orders = viewModel.orders.collectAsState(initial = emptyList())
    val ordersUi = orders.value.map { context.orderPresentationToUiMapper.toUi(it) }
        .sortedByDescending { order -> order.dateTime.toLong() }
    var name by remember { mutableStateOf(getUserName(context)) }
    var showGreeting by remember { mutableStateOf(false) }

    val isPresentGreetings = !context.mainViewModel.greetingAlreadyShown && showGreeting && (name.isNotBlank() || name.isNotEmpty())

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
        if (name.isBlank() || name.isBlank()) {
            NameRequestDialog {
                saveUserName(context, name)
                name = it
            }
        }

        if (isPresentGreetings) {
            UserGreedDialog(name) {
                context.mainViewModel.greetingAlreadyShown = true
                showGreeting = false
            }
        }

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

            LazyColumn(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .weight(3f)
            ) {

                items(ordersUi.size) { index ->
                    val order = ordersUi[index]
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

    LaunchedEffect(true) {
        delay(1000L)
        showGreeting = true
    }
}
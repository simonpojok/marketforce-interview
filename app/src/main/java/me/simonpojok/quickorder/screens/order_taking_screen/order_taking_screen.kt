package me.simonpojok.quickorder.screens.order_taking_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import me.simonpojok.presentation.viewModel.OrderTakingViewModel
import me.simonpojok.quickorder.MainActivity
import me.simonpojok.quickorder.model.OrderUiModel
import me.simonpojok.quickorder.model.ProductUiModel
import me.simonpojok.quickorder.screens.components.Toolbar
import me.simonpojok.quickorder.screens.order_taking_screen.components.ProductListItem
import me.simonpojok.quickorder.screens.order_taking_screen.components.RoundedCornerButton
import java.util.Date

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
fun OrderTakingScreen(
    navController: NavHostController,
    viewModel: OrderTakingViewModel = hiltViewModel()
) {
    val context = LocalContext.current as MainActivity
    var products by remember { mutableStateOf(cartItems) }
    var customerName by remember { mutableStateOf("") }

    val productsPrice = products.sumOf { product -> product.price * product.count }
    Scaffold(
        topBar = {
            Toolbar(
                onNavigationIconClicked = { navController.popBackStack() },
                title = "Take Order"
            )
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 12.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Customer Name", style = MaterialTheme.typography.h5.copy(
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                )

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .height(54.dp),
                    color = Color.Black.copy(alpha = 0.1f)
                ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxSize(),
                        value = customerName,
                        onValueChange = { customerName = it },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Gray,
                            unfocusedBorderColor = Color.Gray,
                            focusedLabelColor = Color.Gray,
                            cursorColor = Color.Gray,
                            backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.3f)
                        ),
                        placeholder = { Text(text = "Customer Name") }
                    )
                }

                Text(
                    text = "Products", style = MaterialTheme.typography.h5.copy(
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                )

            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f),
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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 12.dp)
            ) {
                Row {
                    Text(
                        modifier = Modifier.weight(2f),
                        text = "Total:",
                        style = MaterialTheme.typography.body1.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    )
                    Text(
                        text = "KES ${"%,d".format(productsPrice)}",
                        style = MaterialTheme.typography.body1.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    )
                }

                RoundedCornerButton(modifier = Modifier.padding(top = 16.dp)) {
                    if ((customerName.isEmpty() || customerName.isBlank()) && productsPrice == 0) {
                        context.displayMessage("Add Product and Provide Customer Name")
                    } else {
                        val timeStamp = Date().time
                        val orderUiModel = OrderUiModel(
                            customerName = customerName,
                            totalPrice = productsPrice,
                            dateTime = timeStamp.toString()
                        )
                        viewModel.createOrder(
                            order = context.orderUiToPresentationMapper.toPresentation(
                                orderUiModel
                            )
                        )
                        context.displayMessage("Order Added Successfully")
                        navController.popBackStack()
                    }
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
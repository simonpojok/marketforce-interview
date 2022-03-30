package me.simonpojok.quickorder.screens.orders_screen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.simonpojok.quickorder.model.OrderUiModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun OrderItem(
    orderItem: OrderUiModel
) {
    val dateFormat = SimpleDateFormat("dd MMM yyyy, HH:mm a", Locale.getDefault())

    val status = if (orderItem.syncStatus) "Synced" else "Pending"

    Row(
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.padding(horizontal = 12.dp), contentAlignment = Alignment.Center) {
            Canvas(modifier = Modifier
                .size(50.dp)
                .align(Alignment.Center), onDraw = {
                drawCircle(color = Color.Black.copy(alpha = 0.05f))
            })
            Icon(
                modifier = Modifier.size(30.dp),
                imageVector = Icons.Filled.AddShoppingCart,
                contentDescription = null,
                tint = Color.Gray
            )
        }

        Column(modifier = Modifier.weight(2f)) {
            Text(
                text = orderItem.customerName, style = MaterialTheme.typography.h4.copy(
                    fontSize = 18.sp
                )
            )
            Text(
                modifier = Modifier.padding(top = 2.dp),
                text = dateFormat.format(Date(orderItem.dateTime.toLong())),
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 15.sp,
                    color = Color.Gray
                )
            )
        }

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text(
                modifier = Modifier.padding(horizontal = 12.dp),
                text = "KES ${"%,d".format(orderItem.totalPrice)}",
                style = MaterialTheme.typography.h4.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                modifier = Modifier.padding(horizontal = 12.dp),
                text = status,
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 12.sp,
                    color = Color.LightGray,
                    fontStyle = FontStyle.Italic
                )
            )
        }


    }
}
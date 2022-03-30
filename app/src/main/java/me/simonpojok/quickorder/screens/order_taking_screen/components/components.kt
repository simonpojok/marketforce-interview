package me.simonpojok.quickorder.screens.order_taking_screen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductListItem(
    name: String,
    price: Int,
    count: Int,
    onIncreaseValue: () -> Unit = {},
    onDecreaseValue: () -> Unit = {},
) {
    Row(
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp),
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
                imageVector = Icons.Filled.ShoppingBag,
                contentDescription = null,
                tint = Color.Gray
            )
        }
        Column(modifier = Modifier.weight(2f)) {
            Text(
                text = name, style = MaterialTheme.typography.h4.copy(
                    fontSize = 18.sp
                )
            )
            Text(
                text = "KES, ${"%,d".format(price)}", style = MaterialTheme.typography.body1.copy(
                    fontSize = 15.sp,
                    color = Color.Gray
                )
            )
        }
        ProductValuePicker(
            onDecreaseValue = onDecreaseValue,
            onIncreaseValue = onIncreaseValue,
            value = count
        )
        Spacer(modifier = Modifier.padding(end = 12.dp))
    }
}

@Preview
@Composable
fun ProductListItemPreview() {
    ProductListItem(name = "Product 1", price = 1540, count = 0)
}

@Preview
@Composable
fun ProductValuePicker(
    value: Int = 0,
    onIncreaseValue: () -> Unit = {},
    onDecreaseValue: () -> Unit = {}
) {
    Row {
        ProductCountPicker(
            isEnabled = value > 0,
            buttonIcon = Icons.Filled.Remove,
            onClickedEvent = onDecreaseValue
        )
        Box(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .background(Color.Black.copy(alpha = 0.05f))
                .width(50.dp)
                .height(28.dp)
                .clip(RoundedCornerShape(100f)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "$value")
        }
        ProductCountPicker(
            buttonIcon = Icons.Filled.Add,
            onClickedEvent = onIncreaseValue,
            isEnabled = true
        )
    }
}

@Preview
@Composable
fun ProductCountPicker(
    buttonIcon: ImageVector = Icons.Filled.Remove,
    onClickedEvent: () -> Unit = {},
    isEnabled: Boolean = false
) {
    val buttonColor = if (isEnabled) Color.Black else Color.LightGray
    Row(
        modifier = Modifier
            .size(28.dp)
            .clip(CircleShape.copy(CornerSize(24.dp)))
            .clickable { onClickedEvent() }
    ) {
        Box(contentAlignment = Alignment.Center) {
            Canvas(modifier = Modifier
                .size(28.dp)
                .align(Alignment.Center), onDraw = {
                drawCircle(color = buttonColor)
            })
            Canvas(modifier = Modifier
                .size(24.dp)
                .align(Alignment.Center), onDraw = {
                drawCircle(color = Color.White)
            })

            Icon(imageVector = buttonIcon, contentDescription = null, tint = buttonColor)
        }
    }
}
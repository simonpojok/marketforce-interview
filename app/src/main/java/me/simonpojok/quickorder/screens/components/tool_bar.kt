package me.simonpojok.quickorder.screens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Toolbar(
    onNavigationIconClicked: (() -> Unit)? = null,
    title: String,
    isDoneShown: Boolean = false,
    onDoneClicked: () -> Unit = {}
) {
    TopAppBar(
        backgroundColor = Color.White,
        title = { Text(text = title, color = Color.Black) },
        navigationIcon = {
            if (onNavigationIconClicked != null) {
                Icon(
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .clickable { onNavigationIconClicked() },
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        },
        actions = {
            if (isDoneShown) {
                Icon(
                    imageVector = Icons.Rounded.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .clickable { onDoneClicked() }
                )
            }
        },
        elevation = 0.dp
    )
}

@Preview
@Composable
fun ToolbarPreview() {
    Toolbar(onNavigationIconClicked = {}, title = "App Name")
}
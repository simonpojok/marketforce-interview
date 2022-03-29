package me.simonpojok.proder.screens.orders_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import me.simonpojok.proder.MainActivity
import me.simonpojok.proder.getUserName
import me.simonpojok.proder.saveUserName
import me.simonpojok.proder.screens.Screen

@Composable
fun OrderScreen(navController: NavHostController) {
    val context = LocalContext.current as MainActivity
    var showUserNameDialog by remember {
        mutableStateOf(false)
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.OrderTakingScreen.name) },
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null)
            }
        }
    ) {

        if (showUserNameDialog) {
            SimpleAlertDialog { username ->
                saveUserName(context, username)
                showUserNameDialog = false
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Order Screen")
        }
    }

    LaunchedEffect(true) {
        val savedUserName = getUserName(context)
        if (savedUserName.isBlank() || savedUserName.isEmpty()) {
            showUserNameDialog = true
        }
    }
}

@Composable
fun SimpleAlertDialog(
    onSaveUserName: (String) -> Unit
) {
    val context = LocalContext.current as MainActivity
    var username by remember {
        mutableStateOf("")
    }

    fun validateAndSubmit() {
        if (username.isEmpty() || username.isBlank()) {
            context.displayMessage("Kindly provide name")
        } else {
            onSaveUserName(username)
        }
    }
    AlertDialog(
        onDismissRequest = { },
        confirmButton = {
            TextButton(onClick = {
                validateAndSubmit()
            })
            { Text(text = "OK") }
        },
        text = {
            Column {
                Text(
                    text = "Username", style = MaterialTheme.typography.h5.copy(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light
                    )
                )
                OutlinedTextField(
                    modifier = Modifier.padding(top = 8.dp),
                    value = username, onValueChange = { username = it })
            }
        }
    )
}
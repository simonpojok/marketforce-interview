package me.simonpojok.quickorder.screens.orders_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.simonpojok.quickorder.MainActivity

@Composable
fun NameRequestDialog( onHideDialog: (String) -> Unit) {
    val context = LocalContext.current as MainActivity
    var name by remember { mutableStateOf("") }
    AlertDialog(
        onDismissRequest = {
        },
        text = {
            Column(horizontalAlignment = Alignment.Start) {
                Text(text = "Dialog Title")
                OutlinedTextField(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth(),
                    value = name,
                    onValueChange = { name = it },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray,
                        focusedLabelColor = Color.Gray,
                        cursorColor = Color.Gray,
                        backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.3f)
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = null
                        )
                    },
                    placeholder = { Text(text = "Name") }
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (name.isBlank() || name.isBlank()) {
                        context.displayMessage("Please Provide Name")
                    } else {
                        onHideDialog(name)
                        context.displayMessage("Name saved successfully")
                    }

                }) {
                Text(text = "Save")
            }
        },
    )
}

@Composable
fun UserGreedDialog(userName: String, onHideDialog: () -> Unit) {
    AlertDialog(
        onDismissRequest = {
        },
        text = {
            Column {
                Text(text = "You Are Most Welcome", style = MaterialTheme.typography.body1.copy(
                    fontSize = 18.sp
                ))

                Text(text = "Hello ${userName}, Welcome Back to Product Orders, start by review your recently added order sorted by date", style = MaterialTheme.typography.body1.copy(
                    fontSize = 14.sp
                ),
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }
        },
        confirmButton = {
            TextButton(

                onClick = {
                    onHideDialog()
                }) {
                Text("Okay")
            }
        }
    )
}
package com.example.userapp.ui.presentations.users

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.userapp.model.User
import com.example.userapp.ui.presentations.composable.Avatar

/**
 * Composable function for displaying a detailed dialog of a user.
 * It takes a User object and a function to dismiss the dialog as parameters.
 * @param user The User object to be displayed.
 * @param onDismissRequest The function to be called when the dialog is dismissed.
 */
@Composable
fun DetailDialog(user: User, onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Surface(
            modifier = Modifier
                .padding(18.dp)
                .clip(RoundedCornerShape(8.dp)),
        ) {
            Column(
                modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center
            ) {
                Avatar(user.avatar)
                UserInformation(
                    user.email, user.firstName, user.lastName
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailDialogPreview() {
    DetailDialog(user = User(
        1, "John@gmail.com", "Doe", "Lawson", "https://reqres.in/img/faces/7-image.jpg"
    ), onDismissRequest = {})
}


package com.example.userapp.ui.presentations.users

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.userapp.R

/**
 * Composable function for displaying user information.
 * It takes an email, first name, last name, and a modifier as parameters.
 * @param email The email of the user.
 * @param firstName The first name of the user.
 * @param lastName The last name of the user.
 * @param modifier The modifier to be applied to the composable.
 */
@Composable
fun UserInformation(
    email: String,
    firstName: String,
    lastName: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "$firstName $lastName",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = email, style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun UserInformationPreview() {
    UserInformation(
        "John@gmail.com",
        "Doe",
        "Lawson"
    )
}
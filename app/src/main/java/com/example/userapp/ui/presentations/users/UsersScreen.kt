package com.example.userapp.ui.presentations.users

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.data.UiState
import com.example.domain.model.ResponseData
import com.example.domain.model.Support
import com.example.domain.model.User
import com.example.userapp.R
import com.example.userapp.ui.presentations.composable.Avatar
import com.example.userapp.ui.presentations.composable.MessageScreen
import com.example.userapp.ui.theme.UserAppTheme
import androidx.compose.ui.Modifier.Companion as Modifier1

@Composable
fun UsersScreen(
    viewModel: UsersViewModel = hiltViewModel(),
) {
    val uiStateUsers by remember { viewModel.uiStateUsers }.collectAsState()

    when (uiStateUsers) {
        is UiState.Loading -> {
            viewModel.getUsers()
            MessageScreen(
                message = R.string.loading, modifier = Modifier.fillMaxSize()
            )
        }

        is UiState.Success -> {
            UsersList(response = (uiStateUsers as UiState.Success<ResponseData>).data)
        }

        is UiState.Error -> MessageScreen(
            message = R.string.loading_failed, modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun UsersList(response: ResponseData) {
    val openAlertDialog = remember { mutableStateOf(false) }
    val userForDialog = remember { mutableStateOf(User(0, "", "", "", "")) }

    Scaffold { it ->
        LazyColumn(contentPadding = it) {
            itemsIndexed(response.data) { index, user ->
                UserItem(user = user, modifier = Modifier1.padding(8.dp), clickableItem = {
                    openAlertDialog.value = !openAlertDialog.value
                    userForDialog.value = user
                })
            }
        }
    }

    when {
        openAlertDialog.value -> {
            DetailDialog(userForDialog.value) {
                openAlertDialog.value = false
            }
        }
    }
}

@Composable
fun UserItem(
    user: User, modifier: Modifier = Modifier, clickableItem: () -> Unit
) {
    Surface(modifier = Modifier.clickable { clickableItem() }) {
        Card(modifier = modifier) {
            Column(modifier = Modifier1.fillMaxWidth()) {
                Row {
                    Avatar(user.avatar)
                    UserInformation(user.email, user.firstName, user.lastName)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UserAppTheme {
        UsersList(
            response = ResponseData(
                data = listOf(
                    User(
                        1,
                        "John@gmail.com",
                        "Doe",
                        "Lawson",
                        "https://reqres.in/img/faces/7-image.jpg"
                    )
                ), page = 1, perPage = 1, total = 1, totalPages = 1, support = Support(
                    "Support", "https://reqres.in/#support-heading"
                )
            )
        )
    }
}
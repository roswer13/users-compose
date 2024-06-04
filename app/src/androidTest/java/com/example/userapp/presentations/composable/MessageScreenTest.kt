package com.example.userapp.presentations.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.userapp.R
import com.example.userapp.ui.presentations.composable.MessageScreen
import org.junit.Rule
import org.junit.Test

class MessageScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Composable
    fun TestMessageScreen(message: Int, modifier: Modifier = Modifier) {
        MessageScreen(message = message, modifier = modifier.testTag("MessageText"))
    }

    @Test
    fun messageScreen_displaysCorrectMessage() {
        // Arrange
        val testMessageId = R.string.test_message
        var string = ""

        // Act
        composeTestRule.setContent {
            string = stringResource(id = testMessageId)
            TestMessageScreen(message = testMessageId)
        }

        // Assert
        composeTestRule.onNodeWithText(string).assertExists()
    }
}

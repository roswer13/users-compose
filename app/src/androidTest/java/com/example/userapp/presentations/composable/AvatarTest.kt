package com.example.userapp.presentations.composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.userapp.ui.presentations.composable.Avatar
import org.junit.Rule
import org.junit.Test

class AvatarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun avatar_isDisplayed() {
        // Arrange
        val avatarUrl = "https://www.example.com/avatar.jpg"
        val testTag = "AvatarTestTag"

        // Act
        composeTestRule.setContent {
            Avatar(
                avatar = avatarUrl,
                modifier = Modifier.testTag(testTag)
            )
        }

        // Assert
        composeTestRule.onNodeWithTag(testTag).assertIsDisplayed()
    }
}
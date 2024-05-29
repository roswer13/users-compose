package com.example.userapp.ui.presentations.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.userapp.R

/**
 * Composable function for displaying an avatar.
 * It takes a string URL of the avatar and a modifier as parameters.
 * @param avatar The string URL of the avatar to be displayed.
 * @param modifier The modifier to be applied to the avatar.
 */
@Composable
fun Avatar(avatar: String, modifier: Modifier = Modifier) {
    AsyncImage(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_small))
            .size(dimensionResource(R.dimen.image_size))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        placeholder = debugPlaceholder(R.drawable.ic_launcher_background),
        model = avatar,
        // Content Description is not needed here - image is decorative, and setting a null content
        // description allows accessibility services to skip this element during navigation.
        contentDescription = null
    )
}

@Preview(showBackground = true)
@Composable
fun AvatarPreview() {
    Avatar("https://www.example.com/avatar.jpg")
}
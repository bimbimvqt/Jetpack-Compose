package com.loc.newsapp.onboarding;

import androidx.annotation.DrawableRes
import com.example.testapp.android.R


data class Page(
    val title: String,
    val content: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf(
    Page(
        title = "Page 1",
        content = "Content 1",
        image = R.drawable.onboarding1,
        description = "Note that you should always use the lambda parameter and reflect it to the content. The API uses this value as the key to identify the content that's currently shown.",
    ),
    Page(
        title = "Page 2",
        content = "Content 2",
        image = R.drawable.onboarding2,
        description = "Note that you should always use the lambda parameter and reflect it to the content. The API uses this value as the key to identify the content that's currently shown",
    ),
    Page(
        title = "Page 3",
        content = "Content 3",
        image = R.drawable.onboarding3,
        description = "Crossfade animates between two layouts with a crossfade animation. By toggling the value passed to the current parameter, the content is switched with a crossfade animation.",
    ),
)
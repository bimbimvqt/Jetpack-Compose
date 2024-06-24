package com.loc.newsapp.onboarding

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.loc.newsapp.onboarding.components.OnBoardingPage
import com.loc.newsapp.onboarding.components.PageIndicator
import com.loc.newsapp.presentation.common.NewButton
import com.loc.newsapp.presentation.common.NewsTextButton
import kotlinx.coroutines.launch

@SuppressLint("RememberReturnType")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val pageState = rememberPagerState(initialPage = 0) {
            pages.size
        }
        val buttonState = remember {
            derivedStateOf {
                when (pageState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }
        HorizontalPager(state = pageState) { index ->
            OnBoardingPage(
                page = pages[index],
            )

        }
        Spacer(modifier = Modifier.weight(10f))

        Spacer(modifier = Modifier.weight(1f))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val scope = rememberCoroutineScope()
            Spacer(modifier = Modifier.width(25.dp))
            PageIndicator(
                modifier = Modifier.width(50.dp),
                pageSize = pages.size,
                selectedPage = pageState.currentPage
            )
            Spacer(modifier = Modifier.weight(1f))
            if (buttonState.value[0].isNotEmpty()) {
                NewsTextButton(text = buttonState.value[0], onClick = {
                    scope.launch {
                        pageState.animateScrollToPage(page = pageState.currentPage - 1)
                    }
                }
                )
            }
            NewButton(text = buttonState.value[1], onClick = {
                scope.launch {
                    if (pageState.currentPage == 3) {
                        //TODO: Navigate to home screen
                    } else {
                        pageState.animateScrollToPage(page = pageState.currentPage + 1)
                    }
                }
            }
            )
            Spacer(modifier = Modifier.width(25.dp))
        }
        Spacer(modifier = Modifier.weight(15f))
    }
}
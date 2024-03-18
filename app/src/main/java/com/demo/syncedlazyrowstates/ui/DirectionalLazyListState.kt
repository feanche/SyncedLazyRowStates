package com.demo.syncedlazyrowstates.ui

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

internal class DirectionalLazyListState(
    private val lazyListState: LazyListState
) {

    private var positionX = lazyListState.firstVisibleItemScrollOffset
    private var visibleItem = lazyListState.firstVisibleItemIndex

    val scrollDirection by derivedStateOf {
        if (lazyListState.isScrollInProgress.not()) {
            HorizontalScrollDirection.None
        } else {
            val firstVisibleItemIndex = lazyListState.firstVisibleItemIndex
            val firstVisibleItemScrollOffset = lazyListState.firstVisibleItemScrollOffset

            if (firstVisibleItemIndex == visibleItem) {
                val direction =
                    if (firstVisibleItemScrollOffset > positionX) HorizontalScrollDirection.Right
                    else HorizontalScrollDirection.Left
                positionX = firstVisibleItemScrollOffset
                direction
            } else {
                val direction =
                    if (firstVisibleItemIndex > visibleItem) HorizontalScrollDirection.Right
                    else HorizontalScrollDirection.Left
                positionX = firstVisibleItemScrollOffset
                visibleItem = firstVisibleItemIndex
                direction
            }
        }
    }
}

internal enum class HorizontalScrollDirection {
    Left, Right, None
}

@Composable
internal fun rememberDirectionalLazyListState(
    lazyListState: LazyListState
): DirectionalLazyListState = remember {
    DirectionalLazyListState(lazyListState)
}
package com.demo.syncedlazyrowstates.ui

import androidx.compose.runtime.compositionLocalOf

internal val LocalHorizontalLazyRowInfo = compositionLocalOf {
    HorizontalLazyRowInfo()
}

internal class HorizontalLazyRowInfo
package com.demo.syncedlazyrowstates.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.syncedlazyrowstates.ui.theme.PurpleGrey80
import com.demo.syncedlazyrowstates.ui.theme.SyncedLazyRowStatesTheme

@Composable
internal fun Trip() {
    Box(
        modifier = Modifier
            .height(180.dp)
            .width(300.dp)
            .background(color = PurpleGrey80)
    )
}

@Preview(showBackground = false)
@Composable
private fun TripPreview() {
    SyncedLazyRowStatesTheme {
        Trip()
    }
}
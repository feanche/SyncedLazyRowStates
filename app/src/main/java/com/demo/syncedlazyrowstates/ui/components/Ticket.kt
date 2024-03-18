package com.demo.syncedlazyrowstates.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.syncedlazyrowstates.ui.theme.Purple80
import com.demo.syncedlazyrowstates.ui.theme.SyncedLazyRowStatesTheme

@Composable
internal fun Ticket() {
    Box(
        modifier = Modifier
            .height(180.dp)
            .width(300.dp)
            .background(
                color = Purple80,
                shape = RoundedCornerShape(16.dp)
            )
    )
}

@Preview(showBackground = false)
@Composable
private fun TicketPreview() {
    SyncedLazyRowStatesTheme {
        Ticket()
    }
}
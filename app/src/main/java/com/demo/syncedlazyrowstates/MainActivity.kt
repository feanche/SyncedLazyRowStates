package com.demo.syncedlazyrowstates

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.demo.syncedlazyrowstates.ui.HorizontalLazyRowInfo
import com.demo.syncedlazyrowstates.ui.LocalHorizontalLazyRowInfo
import com.demo.syncedlazyrowstates.ui.rememberDirectionalLazyListState
import com.demo.syncedlazyrowstates.ui.theme.SyncedLazyRowStatesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SyncedLazyRowStatesTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
private fun Greeting() {

    val horizontalLazyRowInfo = remember {
        HorizontalLazyRowInfo()
    }

    val ticketListState = rememberLazyListState()
    val tripListState = rememberLazyListState()

    val ticketFirstVisibleItemOffsetState by remember {
        derivedStateOf {
            ticketListState.firstVisibleItemScrollOffset
        }
    }

    val tripFirstVisibleItemOffsetState by remember {
        derivedStateOf {
            tripListState.firstVisibleItemScrollOffset
        }
    }

    val ticketScrollDirection = rememberDirectionalLazyListState(ticketListState)
    val tripScrollDirection = rememberDirectionalLazyListState(tripListState)

    CompositionLocalProvider(
        value = LocalHorizontalLazyRowInfo provides horizontalLazyRowInfo
    ) {}
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    SyncedLazyRowStatesTheme {
        Greeting()
    }
}
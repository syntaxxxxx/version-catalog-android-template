package com.hightech.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hightech.designsystem.VersionCatalogAndroidTemplateTheme

@Composable
internal fun WatchListRoute(onButtonClick: () -> Unit) {
    WatchListScreen(onButtonClick = onButtonClick)
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun WatchListScreen(onButtonClick: () -> Unit) {
    Button(onClick = {
        onButtonClick()
        Log.d("WatchListScreen", "Event click listener")
    }) {
        Text("Navigate to detail")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun WatchListScreen(
    items: List<String>, onSave: (name: String) -> Unit, modifier: Modifier = Modifier
) {
    Column(modifier) {
        var nameMyModel by remember { mutableStateOf("Compose") }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(value = nameMyModel, onValueChange = { nameMyModel = it })

            Button(modifier = Modifier.width(96.dp), onClick = { onSave(nameMyModel) }) {
                Text("Save")
            }
        }
        items.forEach {
            Text("Saved item: $it")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    VersionCatalogAndroidTemplateTheme {
        WatchListScreen(listOf("Compose", "Room", "Kotlin"), onSave = {})
    }
}

@Preview(showBackground = true, widthDp = 480)
@Composable
private fun PortraitPreview() {
    VersionCatalogAndroidTemplateTheme {
        WatchListScreen(listOf("Compose", "Room", "Kotlin"), onSave = {})
    }
}
package com.hightech.versioncatalogtemplate.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector

enum class TopLevelDestination(
    val selectedIcon: ImageVector, val unselectedIcon: ImageVector, val iconTextId: String, val titleTextId: String
) {
    WATCH_LIST(
        selectedIcon = Icons.Filled.List,
        unselectedIcon = Icons.Filled.List,
        iconTextId = "Watch List",
        titleTextId = "Watch List",
    ),

    BOOKMARKS(
        selectedIcon = Icons.Filled.Favorite,
        unselectedIcon = Icons.Filled.Favorite,
        iconTextId = "Saved",
        titleTextId = "Saved",
    )
}
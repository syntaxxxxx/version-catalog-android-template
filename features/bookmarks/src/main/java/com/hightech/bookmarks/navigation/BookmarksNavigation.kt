package com.hightech.bookmarks.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.hightech.bookmarks.BookmarksRoute

const val bookmarksRoute = "bookmarks_route"

fun NavController.navigateToBookmarks(navOptions: NavOptions? = null) {
    this.navigate(bookmarksRoute, navOptions)
}

fun NavGraphBuilder.bookmarksScreen() {
    composable(route = bookmarksRoute) {
        BookmarksRoute()
    }
}
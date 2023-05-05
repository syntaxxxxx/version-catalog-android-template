package com.hightech.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.hightech.ui.WatchListRoute

const val watchListDetailsRoute = "watch_list_details_route"

fun NavController.navigateToWatchListDetails(navOptions: NavOptions? = null) {
    this.navigate(watchListDetailsRoute, navOptions)
}

fun NavGraphBuilder.watchListDetailsScreen(
    onBackClick: () -> Unit,
    onButtonClick: () -> Unit,
) {
    composable(route = watchListDetailsRoute) {
        WatchListRoute(
            onBackClick = onBackClick,
            onButtonClick = onButtonClick
        )
    }
}
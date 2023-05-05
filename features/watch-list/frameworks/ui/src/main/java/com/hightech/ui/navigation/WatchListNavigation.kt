package com.hightech.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hightech.ui.WatchListRoute

const val watchListGraphRoute = "watch_list_graph_route"
const val watchListRoute = "watch_list_route"

fun NavController.navigateToWatchListGraph(navOptions: NavOptions? = null) {
    this.navigate(watchListGraphRoute, navOptions)
}

fun NavGraphBuilder.watchListGraph(
    onButtonClick: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation(
        route = watchListGraphRoute,
        startDestination = watchListRoute
    ) {
        composable(route = watchListRoute) {
            WatchListRoute(onButtonClick)
        }
        nestedGraphs()
    }
}
package com.hightech.versioncatalogtemplate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.hightech.bookmarks.navigation.navigateToBookmarks
import com.hightech.ui.navigation.navigateToWatchListGraph
import com.hightech.versioncatalogtemplate.navigation.TopLevelDestination

@Composable
fun rememberMainAppState(
    navHostController: NavHostController = rememberNavController()
): MainAppState {
    return remember(navHostController) {
        MainAppState(navHostController)
    }
}

@Stable
class MainAppState(val navHostController: NavHostController) {
    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    val currentDestination: NavDestination?
        @Composable get() = navHostController
            .currentBackStackEntryAsState().value?.destination

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (topLevelDestination) {
            TopLevelDestination.WATCH_LIST -> navHostController.navigateToWatchListGraph(topLevelNavOptions)
            TopLevelDestination.BOOKMARKS -> navHostController.navigateToBookmarks(topLevelNavOptions)
        }
    }
}
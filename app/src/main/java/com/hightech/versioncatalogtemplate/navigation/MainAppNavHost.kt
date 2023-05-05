package com.hightech.versioncatalogtemplate.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.hightech.bookmarks.navigation.bookmarksScreen
import com.hightech.ui.navigation.navigateToWatchListDetails
import com.hightech.ui.navigation.watchListDetailsScreen
import com.hightech.ui.navigation.watchListGraph
import com.hightech.ui.navigation.watchListGraphRoute
import com.hightech.versioncatalogtemplate.MainAppState

@Composable
fun MainAppNavHost(
    mainAppState: MainAppState,
    modifier: Modifier = Modifier,
    startDestination: String = watchListGraphRoute
) {
    val navController = mainAppState.navHostController
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        watchListGraph(
            onButtonClick = {
                println("onButtonClick fro navhost")
                navController.navigateToWatchListDetails()
            },
            nestedGraphs = {
                watchListDetailsScreen(
                    onBackClick = navController::popBackStack,
                    onButtonClick = {}
                )
            }
        )
        bookmarksScreen()
    }
}
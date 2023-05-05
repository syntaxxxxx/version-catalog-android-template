package com.hightech.versioncatalogtemplate

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.hightech.versioncatalogtemplate.navigation.MainAppNavHost
import com.hightech.versioncatalogtemplate.navigation.TopLevelDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(
    mainAppState: MainAppState = rememberMainAppState()
) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = { Text(text = "Streaming App") })
    }, bottomBar = {
        MainBottomBar(
            destinations = mainAppState.topLevelDestinations,
            onNavigateToDestination = mainAppState::navigateToTopLevelDestination,
            currentDestination = mainAppState.currentDestination
        )
    }) { paddingValues ->
        MainAppNavHost(
            mainAppState,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun MainBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?
) {
    NavigationBar {
        destinations.forEach { topLevelDestination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(topLevelDestination)
            NavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(topLevelDestination) },
                icon = {
                    val icon = if (selected) {
                        topLevelDestination.selectedIcon
                    } else {
                        topLevelDestination.unselectedIcon
                    }
                    Icon(icon, contentDescription = "")
                },
                label = { Text(topLevelDestination.iconTextId) }
            )
        }
    }

}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
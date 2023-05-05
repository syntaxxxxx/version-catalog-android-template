package com.hightech.presentation

import java.util.UUID

data class RemoteWatchListItem(
    val uuid: UUID
)

data class LocalWatchListItem(
    val uuid: UUID
)

data class WatchListItem(
    val uuid: UUID
)

// by feature per directory
// http/local
// domain
// presentation
// ui
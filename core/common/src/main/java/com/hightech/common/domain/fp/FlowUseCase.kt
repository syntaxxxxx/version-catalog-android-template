package com.hightech.common.domain.fp

import android.view.SurfaceControl
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getTransactions(): Flow<List<SurfaceControl.Transaction>>
}

fun getTransactions(
    repository: Repository
): Flow<List<SurfaceControl.Transaction>> {
    return repository.getTransactions()
}

typealias GetTransactionsUseCase = () -> Flow<List<SurfaceControl.Transaction>>
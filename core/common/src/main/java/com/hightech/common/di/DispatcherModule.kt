package com.hightech.common.di

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DispatcherModule {
    @Singleton
    @Binds
    abstract fun provideDispatcherProvider(dispatcherProviderImpl: DispatcherProviderImpl): DispatcherProvider
}
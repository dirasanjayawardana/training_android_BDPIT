package com.fazztrack.bcasyariah.di

import com.fazztrack.bcasyariah.data.Service
import com.fazztrack.bcasyariah.data.remote.MenuDashboardRemoteDataSource
import com.fazztrack.bcasyariah.data.remote.MenuDashboardRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MenuModule {

    @Singleton
    @Provides
    fun provideMenuDashboardRemoteDataSource(service: Service) : MenuDashboardRemoteDataSource {
        return MenuDashboardRemoteDataSourceImpl(service)
    }
}
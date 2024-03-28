package com.fazztrack.bcasyariah.data.remote

import com.fazztrack.bcasyariah.data.Service
import com.fazztrack.bcasyariah.model.MenuDashboardResponse
import retrofit2.Response
import javax.inject.Inject

class MenuDashboardRemoteDataSourceImpl @Inject constructor(val service: Service) : MenuDashboardRemoteDataSource {

    override suspend fun getMenuDashboard(): Response<MenuDashboardResponse> {
        return service.getHomeMenu()
    }
}
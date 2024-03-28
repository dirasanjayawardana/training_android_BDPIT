package com.fazztrack.bcasyariah.data.remote

import com.fazztrack.bcasyariah.model.MenuDashboardResponse
import retrofit2.Response

interface MenuDashboardRemoteDataSource {

    suspend fun getMenuDashboard() : Response<MenuDashboardResponse>
}
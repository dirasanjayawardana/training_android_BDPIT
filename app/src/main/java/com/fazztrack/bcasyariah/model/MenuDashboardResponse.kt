package com.fazztrack.bcasyariah.model

import com.google.gson.annotations.SerializedName

data class MenuDashboardResponse(
    @SerializedName("data")
    val data: List<MenuDashboard>
)

data class MenuDashboard(
    @SerializedName("imga")
    val imageMenu: String?,

    @SerializedName("name_menu")
    val nameMenu: String?
)
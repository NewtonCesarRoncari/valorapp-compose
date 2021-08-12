package com.nroncari.valorappcompose.data.service

import com.nroncari.valorappcompose.data.model.BaseModel
import com.nroncari.valorappcompose.data.model.WeaponResponse
import retrofit2.http.GET

interface WeaponService {

    @GET("weapons?language=pt-BR")
    suspend fun getWeapons(): BaseModel<List<WeaponResponse>>
}

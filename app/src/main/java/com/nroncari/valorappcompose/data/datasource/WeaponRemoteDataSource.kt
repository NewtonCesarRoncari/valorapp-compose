package com.nroncari.valorappcompose.data.datasource

import com.nroncari.valorappcompose.domain.model.WeaponDomain

interface WeaponRemoteDataSource {

    suspend fun getWeapons(): List<WeaponDomain>
}

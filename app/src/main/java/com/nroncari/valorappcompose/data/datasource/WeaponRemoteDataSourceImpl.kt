package com.nroncari.valorappcompose.data.datasource

import com.nroncari.valorappcompose.data.mapper.WeaponToDomainMapper
import com.nroncari.valorappcompose.data.service.WeaponService

class WeaponRemoteDataSourceImpl(
    private val service: WeaponService
) : WeaponRemoteDataSource {

    private val mapper = WeaponToDomainMapper()

    override suspend fun getWeapons() = mapper.map(service.getWeapons().data)
}

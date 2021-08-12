package com.nroncari.valorappcompose.data.repository

import com.nroncari.valorappcompose.domain.repository.WeaponRepository
import com.nroncari.valorappcompose.data.datasource.WeaponRemoteDataSource
import com.nroncari.valorappcompose.domain.mapper.WeaponToPresentationMapper

class WeaponRepositoryImpl(
    private val remoteDataSource: WeaponRemoteDataSource
) : WeaponRepository {

    private val mapper = WeaponToPresentationMapper()

    override suspend fun getListWeapon() = mapper.map(remoteDataSource.getWeapons())
}

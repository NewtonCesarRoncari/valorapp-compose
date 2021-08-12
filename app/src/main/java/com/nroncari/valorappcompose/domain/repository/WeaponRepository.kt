package com.nroncari.valorappcompose.domain.repository

import com.nroncari.valorappcompose.presentation.model.WeaponPresentation

interface WeaponRepository {

    suspend fun getListWeapon(): List<WeaponPresentation>
}

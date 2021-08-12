package com.nroncari.valorappcompose.domain.usecase

import com.nroncari.valorappcompose.domain.repository.WeaponRepository

class GetWeaponListUseCase(
    private val repository: WeaponRepository
) {

    suspend operator fun invoke() = repository.getListWeapon()
}

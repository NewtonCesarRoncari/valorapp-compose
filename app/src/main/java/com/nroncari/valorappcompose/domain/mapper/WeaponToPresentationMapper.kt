package com.nroncari.valorappcompose.domain.mapper

import com.nroncari.valorappcompose.domain.model.WeaponDomain
import com.nroncari.valorappcompose.presentation.model.WeaponPresentation
import com.nroncari.valorappcompose.presentation.model.WeaponSkinPresentation
import com.nroncari.valorappcompose.utils.Mapper

class WeaponToPresentationMapper : Mapper<List<WeaponDomain>, List<WeaponPresentation>> {

    override fun map(source: List<WeaponDomain>): List<WeaponPresentation> {
        return source.map { weaponDomain ->
            WeaponPresentation(
                weaponDomain.uuid,
                weaponDomain.displayName,
                weaponDomain.category,
                weaponDomain.defaultSkinUuid,
                weaponDomain.displayIcon,
                weaponDomain.assetPath,
                weaponDomain.skins.map { weaponSkinDomain ->
                    WeaponSkinPresentation(
                        weaponSkinDomain.uuid,
                        weaponSkinDomain.displayName,
                        weaponSkinDomain.themeUuid,
                        weaponSkinDomain.displayIcon,
                        weaponSkinDomain.assetPath
                    )
                }
            )
        }
    }
}

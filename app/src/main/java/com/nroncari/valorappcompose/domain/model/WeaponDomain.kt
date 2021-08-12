package com.nroncari.valorappcompose.domain.model

data class WeaponDomain(
    val uuid: String,
    val displayName: String,
    val category: String,
    val defaultSkinUuid: String,
    val displayIcon: String,
    val assetPath: String,
    val skins: List<WeaponSkinDomain>
)

data class WeaponSkinDomain(
    val uuid: String,
    val displayName: String,
    val themeUuid: String,
    val displayIcon: String,
    val assetPath: String,
)

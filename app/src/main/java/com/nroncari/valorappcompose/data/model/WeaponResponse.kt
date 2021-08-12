package com.nroncari.valorappcompose.data.model

data class WeaponResponse(
    val uuid: String,
    val displayName: String,
    val category: String,
    val defaultSkinUuid: String,
    val displayIcon: String,
    val assetPath: String,
    val skins: Array<WeaponSkinResponse>
)

data class WeaponSkinResponse(
    val uuid: String,
    val displayName: String,
    val themeUuid: String,
    val displayIcon: String?,
    val assetPath: String,
)

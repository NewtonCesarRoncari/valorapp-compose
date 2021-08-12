package com.nroncari.valorappcompose.presentation.model

data class WeaponPresentation(
    val uuid: String,
    val displayName: String,
    val category: String,
    val defaultSkinUuid: String,
    val displayIcon: String,
    val assetPath: String,
    val skins: List<WeaponSkinPresentation>
)

data class WeaponSkinPresentation(
    val uuid: String,
    val displayName: String,
    val themeUuid: String,
    val displayIcon: String,
    val assetPath: String,
)

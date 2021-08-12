package com.nroncari.valorappcompose.data.model

data class AgentResponse(
    val uuid: String,
    val displayName: String,
    val description: String,
    val developerName: String,
    val displayIcon: String,
    val bustPortrait: String? = "",
    val fullPortrait: String?,
    val isFullPortraitRightFacing: Boolean,
    val killfeedPortrait: String?,
    val isPlayableCharacter: Boolean,
    val isAvailableForTest: Boolean,
    val role: AgentRoleResponse?,
    val abilities: Array<AgentAbilityResponse>
)

data class AgentRoleResponse(
    val uuid: String,
    val displayName: String,
    val description: String,
    val displayIcon: String,
    val assetPath: String
)

data class AgentAbilityResponse(
    val slot: String,
    val displayName: String?,
    val description: String?,
    val displayIcon: String?
)

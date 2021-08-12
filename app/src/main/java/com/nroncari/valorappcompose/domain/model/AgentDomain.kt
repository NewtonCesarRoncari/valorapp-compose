package com.nroncari.valorappcompose.domain.model

data class AgentDomain(
    val uuid: String,
    val displayName: String,
    val description: String,
    val developerName: String,
    val displayIcon: String,
    val bustPortrait: String?,
    val fullPortrait: String?,
    val killfeedPortrait: String?,
    val isFullPortraitRightFacing: Boolean,
    val isPlayableCharacter: Boolean,
    val isAvailableForTest: Boolean,
    val role: AgentRoleDomain?,
    val abilities: List<AgentAbilityDomain>
)

data class AgentRoleDomain(
    val uuid: String,
    val displayName: String,
    val description: String,
    val displayIcon: String,
    val assetPath: String
)

data class AgentAbilityDomain(
    val slot: String,
    val displayName: String?,
    val description: String?,
    val displayIcon: String?
)

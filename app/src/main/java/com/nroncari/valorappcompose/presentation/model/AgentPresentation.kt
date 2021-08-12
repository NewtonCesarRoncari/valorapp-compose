package com.nroncari.valorappcompose.presentation.model

import java.io.Serializable

class AgentPresentation(
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
    val role: AgentRolePresentation?,
    val abilities: List<AgentAbilityPresentation>
) : Serializable

data class AgentRolePresentation(
    val uuid: String,
    val displayName: String,
    val description: String,
    val displayIcon: String,
    val assetPath: String
) : Serializable

data class AgentAbilityPresentation(
    val slot: String,
    val displayName: String?,
    val description: String?,
    val displayIcon: String?
) : Serializable

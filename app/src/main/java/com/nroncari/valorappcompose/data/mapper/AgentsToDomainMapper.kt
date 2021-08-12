package com.nroncari.valorappcompose.data.mapper

import com.nroncari.valorappcompose.data.model.AgentResponse
import com.nroncari.valorappcompose.domain.model.AgentAbilityDomain
import com.nroncari.valorappcompose.domain.model.AgentDomain
import com.nroncari.valorappcompose.domain.model.AgentRoleDomain
import com.nroncari.valorappcompose.utils.Mapper

class AgentsToDomainMapper : Mapper<List<AgentResponse>, List<AgentDomain>> {

    override fun map(source: List<AgentResponse>): List<AgentDomain> {
        return source.map { agentResponse ->
            AgentDomain(
                uuid = agentResponse.uuid,
                displayName = agentResponse.displayName,
                description = agentResponse.description,
                developerName = agentResponse.developerName,
                displayIcon = agentResponse.displayIcon,
                bustPortrait = agentResponse.bustPortrait,
                fullPortrait = agentResponse.fullPortrait,
                isFullPortraitRightFacing = agentResponse.isFullPortraitRightFacing,
                killfeedPortrait = agentResponse.killfeedPortrait,
                isPlayableCharacter = agentResponse.isPlayableCharacter,
                isAvailableForTest = agentResponse.isAvailableForTest,
                role = agentResponse.role?.let { agentRoleResponse ->
                    AgentRoleDomain(
                        agentRoleResponse.uuid,
                        agentResponse.role.displayName,
                        agentResponse.role.description,
                        agentResponse.role.displayIcon,
                        agentResponse.role.assetPath,
                    )
                },
                abilities = agentResponse.abilities.map { agentAbilityResponse ->
                    AgentAbilityDomain(
                        agentAbilityResponse.slot,
                        agentAbilityResponse.displayName,
                        agentAbilityResponse.description,
                        agentAbilityResponse.displayIcon,
                    )
                }
            )
        }
    }

    fun map(source: AgentResponse): AgentDomain {
        return AgentDomain(
            uuid = source.uuid,
            displayName = source.displayName,
            description = source.description,
            developerName = source.developerName,
            displayIcon = source.displayIcon,
            bustPortrait = source.bustPortrait,
            fullPortrait = source.fullPortrait,
            killfeedPortrait = source.killfeedPortrait,
            isFullPortraitRightFacing = source.isFullPortraitRightFacing,
            isPlayableCharacter = source.isPlayableCharacter,
            isAvailableForTest = source.isAvailableForTest,
            role = source.role?.let { agentRoleDomain ->
                AgentRoleDomain(
                    agentRoleDomain.uuid,
                    source.role.displayName,
                    source.role.description,
                    source.role.displayIcon,
                    source.role.assetPath,
                )
            },
            abilities = source.abilities.map { agentAbilityResponse ->
                AgentAbilityDomain(
                    agentAbilityResponse.slot,
                    agentAbilityResponse.displayName,
                    agentAbilityResponse.description,
                    agentAbilityResponse.displayIcon,
                )
            }
        )
    }
}

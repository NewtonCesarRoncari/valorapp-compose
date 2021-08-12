package com.nroncari.valorappcompose.domain.mapper

import com.nroncari.valorappcompose.domain.model.AgentDomain
import com.nroncari.valorappcompose.presentation.model.AgentAbilityPresentation
import com.nroncari.valorappcompose.presentation.model.AgentPresentation
import com.nroncari.valorappcompose.presentation.model.AgentRolePresentation
import com.nroncari.valorappcompose.utils.Mapper

class AgentsToPresentationMapper : Mapper<List<AgentDomain>, List<AgentPresentation>> {

    override fun map(source: List<AgentDomain>): List<AgentPresentation> {
        return source.map { agentDomain ->
            AgentPresentation(
                uuid = agentDomain.uuid,
                displayName = agentDomain.displayName,
                description = agentDomain.description,
                developerName = agentDomain.developerName,
                displayIcon = agentDomain.displayIcon,
                bustPortrait = agentDomain.bustPortrait,
                fullPortrait = agentDomain.fullPortrait,
                killfeedPortrait = agentDomain.killfeedPortrait,
                isFullPortraitRightFacing = agentDomain.isFullPortraitRightFacing,
                isPlayableCharacter = agentDomain.isPlayableCharacter,
                isAvailableForTest = agentDomain.isAvailableForTest,
                role = agentDomain.role?.let { agentRoleDomain ->
                    AgentRolePresentation(
                        agentRoleDomain.uuid,
                        agentDomain.role.displayName,
                        agentDomain.role.description,
                        agentDomain.role.displayIcon,
                        agentDomain.role.assetPath,
                    )
                },
                abilities = agentDomain.abilities.map { agentAbilityDomain ->
                    AgentAbilityPresentation(
                        agentAbilityDomain.slot,
                        agentAbilityDomain.displayName,
                        agentAbilityDomain.description,
                        agentAbilityDomain.displayIcon
                    )
                }
            )
        }
    }

    fun map(source: AgentDomain): AgentPresentation {
        return AgentPresentation(
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
                AgentRolePresentation(
                    agentRoleDomain.uuid,
                    source.role.displayName,
                    source.role.description,
                    source.role.displayIcon,
                    source.role.assetPath,
                )
            },
            abilities = source.abilities.map { agentAbilityDomain ->
                AgentAbilityPresentation(
                    agentAbilityDomain.slot,
                    agentAbilityDomain.displayName,
                    agentAbilityDomain.description,
                    agentAbilityDomain.displayIcon
                )
            }
        )
    }
}

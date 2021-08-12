package com.nroncari.valorappcompose.domain.usecase

import com.nroncari.valorappcompose.domain.repository.AgentRepository
import com.nroncari.valorappcompose.presentation.model.AgentPresentation

class GetAgentListUseCase(
    private val repository: AgentRepository
) {

    suspend operator fun invoke(): List<AgentPresentation> {
        val agentListPresentation = repository.getAgents().toMutableList()
        agentListPresentation.removeAt(5)
        return agentListPresentation.toList()
    }
}

package com.nroncari.valorappcompose.domain.usecase

import com.nroncari.valorappcompose.domain.repository.AgentRepository

class GetAgentDetailUseCase(
    private val repository: AgentRepository
) {

    suspend operator fun invoke(uuid: String) = repository.getAgentById(uuid)
}

package com.nroncari.valorappcompose.domain.repository

import com.nroncari.valorappcompose.presentation.model.AgentPresentation

interface AgentRepository {

    suspend fun getAgents(): List<AgentPresentation>

    suspend fun getAgentById(uuid: String): AgentPresentation
}

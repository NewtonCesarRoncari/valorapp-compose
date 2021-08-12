package com.nroncari.valorappcompose.data.datasource

import com.nroncari.valorappcompose.domain.model.AgentDomain

interface AgentRemoteDataSource {

    suspend fun getAgents(): List<AgentDomain>

    suspend fun getAgentDetail(uuid: String): AgentDomain
}

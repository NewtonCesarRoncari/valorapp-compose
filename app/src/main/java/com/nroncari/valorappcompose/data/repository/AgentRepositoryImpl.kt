package com.nroncari.valorappcompose.data.repository

import com.nroncari.valorappcompose.data.datasource.AgentRemoteDataSource
import com.nroncari.valorappcompose.domain.mapper.AgentsToPresentationMapper
import com.nroncari.valorappcompose.domain.repository.AgentRepository
import com.nroncari.valorappcompose.presentation.model.AgentPresentation

class AgentRepositoryImpl(
    private val remoteDataSource: AgentRemoteDataSource
) : AgentRepository {

    private val mapper = AgentsToPresentationMapper()

    override suspend fun getAgents(): List<AgentPresentation> =
        mapper.map(remoteDataSource.getAgents())

    override suspend fun getAgentById(uuid: String): AgentPresentation =
        mapper.map(remoteDataSource.getAgentDetail(uuid))
}

package com.nroncari.valorappcompose.di

import com.nroncari.valorappcompose.data.datasource.AgentRemoteDataSource
import com.nroncari.valorappcompose.data.datasource.AgentRemoteDataSourceImpl
import com.nroncari.valorappcompose.data.datasource.WeaponRemoteDataSource
import com.nroncari.valorappcompose.data.datasource.WeaponRemoteDataSourceImpl
import com.nroncari.valorappcompose.data.repository.AgentRepositoryImpl
import com.nroncari.valorappcompose.data.repository.WeaponRepositoryImpl
import com.nroncari.valorappcompose.data.retrofit.HttpClient
import com.nroncari.valorappcompose.data.retrofit.RetrofitClient
import com.nroncari.valorappcompose.data.service.AgentService
import com.nroncari.valorappcompose.data.service.WeaponService
import com.nroncari.valorappcompose.domain.repository.AgentRepository
import com.nroncari.valorappcompose.domain.repository.WeaponRepository
import com.nroncari.valorappcompose.domain.usecase.GetAgentDetailUseCase
import com.nroncari.valorappcompose.domain.usecase.GetAgentListUseCase
import com.nroncari.valorappcompose.domain.usecase.GetWeaponListUseCase
import com.nroncari.valorappcompose.presentation.viewModel.AgentDetailViewModel
import com.nroncari.valorappcompose.presentation.viewModel.AgentListViewModel
import com.nroncari.valorappcompose.presentation.viewModel.WeaponListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainModules = module {
    factory { GetAgentListUseCase(repository = get()) }
    factory { GetAgentDetailUseCase(repository = get()) }
    factory { GetWeaponListUseCase(repository = get()) }
}

val presentationModules = module {
    viewModel { AgentListViewModel(useCase = get()) }
    viewModel { AgentDetailViewModel(useCase = get()) }
    viewModel { WeaponListViewModel(useCase = get()) }
}

val dataModules = module {
    factory<AgentRemoteDataSource> { AgentRemoteDataSourceImpl(service = get()) }
    factory<WeaponRemoteDataSource> { WeaponRemoteDataSourceImpl(service = get()) }
    factory<AgentRepository> { AgentRepositoryImpl(remoteDataSource = get()) }
    factory<WeaponRepository> { WeaponRepositoryImpl(remoteDataSource = get()) }
}

val networkModules = module {
    single { RetrofitClient(application = androidContext()).newInstance() }
    single { HttpClient(get()) }
    factory { get<HttpClient>().create(AgentService::class.java) }
    factory { get<HttpClient>().create(WeaponService::class.java) }
}

package com.nroncari.valorappcompose.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nroncari.valorappcompose.domain.usecase.GetAgentDetailUseCase
import com.nroncari.valorappcompose.presentation.model.AgentPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AgentDetailViewModel(
    private val useCase: GetAgentDetailUseCase
) : ViewModel() {

    private val _resultSuccess = MutableLiveData<Boolean>().apply { value = false }
    val resultSuccess: LiveData<Boolean> get() = _resultSuccess
    private val _agent = MutableLiveData<AgentPresentation>().apply { null }
    val agent: LiveData<AgentPresentation> get() = _agent

    fun getAgentDetail(uuid: String) {
        viewModelScope.launch(Dispatchers.IO) {

            runCatching {
                useCase(uuid)
            }.onSuccess { agentPresentation ->

                _agent.postValue(agentPresentation)
                _resultSuccess.postValue(true)

            }.onFailure {
                Log.e("Error", "Algo de errado não deu certo", it)
                _resultSuccess.postValue(false)
            }
        }
    }
}

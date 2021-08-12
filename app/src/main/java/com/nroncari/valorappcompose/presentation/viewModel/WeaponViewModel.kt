package com.nroncari.valorappcompose.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nroncari.valorappcompose.presentation.model.AgentPresentation
import com.nroncari.valorappcompose.presentation.model.WeaponPresentation
import com.nroncari.valorappcompose.domain.usecase.GetWeaponListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeaponListViewModel(
    private val useCase: GetWeaponListUseCase
) : ViewModel() {

    private val _resultSuccess = MutableLiveData<Boolean>().apply { value = false }
    val resultSuccess: LiveData<Boolean> get() = _resultSuccess
    private val _weapons = MutableLiveData<List<WeaponPresentation>>().apply { listOf<AgentPresentation>() }
    val weapons: LiveData<List<WeaponPresentation>> get() = _weapons

    fun getWeapons() {
        viewModelScope.launch(Dispatchers.IO) {

            runCatching {
                useCase()
            }.onSuccess { weaponList ->

                _weapons.postValue(weaponList)
                _resultSuccess.postValue(true)

            }.onFailure {
                Log.e("Error", "Algo de errado não deu certo", it)
                _resultSuccess.postValue(false)
            }
        }
    }
}

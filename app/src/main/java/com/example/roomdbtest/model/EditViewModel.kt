package com.example.roomdbtest.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdbtest.repositori.RepositoriSiswa
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa
) : ViewModel() {

    var siswaUiState by mutableStateOf(UIStateSiswa())
        private set

    private val itemId: Int = 0


    init {
        viewModelScope.launch {
            siswaUiState = repositoriSiswa.getSiswaStream(itemId)
                .filterNotNull()
                .first()
                .toUiStateSiswa(true)
        }
    }


    suspend fun updateSiswa() {
        if (validasiInput(siswaUiState.detailsiswa)) {
            repositoriSiswa.updateSiswa(siswaUiState.detailsiswa.toSiswa())
        }
        else {
            println("Data tidak valid")
        }
    }


    fun updateUiState(detailsiswa: Detailsiswa) {
        siswaUiState =
            UIStateSiswa(detailsiswa = detailsiswa, isEntryValid = validasiInput(detailsiswa))
    }


    private fun validasiInput(uiState: Detailsiswa = siswaUiState.detailsiswa ) : Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }
}
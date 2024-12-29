package com.nadia.pertemuan10.viewmodel

import com.nadia.pertemuan10.model.Mahasiswa

sealed class HomeUiState{
    data class Success(val mahasiswa: List<Mahasiswa>): HomeUiState()
    object Error: HomeUiState()
    object Loading: HomeUiState()
}

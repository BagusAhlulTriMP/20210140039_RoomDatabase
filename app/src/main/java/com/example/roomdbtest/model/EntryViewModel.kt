package com.example.roomdbtest.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.roomdbtest.data.Siswa
import com.example.roomdbtest.repositori.RepositoriSiswa


class EntryViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel() {
    /**
     * Berisi status Siswa saat ini
     */
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    /* Fungsi untuk memvalidasi input */
    private fun validasiInput(uiState: Detailsiswa = uiStateSiswa.detailsiswa ): Boolean{
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun updateUiState(detailSiswa: Detailsiswa) {
        uiStateSiswa =
            UIStateSiswa(detailsiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }

    /* Fungsi untuk menyimpan data yang di entry */
    suspend fun saveSiswa() {
        if (validasiInput()) {
            repositoriSiswa.insertSiswa(uiStateSiswa.detailsiswa.toSiswa())
        }
    }
}

/**
 * Mewakili Status Ui untuk Siswa.
 */
data class UIStateSiswa(
    val detailsiswa: Detailsiswa = Detailsiswa(),
    val isEntryValid: Boolean = false
)

data class Detailsiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = "",
)
/* Fungsi untuk mengkonversi data input ke data dalam tabel sesuai jenis datanya*/
fun Detailsiswa.toSiswa(): Siswa = Siswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)

fun Siswa.toUiStateSiswa(isEntryValid: Boolean = false): UIStateSiswa = UIStateSiswa(
    detailsiswa = this.toDetailSiswa(),
    isEntryValid = isEntryValid
)

fun Siswa.toDetailSiswa(): Detailsiswa = Detailsiswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)
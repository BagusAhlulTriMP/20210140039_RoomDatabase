package com.example.roomdbtest.repositori

import com.example.roomdbtest.data.Siswa
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>

    fun getAllSiswaStream(id: Int): Flow<Siswa?>

    suspend fun insertSiswa(siswa: Siswa)

    suspend fun deleteSiswa(siswa: Siswa)

    suspend fun updateSiswa(siswa: Siswa)
}
package com.example.roomdbtest.repositori

import com.example.roomdbtest.data.Siswa
import com.example.roomdbtest.data.SiswaDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositoriSiswa(private val siswaDao: SiswaDao) :RepositoriSiswa {

    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()

    override fun getSiswaStream(id: Int): Flow<Siswa?> = siswaDao.getSiswa(id)

    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)

    override suspend fun deleteSiswa(siswa: Siswa) = siswaDao.delete(siswa)

    override suspend fun updateSiswa(siswa: Siswa) = siswaDao.update(siswa)
}
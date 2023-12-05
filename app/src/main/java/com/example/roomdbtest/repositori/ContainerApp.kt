package com.example.roomdbtest.repositori

import android.content.Context
import com.example.roomdbtest.data.DatabaseSiswa

interface ContainerApp {
    val repositoriSiswav: RepositoriSiswa
}

class ContainerDataApp(private val context: Context): ContainerApp{
    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa(DatabaseSiswa.getDatabase(context).siswaDao())
    }
}
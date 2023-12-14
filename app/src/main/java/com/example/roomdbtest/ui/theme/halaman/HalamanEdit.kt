package com.example.roomdbtest.ui.theme.halaman

import com.example.roomdbtest.R
import com.example.roomdbtest.navigasi.DestinasiNavigasi


object ItemEditDestination : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg"
}

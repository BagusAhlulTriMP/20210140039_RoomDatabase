package com.example.roomdbtest.ui.theme.halaman

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomdbtest.R
import com.example.roomdbtest.model.Detailsiswa
import com.example.roomdbtest.model.EntryViewModel
import com.example.roomdbtest.model.PenyediaViewModel
import com.example.roomdbtest.model.UIStateSiswa
import com.example.roomdbtest.navigasi.DestinasiNavigasi


object DestinasiEntry: DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = R.string.entry_siswa
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntrySiswaScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EntryViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold (
        modifier = modifier
    )
}

@Composable
fun EntrySiswaBody(
    uiStateSiswa: UIStateSiswa,
    onSiswaValueChange: (Detailsiswa) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier =Modifier
) {}
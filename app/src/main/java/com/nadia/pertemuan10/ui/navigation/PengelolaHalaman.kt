package com.nadia.pertemuan10.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nadia.pertemuan10.ui.view.DestinasiEntry
import com.nadia.pertemuan10.ui.view.DestinasiHome
import com.nadia.pertemuan10.ui.view.EntryMhsScreen
import com.nadia.pertemuan10.ui.view.HomeScreen

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier,
    ){
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToltemEntry = { navController.navigate(DestinasiEntry.route)},
                onDetailClick = {
                }
            )
        }
        composable(DestinasiEntry.route) {
            EntryMhsScreen(
                navigateBack = {
                    navController.navigate(DestinasiHome.route){
                        popUpTo(DestinasiHome.route){
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}
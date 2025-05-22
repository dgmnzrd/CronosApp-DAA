package com.example.cronoapps.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cronoapps.viewModels.CronometroViewModel
import com.example.cronoapps.viewModels.CronosViewModel
import com.example.cronoapps.views.AddView
import com.example.cronoapps.views.EditView
import com.example.cronoapps.views.HomeView

@Composable
fun NavManager(cronometroVM: CronometroViewModel, cronosVM: CronosViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController, cronosVM)
        }
        composable("AddView") {
            AddView(navController, cronometroVM, cronosVM)
        }
        composable("EditView") {
            EditView(navController)
        }
    }
}

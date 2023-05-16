package com.corleonyis.sharinfo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.corleonyis.sharinfo.ui.theme.SharinfoTheme

class MainActivity : ComponentActivity() {
  private val items = listOf(
    BarItem.Home,
    BarItem.ShoppingList,
    BarItem.Stock,
  )

  @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      SharinfoTheme {
        // A surface container using the 'background' color from the theme
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.primary
        ) {
          val navController = rememberNavController()

          Scaffold(
            topBar = {
              AppBar(
                navController = navController
              )
            },
            bottomBar = {
              BottomBar(
                items = items,
                navController = navController
              )
            },
          ){
            NavHost(
              navController = navController,
              startDestination = BarItem.Home.route,
              modifier = Modifier.padding(top = it.calculateTopPadding(), bottom = it.calculateBottomPadding())
            ){
              composable(route = BarItem.Home.route){
                HomeScreen()
              }
              composable(route = BarItem.ShoppingList.route){
                ShoppingListScreen()
              }
              composable(route = BarItem.Stock.route){
                StockListScreen()
              }
              composable(route = BarItem.Setting.route){
                SettingScreen()
              }
            }
          }
        }
      }
    }
  }
}

@Composable
fun HomeScreen(){
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center
  ) {
    Text(text = "Home Screen")
  }
}

@Composable
fun ShoppingListScreen(){
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center
  ) {
    Text(text = "Shopping List Screen")
  }
}

@Composable
fun SettingScreen(){
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center
  ) {
    Text(text = "Setting Screen")
  }
}

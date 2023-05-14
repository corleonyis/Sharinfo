package com.corleonyis.sharinfo

import AppBar
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.corleonyis.sharinfo.ui.theme.SharinfoTheme

class MainActivity : ComponentActivity() {
  private val items = listOf(
    BottomBarItem.Home,
    BottomBarItem.ShoppingList,
    BottomBarItem.Stock,
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
            topBar = { AppBar() },
            bottomBar = { BottomBar(
              items = items,
              navController = navController
            ) },
          ){
            NavHost(navController = navController, startDestination = BottomBarItem.Home.route){
              composable(route = BottomBarItem.Home.route){
                HomeScreen()
              }
              composable(route = BottomBarItem.ShoppingList.route){
                ShoppingListScreen()
              }
              composable(route = BottomBarItem.Stock.route){
                StockListScreen()
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
fun StockListScreen(){
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center
  ) {
    Text(text = "Stock List Screen")
  }
}

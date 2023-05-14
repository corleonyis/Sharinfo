package com.corleonyis.sharinfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@Composable
fun BottomBar(
  items: List<BottomBarItem>,
  navController: NavController
){

  NavigationBar(
    modifier = Modifier.fillMaxWidth(),
    containerColor = MaterialTheme.colorScheme.primary,
    contentColor = MaterialTheme.colorScheme.onPrimary,
    content = {
      Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
      ){
        items.forEach { item ->
          NavigationBarItem(
            icon = { Icon(item.icon, item.title)},
            label = { Text(item.title)},
            selected = item.route == navController.currentBackStackEntryAsState().value?.destination?.route,
            onClick = {
              navController.navigate(item.route){
                popUpTo(navController.graph.findStartDestination().id){
                  saveState = true
                }
                launchSingleTop = true
                restoreState = true
              }
            },
            colors = NavigationBarItemDefaults.colors(
              selectedIconColor = MaterialTheme.colorScheme.primary,
              selectedTextColor = MaterialTheme.colorScheme.onPrimary,
              indicatorColor = MaterialTheme.colorScheme.onPrimary,
              unselectedIconColor = MaterialTheme.colorScheme.inversePrimary,
              unselectedTextColor = MaterialTheme.colorScheme.inversePrimary
            )
          )
        }
      }
    }
  )
}

@Preview
@Composable
fun BottomBarPreview(){
  val items = listOf(
    BottomBarItem.Home,
    BottomBarItem.ShoppingList,
    BottomBarItem.Stock,
  )
  val navController = rememberNavController()
  BottomBar(items = items, navController)
}

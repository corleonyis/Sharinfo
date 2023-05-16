package com.corleonyis.sharinfo

import android.content.res.Configuration.UI_MODE_NIGHT_NO
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
  items: List<BarItem>,
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
          val selected = item.route == navController.currentBackStackEntryAsState().value?.destination?.route
          NavigationBarItem(
            icon = {
              if(selected){
                Icon( item.selectedIcon, item.title)
              } else {
                Icon( item.icon, item.title)
              }
            },
            label = { Text(item.title)},
            selected = selected,
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
              unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
              unselectedTextColor = MaterialTheme.colorScheme.onPrimary
            )
          )
        }
      }
    }
  )
}

@Preview(
  name = "Light Mode",
  showBackground = true,
  uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun BottomBarPreview(){
  val items = listOf(
    BarItem.Home,
    BarItem.ShoppingList,
    BarItem.Stock,
  )
  val navController = rememberNavController()
  BottomBar(items = items, navController)
}

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun BottomBar(){
  var selectedItem by remember {
    mutableStateOf(0)
  }

  val items = listOf(
    BottomBarItem.Home,
    BottomBarItem.ShoppingList,
    BottomBarItem.Stock,
  )
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
        items.forEachIndexed { index, item ->
          NavigationBarItem(
            icon = { Icon(item.icon, item.title)},
            label = { Text(item.title)},
            selected = selectedItem == index,
            onClick = { selectedItem = index },
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

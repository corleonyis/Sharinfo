package com.corleonyis.sharinfo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItem(var route: String, var icon: ImageVector, var title: String){
  object Home: BottomBarItem("home", Icons.Filled.Home, "Home")
  object ShoppingList: BottomBarItem("list", Icons.Filled.ShoppingCart, "Shopping List")
  object Stock: BottomBarItem("stock", Icons.Filled.List, "Stock")
  object Notification: BottomBarItem("notification", Icons.Filled.Notifications, "Notification")
}


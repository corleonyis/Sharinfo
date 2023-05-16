package com.corleonyis.sharinfo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BarItem(var route: String, var selectedIcon: ImageVector, var icon: ImageVector, var title: String){
  object Home: BarItem("home", Icons.Filled.Home, Icons.Outlined.Home, "Home")
  object ShoppingList: BarItem("shoppingList", Icons.Filled.ShoppingCart, Icons.Outlined.ShoppingCart, "Shopping List")
  object Stock: BarItem("stock", Icons.Filled.List, Icons.Outlined.List, "Stock")
  object Setting: BarItem("setting", Icons.Filled.Settings, Icons.Outlined.Settings, "Setting")
  object Notification: BarItem("notification", Icons.Filled.Notifications, Icons.Outlined.Notifications, "Notification")
}


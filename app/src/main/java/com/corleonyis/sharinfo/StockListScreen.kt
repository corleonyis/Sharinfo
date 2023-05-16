package com.corleonyis.sharinfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun StockListScreen(){
  LazyColumn(
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp),
  ) {
    val list = (0..75).map { it.toString() }
    items(count = list.size){
      StockItem(name = "Name${it}")
    }
  }
}

@Composable
fun StockItem(
  name: String
){
  Column {
    Text(text = name)
    Row {
      Column {
        Text(text = "残量")
      }
      Column {
        Text(text = "ストック数")
      }
    }
  }
}

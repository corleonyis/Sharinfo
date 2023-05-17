package com.corleonyis.sharinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .background(color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f))
      .padding(10.dp),
    verticalAlignment = Alignment.CenterVertically
  ){
    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
    Spacer(modifier = Modifier.width(10.dp))
    Column(
      modifier = Modifier.fillMaxWidth()
    ){
      Text(
        text = name,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
      )
      Spacer(modifier = Modifier.height(5.dp))

      // 残量・ストック数 Textエリア
      Row(
        modifier = Modifier.fillMaxWidth()
      ) {
        Text(text = "残 70 %,")
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "ストック数 : 2個")
      }

      Spacer(modifier = Modifier.height(10.dp))

      // 残量ゲージ
      LinearProgressIndicator(progress = 0.7f)
    }
  }
}

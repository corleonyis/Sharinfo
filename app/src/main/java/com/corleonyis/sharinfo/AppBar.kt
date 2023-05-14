import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.corleonyis.sharinfo.ui.theme.SharinfoTheme

@Preview
@Composable
fun AppBar() {
  SharinfoTheme() {
    Surface(
      color = MaterialTheme.colorScheme.primary
    ) {
      CenterAlignedTopAppBar(
        title = {
          Text(
            text = "Sharinfo",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        },
        navigationIcon = {
          IconButton(onClick = { /*TODO*/ }) {
            Icon(
              imageVector = Icons.Filled.Menu,
              contentDescription = "Localized description"
            )
          }
        },
        actions = {
          IconButton(onClick = { /*TODO*/ }) {
            Icon(
              imageVector = Icons.Filled.Settings,
              contentDescription = "Localized description"
            )
          }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
          containerColor = MaterialTheme.colorScheme.primary,
          titleContentColor = MaterialTheme.colorScheme.onPrimary,
          navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
          actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
      )
    }
  }
}
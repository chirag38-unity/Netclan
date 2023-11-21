package com.chirag_redij.netclan.Homescreen.appbar

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chirag_redij.netclan.Homescreen.destinations.RefineScreenDestination
import com.chirag_redij.netclan.Homescreen.refine.RefineScreen
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    navigator: DestinationsNavigator,
    onNavigationClick : () -> Unit
) {
    TopAppBar(
        title = {
            AppBarContent(navigator)
        },
        navigationIcon = {
            IconButton(
                onClick = onNavigationClick,
                modifier = Modifier) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(2.dp),
                    contentDescription = "Toggle Drawer",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }                 
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Preview
@Composable
fun Preview() {
//    AppBar  {
//
//    }
}

@Composable
fun AppBarContent(
    navigator: DestinationsNavigator
) {
   Row (
       modifier = Modifier
           .fillMaxWidth(),
       horizontalArrangement = Arrangement.SpaceBetween
   ) {
       Column (
           modifier = Modifier
       ) {
          Text(text = "Howdy Chirag Redij!!", fontSize = 18.sp)
          Row (
              verticalAlignment = Alignment.CenterVertically
          ){
              Icon(
                  imageVector = Icons.Filled.Place,
                  contentDescription = null,
                  modifier = Modifier.size(16.dp))
              Text(text = "Panvel", fontSize = 16.sp)
          }
       }

       Column (
           horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier
               .align(Alignment.CenterVertically)
               .padding(end = 10.dp)
               .clickable {
                   navigator.navigate(RefineScreenDestination)
               }
       ) {

           Icon(
               imageVector = Icons.Filled.Check,
               contentDescription = null,
               modifier = Modifier.size(16.dp))
           Text(text = "Refine", fontSize = 16.sp)
       }

   }
}
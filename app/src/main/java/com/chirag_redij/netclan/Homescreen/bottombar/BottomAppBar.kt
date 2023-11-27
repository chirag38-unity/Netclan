package com.chirag_redij.netclan.Homescreen.bottombar

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.chirag_redij.netclan.Homescreen.Constants.bottomNavItems
import com.chirag_redij.netclan.ui.theme.NoRippleTheme
import timber.log.Timber

data class BottomAppBarNavigationItem (
    val title : String,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector,
    val showBadge : Boolean,
    val badgeCount : Int? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultBottomAppBar(
    seletctedItem : Int,
    onNavigationClick : (Int) -> Unit
) {

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(seletctedItem)
    }

    CompositionLocalProvider (LocalRippleTheme provides NoRippleTheme) {

        NavigationBar(
            modifier = Modifier
                .height(70.dp)
                .padding(horizontal = 18.dp),
            containerColor = Color.White
        ) {
            bottomNavItems.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedItemIndex == index,
                    onClick = {
                        onNavigationClick(index)
                        Timber.tag("BottomBar").d("Index - ${index}")
                    },
                    alwaysShowLabel = true,
                    label = {
                        Text(text = item.title)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.White
                    ),
                    icon = {
                        BadgedBox(
                            badge = {
                                if (item.badgeCount != null) {
                                    Badge {
                                        Text(text = item.badgeCount.toString())
                                    }
                                } else if (item.showBadge) {
                                    Badge()
                                }
                            }
                        ) {
                            Icon(
                                imageVector = if (index == selectedItemIndex) item.selectedIcon else item.unselectedIcon,
                                contentDescription = item.title
                            )
                        }
                    })
            }

        }
    }
}
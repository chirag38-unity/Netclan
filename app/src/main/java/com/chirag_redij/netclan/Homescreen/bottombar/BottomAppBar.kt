package com.chirag_redij.netclan.Homescreen.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.SignalCellular4Bar
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Contacts
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material.icons.outlined.SignalCellular0Bar
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
    val bottomNavItems = listOf<BottomAppBarNavigationItem>(
        BottomAppBarNavigationItem(
            title = "Explore",
            selectedIcon = Icons.Filled.RemoveRedEye,
            unselectedIcon = Icons.Outlined.RemoveRedEye,
            showBadge = false
        ),
        BottomAppBarNavigationItem(
            title = "Network",
            selectedIcon = Icons.Filled.SignalCellular4Bar,
            unselectedIcon = Icons.Outlined.SignalCellular0Bar,
            showBadge = false
        ),
        BottomAppBarNavigationItem(
            title = "Chat",
            selectedIcon = Icons.Filled.Chat,
            unselectedIcon = Icons.Outlined.Chat,
            showBadge = false,
            badgeCount = 3
        ),
        BottomAppBarNavigationItem(
            title = "Contacts",
            selectedIcon = Icons.Filled.Contacts,
            unselectedIcon = Icons.Outlined.Contacts,
            showBadge = false
        ),
        BottomAppBarNavigationItem(
            title = "Groups",
            selectedIcon = Icons.Filled.Groups,
            unselectedIcon = Icons.Outlined.Groups,
            showBadge = true
        )
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(seletctedItem)
    }
    NavigationBar {
        bottomNavItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    onNavigationClick(index)
                    Timber.tag("BottomBar").d("Index - ${index}")
                },
                label = {
                    Text(text = item.title)
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.LightGray
                ),
                icon = {
                    BadgedBox(
                        badge = {
                            if(item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            } else if(item.showBadge) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if(index == selectedItemIndex) item.selectedIcon else item.unselectedIcon ,
                            contentDescription = item.title
                        )
                    }
                })
        }

    }
}
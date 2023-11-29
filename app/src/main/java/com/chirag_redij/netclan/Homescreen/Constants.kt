package com.chirag_redij.netclan.Homescreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArtTrack
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Dining
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.MovieFilter
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Sell
import androidx.compose.material.icons.filled.SignalCellular4Bar
import androidx.compose.material.icons.outlined.Business
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Contacts
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material.icons.outlined.Sell
import androidx.compose.material.icons.outlined.SignalCellular0Bar
import com.chirag_redij.netclan.Homescreen.UserTile.UserTile
import com.chirag_redij.netclan.Homescreen.bottombar.BottomAppBarNavigationItem
import com.chirag_redij.netclan.Homescreen.explore.TabItem
import com.chirag_redij.netclan.Homescreen.refine.Purpose


object Constants {
    val PurposeList = mutableListOf(
        Purpose(
            title = "Coffee",
            selected = true,
            icon = Icons.Filled.Coffee
        ),
        Purpose(
            title = "Business",
            selected = true,
            icon = Icons.Filled.Business
        ),
        Purpose(
            title = "Hobbies",
            selected = false,
            icon = Icons.Filled.ArtTrack
        ),
        Purpose(
            title = "Friendship",
            selected = true,
            icon = Icons.Filled.Groups
        ),
        Purpose(
            title = "Movies",
            selected = false,
            icon = Icons.Filled.MovieFilter
        ),
        Purpose(
            title = "Dining",
            selected = false,
            icon = Icons.Filled.Dining
        ),
        Purpose(
            title = "Dating",
            selected = false,
            icon = Icons.Filled.Favorite
        ),
        Purpose(
            title = "Matrimony",
            selected = false,
            icon = Icons.Filled.Favorite
        )
    )
    val peopleList = listOf(
        UserTile(
            name = "Vaibhav Kamble",
            initial = "VK",
            description = "Navi Mumbai | Testing Engineer",
            location = "Within 8.1 KM",
            imageUrl = "https://images.pexels.com/photos/13484361/pexels-photo-13484361.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        UserTile(
            name = "Adesh Shinde",
            initial = "AS",
            description = "Navi Mumbai | Electronics Engineer",
            location = "Within 12.8 KM"
        ),
        UserTile(
            name = "Praveen Kumar",
            initial = "PK",
            description = "Navi Mumbai | Mechanical Engineer",
            location = "Within 6 KM"
        ),
        UserTile(
            name = "Gaurav Sawant",
            initial = "GS",
            description = "Navi Mumbai | IT Engineer",
            location = "Within 9.4 KM"
        )
    )
    val tabItemsList = listOf(
        TabItem(
            "Personal",
            Icons.Filled.Person,
            Icons.Outlined.Person
        ),
        TabItem(
            "Business",
            Icons.Filled.Business,
            Icons.Outlined.Business
        ),
        TabItem(
            "Merchant",
            Icons.Filled.Sell,
            Icons.Outlined.Sell
        )
    )
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
}
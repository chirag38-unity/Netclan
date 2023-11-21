package com.chirag_redij.netclan.Homescreen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chirag_redij.netclan.Homescreen.appbar.AppBar
import com.chirag_redij.netclan.Homescreen.bottombar.DefaultBottomAppBar
import com.chirag_redij.netclan.Homescreen.destinations.ChatScreenDestination
import com.chirag_redij.netclan.Homescreen.destinations.ContactScreenDestination
import com.chirag_redij.netclan.Homescreen.destinations.GroupsScreenDestination
import com.chirag_redij.netclan.Homescreen.destinations.HomeScreenDestination
import com.chirag_redij.netclan.Homescreen.destinations.NetworkScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch
import timber.log.Timber

@Destination
@Composable
fun NetworkScreen(
    navigator: DestinationsNavigator,
    selectedItem : Int = 1
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Navigation Drawer", modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding))
            }
        },
        drawerState = drawerState
    ) {
        Scaffold (
            topBar = {
                AppBar (navigator) {
                    scope.launch {
                        drawerState.open()
                    }
                }
            },
            bottomBar = {
                DefaultBottomAppBar(seletctedItem = selectedItem) { index->
                    scope.launch {
                        when(index) {
                            0 -> {
                               navigator.navigate(HomeScreenDestination) {
                                   popUpTo(NetworkScreenDestination.route) {inclusive = true}
                               }
                            }
                            1 -> {

                            }
                            2 -> {
                                navigator.navigate(ChatScreenDestination()) {
                                    popUpTo(NetworkScreenDestination.route) {inclusive = true}
                                }
                            }
                            3 -> {
                                navigator.navigate(ContactScreenDestination()) {
                                    popUpTo(NetworkScreenDestination.route) {inclusive = true}
                                }
                            }
                            4 -> {
                                navigator.navigate(GroupsScreenDestination()) {
                                    popUpTo(NetworkScreenDestination.route) {inclusive = true}
                                }
                            }
                            else -> {
                                Timber.tag("BottomBar").d("Index - ${index}")
                            }
                        }
                    }
                }
            }
        ) { paddingValues ->
            Text(text = "Network Screen", modifier = Modifier.padding(paddingValues))
        }
    }
}

@Destination
@Composable
fun ChatScreen(
    navigator: DestinationsNavigator,
    selectedItem : Int = 2
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Navigation Drawer", modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding))
            }
        },
        drawerState = drawerState
    ) {
        Scaffold (
            topBar = {
                AppBar (navigator) {
                    scope.launch {
                        drawerState.open()
                    }
                }
            },
            bottomBar = {
                DefaultBottomAppBar(seletctedItem = selectedItem) { index->
                    scope.launch {
                        when(index) {
                            0 -> {
                                navigator.navigate(HomeScreenDestination) {
                                    popUpTo(ChatScreenDestination.route) {inclusive = true}
                                }
                            }
                            1 -> {
                                navigator.navigate(NetworkScreenDestination()) {
                                    popUpTo(ChatScreenDestination.route) {inclusive = true}
                                }
                            }
                            2 -> {

                            }
                            3 -> {
                                navigator.navigate(ContactScreenDestination()) {
                                    popUpTo(ChatScreenDestination.route) {inclusive = true}
                                }
                            }
                            4 -> {
                                navigator.navigate(GroupsScreenDestination()) {
                                    popUpTo(ChatScreenDestination.route) {inclusive = true}
                                }
                            }
                            else -> {
                                Timber.tag("BottomBar").d("Index - ${index}")
                            }
                        }
                    }
                }
            }
        ) { paddingValues ->
            Text(text = "Chat screen", modifier = Modifier.padding(paddingValues))
        }
    }
}

@Destination
@Composable
fun ContactScreen(
    navigator: DestinationsNavigator,
    selectedItem : Int = 3
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Navigation Drawer", modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding))
            }
        },
        drawerState = drawerState
    ) {
        Scaffold (
            topBar = {
                AppBar (navigator) {
                    scope.launch {
                        drawerState.open()
                    }
                }
            },
            bottomBar = {
                DefaultBottomAppBar(seletctedItem = selectedItem) { index->
                    scope.launch {
                        when(index) {
                            0 -> {
                                navigator.navigate(HomeScreenDestination) {
                                    popUpTo(ContactScreenDestination.route) {inclusive = true}
                                }
                            }
                            1 -> {
                                navigator.navigate(NetworkScreenDestination()) {
                                    popUpTo(ContactScreenDestination.route) {inclusive = true}
                                }
                            }
                            2 -> {
                                navigator.navigate(ChatScreenDestination()) {
                                    popUpTo(ContactScreenDestination.route) {inclusive = true}
                                }
                            }
                            3 -> {

                            }
                            4 -> {
                                navigator.navigate(GroupsScreenDestination()) {
                                    popUpTo(ContactScreenDestination.route) {inclusive = true}
                                }
                            }
                            else -> {
                                Timber.tag("BottomBar").d("Index - ${index}")
                            }
                        }
                    }
                }
            }
        ) { paddingValues ->
            Text(text = "Contact screen", modifier = Modifier.padding(paddingValues))
        }
    }
}

@Destination
@Composable
fun GroupsScreen(
    navigator: DestinationsNavigator,
    selectedItem : Int = 4
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Navigation Drawer", modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding))
            }
        },
        drawerState = drawerState
    ) {
        Scaffold (
            topBar = {
                AppBar (navigator) {
                    scope.launch {
                        drawerState.open()
                    }
                }
            },
            bottomBar = {
                DefaultBottomAppBar(seletctedItem = selectedItem) { index->
                    scope.launch {
                        when(index) {
                            0 -> {
                                navigator.navigate(HomeScreenDestination) {
                                    popUpTo(GroupsScreenDestination.route) {inclusive = true}
                                }
                            }
                            1 -> {
                                navigator.navigate(NetworkScreenDestination()) {
                                    popUpTo(GroupsScreenDestination.route) {inclusive = true}
                                }
                            }
                            2 -> {
                                navigator.navigate(ChatScreenDestination()) {
                                    popUpTo(GroupsScreenDestination.route) {inclusive = true}
                                }
                            }
                            3 -> {
                                navigator.navigate(ContactScreenDestination()) {
                                    popUpTo(GroupsScreenDestination.route) {inclusive = true}
                                }
                            }
                            4 -> {

                            }
                            else -> {
                                Timber.tag("BottomBar").d("Index - ${index}")
                            }
                        }
                    }
                }
            }
        ) { paddingValues ->
            Text(text = "Group screen", modifier = Modifier.padding(paddingValues))
        }
    }
}
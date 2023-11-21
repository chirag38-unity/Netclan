package com.chirag_redij.netclan.Homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chirag_redij.netclan.Homescreen.UserTile.UserTileComposable
import com.chirag_redij.netclan.Homescreen.UserTile.peopleList
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

@Destination(
    start = true
)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
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
                DefaultBottomAppBar(seletctedItem = 0) { index ->
                    scope.launch {
                        when(index) {
                            0 -> {

                            }
                            1 -> {
                                navigator.navigate(NetworkScreenDestination()) {
                                    popUpTo(HomeScreenDestination.route) {inclusive = true}
                                }
                            }
                            2 -> {
                                navigator.navigate(ChatScreenDestination()) {
                                    popUpTo(HomeScreenDestination.route) {inclusive = true}
                                }
                            }
                            3 -> {
                                navigator.navigate(ContactScreenDestination()) {
                                    popUpTo(HomeScreenDestination.route) {inclusive = true}
                                }
                            }
                            4 -> {
                                navigator.navigate(GroupsScreenDestination()) {
                                    popUpTo(HomeScreenDestination.route) {inclusive = true}
                                }
                            }
                            else -> {
                                Timber.tag("BottomBar").d("Index - ${index}")
                            }
                        }
                    }
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    shape = CircleShape,
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onSecondary,
                    elevation = FloatingActionButtonDefaults.elevation(

                    )
                ) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
                }
            }
        ) { padding ->
            Box (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(Color.White)
            ) {
                Column {
                    ExploreHeadingBar()
                    SearchSection()
                    LazyColumn (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                       items (count = peopleList.size) {
                            UserTileComposable(userTile = peopleList[it])
                       }
                    }
                }
            }
        }
    }
}

@Composable
fun ExploreHeadingBar() {
    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondary)
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        Text(text = "Personal", fontStyle = FontStyle.Normal ,fontSize = 16.sp ,color = Color.White)
        Text(text = "Business", fontStyle = FontStyle.Normal ,fontSize = 16.sp ,color = Color.White)
        Text(text = "Merchant", fontStyle = FontStyle.Normal ,fontSize = 16.sp ,color = Color.White)
    }
}

@Composable
fun SearchSection(
    modifier: Modifier = Modifier
) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(horizontal = 12.dp, vertical = 12.dp)
    ) {
        SearchBar(
            modifier = Modifier
                .heightIn(16.dp)
                .fillMaxWidth(.9f)
        )
        Icon(
            imageVector = Icons.Filled.Sort,
            contentDescription = "Sort options",
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        var searchvalue by remember {
            mutableStateOf("")
        }
        val focusRequester = remember { FocusRequester() }
        val focusManager = LocalFocusManager.current
        TextField(
            value = searchvalue,
            onValueChange = {
                searchvalue = it
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.LightGray),
            placeholder = {
                Text(text = "Search", color = Color.Gray)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search",
                    tint = Color.LightGray
                )
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Search,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    focusManager.clearFocus()
                }
            ),
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .focusable()
                .focusRequester(focusRequester)
        )
    }
}
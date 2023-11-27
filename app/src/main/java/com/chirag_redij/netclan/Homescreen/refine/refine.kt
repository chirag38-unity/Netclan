package com.chirag_redij.netclan.Homescreen.refine

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArtTrack
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Dining
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MovieFilter
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.spec.DestinationStyle

@Destination (
    style = SlideTransition::class
)
@Composable
fun RefineScreen(
    navigator: DestinationsNavigator
) {
    Scaffold (
        topBar = {
            RefineTopAppBar() {
                navigator.popBackStack()
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                AvailabilitySection()
                Spacer(modifier = Modifier.height(16.dp))
                StatusSection()
                Spacer(modifier = Modifier.height(16.dp))
                DistanceSection()
                Spacer(modifier = Modifier.height(16.dp))
                PurposeSection()
                Spacer(modifier = Modifier.height(16.dp))
                SaveButton()
            }
        }
    }
}

@Composable
fun SaveButton() {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            ),
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Save & Explore")
        }
    }
}

data class Purpose (
    val title : String,
    var selected : Boolean,
    val icon : ImageVector? = null
)

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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PurposeSection() {
    Text(
        text = "Select Purpose",
        color = MaterialTheme.colorScheme.secondary,
        fontSize = 16.sp,
    )
    Spacer(modifier = Modifier.height(10.dp))
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        for (purpose in PurposeList) {
            PurposeChip(purpose = purpose)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PurposeChip(purpose : Purpose) {
    var selected by remember {
        mutableStateOf(purpose.selected)
    }
    FilterChip(
        modifier = Modifier,
        shape = RoundedCornerShape(40.dp),
        selected = selected,
        onClick = { selected = !selected },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.secondary,
            selectedLabelColor = MaterialTheme.colorScheme.onSecondary,
            selectedLeadingIconColor = MaterialTheme.colorScheme.onSecondary,
            labelColor = MaterialTheme.colorScheme.secondary,
            iconColor = MaterialTheme.colorScheme.secondary
        ),
        label = {
            Text(text = purpose.title, textAlign = TextAlign.Center)
        },
        leadingIcon = {
            if(selected && purpose.icon != null) {
                Icon(imageVector = purpose.icon, contentDescription = null, modifier = Modifier.size(FilterChipDefaults.IconSize) )
            } else null
        }
    )
}

@Composable
fun DistanceSection(
    modifier: Modifier = Modifier
) {
    var currDistance by remember {
        mutableStateOf(50f)
    }
    Text(
        text = "Select Your Availability",
        color = MaterialTheme.colorScheme.secondary,
        fontSize = 16.sp,
    )
    Spacer(modifier = Modifier.height(10.dp))
    Slider(
        value = currDistance,
        onValueChange = { currDistance = it },
        valueRange = 1f..100f,
        steps = 99,
        colors = SliderDefaults.colors(
            activeTrackColor = MaterialTheme.colorScheme.secondary,
            activeTickColor = MaterialTheme.colorScheme.secondary,
            thumbColor = MaterialTheme.colorScheme.secondary
        )
    )
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("1 Km", color = MaterialTheme.colorScheme.secondary)
        Text(text = "100 Km", color = MaterialTheme.colorScheme.secondary)
    }
}

@Composable
fun StatusSection(
    modifier: Modifier = Modifier
) {
    val maxLen = 250
    var status by remember {
        mutableStateOf("Hi community! I am open to new connections\uD83D\uDE04")
    }
    Text(
        text = "Select Your Availability",
        color = MaterialTheme.colorScheme.secondary,
        fontSize = 16.sp,
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        value = status ,
        onValueChange = {
            if (it.length <= maxLen) status = it
        },
        supportingText = {
            Text(
                text = "${status.length} / $maxLen",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End,
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvailabilitySection(
    modifier: Modifier = Modifier
) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    
    var availability by remember {
        mutableStateOf("Available | Hey Let Us Connect")
    }

    Text(
        text = "Select Your Availability",
        color = MaterialTheme.colorScheme.secondary,
        fontSize = 16.sp,
    )
    Spacer(modifier = Modifier.height(10.dp))
    MaterialTheme (
        colorScheme = MaterialTheme.colorScheme.copy(surface = Color.White),
    ) {
        ExposedDropdownMenuBox(
            modifier = Modifier.fillMaxWidth(),
            expanded = isExpanded,
            onExpandedChange = {
                isExpanded = it
            }
        ) {
            OutlinedTextField(
                value = availability,
                shape = RoundedCornerShape(10.dp),
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .menuAnchor(),
                onValueChange = {

                },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                }
            )
            ExposedDropdownMenu(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent),
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }) {
                DropdownMenuItem(
                    modifier = Modifier.fillMaxWidth(),
                    text = {
                        Text(text = "Available | Hey Let Us Connect")
                    },
                    onClick = {
                        isExpanded = false
                        availability = "Available | Hey Let Us Connect"
                    }
                )
                DropdownMenuItem(
                    modifier = Modifier.fillMaxWidth(),
                    text = {
                        Text(text = "Away | Stay Discrete And Watch")
                    },
                    onClick = {
                        isExpanded = false
                        availability = "Away | Stay Discrete And Watch"
                    }
                )
                DropdownMenuItem(
                    modifier = Modifier.fillMaxWidth(),
                    text = {
                        Text(text = "Busy | Do Not Disturb | Will Catch Up Later")
                    },
                    onClick = {
                        isExpanded = false
                        availability = "Busy | Do Not Disturb | Will Catch Up Later"
                    }
                )
                DropdownMenuItem(
                    modifier = Modifier.fillMaxWidth(),
                    text = {
                        Text(text = "SOS | Emergency! Need Assistance! Help")
                    },
                    onClick = {
                        isExpanded = false
                        availability = "SOS | Emergency! Need Assistance! Help"
                    }
                )
            }
        }
    }
    
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RefineTopAppBar(
    onNavigationClick : () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = "Refine")
        },
        navigationIcon = {
            IconButton(
                onClick = onNavigationClick ,
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
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
package com.chirag_redij.netclan.Homescreen.UserTile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

data class UserTile (
    val name : String,
    val initial : String,
    val description : String,
    val location : String,
    val imageUrl : String? = null
)

@Composable
fun UserTileComposable(
    userTile: UserTile
) {

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {

        Box (
            modifier = Modifier
                .padding(start = 40.dp, top = 10.dp, end = 10.dp)
                .shadow(2.dp, RoundedCornerShape(20.dp), true)
                .background(Color.White)

        ) {
            Column {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(text = "+ INVITE", color = MaterialTheme.colorScheme.secondary)
                }

                Column (
                    modifier = Modifier
                        .padding(start = 50.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = userTile.name,
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 20.sp
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(.7f),
                        text = userTile.description,
                        color = Color.LightGray,
                        fontSize = 14.sp
                    )
                    Text(
                        text = userTile.location,
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 14.sp
                    )
                    Box(
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .width(100.dp)
                            .height(10.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                    ) {
                        Row (
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(.4f)
                                .background(Color.DarkGray)
                        ) {}
                    }

                }

                Spacer(modifier = Modifier.height(10.dp))

                Column (
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Coffee | Business | Friendship",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 15.sp
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(.65f),
                        text = "Hi community! I am open to new connections\uD83D\uDE04",
                        color = Color.LightGray,
                        fontSize = 14.sp,
                        lineHeight = 16.sp
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

            }
        }

        Box(
            modifier = Modifier
                .padding(start = 10.dp, top = 30.dp)
                .size(60.dp)
                .shadow(2.dp, RoundedCornerShape(16.dp), true)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            if(userTile.imageUrl.isNullOrBlank()){
                Text(
                    text = userTile.initial,
                    fontSize = 30.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
            } else {
                SubcomposeAsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(userTile.imageUrl)
                        .crossfade(true)
                        .build(),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = "${userTile.name}'s profile image" )
            }
            
        }

    }
}


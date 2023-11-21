package com.chirag_redij.netclan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chirag_redij.netclan.Homescreen.NavGraphs
import com.chirag_redij.netclan.ui.theme.NetclanTheme
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetclanTheme {
                DestinationsNavHost(navGraph = NavGraphs.root )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NetclanTheme {

    }
}
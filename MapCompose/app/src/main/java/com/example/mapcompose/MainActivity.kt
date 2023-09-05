package com.example.mapcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mapcompose.ui.theme.MapComposeTheme
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MapComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MyGoogleMaps()
                }
            }
        }
    }
}

@Preview
@Composable
fun MyGoogleMaps() {
    val marker = LatLng(7.152087, -73.132807)

    val properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.SATELLITE))
    }

    val cameraPositionState by remember {
        mutableStateOf(CameraPositionState(position = CameraPosition(LatLng(0.0, 0.0), 0f, 0f, 0f)))
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        properties = properties,
        cameraPositionState = cameraPositionState
    ){
        Marker(position = marker, title = "CASA DE JHOAN", snippet = "Traiga pola")


        LaunchedEffect(Unit) {
            cameraPositionState.animate(CameraUpdateFactory.newCameraPosition(CameraPosition(marker, 18f, 0f, 0f)))
        }

    }
}
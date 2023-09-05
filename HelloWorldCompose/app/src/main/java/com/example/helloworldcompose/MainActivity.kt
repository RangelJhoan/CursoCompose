package com.example.helloworldcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
        }
    }
}

@Preview
@Composable
fun ViewContainer() {
    Scaffold(
        topBar = { Toolbar() },
        content = { Content(it) },
        floatingActionButton = { FAB() },
        floatingActionButtonPosition = FabPosition.End
    )
}

@Composable
fun FAB() {
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        Toast.makeText(context, "Contrátame", Toast.LENGTH_LONG).show()
    }) {
        Text("X")
    }
}

@Composable
fun Toolbar() {
    TopAppBar(
        title = { Text(text = "RangelJhoan Profile", color = Color.White) },
        backgroundColor = colorResource(id = R.color.background)
    )
}

@Composable
fun Content(paddingValues: PaddingValues) {
    var counter by rememberSaveable {
        mutableStateOf(0)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(paddingValues)
    ) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                painter = painterResource(id = R.drawable.kotlin_logo),
                contentDescription = "Logo Kotlin"
            )
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Me gusta",
                    modifier = Modifier.clickable {
                        counter++
                    }
                )
                Text(text = counter.toString())
            }
            Text(
                text = "Jhoan Rangel",
                fontSize = 32.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(text = "Android Developer")
            Text(text = "Experiencia: 1 año")
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Stack:")
                Text(text = "Java")
                Text(text = "Kotlin")
            }
        }
    }
}
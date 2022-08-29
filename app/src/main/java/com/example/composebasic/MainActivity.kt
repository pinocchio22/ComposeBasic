package com.example.composebasic

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("안드로이드")
                }
            }
        }
    }
}

// 뷰
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Greeting(name: String) {
    Scaffold(
        topBar = {
        TopAppBar(title = {Text(text = "탑앱바")}
            ,backgroundColor = Color(0xffEE6983)) },

        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Text(text = "클릭")
            }
        }
    ) {
//        Text(text = "Hello $name!")
        MyComposableView()
    }
}

@Composable
fun MyRowItem() {
    Log.d("TAG", "MyRowItem: ")

    // horizental linearlayot
    Row(
        Modifier
            .padding(10.dp)
            .background(Color(0xff8FE3CF))
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Hello!",
            Modifier
                .padding(all = 10.dp)
                .background(Color.Yellow))
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "Hello!")
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "Hello!")
    }
}

@Composable
fun MyComposableView() {
    Log.d("TAG", "MyComposableView: ")

    Column(
        Modifier
            .background(Color.Green)
            .verticalScroll(rememberScrollState())
    ) {
        for (i in 0..5) {
            MyRowItem()
        }
    }
}

// 미리보기
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasicTheme {
        Greeting("안드로")
    }
}
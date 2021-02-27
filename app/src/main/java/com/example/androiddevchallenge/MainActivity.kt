/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.creator.DogCreator
import com.example.androiddevchallenge.models.Dog
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(
                    onItemClick = { dog ->
                        startActivity(
                            Intent(this, DogActivity::class.java).apply {
                                putExtra("name", dog.name)
                            }
                        )
                    }
                )
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(onItemClick: (Dog) -> Unit) {
    Surface(color = Color(0xFFEEEEEE)) {
        DogList(dogs = DogCreator().makeDogs(), onItemClick = onItemClick)
    }
}

@Composable
fun DogList(dogs: List<Dog>, onItemClick: (Dog) -> Unit) {
    LazyColumn(
        modifier = Modifier.padding(
            top = 8.dp,
            bottom = 16.dp
        )
    ) {
        items(dogs) { dog ->
            DogCard(dog = dog, onItemClick = onItemClick)
        }
    }
}

@Composable
fun DogCard(dog: Dog, onItemClick: (Dog) -> Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp,
            top = 16.dp
        )
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .height(270.dp)
                .clickable { onItemClick(dog) }
        ) {
            Text(
                text = dog.name,
                style = TextStyle(
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(16.dp)
            )
            Image(
                bitmap = ImageBitmap.imageResource(id = dog.imageResId),
                contentDescription = "",
                Modifier
                    .fillMaxWidth()
                    .height(270.dp),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(
            onItemClick = {
            }
        )
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp(
            onItemClick = {
            }
        )
    }
}

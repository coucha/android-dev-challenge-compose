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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

class DogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = intent.getStringExtra("name")
        val dog = DogCreator().makeDogs().find { name == it.name } ?: return
        setContent {
            MyTheme {
                DetailApp(dog)
            }
        }
    }
}

@Composable
fun DetailApp(dog: Dog) {
    Surface {
        Column {
            Column(
                Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    bitmap = ImageBitmap.imageResource(id = dog.imageResId),
                    contentDescription = "",
                    Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
            Text(
                text = dog.name, style = TextStyle(
                    fontSize = 30.sp
                ),
                modifier = Modifier.padding(16.dp)
            )
            Button(
                onClick = {
                    // Welcome!
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Welcome!")
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun DetailLightPreview() {
    MyTheme {
        DetailApp(
            Dog(
                name = "Takashi",
                imageResId = R.drawable.takashi
            )
        )
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DetailDarkPreview() {
    MyTheme(darkTheme = true) {
        DetailApp(
            Dog(
                name = "Takashi",
                imageResId = R.drawable.takashi
            )
        )
    }
}
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
package com.example.androiddevchallenge.creator

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Dog

class DogCreator {

    fun makeDogs(): List<Dog> {
        return listOf(
            Dog(
                "Takashi",
                R.drawable.takashi
            ),
            Dog(
                "Fumiya",
                R.drawable.fumiya
            ),
            Dog(
                "Ryo",
                R.drawable.ryo
            ),
            Dog(
                "Kaoru",
                R.drawable.kaoru
            ),
            Dog(
                "Kohei",
                R.drawable.kohei
            ),
            Dog(
                "George",
                R.drawable.george
            ),
        )
    }
}

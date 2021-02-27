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
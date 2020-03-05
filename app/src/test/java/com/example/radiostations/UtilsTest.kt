package com.example.radiostations

import com.example.radiostations.utils.CheckInput
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*


class UtilsTest {
    @Test
    fun validateBadFormatEntryCoordinate() {
        val input = "33.4392669-112.0733225"
        assertThat(
                CheckInput.canBeCoordinate(input),
        CoreMatchers.`is`(false)
        )
    }

    @Test
    fun validateNotAlphaInCoordinate() {
        val input = "33.4392669a,-112.0733225"
        assertThat(
            CheckInput.canBeCoordinate(input),
            CoreMatchers.`is`(false)
        )
    }

    @Test
    fun validateValidCoordinate() {
        val input= "-33.4392669,-112.0733225"
        assertThat(
            CheckInput.canBeCoordinate(input),
            CoreMatchers.`is`(true)
        )
    }

    @Test
    fun validateInputIsAlpha(){

        val input= "Dallas"
        assertThat(
            CheckInput.isAlpha(input),
            CoreMatchers.`is`(true)
        )
    }

    @Test
    fun validateInputNotAlpha(){

        val input= "6890995677"
        assertThat(
            CheckInput.isAlpha(input),
            CoreMatchers.`is`(false)
        )
    }
}

package com.zabochen.fugaapp

import com.zabochen.fugaapp.example.PairExample
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun test_pair_class() {

        val pair = PairExample().mainScope()

        val (firstValue, secondValue) = pair

        println("1: $firstValue, 2: $secondValue")

    }

}

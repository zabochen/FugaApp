package com.zabochen.fugaapp.example

class PairExample {

    fun mainScope(): Pair<String, String> {

        val pair: Pair<String, Int> = "key" to 10

        val intentKey = "key_intent"
        val intentPair: Pair<String, String> = intentKey to "success"

        val oldPair: Pair<String, String> = Pair("key", "value")

        return oldPair
    }

}
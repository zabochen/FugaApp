package com.zabochen.fugaapp.example

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(r = 255, g = 0, b = 0),
    GREEN(r = 0, g = 255, b = 0),
    BLUE(r = 0, g = 0, b = 255);

    fun rgb(): Int {
        return r + g + b
    }
}

class ColorImpl {

    fun getColor(color: Color): String {
        return when (color) {
            Color.RED -> "color red"
            Color.GREEN -> "color green"
            Color.BLUE -> "color blue"
        }
    }
}


enum class State {

    CREATE {
        override fun log(): String {
            return "CREATE"
        }
    },

    RESUME {
        override fun log(): String {
            return "RESUME"
        }
    },

    DESTROY {
        override fun log(): String {
            return "DESTROY"
        }
    };

    abstract fun log(): String
}
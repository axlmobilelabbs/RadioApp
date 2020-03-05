package com.example.radiostations.utils

import android.content.Context
import android.net.ConnectivityManager

class CheckInput() {
    companion object Factory {
        fun isAlpha(entry: String?): Boolean {
            return entry!!.matches("[a-zA-Z]+".toRegex())
        }

        fun canBeCoordinate(entry: String?): Boolean {

            var valid = false
            if(entry!!.contains(",")){
                val coordinates: List<String> = entry.split(",").map { it -> it.trim() }
                if(coordinates.size == 2){
                    if(coordinates[0].toFloatOrNull()!=null && coordinates[1].toFloatOrNull()!=null )
                        valid = true
                }
                else{
                    valid = false
                }
            }

           return valid
        }
    }
}


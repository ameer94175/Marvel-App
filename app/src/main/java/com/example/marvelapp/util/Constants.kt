package com.example.marvelapp.util

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object Constants {
     val BASE_URL = "https://gateway.marvel.com/"

    val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()

    const val API_KEY = "85987a43b525722806ee59cd24c15db4"
    const val PRIVATE_KEY = "f5fed701f640f10623e899a893ccb74e397772ee"

    fun hash():String{
        val input = "$timeStamp$PRIVATE_KEY$API_KEY"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32,'0')
    }

}
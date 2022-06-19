package com.mlinde.marvelcomicsapp.util

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {

    companion object{
        const val BASE_URL = "https://gateway.marvel.com/v1/public/"
        val timeStamp = Timestamp(System.currentTimeMillis()).toString()
        const val API_KEY = "8e6eaff2babc82d749bb7e1f5586a85a"
        const val PRIVATE_KEY = "6ca43e1e43e8696e0d09bc35ccb20593c6ffc715"
        fun hash(): String {
            val input = "$timeStamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }
    }
}
package com.pm.urlshorteningservice.utils

private const val  BASE62_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"

fun generateShortCode(length: Int = 6) : String{
    val stringBuilder = StringBuilder();
    repeat(length){
        val randomCharacter = BASE62_CHARS.random()
        stringBuilder.append(randomCharacter);
    }

    return stringBuilder.toString()
}
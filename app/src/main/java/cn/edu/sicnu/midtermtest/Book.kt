package cn.edu.sicnu.midtermtest

import java.io.Serializable
data class Book(
    val name: String,
    val author: String,
    val publisher: String,
    val price: Double
) : Serializable

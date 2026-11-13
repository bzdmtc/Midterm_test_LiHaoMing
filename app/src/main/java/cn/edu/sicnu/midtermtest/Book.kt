package cn.edu.sicnu.midtermtest

import java.io.Serializable

/**
 * 书籍信息：书名、作者、出版社、价格。
 */
data class Book(
    val name: String,
    val author: String,
    val publisher: String,
    val price: Double
) : Serializable

package cn.edu.sicnu.midtermtest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.edu.sicnu.midtermtest.databinding.ActivityMainBinding

/**
 * 书籍列表界面：在代码中创建书籍数组，按价格从低到高排序后用列表显示。
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val books = arrayOf(
        Book("Android开发艺术探索", "任玉刚", "电子工业出版社", 89.00),
        Book("第一行代码：Android（第3版）", "郭霖", "人民邮电出版社", 79.00),
        Book("Java编程思想（第4版）", "Bruce Eckel", "机械工业出版社", 108.00),
        Book("计算机网络：自顶向下方法", "James F. Kurose", "机械工业出版社", 69.00),
        Book("Kotlin实战", "Dmitry Jemerov", "电子工业出版社", 59.80),
        Book("数据结构与算法分析", "Mark Allen Weiss", "机械工业出版社", 49.90)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle(R.string.main_title)

        val sortedBooks = books.sortedBy { it.price }
        binding.listBooks.adapter = BookAdapter(layoutInflater, sortedBooks)
        binding.listBooks.setOnItemClickListener { _, _, position, _ ->
            openBookDetail(sortedBooks[position])
        }
    }

    private fun openBookDetail(book: Book) {
        val intent = Intent(this, BookDetailActivity::class.java)
            .putExtra(BookDetailActivity.EXTRA_BOOK, book)
        startActivity(intent)
    }
}

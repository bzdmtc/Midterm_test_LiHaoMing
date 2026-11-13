package cn.edu.sicnu.midtermtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.edu.sicnu.midtermtest.databinding.ActivityBookDetailBinding

/**
 * 书籍详情界面：显示从列表界面选中的书籍的完整信息。
 */
class BookDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle(R.string.detail_title)

        @Suppress("DEPRECATION")
        val book = intent.getSerializableExtra(EXTRA_BOOK) as? Book
        if (book == null) {
            finish()
            return
        }

        binding.tvBookName.text = getString(R.string.detail_book_name_format, book.name)
        binding.tvAuthor.text = getString(R.string.detail_author_format, book.author)
        binding.tvPublisher.text = getString(R.string.detail_publisher_format, book.publisher)
        binding.tvPrice.text = getString(R.string.detail_price_format, book.price)
    }

    companion object {
        const val EXTRA_BOOK = "extra_book"
    }
}

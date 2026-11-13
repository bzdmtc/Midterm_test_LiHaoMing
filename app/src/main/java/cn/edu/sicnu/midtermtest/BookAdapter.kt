package cn.edu.sicnu.midtermtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import cn.edu.sicnu.midtermtest.databinding.ItemBookBinding


class BookAdapter(
    private val inflater: LayoutInflater,
    private val books: List<Book>
) : BaseAdapter() {

    override fun getCount(): Int = books.size

    override fun getItem(position: Int): Book = books[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = if (convertView == null) {
            ItemBookBinding.inflate(inflater, parent, false)
        } else {
            ItemBookBinding.bind(convertView)
        }

        val book = books[position]
        val context = binding.root.context
        binding.tvTitle.text = book.name
        binding.tvPrice.text = context.getString(R.string.price_format, book.price)
        binding.tvAuthorPublisher.text = context.getString(
            R.string.author_publisher_format,
            book.author,
            book.publisher
        )
        return binding.root
    }
}

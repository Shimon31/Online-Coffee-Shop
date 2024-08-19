package com.blockfrom.onlinecoffeshop.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blockfrom.onlinecoffeshop.R
import com.blockfrom.onlinecoffeshop.adapter.CategoryAdapter
import com.blockfrom.onlinecoffeshop.databinding.ActivityIntroBinding
import com.blockfrom.onlinecoffeshop.databinding.ActivityMainBinding
import com.blockfrom.onlinecoffeshop.viewModel.MainViewModel

class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initCategory()

    }

    private fun initCategory() {
        binding.progressBarCategory.visibility = View.VISIBLE
        viewModel.category.observe(this, Observer {

            binding.recyclerViewCategory.layoutManager =
                LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            binding.recyclerViewCategory.adapter = CategoryAdapter(it)
            binding.progressBarCategory.visibility = View.GONE
        })
        viewModel.loadCategory()
    }
}

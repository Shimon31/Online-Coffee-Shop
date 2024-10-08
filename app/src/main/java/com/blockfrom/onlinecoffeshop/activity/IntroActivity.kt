package com.blockfrom.onlinecoffeshop.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blockfrom.onlinecoffeshop.databinding.ActivityIntroBinding

class IntroActivity : BaseActivity() {
    lateinit var binding:ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.StartButton.setOnClickListener {

            startActivity(Intent(this@IntroActivity, MainActivity::class.java))

        }

    }
}
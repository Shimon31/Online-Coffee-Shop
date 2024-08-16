package com.blockfrom.onlinecoffeshop

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.blockfrom.onlinecoffeshop.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    lateinit var binding:ActivityIntroBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_intro)

    }
}
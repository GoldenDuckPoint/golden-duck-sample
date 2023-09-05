package com.gduck.sample.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ad.gduck.app.GoldenDuck
import com.gduck.sample.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.setOnClickListener {
            // 무료 포인트 적립 실행
            GoldenDuck.launch(this)
        }
    }
}
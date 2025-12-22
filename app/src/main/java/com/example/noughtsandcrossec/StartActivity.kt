package com.example.noughtsandcrossec

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.noughtsandcrossec.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    private var Selectbutton = false
    private var grid = false


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityStartBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnStart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val gridButtons = listOf<Button>(binding.btn3x3, binding.btn4x4, binding.btn5x5)
        val SelectPlayerButtons = listOf<Button>(binding.btnPlayer, binding.btnBot)

        // Установка цветов для кнопок
        SelectPlayerButtons.forEach { button ->
            button.setOnClickListener { clickBtn ->
                SelectPlayerButtons.forEach { Btnsetcolor ->
                    Btnsetcolor.setBackgroundColor(getColor(R.color.whiteLightCyan))
                    Selectbutton = false
                }
                clickBtn.setBackgroundColor(getColor(R.color.red))
                Selectbutton = true
                checkStartButton()
            }
        }
        gridButtons.forEach { gridButton ->
            gridButton.setOnClickListener { clickGridBtn ->
                gridButtons.forEach { SetGridColorBtn ->
                    SetGridColorBtn.setBackgroundColor(getColor(R.color.whiteLightCyan))
                    grid = false
                }
                clickGridBtn.setBackgroundColor(getColor(R.color.red))
                grid = true
                checkStartButton()
            }
        }
    }
        fun checkStartButton() {
            if (Selectbutton != false && grid != false) {
                binding.btnStart.visibility = View.VISIBLE
            } else {
                binding.btnStart.visibility = View.GONE
            }
        }
}
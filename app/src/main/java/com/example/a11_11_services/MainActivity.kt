package com.example.a11_11_services

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editTextText)
        textView = findViewById(R.id.textView)

        findViewById<Button>(R.id.button).apply {
            setOnClickListener {
                val input = editText.text.toString().toIntOrNull()
                val intent = Intent(this@MainActivity, MyService::class.java)
                if (input != null) {
                    textView.text = "Timer started for $input seconds"
                    intent.putExtra("timerInput", input)
                } else {
                    textView.text = "Please enter a valid number"
                }
                startService(intent)
            }

        }


    }
}
package com.example.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var countButton : Button
    lateinit var countTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countButton = findViewById(R.id.count_button)
        countTextView = findViewById(R.id.count_text_view)
        countButton.setOnClickListener{
            var counter = countTextView.text.toString().toInt()
            counter++

            if (counter > 1000) {
                counter = 0
            }

            /**
             * "%04d" - means if I have less than 4 digits, put zeros before my digit
             */
            val text = String.format("%04d", counter)
            countTextView.text = text
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("counter", countTextView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        countTextView.text = savedInstanceState.getString("counter")
    }
}
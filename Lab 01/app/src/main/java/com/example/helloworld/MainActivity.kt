package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val text = findViewById<TextView>(R.id.TextView)

        button1?.setOnClickListener()
        {
            text.setText("Hello World!")
        }

        button2?.setOnClickListener()
        {
            text.setTextColor(Integer.parseUnsignedInt("aaff0000",16))
        }

        button3?.setOnClickListener()
        {
            text.setText("")
            text.setTextColor(Integer.parseUnsignedInt("aaffffff",16))
        }

    }
}
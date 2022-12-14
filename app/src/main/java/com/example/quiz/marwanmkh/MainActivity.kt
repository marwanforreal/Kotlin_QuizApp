package com.example.quiz.marwanmkh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btn_start);
        val name : EditText =findViewById(R.id.et_name);

        btnStart.setOnClickListener {

            if(name.text.isEmpty()){
                Toast.makeText(this, "Please Enter your name", Toast.LENGTH_LONG).show();
            } else {
                val intent = Intent(this, QuizzQuestionsActivity::class.java);
                startActivity(intent);
                //finish() in order to end the app;
            }

        }
    }
}
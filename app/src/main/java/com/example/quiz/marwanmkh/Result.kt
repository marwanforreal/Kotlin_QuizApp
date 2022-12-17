package com.example.quiz.marwanmkh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val name : TextView = findViewById(R.id.tv_name);
        val score : TextView = findViewById(R.id.tv_score);
        val button : Button = findViewById(R.id.btn_finish);

        name.text = intent.getStringExtra(Constants.USER_NAME);
//        score.text = intent.getStringExtra(Constants.CORRECT_ANSWERS);

        val totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTION, 0);
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0);

        score.text = "Your score is ${correctAnswers} out of ${totalQuestion}";

        button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java));
        }
    }
}
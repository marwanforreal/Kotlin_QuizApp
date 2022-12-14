package com.example.quiz.marwanmkh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class QuizzQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz_questions)

        val questionsList = Constants.getQuestion();

        //Log.i("numbers of text", "${questionsList.size}");
    }
}
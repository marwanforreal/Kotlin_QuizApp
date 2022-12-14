package com.example.quiz.marwanmkh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizzQuestionsActivity : AppCompatActivity() {

    private var progressBar : ProgressBar? = null;
    private var tvProgess : TextView? = null;
    private var questionString : TextView? = null;
    private var optionOne : TextView? = null;
    private var optionTwo : TextView? = null;
    private var optionThree : TextView? = null;
    private var optionFour : TextView? = null;
    private var imageView : ImageView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz_questions)

        val questionsList = Constants.getQuestion();
        progressBar = findViewById(R.id.progress_bar);
        tvProgess = findViewById(R.id.tv_progress);
        questionString = findViewById(R.id.tv_question);

        imageView = findViewById(R.id.iv_image);
        optionOne = findViewById(R.id.optionOne);
        optionTwo = findViewById(R.id.optionTwo);
        optionThree = findViewById(R.id.optionThree);
        optionFour = findViewById(R.id.optionFour);

        var currentPosition = 1;
        val question : Question = questionsList[currentPosition - 1];

        imageView?.setImageResource(question.image);

        progressBar?.progress = currentPosition;
        tvProgess?.text = "$currentPosition / ${progressBar?.max}"

        questionString?.text = question.question;
        optionOne?.text = question.optionOne;
        optionTwo?.text = question.optionTwo;
        optionThree?.text = question.optionThree;
        optionFour?.text = question.optionFour;



        //Log.i("numbers of text", "${questionsList.size}");
    }
}
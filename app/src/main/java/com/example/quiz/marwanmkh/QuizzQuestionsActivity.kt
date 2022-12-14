package com.example.quiz.marwanmkh

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizzQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var myCurrentPosition : Int = 1;
    private var questionsList:ArrayList<Question>? = null;
    private var mySelectedOptionSelected : Int? = null;

    private var progressBar : ProgressBar? = null;
    private var tvProgess : TextView? = null;
    private var questionString : TextView? = null;
    private var optionOne : TextView? = null;
    private var optionTwo : TextView? = null;
    private var optionThree : TextView? = null;
    private var optionFour : TextView? = null;
    private var imageView : ImageView? = null;
    private var submitButton : Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz_questions)

        questionsList = Constants.getQuestion();
        progressBar = findViewById(R.id.progress_bar);
        tvProgess = findViewById(R.id.tv_progress);
        questionString = findViewById(R.id.tv_question);

        imageView = findViewById(R.id.iv_image);
        optionOne = findViewById(R.id.optionOne);
        optionTwo = findViewById(R.id.optionTwo);
        optionThree = findViewById(R.id.optionThree);
        optionFour = findViewById(R.id.optionFour);

        submitButton = findViewById(R.id.btn_submit);

        setQuestion();
        defaultOptionsView();
        //Log.i("numbers of text", "${questionsList.size}");
    }

    private fun setQuestion() {
        val question: Question = questionsList!![myCurrentPosition - 1];

        imageView?.setImageResource(question.image);

        progressBar?.progress = myCurrentPosition;
        tvProgess?.text = "$myCurrentPosition / ${progressBar?.max}"

        questionString?.text = question.question;
        optionOne?.text = question.optionOne;
        optionTwo?.text = question.optionTwo;
        optionThree?.text = question.optionThree;
        optionFour?.text = question.optionFour;

        if(myCurrentPosition == questionsList!!.size){
            submitButton?.text = "FINISH";
        } else {
            submitButton?.text = "SUBMIT";
        }
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>();

        optionOne?.let{
            options.add(0, it);
        }

        optionTwo?.let{
            options.add(1, it);
        }

        optionThree?.let{
            options.add(2, it);
        }

        optionFour?.let{
            options.add(3, it);
        }

        for(option in options){
            option.setTextColor(Color.RED);
        }

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}
package com.example.quiz.marwanmkh

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizzQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var myCurrentPosition : Int = 1;
    private var questionsList:ArrayList<Question>? = null;
    private var mySelectedOptionSelected : Int = 0;

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

        optionOne?.setOnClickListener(this);
        optionTwo?.setOnClickListener(this);
        optionThree?.setOnClickListener(this);
        optionFour?.setOnClickListener(this);
        submitButton?.setOnClickListener(this);


        setQuestion();
        defaultOptionsView();
        //Log.i("numbers of text", "${questionsList.size}");
    }

    private fun setQuestion() {
        defaultOptionsView();
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
            option.typeface = Typeface.DEFAULT;
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            );
        }

    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum : Int){
        defaultOptionsView();

        mySelectedOptionSelected = selectedOptionNum;

        tv.setTextColor(Color.MAGENTA);
        tv.setTypeface(tv.typeface, Typeface.BOLD);
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    private fun answerView(answer: Int, drawableView : Int){
        when(answer){
            1 -> {
                optionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            2 -> {
                optionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            3 -> {
                optionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                optionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        };
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.optionOne -> { optionOne?.let { selectedOptionView(it, 1); } }
            R.id.optionTwo -> { optionTwo?.let { selectedOptionView(it, 2); } }
            R.id.optionThree -> { optionThree?.let { selectedOptionView(it, 3); } }
            R.id.optionFour -> { optionFour?.let { selectedOptionView(it, 4); } }
            R.id.btn_submit -> {
                if(mySelectedOptionSelected == 0){
                    myCurrentPosition++;
                    when{ myCurrentPosition <= questionsList!!.size ->{ setQuestion()}
                    else -> {Toast.makeText(this, "You're done'!", Toast.LENGTH_LONG).show()}}
                } else {
                    val question = questionsList?.get(myCurrentPosition - 1);
                    if(question!!.correctAnswer != mySelectedOptionSelected){ answerView(mySelectedOptionSelected, R.drawable.wrong_option_border_bg) }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg);

                    if(myCurrentPosition == questionsList!!.size){
                        submitButton?.text = "FINISH"
                    } else { submitButton?.text = "Next Question"}

                    mySelectedOptionSelected = 0;
                }
            }
        }
    }
}
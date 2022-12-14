package com.example.quiz.marwanmkh

object Constants {

    fun getQuestion() : ArrayList<Question>{
        val questionsList = ArrayList<Question>();

        val questionOne = Question(
            1,
            "Where is Georgia Located?",
            R.drawable.egypy,
            "Asia",
            "Europe",
            "Africa",
            "Western Asia",
            1
        )

        val questionTwo = Question(
            2,
            "Where is Jordan Located?",
            R.drawable.egypy,
            "South America",
            "Europe",
            "Africa",
            "Western Asia",
            3
        )

        questionsList.add(questionOne);
        questionsList.add(questionTwo);

        return questionsList;
    }
}
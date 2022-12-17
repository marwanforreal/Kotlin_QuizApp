package com.example.quiz.marwanmkh

object Constants {

    const val USER_NAME : String = "user_name";
    const val TOTAL_QUESTION : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"

    fun getQuestion() : ArrayList<Question>{
        val questionsList = ArrayList<Question>();

        val questionOne = Question(
            1,
            "Where is Egypt Located?",
            R.drawable.egypy,
            "Asia",
            "Europe",
            "Africa",
            "Western Asia",
            2
        )

        val questionTwo = Question(
            2,
            "What country is this flag for?",
            R.drawable.cu,
            "South America",
            "Lala land",
            "Cuba",
            "Dominican Republic",
            3
        )

        val questionThree = Question(
            3,
            "What country is this flag for?",
            R.drawable.sc,
            "Seychelles",
            "Kenya",
            "Uganda",
            "Ecuador",
            1
        )

        val questionFour = Question(
            3,
            "What country is this flag for?",
            R.drawable.et,
            "Macedonia",
            "Holland",
            "Ethiopia",
            "South Africa",
            3
        )

        val questionFive = Question(
            3,
            "What country is this flag for?",
            R.drawable.gl,
            "Iceland",
            "Greenland",
            "Antarctica",
            "North American Islands",
            2
        )

        questionsList.add(questionOne);
        questionsList.add(questionTwo);
        questionsList.add(questionThree);
        questionsList.add(questionFour);
        questionsList.add(questionFive);

        return questionsList;
    }
}
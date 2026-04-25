package com.example.myassigmnenttwo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private lateinit var questionText: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var feedbackText: TextView

    private var currentIndex = 0
    private var score = 0
//this block of code for questions and answers
    private val questions = arrayOf(
        "Placing your phone in rice fixes water damage",
        "Drinking water helps improve concentration",
        "Cracking knuckles causes arthritis",
        "Using dark mode saves battery",
        "Eating carrots improves night vision"
    )

    private val answers = arrayOf(
        false, true, false, true, false
    )
//The below bock of code was adapted from https://chatgpt.com/share/69ed1948-3fec-83ea-9a79-8fd5699a9359
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionText = findViewById(R.id.txtQuestion)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)
        feedbackText = findViewById(R.id.txtFeedback)

        loadQuestion()

        btnTrue.setOnClickListener { checkAnswer(true) }
        btnFalse.setOnClickListener { checkAnswer(false) }
    }

    private fun loadQuestion() {
        questionText.text = questions[currentIndex]
        feedbackText.text = ""
    }
//The below block of code was adapted from https://chatgpt.com/share/69ed1948-3fec-83ea-9a79-8fd5699a9359
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentIndex]

        if (userAnswer == correctAnswer) {
            this.feedbackText.text = "Correct! ✅"
            score++
        } else {
            feedbackText.text = "Wrong! ❌"
        }

        currentIndex++

        if (currentIndex < questions.size) {
            questionText.postDelayed({
                loadQuestion()
            }, 1000)
        } else {
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("SCORE", score)
            intent.putExtra("TOTAL", questions.size)
            startActivity(intent)
            finish()
        }
    }
}

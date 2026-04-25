package com.example.myassigmnenttwo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val scoreText = findViewById<TextView>(R.id.txtScore)
        val feedbackText = findViewById<TextView>(R.id.txtFinalFeedback)

        val score = intent.getIntExtra("SCORE", 0)
        val total = intent.getIntExtra("TOTAL", 0)

        scoreText.text = "Score: $score / $total"

        val feedback = if (score >= total * 0.7) {
            "Master Hacker! 🔥"
        } else {
            "Stay Safe Online! ⚠️"
        }

        feedbackText.text = feedback
    }
}

package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var rightAnswer: TextView
    lateinit var question: TextView
    lateinit var answer: EditText
    lateinit var showBtn: Button
    lateinit var changeBtn: Button
    lateinit var checkBtn: Button
    lateinit var day: String
    lateinit var random: Random


    internal var days =
        arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rightAnswer = findViewById(R.id.rightAnswer)
        question = findViewById(R.id.word)
        answer = findViewById(R.id.answer)
        showBtn = findViewById(R.id.showBtn)
        changeBtn = findViewById(R.id.changeBtn)
        checkBtn = findViewById(R.id.checkBtn)
        random = Random()

        playQuiz()
    }

    private fun playQuiz() {
        day = days[random.nextInt(days.size)]
        question.text = mixLetters(day)
    }

    fun mixLetters(word: String): String {
        val words =
            Arrays.asList<String>(*word.split("".toRegex()).dropLastWhile({ (it.isEmpty()) }).toTypedArray())

        Collections.shuffle(words)

        var mixes = ""

        for (i in words) {
            mixes += i
        }

        return mixes
    }
}

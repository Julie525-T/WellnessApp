package com.julie.simba_wellnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        Finding ids using find view by id from the layout
//        Creating a variable to store the button

        val recipes=findViewById<Button>(R.id.recipes)

//        Set onClick listener
        recipes.setOnClickListener {
//            Enable our intent

            val recipesIntent= Intent(applicationContext, HealthyRecipes::class.java)
            startActivity(recipesIntent)
        }

//        Nutrition intent

        val nutrition=findViewById<Button>(R.id.nutrition)

        nutrition.setOnClickListener {

            val nutritionIntent= Intent(applicationContext, NutritionAdvice::class.java)
            startActivity(nutritionIntent)
        }

//        Meditation Intent

        val meditation=findViewById<Button>(R.id.meditation)

        meditation.setOnClickListener {

            val meditationIntent= Intent(applicationContext, Meditation::class.java)
            startActivity(meditationIntent)
        }

//        Hydration Intent

        val hydration=findViewById<Button>(R.id.hydration)

        hydration.setOnClickListener {

            val hydrationIntent= Intent(applicationContext, HydrationAlert::class.java)
            startActivity(hydrationIntent)
        }

//Weekly Goals Intent

        val goals=findViewById<Button>(R.id.goals)

        goals.setOnClickListener {
            val goalsIntent= Intent(applicationContext, WeeklyGoals::class.java)

            startActivity(goalsIntent)

        }
//Check Progress Intent

        val progress=findViewById<Button>(R.id.progress)

        progress.setOnClickListener {
            val progressIntent= Intent(applicationContext, WeeklyGoals::class.java)

            startActivity(progressIntent)
        }
    }
}
package com.julie.simba_wellnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds

import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : AppCompatActivity() {

//    A variable to store our interstitial ad
    private var mInterstitialAd: InterstitialAd?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//        mobileAds.initialize-preparing the app to load the app
        MobileAds.initialize(this)

//        Get the adview from layout using the ID
        val adView=findViewById<AdView>(R.id.adView)

//        Creare a request asking admob for an ad
        val adRequest= AdRequest.Builder().build()

//        Load the ad and send request to admob then admob returns the add
        adView.loadAd(adRequest)

//        Call the function to load the ad from the server

        loadInterstitialAd()



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

//            Show your ad here
            showInterstitialAd()
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

//    A fuction to load our interstitial ad from the server

    fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            "ca-app-pub-3940256099942544/1033173712", // Test ID
            adRequest,
            object : InterstitialAdLoadCallback() {

                override fun onAdLoaded(ad: InterstitialAd) {
                    mInterstitialAd = ad
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    mInterstitialAd = null
                }
            }
        )
    }
    //Show Interstitial ad
    fun showInterstitialAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        }
    }
}
package com.example.candycrush;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.roger.catloadinglibrary.CatLoadingView;


public class MainMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        SharedPreferences myPrefs;
        myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPrefs.edit();
        boolean admin = myPrefs.getBoolean("AdminMode", false);
        boolean livello1 = myPrefs.getBoolean("Livello1", true);
        boolean livello2 = myPrefs.getBoolean("Livello2", false);
        boolean livello3 = myPrefs.getBoolean("Livello3", false);
        boolean livello4 = myPrefs.getBoolean("Livello4", false);
        int puntLivello1 = myPrefs.getInt("PuntLivello1", 0);
        int puntLivello2 = myPrefs.getInt("PuntLivello2", 0);
        int puntLivello3 = myPrefs.getInt("PuntLivello3", 0);
        int puntLivello4 = myPrefs.getInt("PuntLivello4", 0);
        int NStelle1 = myPrefs.getInt("Nstelle1", 0);
        int NStelle2 = myPrefs.getInt("Nstelle2", 0);
        int NStelle3 = myPrefs.getInt("Nstelle3", 0);
        int NStelle4 = myPrefs.getInt("Nstelle4", 0);
        int moneta = myPrefs.getInt("Moneta", 15);
        editor.putBoolean("AdminMode", admin);
        editor.putBoolean("Livello1", livello1);
        editor.putBoolean("Livello2", livello2);
        editor.putBoolean("Livello3", livello3);
        editor.putBoolean("Livello4", livello4);
        editor.putInt("PuntLivello1", puntLivello1);
        editor.putInt("PuntLivello2", puntLivello2);
        editor.putInt("PuntLivello3", puntLivello3);
        editor.putInt("PuntLivello4", puntLivello4);
        editor.putInt("Nstelle1", NStelle1);
        editor.putInt("Nstelle2", NStelle2);
        editor.putInt("Nstelle3", NStelle3);
        editor.putInt("Nstelle4", NStelle4);
        editor.putInt("Moneta", moneta);
        editor.apply();
        editor.commit();
        CatLoadingView mView;
        mView = new CatLoadingView();
        Button play = findViewById(R.id.bottonePlay);
        Intent livelli = new Intent(this, Livelli.class);
        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake_animation_infinite);
        play.startAnimation(animShake);
        play.setOnClickListener(
                (View v) -> {
                    mView.show(getSupportFragmentManager(), "");
                    new Handler().postDelayed (() -> {
                        startActivity(livelli);
                        Animatoo.animateCard(MainMenu.this);
                        finish();
                    }, 1500);


                }
        );


    }
}
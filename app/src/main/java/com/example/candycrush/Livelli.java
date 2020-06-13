package com.example.candycrush;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.roger.catloadinglibrary.CatLoadingView;

import java.util.ArrayList;
import java.util.List;


public class Livelli extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livelli);
        models = new ArrayList<>();
        models.add(new Model(R.drawable.livello1, "Livello 1", "Il primo livello del gioco consiste in una tavola 3x3 per vincere bisogna fare 20 punti", 0));
        models.add(new Model(R.drawable.livello2, "Livello 2", "Composto da una tavola 4x4 punteggio minimo per passare il livello 150 punti", 1));
        models.add(new Model(R.drawable.livello3, "Livello 3", "Composto da una tavola 5x5 punteggio minimo per passare il livello 500 punti", 2));
        models.add(new Model(R.drawable.livello4, "Livello 4", "Questo è il livello più difficile del gioco tavola 6x6 punteggio minimo 1500 punti", 3));
        SharedPreferences myPrefs;
        TextView monete = findViewById(R.id.NumeroMoneteLivelli);
        myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);

        int coin = myPrefs.getInt("Moneta", 3);
        String sup = "  " + coin;
        monete.setText(sup);


        adapter = new Adapter(models, this);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        Intent ciao = new Intent(this, Istruzioni.class);
        viewPager.setPadding(130, 0, 130, 0);
        Button istruzioni = findViewById(R.id.Istruzioni);
        CatLoadingView mView;
        mView = new CatLoadingView();
        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake_animation_infinite);
        istruzioni.startAnimation(animShake);
        istruzioni.setOnClickListener(v -> {
            mView.show(getSupportFragmentManager(), "");
            new Handler().postDelayed(() -> {
                startActivity(ciao);
                Animatoo.animateSplit(Livelli.this);
                finish();
            }, 1500);

        });
    }

}

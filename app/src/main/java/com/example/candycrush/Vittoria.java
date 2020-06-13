package com.example.candycrush;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.roger.catloadinglibrary.CatLoadingView;

import pl.droidsonroids.gif.GifImageView;

public class Vittoria extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vittoria);

        Vibrator vx = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vx.vibrate(VibrationEffect.createOneShot(1500, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {

            vx.vibrate(1500);
        }
        SharedPreferences myPrefs;
        myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPrefs.edit();
        int NLivello = myPrefs.getInt("Nlivello", 1);
        TextView livello = findViewById(R.id.Numerolivello);
        String sup = "" + NLivello;
        String finale = "Livello " + sup;
        livello.setText(finale);
        ImageView stella1 = findViewById(R.id.PrimaStella);
        ImageView stella2 = findViewById(R.id.SecondaStella);
        ImageView stella3 = findViewById(R.id.TerzaStella);
        TextView punti = findViewById(R.id.puntiVittoria);
        int moneta = myPrefs.getInt("Moneta", 0);
        TextView cMonete = findViewById(R.id.Nsoldi);

        Button rigioca = findViewById(R.id.Rigioca);
        Button avanti = findViewById(R.id.Successivo);
        Intent menu = new Intent(this, Livelli.class);
        Intent livello1 = new Intent(this, Livello1.class);
        Intent livello2 = new Intent(this, Livello2.class);
        Intent livello3 = new Intent(this, Livello3.class);
        Intent livello4 = new Intent(this, MainActivity.class);
        Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake_animation_infinite);
        avanti.startAnimation(animShake);
        CatLoadingView mView;
        mView = new CatLoadingView();
        avanti.setOnClickListener(
                (View v) -> {
                    mView.show(getSupportFragmentManager(), "");
                    new Handler().postDelayed(() -> {
                        startActivity(menu);
                        Animatoo.animateInAndOut(Vittoria.this);
                        finish();
                    }, 1500);

                });
        rigioca.setOnClickListener(
                (View v) -> {
                    mView.show(getSupportFragmentManager(), "");
                    if (NLivello == 1) {
                        new Handler().postDelayed(() -> {
                            startActivity(livello1);
                            Animatoo.animateInAndOut(Vittoria.this);
                            finish();
                        }, 1500);


                    } else if (NLivello == 2) {
                        new Handler().postDelayed(() -> {
                            startActivity(livello2);
                            Animatoo.animateInAndOut(Vittoria.this);
                            finish();
                        }, 1500);
                    } else if (NLivello == 3) {
                        new Handler().postDelayed(() -> {
                            startActivity(livello3);
                            Animatoo.animateInAndOut(Vittoria.this);
                            finish();
                        }, 1500);
                    } else if (NLivello == 4) {
                        new Handler().postDelayed(() -> {
                            startActivity(livello4);
                            Animatoo.animateInAndOut(Vittoria.this);
                            finish();
                        }, 1500);
                    }
                });
        GifImageView lucette1 = findViewById(R.id.lucette1);
        GifImageView lucette2 = findViewById(R.id.lucette2);
        GifImageView lucette3 = findViewById(R.id.lucette3);
        int punteggio = 0;
        if (NLivello == 1) {
            punteggio = myPrefs.getInt("PuntLivello1", 0);
            sup = "" + punteggio;
            punti.setText(sup);
            int numeros = myPrefs.getInt("Nstelle1", 3);
            if (numeros == 1) {
                stella1.setBackgroundResource(R.drawable.stella);
                lucette1.setVisibility(View.VISIBLE);
                animShake = AnimationUtils.loadAnimation(this, R.anim.rotazione);
                stella1.startAnimation(animShake);
                lucette2.setVisibility(View.INVISIBLE);
                lucette3.setVisibility(View.INVISIBLE);
                stella2.setBackgroundResource(R.drawable.stellavuota);
                stella3.setBackgroundResource(R.drawable.stellavuota);
                moneta++;
                sup = "+" + "1";
                cMonete.setText(sup);
                editor.putInt("Moneta", moneta);
                editor.apply();
                editor.commit();
            } else if (numeros == 2) {
                stella1.setBackgroundResource(R.drawable.stella);
                stella2.setBackgroundResource(R.drawable.stella);
                stella3.setBackgroundResource(R.drawable.stellavuota);
                lucette1.setVisibility(View.VISIBLE);
                lucette2.setVisibility(View.VISIBLE);
                animShake = AnimationUtils.loadAnimation(this, R.anim.rotazione);
                stella1.startAnimation(animShake);
                stella2.startAnimation(animShake);
                lucette3.setVisibility(View.INVISIBLE);
                moneta = moneta + 2;
                sup = "+" + "2";
                cMonete.setText(sup);
                editor.putInt("Moneta", moneta);
                editor.apply();
                editor.commit();
            } else if (numeros == 3) {
                stella1.setBackgroundResource(R.drawable.stella);
                stella2.setBackgroundResource(R.drawable.stella);
                stella3.setBackgroundResource(R.drawable.stella);
                lucette1.setVisibility(View.VISIBLE);
                lucette2.setVisibility(View.VISIBLE);
                lucette3.setVisibility(View.VISIBLE);
                animShake = AnimationUtils.loadAnimation(this, R.anim.rotazione);
                stella1.startAnimation(animShake);
                stella2.startAnimation(animShake);
                stella3.startAnimation(animShake);
                moneta = moneta + 3;
                sup = "+" + "3";
                cMonete.setText(sup);
                editor.putInt("Moneta", moneta);
                editor.apply();
                editor.commit();
            }
        } else if (NLivello == 2) {
            int numeros = myPrefs.getInt("Nstelle2", 3);
            punteggio = myPrefs.getInt("PuntLivello2", 0);
            sup = "" + punteggio;
            punti.setText(sup);
            if (numeros == 1) {
                stella1.setBackgroundResource(R.drawable.stella);
                lucette1.setVisibility(View.VISIBLE);
                animShake = AnimationUtils.loadAnimation(this, R.anim.rotazione);
                stella1.startAnimation(animShake);
                lucette2.setVisibility(View.INVISIBLE);
                lucette3.setVisibility(View.INVISIBLE);
                stella2.setBackgroundResource(R.drawable.stellavuota);
                stella3.setBackgroundResource(R.drawable.stellavuota);
                moneta++;
                sup = "+" + "1";
                cMonete.setText(sup);
                editor.putInt("Moneta", moneta);
                editor.apply();
                editor.commit();
            } else if (numeros == 2) {
                stella1.setBackgroundResource(R.drawable.stella);
                stella2.setBackgroundResource(R.drawable.stella);
                stella3.setBackgroundResource(R.drawable.stellavuota);
                lucette1.setVisibility(View.VISIBLE);
                lucette2.setVisibility(View.VISIBLE);
                animShake = AnimationUtils.loadAnimation(this, R.anim.rotazione);
                stella1.startAnimation(animShake);
                stella2.startAnimation(animShake);
                lucette3.setVisibility(View.INVISIBLE);
                moneta = moneta + 2;
                sup = "+" + "2";
                cMonete.setText(sup);
                editor.putInt("Moneta", moneta);
                editor.apply();
                editor.commit();
            } else if (numeros == 3) {
                stella1.setBackgroundResource(R.drawable.stella);
                stella2.setBackgroundResource(R.drawable.stella);
                stella3.setBackgroundResource(R.drawable.stella);
                lucette1.setVisibility(View.VISIBLE);
                lucette2.setVisibility(View.VISIBLE);
                lucette3.setVisibility(View.VISIBLE);
                animShake = AnimationUtils.loadAnimation(this, R.anim.rotazione);
                stella1.startAnimation(animShake);
                stella2.startAnimation(animShake);
                stella3.startAnimation(animShake);
                moneta = moneta + 3;
                sup = "+" + "3";
                cMonete.setText(sup);
                editor.putInt("Moneta", moneta);
                editor.apply();
                editor.commit();
            }
        } else if (NLivello == 3) {
            int numeros = myPrefs.getInt("Nstelle3", 3);
            punteggio = myPrefs.getInt("PuntLivello3", 0);
            sup = "" + punteggio;
            punti.setText(sup);
            if (numeros == 1) {
                stella1.setBackgroundResource(R.drawable.stella);
                lucette1.setVisibility(View.VISIBLE);
                animShake = AnimationUtils.loadAnimation(this, R.anim.rotazione);
                stella1.startAnimation(animShake);
                lucette2.setVisibility(View.INVISIBLE);
                lucette3.setVisibility(View.INVISIBLE);
                stella2.setBackgroundResource(R.drawable.stellavuota);
                stella3.setBackgroundResource(R.drawable.stellavuota);
                moneta++;
                sup = "+" + "1";
                cMonete.setText(sup);
                editor.putInt("Moneta", moneta);
                editor.apply();
                editor.commit();
            } else if (numeros == 2) {
                stella1.setBackgroundResource(R.drawable.stella);
                stella2.setBackgroundResource(R.drawable.stella);
                stella3.setBackgroundResource(R.drawable.stellavuota);
                lucette1.setVisibility(View.VISIBLE);
                lucette2.setVisibility(View.VISIBLE);
                animShake = AnimationUtils.loadAnimation(this, R.anim.rotazione);
                stella1.startAnimation(animShake);
                stella2.startAnimation(animShake);
                lucette3.setVisibility(View.INVISIBLE);
                moneta = moneta + 2;
                sup = "+" + "2";
                cMonete.setText(sup);
                editor.putInt("Moneta", moneta);
                editor.apply();
                editor.commit();
            } else if (numeros == 3) {
                stella1.setBackgroundResource(R.drawable.stella);
                stella2.setBackgroundResource(R.drawable.stella);
                stella3.setBackgroundResource(R.drawable.stella);
                lucette1.setVisibility(View.VISIBLE);
                lucette2.setVisibility(View.VISIBLE);
                lucette3.setVisibility(View.VISIBLE);
                animShake = AnimationUtils.loadAnimation(this, R.anim.rotazione);
                stella1.startAnimation(animShake);
                stella2.startAnimation(animShake);
                stella3.startAnimation(animShake);
                moneta = moneta + 3;
                sup = "+" + "3";
                cMonete.setText(sup);
                editor.putInt("Moneta", moneta);
                editor.apply();
                editor.commit();
            }
        } else if (NLivello == 4) {
            punteggio = myPrefs.getInt("PuntLivello4", 0);
            sup = "" + punteggio;
            punti.setText(sup);
            int numeros = myPrefs.getInt("Nstelle4", 3);
            if (numeros == 1) {
                stella1.setBackgroundResource(R.drawable.stella);
                lucette1.setVisibility(View.VISIBLE);
                animShake = AnimationUtils.loadAnimation(this, R.anim.rotazione);
                stella1.startAnimation(animShake);
                lucette2.setVisibility(View.INVISIBLE);
                lucette3.setVisibility(View.INVISIBLE);
                stella2.setBackgroundResource(R.drawable.stellavuota);
                stella3.setBackgroundResource(R.drawable.stellavuota);
                moneta++;
                sup = "+" + "1";
                cMonete.setText(sup);
                editor.putInt("Moneta", moneta);
                editor.apply();
                editor.commit();
            } else if (numeros == 2) {
                stella1.setBackgroundResource(R.drawable.stella);
                stella2.setBackgroundResource(R.drawable.stella);
                stella3.setBackgroundResource(R.drawable.stellavuota);
                lucette1.setVisibility(View.VISIBLE);
                lucette2.setVisibility(View.VISIBLE);
                animShake = AnimationUtils.loadAnimation(this, R.anim.rotazione);
                stella1.startAnimation(animShake);
                stella2.startAnimation(animShake);
                lucette3.setVisibility(View.INVISIBLE);
                moneta = moneta + 2;
                sup = "+" + "2";
                cMonete.setText(sup);
                editor.putInt("Moneta", moneta);
                editor.apply();
                editor.commit();
            } else if (numeros == 3) {
                stella1.setBackgroundResource(R.drawable.stella);
                stella2.setBackgroundResource(R.drawable.stella);
                stella3.setBackgroundResource(R.drawable.stella);
                lucette1.setVisibility(View.VISIBLE);
                lucette2.setVisibility(View.VISIBLE);
                lucette3.setVisibility(View.VISIBLE);
                animShake = AnimationUtils.loadAnimation(this, R.anim.rotazione);
                stella1.startAnimation(animShake);
                stella2.startAnimation(animShake);
                stella3.startAnimation(animShake);
                moneta = moneta + 3;
                sup = "+" + "3";
                cMonete.setText(sup);
                editor.putInt("Moneta", moneta);
                editor.apply();
                editor.commit();
            }
        }
    }
}

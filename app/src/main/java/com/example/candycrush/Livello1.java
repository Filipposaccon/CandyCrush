package com.example.candycrush;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.Random;

public class Livello1 extends AppCompatActivity {
    int mat[][] = new int[3][3];
    ImageView[][] matfot = new ImageView[3][3];
    ImageButton[][] matbut = new ImageButton[3][3];
    ObjectAnimator oggetto1;
    ObjectAnimator oggetto2;
    ObjectAnimator oggetto3;
    ObjectAnimator oggetto4;
    ImageButton aiutiverticale[] = new ImageButton[3];
    ImageButton aiutiorizzontale[] = new ImageButton[3];
    ImageButton verticale;
    ImageButton orizzontale;
    int attuale = 0;
    String sup10 = "";
    int codice = 0;
    float x1 = 0;
    float x2 = 0;
    float y1 = 0;
    float y2 = 0;
    final Handler handler = new Handler();
    int sup1 = 0;
    int sup2 = 0;
    int sup3 = 0;
    Random gh = new Random();
    AnimatorSet set = new AnimatorSet();
    int numeromosse=10;
    int obiettivo=25;
    String sup="";
    String mon="";
    SharedPreferences myPrefs;

    SensorManager mSensorManager;

    ShakeListener mSensorListener;

    void caricanumeri(int[][] mat) {
        Random seedr = new Random();
        int seed = seedr.nextInt(10000);
        Random r = new Random(seed);
        for (int i = 0; i < 3; i++) {
            for (int c = 0; c < 3; c++) {
                mat[i][c] = r.nextInt(3);
            }
        }
    }

    void caricaCaramelle(int[][] mat, ImageButton[][] matbut) {

        for (int i = 0; i < 3; i++) {
            for (int c = 0; c < 3; c++) {
                if (mat[i][c] == 0) {
                    matbut[i][c].setBackgroundResource(R.drawable.crossa);
                } else if (mat[i][c] == 1) {
                    matbut[i][c].setBackgroundResource(R.drawable.cgialla);
                } else if (mat[i][c] == 2) {
                    matbut[i][c].setBackgroundResource(R.drawable.carancione);
                } else if (mat[i][c] == 3) {
                    matbut[i][c].setBackgroundResource(R.drawable.cverde);
                } else if (mat[i][c] == 4) {
                    matbut[i][c].setBackgroundResource(R.drawable.cviola);
                } else if (mat[i][c] == 5) {
                    matbut[i][c].setBackgroundResource(R.drawable.cblue);
                }

            }
        }
    }

    void caricaimmagine(int i1, int i2, int i3, int i4) {
        if (mat[i1][i2] == 0) {
            matfot[i1][i2].setBackgroundResource(R.drawable.crossa);
        } else if (mat[i1][i2] == 1) {
            matfot[i1][i2].setBackgroundResource(R.drawable.cgialla);
        } else if (mat[i1][i2] == 2) {
            matfot[i1][i2].setBackgroundResource(R.drawable.carancione);
        } else if (mat[i1][i2] == 3) {
            matfot[i1][i2].setBackgroundResource(R.drawable.cverde);
        } else if (mat[i1][i2] == 4) {
            matfot[i1][i2].setBackgroundResource(R.drawable.cviola);
        } else if (mat[i1][i2] == 5) {
            matfot[i1][i2].setBackgroundResource(R.drawable.cblue);
        }
        if (mat[i3][i4] == 0) {
            matfot[i3][i4].setBackgroundResource(R.drawable.crossa);
        } else if (mat[i3][i4] == 1) {
            matfot[i3][i4].setBackgroundResource(R.drawable.cgialla);
        } else if (mat[i3][i4] == 2) {
            matfot[i3][i4].setBackgroundResource(R.drawable.carancione);
        } else if (mat[i3][i4] == 3) {
            matfot[i3][i4].setBackgroundResource(R.drawable.cverde);
        } else if (mat[i3][i4] == 4) {
            matfot[i3][i4].setBackgroundResource(R.drawable.cviola);
        } else if (mat[i3][i4] == 5) {
            matfot[i3][i4].setBackgroundResource(R.drawable.cblue);
        }

    }

    void cercauguali() {//cambiare il nome in cerca uguali orizzontale
        Random seedr = new Random();
        int seed = seedr.nextInt(10000);
        Random r = new Random(seed);
        for (int i = 0; i < 3; i++) {
            for (int c = 0; c + 2 < 3; c++) {
                if (mat[i][c] == mat[i][c + 1] && mat[i][c] == mat[i][c + 2]) {
                    attuale=attuale+15;
                    if (i == 0) {
                        mat[i][c] = r.nextInt(6);
                        mat[i][c + 1] = r.nextInt(6);
                        mat[i][c + 2] = r.nextInt(6);
                        caricaCaramelle(mat, matbut);
                    } else {
                        for (int j = i; j >= 0; j--) {
                            if (j == 0) {
                                mat[j][c] = r.nextInt(6);
                                mat[j][c + 1] =r.nextInt(6);
                                mat[j][c + 2] = r.nextInt(6);
                            } else {
                                sup1 = mat[j - 1][c];
                                sup2 = mat[j - 1][c + 1];
                                sup3 = mat[j - 1][c + 2];
                                mat[j][c] = sup1;
                                mat[j][c + 1] = sup2;
                                mat[j][c + 2] = sup3;
                            }
                        }
                        caricaCaramelle(mat, matbut);

                    }
                }
            }
        }//orizzontale 3
    }

    void cercaugualiverticale() {
        Random seedr = new Random();
        int seed = seedr.nextInt(10000);
        Random r = new Random(seed);

        for (int i = 0; i < 3; i++) {
            for (int c = 0; c + 2 < 3; c++) {
                if (mat[c][i] == mat[c + 1][i] && mat[c][i] == mat[c + 2][i]) {
                    attuale=attuale+15;
                    int test1 = c + 1;
                    int test2 = c + 2;
                    if (c == 0 && test1 == 1 && test2 == 2) {
                        mat[c][i] = r.nextInt(6);
                        mat[c + 1][i] = r.nextInt(6);
                        mat[c + 2][i] =r.nextInt(6);
                        caricaCaramelle(mat, matbut);
                    } else if (c == 1 && test1 == 2 && test2 == 3) {
                        mat[c + 2][i] = mat[0][i];
                        mat[c][i] = r.nextInt(6);
                        mat[c + 1][i] = r.nextInt(6);
                        mat[0][i] = r.nextInt(6);
                        caricaCaramelle(mat, matbut);
                    } else if (c == 2 && test1 == 3 && test2 == 4) {
                        mat[c + 2][i] = mat[1][i];
                        mat[c][i] = r.nextInt(6);
                        mat[c + 1][i] = mat[0][i];
                        mat[0][i] = r.nextInt(6);
                        mat[1][i] = r.nextInt(6);
                        caricaCaramelle(mat, matbut);
                    } else if (c == 3 && test1 == 4 && test2 == 5) {
                        mat[c + 2][i] = mat[2][i];
                        mat[c + 1][i] = mat[1][i];
                        mat[c][i] = mat[0][i];
                        mat[0][i] = r.nextInt(6);
                        mat[1][i] = r.nextInt(6);
                        mat[2][i] = r.nextInt(6);
                        caricaCaramelle(mat, matbut);
                    }
                }
            }
        }//verticali 3
    }
    void rimuovicolonna(int pos) {
        mat[0][pos] = gh.nextInt(6);
        mat[1][pos] = gh.nextInt(6);
        mat[2][pos] = gh.nextInt(6);
        caricaCaramelle(mat, matbut);
        cercauguali();
        cercaugualiverticale();
    }

    void rimuoviriga(int pos) {
        if (pos == 0) {
            mat[pos][0] = gh.nextInt(6);
            mat[pos][1] = gh.nextInt(6);
            mat[pos][2] = gh.nextInt(6);
            caricaCaramelle(mat, matbut);
            cercauguali();
            cercaugualiverticale();
        } else {
            for (; pos >= 0; pos--) {
                if (pos == 0) {
                    mat[pos][0] = gh.nextInt(6);
                    mat[pos][1] = gh.nextInt(6);
                    mat[pos][2] = gh.nextInt(6);
                    caricaCaramelle(mat, matbut);
                    cercauguali();
                    cercaugualiverticale();
                } else {
                    sup1 = mat[pos - 1][0];
                    sup2 = mat[pos - 1][1];
                    sup3 = mat[pos - 1][2];
                    mat[pos][0] = sup1;
                    mat[pos][1] = sup2;
                    mat[pos][2] = sup3;

                }
            }
        }

    }

    int coin=0;
    @Override
    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livello1);


        matbut[0][0] = findViewById(R.id.Bottone1L1);
        matbut[0][1] = findViewById(R.id.Bottone2L1);
        matbut[0][2] = findViewById(R.id.Bottone3L1);
        matbut[1][0] = findViewById(R.id.Bottone4L1);
        matbut[1][1] = findViewById(R.id.Bottone5L1);
        matbut[1][2] = findViewById(R.id.Bottone6L1);
        matbut[2][0] = findViewById(R.id.Bottone7L1);
        matbut[2][1] = findViewById(R.id.Bottone8L1);
        matbut[2][2] = findViewById(R.id.Bottone9L1);
        //foto
        matfot[0][0] = findViewById(R.id.Foto1L1);
        matfot[0][1] = findViewById(R.id.Foto2L1);
        matfot[0][2] = findViewById(R.id.Foto3L1);
        matfot[1][0] = findViewById(R.id.Foto4L1);
        matfot[1][1] = findViewById(R.id.Foto5L1);
        matfot[1][2] = findViewById(R.id.Foto6L1);
        matfot[2][0] = findViewById(R.id.Foto7L1);
        matfot[2][1] = findViewById(R.id.Foto8L1);
        matfot[2][2] = findViewById(R.id.Foto9L1);
        //aiuti
        //carico array per gli aiuti verticali
        aiutiverticale[0] = findViewById(R.id.verticalec1L1);
        aiutiverticale[1] = findViewById(R.id.verticalec2L1);
        aiutiverticale[2] = findViewById(R.id.verticalec3L1);
        //carica array per gli aiuti orizzontali
        aiutiorizzontale[0] = findViewById(R.id.orizzontalec1L1);
        aiutiorizzontale[1] = findViewById(R.id.orizzontalec2L1);
        aiutiorizzontale[2] = findViewById(R.id.orizzontalec3L1);
        verticale = findViewById(R.id.verticaleL1);
        orizzontale = findViewById(R.id.orizzontaleL1);
        myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
        coin=myPrefs.getInt("Moneta",3);
        TextView monete=findViewById(R.id.numeromoneteL1);
        mon=" "+" "+coin;
        monete.setText(mon);
        ProgressBar bar1 = findViewById(R.id.barralivelloL1);
        ProgressBar bar2 = findViewById(R.id.barrapuntiL1);
        bar1.setMax(numeromosse);
        caricanumeri(mat);
        caricaCaramelle(mat, matbut);
        cercauguali();
        cercaugualiverticale();
        attuale = 0;
        bar2.setMax(obiettivo);
        sup10 = "" + attuale;
        TextView t = findViewById(R.id.numeromosseL1);
        TextView t1 = findViewById(R.id.numeropuntiL1);
        sup=""+numeromosse;
        t.setText(sup);
        t1.setText(sup10);

        //AIUTI

        for (int i = 0; i < 3; i++) {
            aiutiorizzontale[i].setVisibility(View.GONE);
            aiutiverticale[i].setVisibility(View.GONE);
        }

        for (int i = 0; i < 3; i++) {
            final int c = i;
            aiutiorizzontale[i].setOnClickListener(v -> {
                rimuoviriga(c);
                for (int x = 0; x < 3; x++) {
                    aiutiorizzontale[x].setVisibility(View.GONE);
                    aiutiverticale[x].setVisibility(View.GONE);
                }
            });

        }

        for (int i = 0; i < 3; i++) {
            final int c = i;
            aiutiverticale[i].setOnClickListener(v -> {
                rimuovicolonna(c);
                for (int x = 0; x < 3; x++) {
                    aiutiorizzontale[x].setVisibility(View.GONE);
                    aiutiverticale[x].setVisibility(View.GONE);
                }
            });

        }
        verticale.setOnClickListener(v -> {
            if (coin > 0) {
                for (int i = 0; i < 3; i++) {
                    aiutiverticale[i].setVisibility(View.VISIBLE);
                }
                coin--;
                mon = " " + " " + coin;
                monete.setText(mon);
            } else {
                Toast.makeText(Livello1.this, "Numero di monete insufficente", Toast.LENGTH_LONG).show();
            }

        });

        orizzontale.setOnClickListener(v -> {
            if (coin > 0) {
                for (int i = 0; i < 3; i++) {
                    aiutiorizzontale[i].setVisibility(View.VISIBLE);
                }
                coin--;
                mon = " " + " " + coin;
                monete.setText(mon);
            } else {
                Toast.makeText(Livello1.this, "Numero di monete insufficente", Toast.LENGTH_LONG).show();
            }

        });
        //aggiunta mosse
        ImageButton mosse = findViewById(R.id.piumosseL1);
        mosse.setOnClickListener(v -> {
            if (coin > 0) {
                numeromosse = numeromosse + 3;
                coin--;
                mon = " " + " " + coin;
                monete.setText(mon);
                sup = "" + numeromosse;
                t.setText(sup);
                bar1.setProgress(numeromosse);
            } else {
                Toast.makeText(Livello1.this, "Numero di monete insufficenti", Toast.LENGTH_LONG).show();
            }

        });

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorListener = new ShakeListener();
        mSensorListener.setOnShakeListener(new ShakeListener.OnShakeListener() {
            public void onShake() {
                Toast.makeText(Livello1.this, "La tavola è stata aggiornata e ti sono stati aggiunti dei punti in regalo ", Toast.LENGTH_LONG).show();
                caricanumeri(mat);
                caricaCaramelle(mat, matbut);
                cercauguali();
                cercaugualiverticale();
                if (numeromosse == 3) {
                    numeromosse = numeromosse - 3;
                    if (attuale >= obiettivo) {

                        myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = myPrefs.edit();
                        boolean livello2 = myPrefs.getBoolean("Livello2", false);
                        livello2 = true;
                        editor.putBoolean("Livello2", true);
                        int puntLivello1 = myPrefs.getInt("PuntLivello1", 0);
                        puntLivello1 = attuale;
                        editor.putInt("PuntLivello1", puntLivello1);
                        int NLivello = 1;
                        editor.putInt("Nlivello", NLivello);
                        int NStelle1=3;
                        editor.putInt("Nstelle1",NStelle1);
                        editor.putInt("PuntLivello1",attuale);
                        editor.putInt("Moneta",coin);
                        editor.apply();
                        editor.commit();
                        Intent vittoria=new Intent(Livello1.this,Vittoria.class);
                        startActivity(vittoria);
                        Animatoo.animateDiagonal(Livello1.this);
                        finish();
                    } else {
                        Intent sconfitta=new Intent(Livello1.this,Sconfitta.class);
                        SharedPreferences myPrefs;
                        myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = myPrefs.edit();
                        editor.putInt("Obiettivo",obiettivo);
                        int NLivello = 1;
                        editor.putInt("Nlivello", NLivello);
                        editor.putInt("Moneta",coin);
                        editor.apply();
                        editor.commit();
                        startActivity(sconfitta);
                        Animatoo.animateDiagonal(Livello1.this);
                        finish();
                    }

                } else if (numeromosse > 3) {
                    numeromosse = numeromosse - 3;
                    sup10 = "" + attuale;
                    sup = "" + numeromosse;
                    t.setText(sup);
                    t1.setText(sup10);
                }
            }
        });
        matbut[0][0].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {
                matbut[0][0].setBackgroundColor(0x00000000);
                matbut[0][1].setBackgroundColor(0x00000000);
                caricaimmagine(0, 0, 0, 1);
                x1 = matbut[0][0].getX();
                x2 = matbut[0][1].getX();
                y1 = matbut[0][0].getY();
                y2 = matbut[0][1].getY();
                oggetto2 = ObjectAnimator.ofFloat(matfot[0][0], "x", x1, x2);
                oggetto4 = ObjectAnimator.ofFloat(matfot[0][1], "x", x2, x1);
                set.playTogether(oggetto2, oggetto4);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[0][0];
                    mat[0][0] = mat[0][1];
                    mat[0][1] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[0][0].setBackgroundColor(0x00000000);
                    matfot[0][1].setBackgroundColor(0x00000000);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[0][1], "x", x1, x2);
                    oggetto4 = ObjectAnimator.ofFloat(matfot[0][0], "x", x2, x1);
                    set.playTogether(oggetto2, oggetto4);
                    set.start();
                    cercauguali();
                    cercaugualiverticale();
                    cercauguali();
                    cercaugualiverticale();
                }, 1000);
                sup10 = "" + attuale;
                numeromosse--;
                sup = "" + numeromosse;
                t.setText(sup);
                t1.setText(sup10);
                bar1.setProgress(numeromosse);
                bar2.setProgress(attuale);
                if(numeromosse==0&&attuale>=obiettivo)
                {
                    Intent vittoria=new Intent(Livello1.this,Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello2",true);
                    int NStelle1=3;
                    editor.putInt("Nstelle1",NStelle1);
                    editor.putInt("Moneta",coin);
                    editor.putInt("PuntLivello1",attuale);
                    int NLivello = 1;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }
                if(numeromosse==0&&attuale<obiettivo)
                {//aggiungere le robe da passare
                    Intent sconfitta=new Intent(Livello1.this,Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo",obiettivo);
                    int NLivello = 1;
                    editor.putInt("Moneta",coin);
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }


            }
        });
        matbut[0][1].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {
                matbut[0][1].setBackgroundColor(0x00000000);
                matbut[0][2].setBackgroundColor(0x00000000);
                caricaimmagine(0, 1, 0, 2);
                x1 = matbut[0][1].getX();
                x2 = matbut[0][2].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[0][1], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[0][2], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[0][1];
                    mat[0][1] = mat[0][2];
                    mat[0][2] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[0][1].setBackgroundColor(0x00000000);
                    matfot[0][2].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[0][2], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[0][1], "x", x2, x1);
                    set.playTogether(oggetto1, oggetto2);
                    set.start();
                    cercauguali();
                    cercaugualiverticale();
                    cercauguali();
                    cercaugualiverticale();
                }, 1000);
                sup10 = "" + attuale;
                numeromosse--;
                sup = "" + numeromosse;
                t.setText(sup);
                t1.setText(sup10);
                bar1.setProgress(numeromosse);
                bar2.setProgress(attuale);
                if(numeromosse==0&&attuale>=obiettivo)
                {
                    Intent vittoria=new Intent(Livello1.this,Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello2",true);
                    int NStelle1=3;
                    editor.putInt("Nstelle1",NStelle1);
                    editor.putInt("Moneta",coin);
                    editor.putInt("PuntLivello1",attuale);
                    int NLivello = 1;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }
                if(numeromosse==0&&attuale<obiettivo)
                {//aggiungere le robe da passare
                    Intent sconfitta=new Intent(Livello1.this,Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo",obiettivo);
                    int NLivello = 1;
                    editor.putInt("Moneta",coin);
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }


            }

            @Override
            public void onSwipeLeft() {
                matbut[0][1].setBackgroundColor(0x00000000);
                matbut[0][0].setBackgroundColor(0x00000000);
                caricaimmagine(0, 1, 0, 0);
                x1 = matbut[0][1].getX();
                x2 = matbut[0][0].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[0][1], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[0][0], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[0][1];
                    mat[0][1] = mat[0][0];
                    mat[0][0] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[0][1].setBackgroundColor(0x00000000);
                    matfot[0][0].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[0][0], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[0][1], "x", x2, x1);
                    set.playTogether(oggetto1, oggetto2);
                    set.start();
                    cercauguali();
                    cercaugualiverticale();
                    cercauguali();
                    cercaugualiverticale();
                }, 1000);
                sup10 = "" + attuale;
                numeromosse--;
                sup = "" + numeromosse;
                t.setText(sup);
                t1.setText(sup10);
                bar1.setProgress(numeromosse);
                bar2.setProgress(attuale);
                if(numeromosse==0&&attuale>=obiettivo)
                {
                    Intent vittoria=new Intent(Livello1.this,Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello2",true);
                    int NStelle1=3;
                    editor.putInt("Nstelle1",NStelle1);
                    editor.putInt("Moneta",coin);
                    editor.putInt("PuntLivello1",attuale);
                    int NLivello = 1;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }
                if(numeromosse==0&&attuale<obiettivo)
                {//aggiungere le robe da passare
                    Intent sconfitta=new Intent(Livello1.this,Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo",obiettivo);
                    int NLivello = 1;
                    editor.putInt("Moneta",coin);
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }



            }
        });
        matbut[0][2].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[0][2].setBackgroundColor(0x00000000);
                matbut[0][3].setBackgroundColor(0x00000000);
                caricaimmagine(0, 2, 0, 3);
                x1 = matbut[0][2].getX();
                x2 = matbut[0][3].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[0][2], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[0][3], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[0][2];
                    mat[0][2] = mat[0][3];
                    mat[0][3] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[0][2].setBackgroundColor(0x00000000);
                    matfot[0][3].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[0][3], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[0][2], "x", x2, x1);
                    set.playTogether(oggetto1, oggetto2);
                    set.start();
                    cercauguali();
                    cercaugualiverticale();
                    cercauguali();
                    cercaugualiverticale();
                }, 1000);
                sup10 = "" + attuale;
                numeromosse--;
                sup = "" + numeromosse;
                t.setText(sup);
                t1.setText(sup10);
                bar1.setProgress(numeromosse);
                bar2.setProgress(attuale);
                if(numeromosse==0&&attuale>=obiettivo)
                {
                    Intent vittoria=new Intent(Livello1.this,Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello2",true);
                    int NStelle1=3;
                    editor.putInt("Nstelle1",NStelle1);
                    editor.putInt("Moneta",coin);
                    editor.putInt("PuntLivello1",attuale);
                    int NLivello = 1;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }
                if(numeromosse==0&&attuale<obiettivo)
                {//aggiungere le robe da passare
                    Intent sconfitta=new Intent(Livello1.this,Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo",obiettivo);
                    int NLivello = 1;
                    editor.putInt("Moneta",coin);
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }



            }

            @Override
            public void onSwipeLeft() {
                matbut[0][2].setBackgroundColor(0x00000000);
                matbut[0][1].setBackgroundColor(0x00000000);
                caricaimmagine(0, 2, 0, 1);
                x1 = matbut[0][2].getX();
                x2 = matbut[0][1].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[0][2], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[0][1], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[0][2];
                    mat[0][2] = mat[0][1];
                    mat[0][1] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[0][2].setBackgroundColor(0x00000000);
                    matfot[0][1].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[0][1], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[0][2], "x", x2, x1);
                    set.playTogether(oggetto1, oggetto2);
                    set.start();
                    cercauguali();
                    cercaugualiverticale();
                    cercauguali();
                    cercaugualiverticale();
                }, 1000);
                sup10 = "" + attuale;
                numeromosse--;
                sup = "" + numeromosse;
                t.setText(sup);
                t1.setText(sup10);
                bar1.setProgress(numeromosse);
                bar2.setProgress(attuale);
                if(numeromosse==0&&attuale>=obiettivo)
                {
                    Intent vittoria=new Intent(Livello1.this,Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello2",true);
                    int NStelle1=3;
                    editor.putInt("Nstelle1",NStelle1);
                    editor.putInt("Moneta",coin);
                    editor.putInt("PuntLivello1",attuale);
                    int NLivello = 1;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }
                if(numeromosse==0&&attuale<obiettivo)
                {//aggiungere le robe da passare
                    Intent sconfitta=new Intent(Livello1.this,Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo",obiettivo);
                    int NLivello = 1;
                    editor.putInt("Moneta",coin);
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }


            }
        });
        matbut[1][0].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[1][0].setBackgroundColor(0x00000000);
                matbut[1][1].setBackgroundColor(0x00000000);
                caricaimmagine(1, 0, 1, 1);
                x1 = matbut[1][0].getX();
                x2 = matbut[1][1].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[1][0], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[1][1], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[1][0];
                    mat[1][0] = mat[1][1];
                    mat[1][1] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[1][0].setBackgroundColor(0x00000000);
                    matfot[1][1].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[1][0], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[1][1], "x", x2, x1);
                    set.playTogether(oggetto1, oggetto2);
                    set.start();
                    cercauguali();
                    cercaugualiverticale();
                    cercauguali();
                    cercaugualiverticale();
                }, 1000);
                sup10 = "" + attuale;
                numeromosse--;
                sup = "" + numeromosse;
                t.setText(sup);
                t1.setText(sup10);
                bar1.setProgress(numeromosse);
                bar2.setProgress(attuale);
                if(numeromosse==0&&attuale>=obiettivo)
                {
                    Intent vittoria=new Intent(Livello1.this,Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello2",true);
                    int NStelle1=3;
                    editor.putInt("Nstelle1",NStelle1);
                    editor.putInt("Moneta",coin);
                    editor.putInt("PuntLivello1",attuale);
                    int NLivello = 1;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }
                if(numeromosse==0&&attuale<obiettivo)
                {//aggiungere le robe da passare
                    Intent sconfitta=new Intent(Livello1.this,Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo",obiettivo);
                    int NLivello = 1;
                    editor.putInt("Moneta",coin);
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }


            }
        });
        matbut[1][1].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[1][1].setBackgroundColor(0x00000000);
                matbut[1][2].setBackgroundColor(0x00000000);
                caricaimmagine(1, 1, 1, 2);
                x1 = matbut[1][1].getX();
                x2 = matbut[1][2].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[1][1], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[1][2], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[1][1];
                    mat[1][1] = mat[1][2];
                    mat[1][2] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[1][1].setBackgroundColor(0x00000000);
                    matfot[1][2].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[1][2], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[1][1], "x", x2, x1);
                    set.playTogether(oggetto1, oggetto2);
                    set.start();
                    cercauguali();
                    cercaugualiverticale();
                    cercauguali();
                    cercaugualiverticale();
                }, 1000);
                sup10 = "" + attuale;
                numeromosse--;
                sup = "" + numeromosse;
                t.setText(sup);
                t1.setText(sup10);
                bar1.setProgress(numeromosse);
                bar2.setProgress(attuale);
                if(numeromosse==0&&attuale>=obiettivo)
                {
                    Intent vittoria=new Intent(Livello1.this,Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello2",true);
                    int NStelle1=3;
                    editor.putInt("Nstelle1",NStelle1);
                    editor.putInt("Moneta",coin);
                    editor.putInt("PuntLivello1",attuale);
                    int NLivello = 1;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }
                if(numeromosse==0&&attuale<obiettivo)
                {//aggiungere le robe da passare
                    Intent sconfitta=new Intent(Livello1.this,Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo",obiettivo);
                    int NLivello = 1;
                    editor.putInt("Moneta",coin);
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }


            }

            @Override
            public void onSwipeLeft() {
                matbut[1][1].setBackgroundColor(0x00000000);
                matbut[1][0].setBackgroundColor(0x00000000);
                caricaimmagine(1, 1, 1, 0);
                x1 = matbut[1][1].getX();
                x2 = matbut[1][0].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[1][1], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[1][0], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[1][1];
                    mat[1][1] = mat[1][0];
                    mat[1][0] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[1][1].setBackgroundColor(0x00000000);
                    matfot[1][0].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[1][0], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[1][1], "x", x2, x1);
                    set.playTogether(oggetto1, oggetto2);
                    set.start();
                    cercauguali();
                    cercaugualiverticale();
                    cercauguali();
                    cercaugualiverticale();
                }, 1000);
                sup10 = "" + attuale;
                numeromosse--;
                sup = "" + numeromosse;
                t.setText(sup);
                t1.setText(sup10);
                bar1.setProgress(numeromosse);
                bar2.setProgress(attuale);
                if(numeromosse==0&&attuale>=obiettivo)
                {
                    Intent vittoria=new Intent(Livello1.this,Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello2",true);
                    int NStelle1=3;
                    editor.putInt("Nstelle1",NStelle1);
                    editor.putInt("Moneta",coin);
                    editor.putInt("PuntLivello1",attuale);
                    int NLivello = 1;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }
                if(numeromosse==0&&attuale<obiettivo)
                {//aggiungere le robe da passare
                    Intent sconfitta=new Intent(Livello1.this,Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo",obiettivo);
                    int NLivello = 1;
                    editor.putInt("Moneta",coin);
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }


            }

        });
        matbut[1][2].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[1][2].setBackgroundColor(0x00000000);
                matbut[1][3].setBackgroundColor(0x00000000);
                caricaimmagine(1, 2, 1, 3);
                x1 = matbut[1][2].getX();
                x2 = matbut[1][3].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[1][2], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[1][3], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[1][2];
                    mat[1][2] = mat[1][3];
                    mat[1][3] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[1][2].setBackgroundColor(0x00000000);
                    matfot[1][3].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[1][3], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[1][2], "x", x2, x1);
                    set.playTogether(oggetto1, oggetto2);
                    set.start();
                    cercauguali();
                    cercaugualiverticale();
                    cercauguali();
                    cercaugualiverticale();
                }, 1000);
                sup10 = "" + attuale;
                numeromosse--;
                sup = "" + numeromosse;
                t.setText(sup);
                t1.setText(sup10);
                bar1.setProgress(numeromosse);
                bar2.setProgress(attuale);
                if(numeromosse==0&&attuale>=obiettivo)
                {
                    Intent vittoria=new Intent(Livello1.this,Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello2",true);
                    int NStelle1=3;
                    editor.putInt("Nstelle1",NStelle1);
                    editor.putInt("Moneta",coin);
                    editor.putInt("PuntLivello1",attuale);
                    int NLivello = 1;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }
                if(numeromosse==0&&attuale<obiettivo)
                {//aggiungere le robe da passare
                    Intent sconfitta=new Intent(Livello1.this,Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo",obiettivo);
                    int NLivello = 1;
                    editor.putInt("Moneta",coin);
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }


            }

            @Override
            public void onSwipeLeft() {
                matbut[1][2].setBackgroundColor(0x00000000);
                matbut[1][1].setBackgroundColor(0x00000000);
                caricaimmagine(1, 2, 1, 1);
                x1 = matbut[1][2].getX();
                x2 = matbut[1][1].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[1][2], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[1][1], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[1][2];
                    mat[1][2] = mat[1][1];
                    mat[1][1] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[1][2].setBackgroundColor(0x00000000);
                    matfot[1][1].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[1][1], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[1][2], "x", x2, x1);
                    set.playTogether(oggetto1, oggetto2);
                    set.start();
                    cercauguali();
                    cercaugualiverticale();
                    cercauguali();
                    cercaugualiverticale();
                }, 1000);
                sup10 = "" + attuale;
                numeromosse--;
                sup = "" + numeromosse;
                t.setText(sup);
                t1.setText(sup10);
                bar1.setProgress(numeromosse);
                bar2.setProgress(attuale);
                if(numeromosse==0&&attuale>=obiettivo)
                {
                    Intent vittoria=new Intent(Livello1.this,Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello2",true);
                    int NStelle1=3;
                    editor.putInt("Nstelle1",NStelle1);
                    editor.putInt("Moneta",coin);
                    editor.putInt("PuntLivello1",attuale);
                    int NLivello = 1;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }
                if(numeromosse==0&&attuale<obiettivo)
                {//aggiungere le robe da passare
                    Intent sconfitta=new Intent(Livello1.this,Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo",obiettivo);
                    int NLivello = 1;
                    editor.putInt("Moneta",coin);
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }


            }


        });

        matbut[2][0].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[2][0].setBackgroundColor(0x00000000);
                matbut[2][1].setBackgroundColor(0x00000000);
                caricaimmagine(2, 0, 2, 1);
                x1 = matbut[2][0].getX();
                x2 = matbut[2][1].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[2][0], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[2][1], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[2][0];
                    mat[2][0] = mat[2][1];
                    mat[2][1] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[2][0].setBackgroundColor(0x00000000);
                    matfot[2][1].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[2][0], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[2][1], "x", x2, x1);
                    set.playTogether(oggetto1, oggetto2);
                    set.start();
                    cercauguali();
                    cercaugualiverticale();
                    cercauguali();
                    cercaugualiverticale();
                }, 1000);
                sup10 = "" + attuale;
                numeromosse--;
                sup = "" + numeromosse;
                t.setText(sup);
                t1.setText(sup10);
                bar1.setProgress(numeromosse);
                bar2.setProgress(attuale);
                if(numeromosse==0&&attuale>=obiettivo)
                {
                    Intent vittoria=new Intent(Livello1.this,Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello2",true);
                    int NStelle1=3;
                    editor.putInt("Nstelle1",NStelle1);
                    editor.putInt("Moneta",coin);
                    editor.putInt("PuntLivello1",attuale);
                    int NLivello = 1;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }
                if(numeromosse==0&&attuale<obiettivo)
                {//aggiungere le robe da passare
                    Intent sconfitta=new Intent(Livello1.this,Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo",obiettivo);
                    int NLivello = 1;
                    editor.putInt("Moneta",coin);
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }




            }
        });
        matbut[2][1].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[2][1].setBackgroundColor(0x00000000);
                matbut[2][2].setBackgroundColor(0x00000000);
                caricaimmagine(2, 1, 2, 2);
                x1 = matbut[2][1].getX();
                x2 = matbut[2][2].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[2][1], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[2][2], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[2][1];
                    mat[2][1] = mat[2][2];
                    mat[2][2] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[2][1].setBackgroundColor(0x00000000);
                    matfot[2][2].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[2][2], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[2][1], "x", x2, x1);
                    set.playTogether(oggetto1, oggetto2);
                    set.start();
                    cercauguali();
                    cercaugualiverticale();
                    cercauguali();
                    cercaugualiverticale();
                }, 1000);

                sup10 = "" + attuale;
                numeromosse--;
                sup = "" + numeromosse;
                t.setText(sup);
                t1.setText(sup10);
                bar1.setProgress(numeromosse);
                bar2.setProgress(attuale);
                if(numeromosse==0&&attuale>=obiettivo)
                {
                    Intent vittoria=new Intent(Livello1.this,Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello2",true);
                    int NStelle1=3;
                    editor.putInt("Nstelle1",NStelle1);
                    editor.putInt("Moneta",coin);
                    editor.putInt("PuntLivello1",attuale);
                    int NLivello = 1;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }
                if(numeromosse==0&&attuale<obiettivo)
                {//aggiungere le robe da passare
                    Intent sconfitta=new Intent(Livello1.this,Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo",obiettivo);
                    int NLivello = 1;
                    editor.putInt("Moneta",coin);
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }


            }

            @Override
            public void onSwipeLeft() {
                matbut[2][1].setBackgroundColor(0x00000000);
                matbut[2][0].setBackgroundColor(0x00000000);
                caricaimmagine(2, 1, 2, 0);
                x1 = matbut[2][1].getX();
                x2 = matbut[2][0].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[2][1], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[2][0], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[2][1];
                    mat[2][1] = mat[2][0];
                    mat[2][0] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[2][1].setBackgroundColor(0x00000000);
                    matfot[2][0].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[2][0], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[2][1], "x", x2, x1);
                    set.playTogether(oggetto1, oggetto2);
                    set.start();
                    cercauguali();
                    cercaugualiverticale();
                    cercauguali();
                    cercaugualiverticale();
                }, 1000);

                sup10 = "" + attuale;
                numeromosse--;
                sup = "" + numeromosse;
                t.setText(sup);
                t1.setText(sup10);
                bar1.setProgress(numeromosse);
                bar2.setProgress(attuale);
                if(numeromosse==0&&attuale>=obiettivo)
                {
                    Intent vittoria=new Intent(Livello1.this,Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello2",true);
                    int NStelle1=3;
                    editor.putInt("Nstelle1",NStelle1);
                    editor.putInt("Moneta",coin);
                    editor.putInt("PuntLivello1",attuale);
                    int NLivello = 1;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }
                if(numeromosse==0&&attuale<obiettivo)
                {//aggiungere le robe da passare
                    Intent sconfitta=new Intent(Livello1.this,Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo",obiettivo);
                    int NLivello = 1;
                    editor.putInt("Moneta",coin);
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }


            }


        });
        matbut[2][2].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[2][2].setBackgroundColor(0x00000000);
                matbut[2][3].setBackgroundColor(0x00000000);
                caricaimmagine(2, 2, 2, 3);
                x1 = matbut[2][2].getX();
                x2 = matbut[2][3].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[2][2], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[2][3], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[2][2];
                    mat[2][2] = mat[2][3];
                    mat[2][3] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[2][2].setBackgroundColor(0x00000000);
                    matfot[2][3].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[2][3], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[2][2], "x", x2, x1);
                    set.playTogether(oggetto1, oggetto2);
                    set.start();
                    cercauguali();
                    cercaugualiverticale();
                    cercauguali();
                    cercaugualiverticale();
                }, 1000);
                sup10 = "" + attuale;
                numeromosse--;
                sup = "" + numeromosse;
                t.setText(sup);
                t1.setText(sup10);
                bar1.setProgress(numeromosse);
                bar2.setProgress(attuale);
                if(numeromosse==0&&attuale>=obiettivo)
                {
                    Intent vittoria=new Intent(Livello1.this,Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello2",true);
                    int NStelle1=3;
                    editor.putInt("Nstelle1",NStelle1);
                    editor.putInt("Moneta",coin);
                    editor.putInt("PuntLivello1",attuale);
                    int NLivello = 1;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }
                if(numeromosse==0&&attuale<obiettivo)
                {//aggiungere le robe da passare
                    Intent sconfitta=new Intent(Livello1.this,Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo",obiettivo);
                    int NLivello = 1;
                    editor.putInt("Moneta",coin);
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }


            }

            @Override
            public void onSwipeLeft() {
                matbut[2][2].setBackgroundColor(0x00000000);
                matbut[2][1].setBackgroundColor(0x00000000);
                caricaimmagine(2, 2, 2, 1);
                x1 = matbut[2][2].getX();
                x2 = matbut[2][1].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[2][2], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[2][1], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[2][2];
                    mat[2][2] = mat[2][1];
                    mat[2][1] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[2][2].setBackgroundColor(0x00000000);
                    matfot[2][1].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[2][1], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[2][2], "x", x2, x1);
                    set.playTogether(oggetto1, oggetto2);
                    set.start();
                    cercauguali();
                    cercaugualiverticale();
                    cercauguali();
                    cercaugualiverticale();
                }, 1000);
                sup10 = "" + attuale;
                numeromosse--;
                sup = "" + numeromosse;
                t.setText(sup);
                t1.setText(sup10);
                bar1.setProgress(numeromosse);
                bar2.setProgress(attuale);
                if(numeromosse==0&&attuale>=obiettivo)
                {
                    Intent vittoria=new Intent(Livello1.this,Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello2",true);
                    int NStelle1=3;
                    editor.putInt("Nstelle1",NStelle1);
                    editor.putInt("Moneta",coin);
                    editor.putInt("PuntLivello1",attuale);
                    int NLivello = 1;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }
                if(numeromosse==0&&attuale<obiettivo)
                {//aggiungere le robe da passare
                    Intent sconfitta=new Intent(Livello1.this,Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo",obiettivo);
                    int NLivello = 1;
                    editor.putInt("Moneta",coin);
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello1.this);
                    finish();
                }


            }

        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mSensorListener,
                mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mSensorListener);
        super.onPause();
    }
}

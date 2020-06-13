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

public class Livello3 extends AppCompatActivity {
    int mat[][] = new int[5][5];
    ImageView[][] matfot = new ImageView[5][5];
    ImageButton[][] matbut = new ImageButton[5][5];
    ImageButton aiutiverticale[] = new ImageButton[5];
    ImageButton aiutiorizzontale[] = new ImageButton[5];
    ImageButton verticale;
    ImageButton orizzontale;
    ObjectAnimator oggetto1;
    ObjectAnimator oggetto2;
    ObjectAnimator oggetto3;
    ObjectAnimator oggetto4;
    int sup4 = 0;
    int sup5 = 0;
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
    int numeromosse = 50;
    int punteggio1stella = 500;
    int punteggio2Stelle = 550;
    int punteggio3stelle = 600;
    String sup = "";
    String mon = "";
    int coin = 0;
    SharedPreferences myPrefs;

    SensorManager mSensorManager;

    ShakeListener mSensorListener;

    void caricanumeri(int[][] mat) {
        Random seedr = new Random();
        int seed = seedr.nextInt(10000);
        Random r = new Random(seed);
        for (int i = 0; i < 5; i++) {
            for (int c = 0; c < 5; c++) {
                mat[i][c] = r.nextInt(6);
            }
        }
    }

    void caricaCaramelle(int[][] mat, ImageButton[][] matbut) {

        for (int i = 0; i < 5; i++) {
            for (int c = 0; c < 5; c++) {
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
        for (int i = 0; i < 5; i++) {
            for (int c = 0; c + 3 < 5; c++) {
                if (mat[i][c] == mat[i][c + 1] && mat[i][c] == mat[i][c + 2] && mat[i][c] == mat[i][c + 3]) {
                    attuale = attuale + 25;
                    if (i == 0) {//4 uguali nella prima riga
                        mat[i][c] = r.nextInt(6);
                        mat[i][c + 1] = r.nextInt(6);
                        mat[i][c + 2] = r.nextInt(6);
                        caricaCaramelle(mat, matbut);
                        if (mat[i][c + 3] == 0) {
                            matbut[i][c + 3].setBackgroundResource(R.drawable.rossa_speciale_orizzontale);
                        } else if (mat[i][c + 3] == 1) {
                            matbut[i][c + 3].setBackgroundResource(R.drawable.gialla_speciale_orizzontale);
                        } else if (mat[i][c + 3] == 2) {
                            matbut[i][c + 3].setBackgroundResource(R.drawable.arancione_speciale_orizzzontale);
                        } else if (mat[i][c + 3] == 3) {
                            matbut[i][c + 3].setBackgroundResource(R.drawable.verde_speciale_orizzontale);
                        } else if (mat[i][c + 3] == 4) {
                            matbut[i][c + 3].setBackgroundResource(R.drawable.viola_speciale_orizzontale);
                        } else if (mat[i][c + 3] == 5) {
                            matbut[i][c + 3].setBackgroundResource(R.drawable.blue_speciale_orizzontale);
                        }

                    } else {
                        int ciao1 = i;
                        int ciao = c;
                        for (int j = i; j >= 0; j--) {
                            if (j == 0) {
                                mat[j][c] = r.nextInt(6);
                                mat[j][c + 1] = r.nextInt(6);
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
                        if (mat[ciao1][ciao + 3] == 0) {
                            matbut[ciao1][ciao + 3].setBackgroundResource(R.drawable.rossa_speciale_orizzontale);
                        } else if (mat[ciao1][ciao + 3] == 1) {
                            matbut[ciao1][ciao + 3].setBackgroundResource(R.drawable.gialla_speciale_orizzontale);
                        } else if (mat[ciao1][ciao + 3] == 2) {
                            matbut[ciao1][ciao + 3].setBackgroundResource(R.drawable.arancione_speciale_orizzzontale);
                        } else if (mat[ciao1][ciao + 3] == 3) {
                            matbut[ciao1][ciao + 3].setBackgroundResource(R.drawable.verde_speciale_orizzontale);
                        } else if (mat[ciao1][ciao + 3] == 4) {
                            matbut[ciao1][ciao + 3].setBackgroundResource(R.drawable.viola_speciale_orizzontale);
                        } else if (mat[ciao1][ciao + 3] == 5) {
                            matbut[ciao1][ciao + 3].setBackgroundResource(R.drawable.blue_speciale_orizzontale);
                        }


                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int c = 0; c + 2 < 5; c++) {
                if (mat[i][c] == mat[i][c + 1] && mat[i][c] == mat[i][c + 2]) {
                    attuale = attuale + 10;
                    if (i == 0) {
                        mat[i][c] = r.nextInt(6);
                        mat[i][c + 1] = r.nextInt(6);
                        mat[i][c + 2] = r.nextInt(6);
                        caricaCaramelle(mat, matbut);
                    } else {
                        for (int j = i; j >= 0; j--) {
                            if (j == 0) {
                                mat[j][c] = r.nextInt(6);
                                mat[j][c + 1] = r.nextInt(6);
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
        for (int i = 0; i < 5; i++) {
            for (int c = 0; c + 3 < 5; c++) {
                if (mat[c][i] == mat[c + 1][i] && mat[c][i] == mat[c + 2][i] && mat[c][i] == mat[c + 3][i]) {
                    attuale = attuale + 25;
                    int test1 = c + 1;
                    int test2 = c + 2;
                    int test3 = c + 3;
                    if (c == 0 && test1 == 1 && test2 == 2 && test3 == 3) {
                        mat[c][i] = r.nextInt(6);
                        mat[c + 1][i] = r.nextInt(6);
                        mat[c + 2][i] = r.nextInt(6);
                        caricaCaramelle(mat, matbut);
                        if (mat[c + 3][i] == 0) {
                            matbut[c + 3][i].setBackgroundResource(R.drawable.rossa_speciale_verticale);
                        } else if (mat[c + 3][i] == 1) {
                            matbut[c + 3][i].setBackgroundResource(R.drawable.gialla_speciale_verticale);
                        } else if (mat[c + 3][i] == 2) {
                            matbut[c + 3][i].setBackgroundResource(R.drawable.arancione_speciale_verticale);
                        } else if (mat[c + 3][i] == 3) {
                            matbut[c + 3][i].setBackgroundResource(R.drawable.verde_speciale_verticale);
                        } else if (mat[c + 3][i] == 4) {
                            matbut[c + 3][i].setBackgroundResource(R.drawable.viola_speciale_verticale);
                        } else if (mat[c + 3][i] == 5) {
                            matbut[c + 3][i].setBackgroundResource(R.drawable.blue_speciale_verticale);
                        }
                    } else if (c == 1 && test1 == 2 && test2 == 3 && test3 == 4) {
                        mat[c][i] = r.nextInt(6);
                        mat[c + 1][i] = r.nextInt(6);
                        mat[c + 2][i] = mat[0][i];
                        mat[0][i] = r.nextInt(6);
                        caricaCaramelle(mat, matbut);
                        if (mat[c + 3][i] == 0) {
                            matbut[c + 3][i].setBackgroundResource(R.drawable.rossa_speciale_verticale);
                        } else if (mat[c + 3][i] == 1) {
                            matbut[c + 3][i].setBackgroundResource(R.drawable.gialla_speciale_verticale);
                        } else if (mat[c + 3][i] == 2) {
                            matbut[c + 3][i].setBackgroundResource(R.drawable.arancione_speciale_verticale);
                        } else if (mat[c + 3][i] == 3) {
                            matbut[c + 3][i].setBackgroundResource(R.drawable.verde_speciale_verticale);
                        } else if (mat[c + 3][i] == 4) {
                            matbut[c + 3][i].setBackgroundResource(R.drawable.viola_speciale_verticale);
                        } else if (mat[c + 3][i] == 5) {
                            matbut[c + 3][i].setBackgroundResource(R.drawable.blue_speciale_verticale);
                        }
                    }
                }
            }
        }//4 uguali verticali
        for (int i = 0; i < 5; i++) {
            for (int c = 0; c + 2 < 5; c++) {
                if (mat[c][i] == mat[c + 1][i] && mat[c][i] == mat[c + 2][i]) {
                    attuale = attuale + 10;
                    int test1 = c + 1;
                    int test2 = c + 2;
                    if (c == 0 && test1 == 1 && test2 == 2) {
                        mat[c][i] = r.nextInt(6);
                        mat[c + 1][i] = r.nextInt(6);
                        mat[c + 2][i] = r.nextInt(6);
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
                    }
                }
            }
        }//3 uguali verticali
    }

    void rimuovicolonna(int pos) {
        mat[0][pos] = gh.nextInt(6);
        mat[1][pos] = gh.nextInt(6);
        mat[2][pos] = gh.nextInt(6);
        mat[3][pos] = gh.nextInt(6);
        mat[4][pos] = gh.nextInt(6);
        caricaCaramelle(mat, matbut);
        cercauguali();
        cercaugualiverticale();
    }

    void rimuoviriga(int pos) {
        if (pos == 0) {
            mat[pos][0] = gh.nextInt(6);
            mat[pos][1] = gh.nextInt(6);
            mat[pos][2] = gh.nextInt(6);
            mat[pos][3] = gh.nextInt(6);
            mat[pos][4] = gh.nextInt(6);
            caricaCaramelle(mat, matbut);
            cercauguali();
            cercaugualiverticale();
        } else {
            for (; pos >= 0; pos--) {
                if (pos == 0) {
                    mat[pos][0] = gh.nextInt(6);
                    mat[pos][1] = gh.nextInt(6);
                    mat[pos][2] = gh.nextInt(6);
                    mat[pos][3] = gh.nextInt(6);
                    mat[pos][4] = gh.nextInt(6);
                    caricaCaramelle(mat, matbut);
                    cercauguali();
                    cercaugualiverticale();
                } else {
                    sup1 = mat[pos - 1][0];
                    sup2 = mat[pos - 1][1];
                    sup3 = mat[pos - 1][2];
                    sup4 = mat[pos - 1][3];
                    sup5 = mat[pos - 1][4];
                    mat[pos][0] = sup1;
                    mat[pos][1] = sup2;
                    mat[pos][2] = sup3;
                    mat[pos][3] = sup4;
                    mat[pos][4] = sup5;

                }
            }
        }

    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livello3);
        matbut[0][0] = findViewById(R.id.Bottone1L3);
        matbut[0][1] = findViewById(R.id.Bottone2L3);
        matbut[0][2] = findViewById(R.id.Bottone3L3);
        matbut[0][3] = findViewById(R.id.Bottone4L3);
        matbut[0][4] = findViewById(R.id.Bottone5L3);
        matbut[1][0] = findViewById(R.id.Bottone6L3);
        matbut[1][1] = findViewById(R.id.Bottone7L3);
        matbut[1][2] = findViewById(R.id.Bottone8L3);
        matbut[1][3] = findViewById(R.id.Bottone9L3);
        matbut[1][4] = findViewById(R.id.Bottone10L3);
        matbut[2][0] = findViewById(R.id.Bottone11L3);
        matbut[2][1] = findViewById(R.id.Bottone12L3);
        matbut[2][2] = findViewById(R.id.Bottone13L3);
        matbut[2][3] = findViewById(R.id.Bottone14L3);
        matbut[2][4] = findViewById(R.id.Bottone15L3);
        matbut[3][0] = findViewById(R.id.Bottone16L3);
        matbut[3][1] = findViewById(R.id.Bottone17L3);
        matbut[3][2] = findViewById(R.id.Bottone18L3);
        matbut[3][3] = findViewById(R.id.Bottone19L3);
        matbut[3][4] = findViewById(R.id.Bottone20L3);
        matbut[4][0] = findViewById(R.id.Bottone21L3);
        matbut[4][1] = findViewById(R.id.Bottone22L3);
        matbut[4][2] = findViewById(R.id.Bottone23L3);
        matbut[4][3] = findViewById(R.id.Bottone24L3);
        matbut[4][4] = findViewById(R.id.Bottone25L3);
        //foto
        matfot[0][0] = findViewById(R.id.Foto1L3);
        matfot[0][1] = findViewById(R.id.Foto2L3);
        matfot[0][2] = findViewById(R.id.Foto3L3);
        matfot[0][3] = findViewById(R.id.Foto4L3);
        matfot[0][4] = findViewById(R.id.Foto5L3);
        matfot[1][0] = findViewById(R.id.Foto6L3);
        matfot[1][1] = findViewById(R.id.Foto7L3);
        matfot[1][2] = findViewById(R.id.Foto8L3);
        matfot[1][3] = findViewById(R.id.Foto9L3);
        matfot[1][4] = findViewById(R.id.Foto10L3);
        matfot[2][0] = findViewById(R.id.Foto11L3);
        matfot[2][1] = findViewById(R.id.Foto12L3);
        matfot[2][2] = findViewById(R.id.Foto13L3);
        matfot[2][3] = findViewById(R.id.Foto14L3);
        matfot[2][4] = findViewById(R.id.Foto15L3);
        matfot[3][0] = findViewById(R.id.Foto16L3);
        matfot[3][1] = findViewById(R.id.Foto17L3);
        matfot[3][2] = findViewById(R.id.Foto18L3);
        matfot[3][3] = findViewById(R.id.Foto19L3);
        matfot[3][4] = findViewById(R.id.Foto20L3);
        matfot[4][0] = findViewById(R.id.Foto21L3);
        matfot[4][1] = findViewById(R.id.Foto22L3);
        matfot[4][2] = findViewById(R.id.Foto23L3);
        matfot[4][3] = findViewById(R.id.Foto24L3);
        matfot[4][4] = findViewById(R.id.Foto25L3);
        caricanumeri(mat);
        caricaCaramelle(mat, matbut);
        ProgressBar bar1 = findViewById(R.id.barralivelloL3);
        ProgressBar bar2 = findViewById(R.id.barrapuntiL3);
        bar1.setMax(numeromosse);
        caricanumeri(mat);
        caricaCaramelle(mat, matbut);
        cercauguali();
        cercaugualiverticale();
        attuale = 0;
        bar2.setMax(punteggio3stelle);
        sup10 = "" + attuale;
        TextView monete = findViewById(R.id.numeromoneteL3);
        TextView t = findViewById(R.id.numeromosseL3);
        TextView t1 = findViewById(R.id.numeropuntiL3);
        sup = "" + numeromosse;
        t.setText(sup);
        t1.setText(sup10);
        myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
        coin = myPrefs.getInt("Moneta", 3);
        mon = " " + " " + coin;
        monete.setText(mon);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorListener = new ShakeListener();
        //carico array per gli aiuti verticali
        aiutiverticale[0] = findViewById(R.id.verticalec1L3);
        aiutiverticale[1] = findViewById(R.id.verticalec2L3);
        aiutiverticale[2] = findViewById(R.id.verticalec3L3);
        aiutiverticale[3] = findViewById(R.id.verticalec4L3);
        aiutiverticale[4] = findViewById(R.id.verticalec5L3);
        //carica array per gli aiuti verticali
        aiutiorizzontale[0] = findViewById(R.id.orizzontalec1L3);
        aiutiorizzontale[1] = findViewById(R.id.orizzontalec2L3);
        aiutiorizzontale[2] = findViewById(R.id.orizzontalec3L3);
        aiutiorizzontale[3] = findViewById(R.id.orizzontalec4L3);
        aiutiorizzontale[4] = findViewById(R.id.orizzontalec5L3);
        verticale = findViewById(R.id.verticaleL3);
        orizzontale = findViewById(R.id.orizzontaleL3);
        for (int i = 0; i < 5; i++) {
            aiutiorizzontale[i].setVisibility(View.GONE);
            aiutiverticale[i].setVisibility(View.GONE);
        }

        for (int i = 0; i < 5; i++) {
            final int c = i;
            aiutiorizzontale[i].setOnClickListener(v -> {
                rimuoviriga(c);
                for (int x = 0; x < 5; x++) {
                    aiutiorizzontale[x].setVisibility(View.GONE);
                    aiutiverticale[x].setVisibility(View.GONE);
                }
            });

        }

        for (int i = 0; i < 5; i++) {
            final int c = i;
            aiutiverticale[i].setOnClickListener(v -> {
                rimuovicolonna(c);
                for (int x = 0; x < 5; x++) {
                    aiutiorizzontale[x].setVisibility(View.GONE);
                    aiutiverticale[x].setVisibility(View.GONE);
                }
            });

        }
        verticale.setOnClickListener(v -> {
            if (coin > 0) {
                for (int i = 0; i < 5; i++) {
                    aiutiverticale[i].setVisibility(View.VISIBLE);
                }
                coin--;
                mon = " " + " " + coin;
                monete.setText(mon);
            } else {
                Toast.makeText(Livello3.this, "Numero di monete insufficente", Toast.LENGTH_LONG).show();
            }

        });

        orizzontale.setOnClickListener(v -> {
            if (coin > 0) {
                for (int i = 0; i < 5; i++) {
                    aiutiorizzontale[i].setVisibility(View.VISIBLE);
                }
                coin--;
                mon = " " + " " + coin;
                monete.setText(mon);
            } else {
                Toast.makeText(Livello3.this, "Numero di monete insufficente", Toast.LENGTH_LONG).show();
            }

        });
        //aggiunta mosse
        ImageButton mosse = findViewById(R.id.piumosseL3);
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
                Toast.makeText(Livello3.this, "Numero di monete insufficenti", Toast.LENGTH_LONG).show();
            }

        });


        mSensorListener.setOnShakeListener(new ShakeListener.OnShakeListener() {
            public void onShake() {
                Toast.makeText(Livello3.this, "La tavola è stata aggiornata e ti sono stati aggiunti dei punti in regalo ", Toast.LENGTH_LONG).show();
                caricanumeri(mat);
                caricaCaramelle(mat, matbut);
                cercauguali();
                cercaugualiverticale();
                if (numeromosse == 3) {
                    numeromosse = numeromosse - 3;
                    if (attuale >= punteggio1stella) {

                        myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = myPrefs.edit();
                        boolean livello4 = myPrefs.getBoolean("Livello4", false);
                        livello4 = true;
                        editor.putBoolean("Livello4", true);
                        int puntLivello3 = myPrefs.getInt("PuntLivello3", 0);
                        puntLivello3 = attuale;
                        editor.putInt("PuntLivello3", puntLivello3);
                        if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                            int NStelle3 = 1;
                            editor.putInt("Nstelle3", NStelle3);
                        } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                            int NStelle3 = 2;
                            editor.putInt("Nstelle3", NStelle3);
                        } else if (attuale >= punteggio3stelle) {
                            int NStelle3 = 3;
                            editor.putInt("Nstelle3", NStelle3);
                        }
                        editor.putInt("Moneta", coin);
                        int NLivello = 3;
                        editor.putInt("Nlivello", NLivello);
                        editor.putInt("PuntLivello3", attuale);
                        editor.apply();
                        editor.commit();
                        Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                        startActivity(vittoria);
                        Animatoo.animateDiagonal(Livello3.this);
                        finish();
                    } else {
                        Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                        SharedPreferences myPrefs;
                        myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = myPrefs.edit();
                        editor.putInt("Obiettivo", punteggio1stella);
                        int NLivello = 3;
                        editor.putInt("Nlivello", NLivello);
                        editor.putInt("Moneta", coin);
                        editor.apply();
                        editor.commit();
                        startActivity(sconfitta);
                        Animatoo.animateDiagonal(Livello3.this);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }
            }


        });
        matbut[0][3].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[0][3].setBackgroundColor(0x00000000);
                matbut[0][4].setBackgroundColor(0x00000000);
                caricaimmagine(0, 3, 0, 4);
                x1 = matbut[0][3].getX();
                x2 = matbut[0][4].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[0][3], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[0][4], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[0][3];
                    mat[0][3] = mat[0][4];
                    mat[0][4] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[0][3].setBackgroundColor(0x00000000);
                    matfot[0][4].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[0][4], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[0][3], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }

            }

            @Override
            public void onSwipeLeft() {
                matbut[0][3].setBackgroundColor(0x00000000);
                matbut[0][2].setBackgroundColor(0x00000000);
                caricaimmagine(0, 3, 0, 2);
                x1 = matbut[0][3].getX();
                x2 = matbut[0][2].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[0][3], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[0][2], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[0][3];
                    mat[0][3] = mat[0][2];
                    mat[0][2] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[0][3].setBackgroundColor(0x00000000);
                    matfot[0][2].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[0][2], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[0][3], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }
            }


        });
        matbut[0][4].setOnTouchListener(new OnSwipeTouchListener(this) {

            @Override
            public void onSwipeLeft() {
                matbut[0][4].setBackgroundColor(0x00000000);
                matbut[0][3].setBackgroundColor(0x00000000);
                caricaimmagine(0, 4, 0, 3);
                x1 = matbut[0][4].getX();
                x2 = matbut[0][3].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[0][4], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[0][3], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[0][4];
                    mat[0][4] = mat[0][3];
                    mat[0][3] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[0][4].setBackgroundColor(0x00000000);
                    matfot[0][3].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[0][3], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[0][4], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }
            }


        });
        //prima riga
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }
            }


        });
        matbut[1][3].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[1][3].setBackgroundColor(0x00000000);
                matbut[1][4].setBackgroundColor(0x00000000);
                caricaimmagine(1, 3, 1, 4);
                x1 = matbut[1][3].getX();
                x2 = matbut[1][4].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[1][3], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[1][4], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[1][3];
                    mat[1][3] = mat[1][4];
                    mat[1][4] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[1][3].setBackgroundColor(0x00000000);
                    matfot[1][4].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[1][4], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[1][3], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }

            }

            @Override
            public void onSwipeLeft() {
                matbut[1][3].setBackgroundColor(0x00000000);
                matbut[1][2].setBackgroundColor(0x00000000);
                caricaimmagine(1, 3, 1, 2);
                x1 = matbut[1][3].getX();
                x2 = matbut[1][2].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[1][3], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[1][2], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[1][3];
                    mat[1][3] = mat[1][2];
                    mat[1][2] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[1][3].setBackgroundColor(0x00000000);
                    matfot[1][2].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[1][2], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[1][3], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }
            }


        });
        matbut[1][4].setOnTouchListener(new OnSwipeTouchListener(this) {


            @Override
            public void onSwipeLeft() {
                matbut[1][4].setBackgroundColor(0x00000000);
                matbut[1][3].setBackgroundColor(0x00000000);
                caricaimmagine(1, 4, 1, 3);
                x1 = matbut[1][4].getX();
                x2 = matbut[1][3].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[1][4], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[1][3], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[1][4];
                    mat[1][4] = mat[1][3];
                    mat[1][3] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[1][4].setBackgroundColor(0x00000000);
                    matfot[1][3].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[1][3], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[1][4], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }


            }


        });

        //seconda riga
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }

            }


        });
        matbut[2][3].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[2][3].setBackgroundColor(0x00000000);
                matbut[2][4].setBackgroundColor(0x00000000);
                caricaimmagine(2, 3, 2, 4);
                x1 = matbut[2][3].getX();
                x2 = matbut[2][4].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[2][3], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[2][4], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[2][3];
                    mat[2][3] = mat[2][4];
                    mat[2][4] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[2][3].setBackgroundColor(0x00000000);
                    matfot[2][4].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[2][4], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[2][3], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }


            }

            @Override
            public void onSwipeLeft() {
                matbut[2][3].setBackgroundColor(0x00000000);
                matbut[2][2].setBackgroundColor(0x00000000);
                caricaimmagine(2, 3, 2, 2);
                x1 = matbut[2][3].getX();
                x2 = matbut[2][2].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[2][3], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[2][2], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[2][3];
                    mat[2][3] = mat[2][2];
                    mat[2][2] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[2][3].setBackgroundColor(0x00000000);
                    matfot[2][2].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[2][2], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[2][3], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }

            }


        });
        matbut[2][4].setOnTouchListener(new OnSwipeTouchListener(this) {


            @Override
            public void onSwipeLeft() {
                matbut[2][4].setBackgroundColor(0x00000000);
                matbut[2][3].setBackgroundColor(0x00000000);
                caricaimmagine(2, 4, 2, 3);
                x1 = matbut[2][4].getX();
                x2 = matbut[2][3].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[2][4], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[2][3], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[2][4];
                    mat[2][4] = mat[2][3];
                    mat[2][3] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[2][4].setBackgroundColor(0x00000000);
                    matfot[2][3].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[2][3], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[2][4], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }

            }


        });


        matbut[3][0].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[3][0].setBackgroundColor(0x00000000);
                matbut[3][1].setBackgroundColor(0x00000000);
                caricaimmagine(3, 0, 3, 1);
                x1 = matbut[3][0].getX();
                x2 = matbut[3][1].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[3][0], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[3][1], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[3][0];
                    mat[3][0] = mat[3][1];
                    mat[3][1] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[3][0].setBackgroundColor(0x00000000);
                    matfot[3][1].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[3][0], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[3][1], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }


            }
        });
        matbut[3][1].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[3][1].setBackgroundColor(0x00000000);
                matbut[3][2].setBackgroundColor(0x00000000);
                caricaimmagine(3, 1, 3, 2);
                x1 = matbut[3][1].getX();
                x2 = matbut[3][2].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[3][1], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[3][2], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[3][1];
                    mat[3][1] = mat[3][2];
                    mat[3][2] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[3][1].setBackgroundColor(0x00000000);
                    matfot[3][2].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[3][2], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[3][1], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }

            }

            @Override
            public void onSwipeLeft() {
                matbut[3][1].setBackgroundColor(0x00000000);
                matbut[3][0].setBackgroundColor(0x00000000);
                caricaimmagine(3, 1, 3, 0);
                x1 = matbut[3][1].getX();
                x2 = matbut[3][0].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[3][1], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[3][0], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[3][1];
                    mat[3][1] = mat[3][0];
                    mat[3][0] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[3][1].setBackgroundColor(0x00000000);
                    matfot[3][0].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[3][0], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[3][1], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }

            }


        });
        matbut[3][2].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[3][2].setBackgroundColor(0x00000000);
                matbut[3][3].setBackgroundColor(0x00000000);
                caricaimmagine(3, 2, 3, 3);
                x1 = matbut[3][2].getX();
                x2 = matbut[3][3].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[3][2], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[3][3], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[3][2];
                    mat[3][2] = mat[3][3];
                    mat[3][3] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[3][2].setBackgroundColor(0x00000000);
                    matfot[3][3].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[3][3], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[3][2], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }

            }

            @Override
            public void onSwipeLeft() {
                matbut[3][2].setBackgroundColor(0x00000000);
                matbut[3][1].setBackgroundColor(0x00000000);
                caricaimmagine(3, 2, 3, 1);
                x1 = matbut[3][2].getX();
                x2 = matbut[3][1].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[3][2], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[3][1], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[3][2];
                    mat[3][2] = mat[3][1];
                    mat[3][1] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[3][2].setBackgroundColor(0x00000000);
                    matfot[3][1].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[3][1], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[3][2], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }

            }


        });
        matbut[3][3].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[3][3].setBackgroundColor(0x00000000);
                matbut[3][4].setBackgroundColor(0x00000000);
                caricaimmagine(3, 3, 3, 4);
                x1 = matbut[3][3].getX();
                x2 = matbut[3][4].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[3][3], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[3][4], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[3][3];
                    mat[3][3] = mat[3][4];
                    mat[3][4] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[3][3].setBackgroundColor(0x00000000);
                    matfot[3][4].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[3][4], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[3][3], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }


            }

            @Override
            public void onSwipeLeft() {
                matbut[3][3].setBackgroundColor(0x00000000);
                matbut[3][2].setBackgroundColor(0x00000000);
                caricaimmagine(3, 3, 3, 2);
                x1 = matbut[3][3].getX();
                x2 = matbut[3][2].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[3][3], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[3][2], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[3][3];
                    mat[3][3] = mat[3][2];
                    mat[3][2] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[3][3].setBackgroundColor(0x00000000);
                    matfot[3][2].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[3][2], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[3][3], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }

            }


        });
        matbut[3][4].setOnTouchListener(new OnSwipeTouchListener(this) {

            @Override
            public void onSwipeLeft() {
                matbut[3][4].setBackgroundColor(0x00000000);
                matbut[3][3].setBackgroundColor(0x00000000);
                caricaimmagine(3, 4, 3, 3);
                x1 = matbut[3][4].getX();
                x2 = matbut[3][3].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[3][4], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[3][3], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[3][4];
                    mat[3][4] = mat[3][3];
                    mat[3][3] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[3][4].setBackgroundColor(0x00000000);
                    matfot[3][3].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[3][3], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[3][4], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }

            }


        });
        matbut[4][0].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[4][0].setBackgroundColor(0x00000000);
                matbut[4][1].setBackgroundColor(0x00000000);
                caricaimmagine(4, 0, 4, 1);
                x1 = matbut[4][0].getX();
                x2 = matbut[4][1].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[4][0], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[4][1], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[4][0];
                    mat[4][0] = mat[4][1];
                    mat[4][1] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[4][0].setBackgroundColor(0x00000000);
                    matfot[4][1].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[4][0], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[4][1], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }


            }
        });
        matbut[4][1].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[4][1].setBackgroundColor(0x00000000);
                matbut[4][2].setBackgroundColor(0x00000000);
                caricaimmagine(4, 1, 4, 2);
                x1 = matbut[4][1].getX();
                x2 = matbut[4][2].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[4][1], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[4][2], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[4][1];
                    mat[4][1] = mat[4][2];
                    mat[4][2] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[4][1].setBackgroundColor(0x00000000);
                    matfot[4][2].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[4][2], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[4][1], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }


            }

            @Override
            public void onSwipeLeft() {
                matbut[4][1].setBackgroundColor(0x00000000);
                matbut[4][0].setBackgroundColor(0x00000000);
                caricaimmagine(4, 1, 4, 0);
                x1 = matbut[4][1].getX();
                x2 = matbut[4][0].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[4][1], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[4][0], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[4][1];
                    mat[4][1] = mat[4][0];
                    mat[4][0] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[4][1].setBackgroundColor(0x00000000);
                    matfot[4][0].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[4][0], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[4][1], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }

            }


        });
        matbut[4][2].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[4][2].setBackgroundColor(0x00000000);
                matbut[4][3].setBackgroundColor(0x00000000);
                caricaimmagine(4, 2, 4, 3);
                x1 = matbut[4][2].getX();
                x2 = matbut[4][3].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[4][2], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[4][3], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[4][2];
                    mat[4][2] = mat[4][3];
                    mat[4][3] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[4][2].setBackgroundColor(0x00000000);
                    matfot[4][3].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[4][3], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[4][2], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }

            }

            @Override
            public void onSwipeLeft() {
                matbut[4][2].setBackgroundColor(0x00000000);
                matbut[4][1].setBackgroundColor(0x00000000);
                caricaimmagine(4, 2, 4, 1);
                x1 = matbut[4][2].getX();
                x2 = matbut[4][1].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[4][2], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[4][1], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[4][2];
                    mat[4][2] = mat[4][1];
                    mat[4][1] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[4][2].setBackgroundColor(0x00000000);
                    matfot[4][1].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[4][1], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[4][2], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }

            }


        });
        matbut[4][3].setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {

                matbut[4][3].setBackgroundColor(0x00000000);
                matbut[4][4].setBackgroundColor(0x00000000);
                caricaimmagine(4, 3, 4, 4);
                x1 = matbut[4][3].getX();
                x2 = matbut[4][4].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[4][3], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[4][4], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[4][3];
                    mat[4][3] = mat[4][4];
                    mat[4][4] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[4][3].setBackgroundColor(0x00000000);
                    matfot[4][4].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[4][4], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[4][3], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }


            }

            @Override
            public void onSwipeLeft() {
                matbut[4][3].setBackgroundColor(0x00000000);
                matbut[4][2].setBackgroundColor(0x00000000);
                caricaimmagine(4, 3, 4, 2);
                x1 = matbut[4][3].getX();
                x2 = matbut[4][2].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[4][3], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[4][2], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[4][3];
                    mat[4][3] = mat[4][2];
                    mat[4][2] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[4][3].setBackgroundColor(0x00000000);
                    matfot[4][2].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[4][2], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[4][3], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();

                }

            }


        });
        matbut[4][4].setOnTouchListener(new OnSwipeTouchListener(this) {

            @Override
            public void onSwipeLeft() {
                matbut[4][4].setBackgroundColor(0x00000000);
                matbut[4][3].setBackgroundColor(0x00000000);
                caricaimmagine(4, 4, 4, 3);
                x1 = matbut[4][4].getX();
                x2 = matbut[4][3].getX();
                oggetto1 = ObjectAnimator.ofFloat(matfot[4][4], "x", x1, x2);
                oggetto2 = ObjectAnimator.ofFloat(matfot[4][3], "x", x2, x1);
                set.playTogether(oggetto1, oggetto2);
                set.setDuration(1000);
                set.start();


                handler.postDelayed(() -> {
                    codice = mat[4][4];
                    mat[4][4] = mat[4][3];
                    mat[4][3] = codice;
                    caricaCaramelle(mat, matbut);
                    matfot[4][4].setBackgroundColor(0x00000000);
                    matfot[4][3].setBackgroundColor(0x00000000);
                    oggetto1 = ObjectAnimator.ofFloat(matfot[4][3], "x", x1, x2);
                    oggetto2 = ObjectAnimator.ofFloat(matfot[4][4], "x", x2, x1);
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
                if (numeromosse == 0 && attuale >= punteggio1stella) {
                    Intent vittoria = new Intent(Livello3.this, Vittoria.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putBoolean("Livello4", true);
                    if (attuale >= punteggio1stella && attuale < punteggio2Stelle) {
                        int NStelle3 = 1;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio2Stelle && attuale < punteggio3stelle) {
                        int NStelle3 = 2;
                        editor.putInt("Nstelle3", NStelle3);
                    } else if (attuale >= punteggio3stelle) {
                        int NStelle3 = 3;
                        editor.putInt("Nstelle3", NStelle3);
                    }
                    editor.putInt("Moneta", coin);
                    editor.putInt("PuntLivello3", attuale);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.apply();
                    editor.commit();
                    startActivity(vittoria);
                    Animatoo.animateDiagonal(Livello3.this);
                    finish();
                }
                if (numeromosse == 0 && attuale < punteggio1stella) {
                    Intent sconfitta = new Intent(Livello3.this, Sconfitta.class);
                    SharedPreferences myPrefs;
                    myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    editor.putInt("Obiettivo", punteggio1stella);
                    int NLivello = 3;
                    editor.putInt("Nlivello", NLivello);
                    editor.putInt("Moneta", coin);
                    editor.apply();
                    editor.commit();
                    startActivity(sconfitta);
                    Animatoo.animateDiagonal(Livello3.this);
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

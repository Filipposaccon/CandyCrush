package com.example.candycrush;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.roger.catloadinglibrary.CatLoadingView;

public class Sconfitta extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sconfitta);
        TextView obiettivo = findViewById(R.id.punteggioObiettivo);
        SharedPreferences myPrefs;
        myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
        int obietti = myPrefs.getInt("Obiettivo", 50);
        String supporto = "" + obietti;
        obiettivo.setText(supporto);
        Button rigioca = findViewById(R.id.Rigioca);
         final int livello=myPrefs.getInt("Nlivello",4);

        CatLoadingView mView;
        mView = new CatLoadingView();
        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake_animation_infinite);
        rigioca.startAnimation(animShake);
        rigioca.setOnClickListener(v -> {
            mView.show(getSupportFragmentManager(), "");
            new Handler().postDelayed(() -> {
                if(livello==1)
                {
                    Intent intent=new Intent(this, Livello1.class);
                    startActivity(intent);
                    Animatoo.animateInAndOut(Sconfitta.this);
                    finish();
                }else if(livello==2)
                {
                    Intent intent=new Intent(this, Livello2.class);
                    startActivity(intent);
                    Animatoo.animateInAndOut(Sconfitta.this);
                    finish();
                }else if(livello==3)
                {
                    Intent intent=new Intent(this, Livello3.class);
                    startActivity(intent);
                    Animatoo.animateInAndOut(Sconfitta.this);
                    finish();
                }else if(livello==4)
                {
                    Intent intent=new Intent(this, MainActivity.class);
                    startActivity(intent);
                    Animatoo.animateInAndOut(Sconfitta.this);
                    finish();
                }



            }, 1500);
        });
    }
}

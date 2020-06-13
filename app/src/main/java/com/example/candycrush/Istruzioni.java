package com.example.candycrush;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import pl.droidsonroids.gif.GifImageView;

public class Istruzioni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istruzioni);

        GifImageView mano = findViewById(R.id.ManoIstruzioni);
        mano.setVisibility(View.GONE);
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            mano.setVisibility(View.VISIBLE);
        }, 5000);
        Button indietro = findViewById(R.id.bottoneIndietroIstruzioni);
        Intent intent = new Intent(this, Livelli.class);
        indietro.setOnClickListener(
                (View v) -> {
                    startActivity(intent);
                    Animatoo.animateInAndOut(Istruzioni.this);
                    finish();

                }
        );
    }
}

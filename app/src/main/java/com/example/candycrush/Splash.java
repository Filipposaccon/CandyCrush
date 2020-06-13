package com.example.candycrush;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

        public class Splash extends AppCompatActivity {




            @Override
            public void onCreate(Bundle savedInstanceState) {
                setTheme(R.style.AppTheme_Launcher);
                super.onCreate(savedInstanceState);
                this.startActivity(new Intent(this, MainMenu.class));
                this.finish();
            }
        }



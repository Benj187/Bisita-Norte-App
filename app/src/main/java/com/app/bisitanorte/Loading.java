package com.app.bisitanorte;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class Loading extends AppCompatActivity {
    ImageView logo;
    Animation anime;
    private static int splash = 3000;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        anime = AnimationUtils.loadAnimation(this,R.anim.loading_animation);

        logo = findViewById(R.id.logoimg);
        logo.setAnimation(anime);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(Loading.this,ActivityIntro.class);
                startActivity(intent);
                finish();
            }
        },splash);
    }
}
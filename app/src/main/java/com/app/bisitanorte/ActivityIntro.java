package com.app.bisitanorte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class ActivityIntro extends AppCompatActivity {
    Animation open_anime, close_anime;
    CardView intro;
    ImageButton xbtn;
    private static int splash = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_intro);

        open_anime = AnimationUtils.loadAnimation(this,R.anim.intro_start_animation);
        close_anime = AnimationUtils.loadAnimation(this,R.anim.intro_end_animation);

        intro = findViewById(R.id.Intro);
        intro.setAnimation(open_anime);

        xbtn = findViewById(R.id.x_btn);

        xbtn.setOnClickListener(view -> {
            setClose_anime();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent =new Intent(ActivityIntro.this,HomeIntro.class);
                    startActivity(intent);
                    finish();
                }
            },splash);

        });
    }

    public void setClose_anime() {
        intro = findViewById(R.id.Intro);
        intro.startAnimation(close_anime);
    }
}
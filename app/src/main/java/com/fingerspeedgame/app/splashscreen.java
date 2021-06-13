package com.fingerspeedgame.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {
    TextView txtwelcome,txtfinger;
    RelativeLayout relativeLayout;
    Animation txtAnimation,layoutAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        txtAnimation = AnimationUtils.loadAnimation(splashscreen.this,R.anim.fall_down);
        layoutAnimation = AnimationUtils.loadAnimation(splashscreen.this,R.anim.bottom_to_top);


        txtwelcome = findViewById(R.id.txtwelcome);
        txtfinger = findViewById(R.id.txtfinger);
        relativeLayout = findViewById(R.id.relMain);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                relativeLayout.setVisibility(View.VISIBLE);
                relativeLayout.setAnimation(layoutAnimation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        txtwelcome.setVisibility(View.VISIBLE);
                        txtfinger.setVisibility(View.VISIBLE);

                        txtwelcome.setAnimation(txtAnimation);
                        txtfinger.setAnimation(txtAnimation);

                    }

                },900);

            }
        },500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashscreen.this,firstscreen.class);
                startActivity(intent);
                finish();
            }
        }, 6000);

    }
}
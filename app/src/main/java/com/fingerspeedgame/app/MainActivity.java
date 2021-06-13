package com.fingerspeedgame.app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    TextView chronometer, remainingTapsTV, statusOfGameTV;
    Button tapTapButton;
    CountDownTimer mCountDownTimer;
    int remainingTaps = 350;
    int remainingTime = 60;
    long timeOfClick;
    int pos = 0;
    String[] nameOfLevels = {"easy", "medium", "high"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.chronometer);
        remainingTapsTV = findViewById(R.id.remainingTapsTV);
        statusOfGameTV = findViewById(R.id.statusOfGameTV);
        tapTapButton = findViewById(R.id.tapTapBtn);

        tapTapButton.setOnClickListener(v -> {
            if(remainingTaps == 350){
                mCountDownTimer.start();
            }

            remainingTaps--;

            remainingTapsTV.setText(String.valueOf(remainingTaps));

            if(remainingTaps == 0){
                mCountDownTimer.cancel();
                mCountDownTimer = null;
                tapTapButton.setEnabled(false);
                statusOfGameTV.setVisibility(View.VISIBLE);
                statusOfGameTV.setText("Congratulations, You have won.");
            }
        });
    }

    private CountDownTimer getCountDownTimer (int duration){
        return new CountDownTimer(duration*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                remainingTime --;
                chronometer.setText(String.valueOf(remainingTime));
                statusOfGameTV.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFinish() {
                tapTapButton.setEnabled(false);
                statusOfGameTV.setVisibility(View.VISIBLE);
                String text = "You have lost the game, try again";
                statusOfGameTV.setText(text);
            }
        };
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mCountDownTimer!=null){
            mCountDownTimer.cancel();
            mCountDownTimer = null;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mCountDownTimer==null){
            mCountDownTimer = getCountDownTimer(remainingTime);
            if(remainingTime!=60){
                mCountDownTimer.start();
            }
        }
    }

    private void onResult(String title, String message, int image){

    }
}
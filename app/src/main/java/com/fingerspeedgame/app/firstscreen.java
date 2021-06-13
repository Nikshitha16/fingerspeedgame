package com.fingerspeedgame.app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.skydoves.powerspinner.OnSpinnerItemSelectedListener;
import com.skydoves.powerspinner.PowerSpinnerView;
import org.jetbrains.annotations.Nullable;


public class firstscreen extends AppCompatActivity {
    Button btnStart;
    PowerSpinnerView selectCharactersSpinner;
    public final static String selectedPosKey = "selectedPosition",
            easylevel = "easylevel", mediumlevel="mediumlevel", hardlevel = "hardlevel";
    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_firstscreen);
        selectCharactersSpinner = findViewById(R.id.selectCharactersSpinner);


        btnStart = findViewById(R.id.button);

        selectCharactersSpinner.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener<Object>() {
            @Override
            public void onItemSelected(int i, @Nullable Object o, int i1, Object t1) {
                pos = i1;
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(firstscreen.this,MainActivity.class);
                intent.putExtra(selectedPosKey, pos);
                intent.putExtra(easylevel, getIntent().getIntExtra(easylevel, 0));
                intent.putExtra(mediumlevel, getIntent().getIntExtra(mediumlevel, 0));
                intent.putExtra(hardlevel, getIntent().getIntExtra(hardlevel, 0));
                startActivity(intent);
                finish();
            }
        });
    }
}
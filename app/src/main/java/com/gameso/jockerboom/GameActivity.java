package com.gameso.jockerboom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class GameActivity extends AppCompatActivity {

    private int health = 30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView gameTimer = findViewById(R.id.gameTimer);
        ImageView imageHealth = findViewById(R.id.imageHealth);
        ImageView imageJoker = findViewById(R.id.imageJoker);

        Button buttonBackToMenu = findViewById(R.id.buttonBackToMenu);
        Button buttonEscape = findViewById(R.id.buttonEscape);
        buttonEscape.setOnClickListener(onClickEscape);
        buttonBackToMenu.setOnClickListener(onClickBackToMenu);

        new CountDownTimer(40000,1000){

            @Override
            public void onTick(long timeUntilEnd) {
               gameTimer.setText(String.format(Locale.getDefault(), "%d", timeUntilEnd/ 1000));

               runOnUiThread(() -> imageJoker.setOnClickListener(view -> {
                   health -= 1;
                   if(health == 0){
                       Intent intentWin = new Intent(GameActivity.this, WinActivity.class);
                       startActivity(intentWin);
                       finish();
                   } else if (health > 10) {
                       imageHealth.setImageResource(R.drawable.life_2_3);
                   } else if (health <= 10 && health > 0){
                       imageHealth.setImageResource(R.drawable.life_1_3);
                   }
               }));
            }

            @Override
            public void onFinish() {
            Intent intentLoose = new Intent(GameActivity.this, LooseActivity.class);
            startActivity(intentLoose);
            finish();
            }
        }.start();
    }

    View.OnClickListener onClickEscape = view -> finishAffinity();

    View.OnClickListener onClickBackToMenu = view -> {
        Intent intentBackToMenu = new Intent(GameActivity.this, MainActivity.class);
        startActivity(intentBackToMenu);
        finish();
    };
}
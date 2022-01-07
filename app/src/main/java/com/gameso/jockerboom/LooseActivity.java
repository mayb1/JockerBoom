package com.gameso.jockerboom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loose);

        Button buttonExitGame = findViewById(R.id.buttonExitGame);
        Button buttonTryAgain = findViewById(R.id.buttonTryAgain);
        buttonTryAgain.setOnClickListener(onClickTryAgain);
        buttonExitGame.setOnClickListener(onClickExitGame);
    }

    View.OnClickListener onClickTryAgain = view -> {
        Intent intent = new Intent (LooseActivity.this, GameActivity.class);
        startActivity(intent);
        finish();
    };

    View.OnClickListener onClickExitGame = view -> finishAffinity();

}
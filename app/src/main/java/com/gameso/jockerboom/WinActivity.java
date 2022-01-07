package com.gameso.jockerboom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        Button buttonGoAgain = findViewById(R.id.buttonGoAgain);
        Button buttonExitApp = findViewById(R.id.buttonExitApp);
        buttonGoAgain.setOnClickListener(onClickGoAgain);
        buttonExitApp.setOnClickListener(onClickExitApp);
    }

    View.OnClickListener onClickGoAgain = view -> {
        Intent intent = new Intent (WinActivity.this, GameActivity.class);
        startActivity(intent);
        finish();
    };

    View.OnClickListener onClickExitApp = view -> finishAffinity();

}
package com.example.abode.Onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.abode.MainPage_Activity;
import com.example.abode.R;

public class MainActivity extends AppCompatActivity {

    private androidx.appcompat.widget.AppCompatButton btn_letStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();

        pageDirectories();
    }

    private void pageDirectories() {

        btn_letStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainPage_Activity.class));
            }
        });
    }

    private void initWidget() {

        btn_letStart = findViewById(R.id.btn_letStart);
    }
}
package com.example.actividad4_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent main4 = new Intent(this, MainActivity4.class);
        startActivity(main4);
    }

}

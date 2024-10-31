package com.example.investigaseekbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.miBoton);
        SeekBar barra = findViewById(R.id.miSeekBar);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            barra.setProgress(barra.getProgress()+1);

            }
        });
    }
}
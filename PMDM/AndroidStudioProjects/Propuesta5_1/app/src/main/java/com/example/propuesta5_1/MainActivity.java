package com.example.propuesta5_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



        public void abrir1(View view) {
            Intent uno = new Intent(this, Activity1.class);
            startActivity(uno);
        }

        public void abrir2(View view) {
            Intent dos = new Intent(this, Activity2.class);
            startActivity(dos);
        }

        public void abrir3(View view) {
            Intent tres = new Intent(this, Activity3.class);
            startActivity(tres);
        }

        public void abrir4(View view) {
            Intent cuatro = new Intent(this, Activity4.class);
            startActivity(cuatro);
        }
    }

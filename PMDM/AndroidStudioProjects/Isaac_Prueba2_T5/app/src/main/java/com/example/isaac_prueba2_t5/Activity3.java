package com.example.isaac_prueba2_t5;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pantalla2);

        imageView = findViewById(R.id.imageView);
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.alfa2);
        imageView.startAnimation(animation);

    }
}


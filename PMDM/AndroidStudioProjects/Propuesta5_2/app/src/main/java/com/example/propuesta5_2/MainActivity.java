package com.example.propuesta5_2;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        // Botones y animaciones
        setupButton(R.id.btnAlpha1, R.anim.alfa1);
        setupButton(R.id.btnAlpha2, R.anim.alfa2);
        setupButton(R.id.btnScale1, R.anim.escala1);
        setupButton(R.id.btnScale2, R.anim.escala2);
        setupButton(R.id.btnMove1, R.anim.mueve1);
        setupButton(R.id.btnMove2, R.anim.mueve2);
        setupButton(R.id.btnRotate1, R.anim.rotar1);
        setupButton(R.id.btnRotate2, R.anim.rotar2);

    }

    private void setupButton(int buttonId, int animResource) {
        Button button = findViewById(buttonId);
        final Animation animation = AnimationUtils.loadAnimation(this, animResource);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(animation);
            }
        });
    }
}
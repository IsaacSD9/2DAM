package com.example.propuesta5_1;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        TextView textoTres = (TextView) findViewById(R.id.textoTres);
        textoTres.append("Texto añadido con Append desde Java");
        textoTres.setTextColor(Color.BLUE);
        textoTres.setTypeface(null, Typeface.ITALIC);

    }
}
package com.example.ai_pedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class category extends AppCompatActivity {

    private CardView fever,cold,cough,stomach,malnutri,period,diarrhea ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.your_color));
        }
        setContentView(R.layout.activity_category);
        fever = (CardView) findViewById(R.id.c1);
        fever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(), fever.class);
                startActivity(i1);
            }
        });
        cough = (CardView) findViewById(R.id.c2);
        cough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(getApplicationContext(), cough.class);
                startActivity(i2);
            }
        });
        cold = (CardView) findViewById(R.id.c3);
        cold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(getApplicationContext(), cold.class);
                startActivity(i3);
            }
        });
        stomach = (CardView) findViewById(R.id.c4);
        stomach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(getApplicationContext(), stomachache.class);
                startActivity(i4);
            }
        });
        malnutri = findViewById(R.id.c5);
        malnutri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(category.this, malnutrition.class);
                startActivity(intent);
            }
        });
        period = (CardView) findViewById(R.id.c6);
        period.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(getApplicationContext(), periodcramps.class);
                startActivity(i6);
            }
        });
        diarrhea = (CardView) findViewById(R.id.c7);
        diarrhea .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7 = new Intent(getApplicationContext(), diarrhea.class);
                startActivity(i7);
            }
        });
    }
}
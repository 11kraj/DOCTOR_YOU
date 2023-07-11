package com.example.ai_pedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class card24 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card24);
    }

    public void myWeb(View v)
    {
        openUrl("https://www.1mg.com/drugs/pause-500-tablet-37631");
    }
    public void openUrl(String url)
    {
        Uri uri = Uri.parse(url);
        Intent i1 =new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i1);
    }
}
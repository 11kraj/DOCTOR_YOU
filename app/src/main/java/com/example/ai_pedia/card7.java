package com.example.ai_pedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class card7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card7);
    }
    public void myWeb(View v)
    {
        openUrl("https://www.1mg.com/drugs/cheston-cold-tablet-63785?wpsrc=Google+Organic+Search\n");
    }
    public void openUrl(String url)
    {
        Uri uri = Uri.parse(url);
        Intent i1 =new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i1);
    }
}
package com.example.ai_pedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class card8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card8);
    }
    public void myWeb(View v)
    {
        openUrl("https://www.1mg.com/otc/dabur-honitus-herbal-cough-remedy-otc113472?wpsrc=Google+Organic+Search");
    }
    public void openUrl(String url)
    {
        Uri uri = Uri.parse(url);
        Intent i1 =new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i1);
    }
}
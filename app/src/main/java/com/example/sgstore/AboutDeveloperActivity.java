package com.example.sgstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutDeveloperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        Button button = findViewById(R.id.open_facebook_developer);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://m.facebook.com/MotazMez00/"));
                startActivity(intent);
            }
        });
        Button button1 = findViewById(R.id.open_whats_developer);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumberWithCountryCode = "+201091720977";
                Intent openWhatsap = new Intent(Intent.ACTION_VIEW);
                openWhatsap.setData(Uri.parse("https://wa.link/zk3g5u"));
                startActivity(openWhatsap);
            }
        });
    }
}
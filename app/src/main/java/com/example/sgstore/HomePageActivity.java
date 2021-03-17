package com.example.sgstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.closed);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        NavigationView navigationView = findViewById(R.id.navigator);
        NavigationView.OnNavigationItemSelectedListener listener = new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int menuItemId = item.getItemId();
                if (menuItemId == R.id.about_s7aly) {
                    startActivity(new Intent(getBaseContext(), AboutUs.class));
                } else if (menuItemId == R.id.open_facebook) {
                    Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://m.facebook.com/SGStoreGaming/"));
                    startActivity(intent);
                } else if (menuItemId == R.id.open_youtube) {
                    Intent openYouTube = new Intent(Intent.ACTION_VIEW);
                    openYouTube.setData(Uri.parse("https://www.youtube.com/channel/UCcZsXshki73F8olS1pxe5ug"));
                    startActivity(openYouTube);
                } else {
                    startActivity(new Intent(getBaseContext(), AboutDeveloperActivity.class));
                }
                return true;
            }
        };
        navigationView.setNavigationItemSelectedListener(listener);
    }

    public void open(View view) {
        Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void soon (View  view){
        Toast.makeText(this, "SOOOOOON....", Toast.LENGTH_SHORT).show();
    }
}
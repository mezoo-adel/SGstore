package com.example.sgstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
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

    @Override
    protected void onStart() {
        super.onStart();
        isNetworkConnectionAvailable();
    }

    public void open(View view) {
        Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void soon (View  view){
        Toast.makeText(this, "SOOOOOON....", Toast.LENGTH_SHORT).show();
    }

    public boolean isNetworkConnectionAvailable(){

        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            AlertDialog.Builder builder =new AlertDialog.Builder(this);
            builder.setTitle("No internet Connection");
            builder.setMessage("Please turn on internet connection to continue");
            builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    HomePageActivity.this.finish();
                }
            });
            builder.setPositiveButton("open", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    HomePageActivity.this.startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

            return false;
        }
        return true;
    }
}
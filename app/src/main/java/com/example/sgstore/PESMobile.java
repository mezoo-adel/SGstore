package com.example.sgstore;

import ConnectSQLserver.SqlDb;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class PESMobile extends AppCompatActivity {
SqlDb db = new SqlDb();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_e_s_mobile);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);


    }

    @Override
    protected void onStart() {
        super.onStart();
        int image = R.drawable.pes2020;String tab = "PES_MOBILE";
        RecyclerView  recyclerView = findViewById(R.id.recycularPes);
        MyRecyclertAdapter adapter = new MyRecyclertAdapter(db.getData("PESMobile").toArray(),image,tab);
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(manager);

    }
}
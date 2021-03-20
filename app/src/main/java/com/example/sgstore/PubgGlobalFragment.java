package com.example.sgstore;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import ConnectSQLserver.SqlDb;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




public class PubgGlobalFragment extends Fragment {
SqlDb db = new SqlDb();
    public PubgGlobalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String tab= "pubgGlobal"; String tableName = "PubgMobile";
        int images = R.drawable.uc;

    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_pubg_global, container, false);
        MyRecyclertAdapter
            recyclertAdapter = new MyRecyclertAdapter(db.getData(tableName).toArray(),images,tab);
        recyclerView.setAdapter(recyclertAdapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);
      return recyclerView;

    }


}
package com.example.sgstore;

import android.os.Bundle;

import ConnectSQLserver.SqlDb;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class PubgKoreanFragment extends Fragment {

    public PubgKoreanFragment() {
        // Required empty public constructor
    }
SqlDb db =new SqlDb();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String tab = "pubgKorean";
        int images = R.drawable.uc;

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_pubg_global,container,false);
       MyRecyclertAdapter recyclertAdapter = new MyRecyclertAdapter(db.getData("PubgKorean").toArray(),images , tab);
        recyclerView.setAdapter(recyclertAdapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);

        return recyclerView;
    }


}
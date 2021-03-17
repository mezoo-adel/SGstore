package com.example.sgstore;

import android.os.Bundle;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int tab = 1;
        int[] prices ={25,65,180,460,890,90};
        String[] description={"60 Uc","190 Uc","660 Uc","1800 Uc","3850 Uc","👑 Prime Plus"};
        int[] image = { R.drawable.uc,R.drawable.uc,R.drawable.uc,R.drawable.season,R.drawable.season,R.drawable.prime};

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_pubg_global,container,false);
       MyRecyclertAdapter recyclertAdapter = new MyRecyclertAdapter(prices ,description,image, tab);
        recyclerView.setAdapter(recyclertAdapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);

        return recyclerView;
    }


}
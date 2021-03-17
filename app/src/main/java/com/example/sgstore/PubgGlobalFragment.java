package com.example.sgstore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




public class PubgGlobalFragment extends Fragment {

    public PubgGlobalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        int tab= 0;
   int[] prices = {15, 20, 25, 65, 90, 125, 175, 190, 210, 250, 375, 420, 450, 650,840, 890,1100, 1400, 1700,1800,25, 100};
        String[] description = {"34 Uc", "63 Uc", "71 Uc", "221 Uc", "325 Uc", "422 Uc", "660 Uc", "770Uc", "844 Uc", "991 Uc", "1540 Uc", "1800 Uc", "2013 Uc", "2783 Uc", "3850 Uc", "4200 Uc", "4970 Uc","6213 Uc","8100 Uc","8750 Uc", "👑 Prime", "👑 Prime Plus"};
        int[] image = {R.drawable.uc,R.drawable.uc,R.drawable.uc,R.drawable.uc,R.drawable.uc,R.drawable.uc,R.drawable.season,R.drawable.uc,R.drawable.uc,R.drawable.uc,R.drawable.uc,R.drawable.season,R.drawable.uc,R.drawable.uc,R.drawable.uc,R.drawable.uc,R.drawable.uc,R.drawable.uc,R.drawable.uc,R.drawable.uc, R.drawable.prime,R.drawable.prime};


        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_pubg_global, container, false);
        MyRecyclertAdapter
            recyclertAdapter = new MyRecyclertAdapter(prices,description,image,tab);
        recyclerView.setAdapter(recyclertAdapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);
      return recyclerView;

    }


}
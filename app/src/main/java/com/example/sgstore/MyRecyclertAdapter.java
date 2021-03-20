package com.example.sgstore;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclertAdapter extends RecyclerView.Adapter {


    private Object[] data;
    private int image;
    private  String tab;



    public MyRecyclertAdapter(Object[] data, int image , String tab) {

        this.data = data;
        this.image = image;
        this.tab=tab;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        MyRecyclertAdapter.MyViewHolder myViewHolder = new MyRecyclertAdapter.MyViewHolder(cardView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyRecyclertAdapter.MyViewHolder myViewHolder = (MyRecyclertAdapter.MyViewHolder) holder;
        final CardView cardView = myViewHolder.getCardView();

        TextView textViewDesc = cardView.findViewById(R.id.textViewDesc);
        textViewDesc.setText(data[position].toString().substring(0,data[position].toString().indexOf('_')));

        TextView textViewPrice = cardView.findViewById(R.id.textViewPrice);
        textViewPrice.setText((data[position].toString().substring(data[position].toString().indexOf('_')+1) + " EGP"));

        ImageView imageView = cardView.findViewById(R.id.imageView);
       imageView.setImageResource(image);

        Button button = cardView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cardView.getContext(), OrderActivity.class);
                    intent.putExtra("order", data[position].toString().concat("EGP")+"\n"+tab);
                    cardView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;

        public MyViewHolder(@NonNull CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }

        public CardView getCardView() {
            return cardView;
        }
    }

}
package com.example.sgstore;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.ResultSet;
import java.sql.SQLException;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclertAdapter extends RecyclerView.Adapter {

   private int[] prices;
    private String[] description;
    private int[] image;
    private  int tab;



    public MyRecyclertAdapter(int[] prices, String[] description, int[] image , int tab) {
        this.prices = prices;
        this.description = description;
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
        TextView textView = cardView.findViewById(R.id.textView);

     textView.setText(description[position]);
        TextView textView2 = cardView.findViewById(R.id.textView2);

        textView2.setText((prices[position]) + " EGP");
        ImageView imageView = cardView.findViewById(R.id.imageView);

       imageView.setImageResource(image[position]);
        Button button = cardView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cardView.getContext(), OrderActivity.class);
                if(tab == 1){
                    intent.putExtra("order", description[position]+ " " + " Pubg Kr"+ "\n" + prices[position] + "EGP" );
                    cardView.getContext().startActivity(intent);
                }
                else {
                    intent.putExtra("order", description[position] + " " +  " Pubg global "+ "\n"+prices[position]+ "EGP");
                    cardView.getContext().startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return prices.length;
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
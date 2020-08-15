package com.example.myapplication.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class CardHolder extends RecyclerView.ViewHolder  {

    public TextView title;
    public ImageView image;

    public CardHolder(@NonNull View itemView) {
        super(itemView);

        this.title = itemView.findViewById(R.id.cardTitle);
        this.image = itemView.findViewById(R.id.cardImages);
    }
}

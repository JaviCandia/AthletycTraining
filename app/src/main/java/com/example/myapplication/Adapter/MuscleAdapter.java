package com.example.myapplication.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Holder.CardHolder;
import com.example.myapplication.Model.CardModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MuscleAdapter extends RecyclerView.Adapter<CardHolder> {
    Context c;
    ArrayList<CardModel> models;

    public MuscleAdapter(Context c, ArrayList<CardModel> models){
        this.c = c;
        this.models = models;
    }


    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_article, null);
        return new CardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardHolder holder, final int position) {
        final String muscle;
        holder.title.setText(muscle = models.get(position).getTitle());
        holder.title.setBackgroundResource(models.get(position).getColor());
        holder.image.setImageResource(R.drawable.ejercicio);

        // Defino los parámetros
        final Bundle bundle = new Bundle();
        bundle.putString("muscle", muscle);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navego y le mando los parámetros
                Navigation.findNavController(holder.itemView).navigate(R.id.action_trainingDayFragment_to_trainingMuscleFragment, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}

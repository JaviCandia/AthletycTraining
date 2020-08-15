package com.example.myapplication.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Dataset.ObjectArticle;
import com.example.myapplication.Dataset.FakeDb;
import com.example.myapplication.Holder.CardHolder;
import com.example.myapplication.Model.CardModel;
import com.example.myapplication.R;
import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<CardHolder> implements Filterable {

    Context c;
    ArrayList<CardModel> models;
    List<CardModel> modelsAll;

    public ArticleAdapter(Context c, ArrayList<CardModel> models) {
        this.c = c;
        this.models = models;
        this.modelsAll = new ArrayList<>(models);
    }

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_article, null);
        return new CardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardHolder holder, final int position) {
        final int colorsin;
        List<ObjectArticle> listaRecibida = FakeDb.getArticles();

        holder.title.setText(models.get(position).getTitle());
        holder.image.setImageResource(listaRecibida.get(position).getImg());
        holder.title.setBackgroundResource(colorsin = models.get(position).getColor());

        // Defino los parámetros
        final Bundle bundle = new Bundle();
        bundle.putInt("numArticle", position);
        bundle.putInt("colorArticle", colorsin);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navego y le mando los parámetros
                Navigation.findNavController(holder.itemView).navigate(R.id.action_homeFragment_to_articleFragment, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<CardModel> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0)
                filteredList.addAll(modelsAll);
            else{

                String filterPattern = constraint.toString().toLowerCase().trim();

                for (CardModel item: modelsAll){
                    if(item.getTitle().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            models.clear();
            models.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}

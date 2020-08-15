package com.example.myapplication.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Adapter.ArticleAdapter;
import com.example.myapplication.Dataset.ObjectArticle;
import com.example.myapplication.Dataset.FakeDb;
import com.example.myapplication.Model.CardModel;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArticleAdapter articleAdapter = new ArticleAdapter(getActivity(), getMyList());

    public HomeFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = rootView.findViewById(R.id.articleRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(articleAdapter);

        return rootView;
    }


    private ArrayList<CardModel> getMyList() {
        ArrayList<CardModel> models = new ArrayList<>();
        List<ObjectArticle> listaRecibida = FakeDb.getArticles();

        CardModel m = new CardModel();
        m.setTitle(listaRecibida.get(0).getTitle());
        m.setColor(getColor());
        models.add(m);

        m = new CardModel();
        m.setTitle(listaRecibida.get(1).getTitle());
        m.setColor(getColor());
        models.add(m);

        m = new CardModel();
        m.setTitle(listaRecibida.get(2).getTitle());
        m.setColor(getColor());
        models.add(m);

        m = new CardModel();
        m.setTitle(listaRecibida.get(3).getTitle());
        m.setColor(getColor());
        models.add(m);

        m = new CardModel();
        m.setTitle(listaRecibida.get(4).getTitle());
        m.setColor(getColor());
        models.add(m);

        m = new CardModel();
        m.setTitle(listaRecibida.get(5).getTitle());
        m.setColor(getColor());
        models.add(m);

        return models;
    }

    public int getColor(){
        int color = 0;
        Random rn = new Random();
        int selection = rn.nextInt(6 - 1) +1;
        switch (selection){
            case 1: color = R.color.transparent_blue; break;
            case 2: color = R.color.transparent_green; break;
            case 3: color = R.color.transparent_magenta; break;
            case 4: color = R.color.transparent_red; break;
            case 5: color = R.color.transparent_violet; break;
        }
        return color;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                articleAdapter.getFilter().filter(newText);
                return false;
            }
        });

    }

}

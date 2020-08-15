package com.example.myapplication.fragments;

import android.app.ActionBar;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.Dataset.ObjectArticle;
import com.example.myapplication.Dataset.FakeDb;
import com.example.myapplication.R;

import java.util.List;

public class ArticleFragment extends Fragment {

    TextView articleTitle, articleBody, articleAutor, articleDate;
    ImageView articleImage;

    int num, color;

    public ArticleFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment}
        View rootView = inflater.inflate(R.layout.fragment_article, container, false);

        articleTitle = rootView.findViewById(R.id.articleTitle);
        //articleAutor = rootView.findViewById(R.id.articleAutor);
        articleDate = rootView.findViewById(R.id.articleDate);
        articleImage = rootView.findViewById(R.id.articleImage);
        articleBody = rootView.findViewById(R.id.articleBody);

        // Extraigo los parámetros que recibo desde el adapter
        Bundle arguments = getArguments();
        num = arguments.getInt("numArticle");
        color = arguments.getInt("colorArticle");

        // Para cambiar el color del fragment
        ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(getBarColor(color))));
        setTitle("AC");
        getActivity().getWindow().setStatusBarColor(getResources().getColor(getBarColor(color)));

        List<ObjectArticle> receivedList = FakeDb.getArticles();

        // Enviando info a la pantalla
        articleTitle.setText(receivedList.get(num).getTitle());
        articleDate.setText(receivedList.get(num).getDate());
        articleImage.setImageResource(receivedList.get(num).getImg());
        articleBody.setText(receivedList.get(num).getBody());

        return rootView;
    }

    public int getBarColor(int selection){
        int color = 0;
        switch (selection){
            case R.color.transparent_blue: color = R.color.solid_blue; break;
            case R.color.transparent_green: color = R.color.solid_green; break;
            case R.color.transparent_magenta: color = R.color.solid_magenta; break;
            case R.color.transparent_red: color = R.color.solid_red; break;
            case R.color.transparent_violet: color = R.color.solid_violet;
        }
        return color;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDestroy() {
        super.onDestroy();

        getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.solid_deeper_blue));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_blue_black));

        setTitleOriginal();
    }

    public void setTitle(String title){
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textView = new TextView(getActivity());
        textView.setText(title);
        textView.setTextSize(20);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(getResources().getColor(R.color.colorWhite));
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setCustomView(textView);
    }

    public void setTitleOriginal(){
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.app_name);
        textView.setTextSize(20);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.LEFT);
        textView.setTextColor(getResources().getColor(R.color.colorWhite));
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setCustomView(textView);
    }
}

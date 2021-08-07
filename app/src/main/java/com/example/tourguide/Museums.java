package com.example.tourguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Museums extends Fragment {
    static ArrayList<Place> museums;
    View view;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_museums, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        museums = new ArrayList<>();

        museums.add(new Place(getString(R.string.alex_museum), R.drawable.alex_museum, getString(R.string.alex_national_museum_detail)));
        museums.add(new Place(getString(R.string.royal_museum), R.drawable.the_royal_jewelry, getString(R.string.no_data)));
        museums.add(new Place(getString(R.string.egypt_museum), R.drawable.egyption_musum, getString(R.string.egyption_museums_detail)));
        museums.add(new Place(getString(R.string.valley_of_the_kings), R.drawable.luxor_egypt, getString(R.string.vally_of_the_kings_detail)));
        museums.add(new Place(getString(R.string.pyramids), R.drawable.pyramids_of_giza, getString(R.string.pyramids_detail)));
        museums.add(new Place(getString(R.string.nubian), R.drawable.nuabian, getString(R.string.no_data)));
        museums.add(new Place(getString(R.string.bibliotheca), R.drawable.alex_library, getString(R.string.biblioteca_detail)));

        recyclerView = view.findViewById(R.id.museumsList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PlaceAdapter(museums, this.getActivity());
        recyclerView.setAdapter(adapter);
    }
}
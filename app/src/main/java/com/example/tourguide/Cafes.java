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

public class Cafes extends Fragment {
    static ArrayList<Place> cafes;
    View view;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cafes, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        cafes = new ArrayList<>();
        cafes.add(new Place(getString(R.string.fishawi_cafe), R.drawable.el_fishawi_cafe, getString(R.string.fishawi_cafe_details)));
        cafes.add(new Place(getString(R.string.greco_cafe), R.drawable.greco_cafe, getString(R.string.cafe)));
        cafes.add(new Place(getString(R.string.starbucks_cafe), R.drawable.starbucks_cafe, getString(R.string.cafe)));
        cafes.add(new Place(getString(R.string.ontherun_cafe), R.drawable.on_the_run_cafe, getString(R.string.cafe)));
        cafes.add(new Place(getString(R.string.espresso_lab), R.drawable.espresso_cafe, getString(R.string.cafe)));
        cafes.add(new Place(getString(R.string.beano_cafe), R.drawable.no_img, getString(R.string.cafe)));
        cafes.add(new Place(getString(R.string.clintro_cafe), R.drawable.no_img, getString(R.string.cafe)));
        cafes.add(new Place(getString(R.string.costa_cafe), R.drawable.costa_cafe, getString(R.string.cafe)));

        recyclerView = view.findViewById(R.id.cafesList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PlaceAdapter(cafes, this.getActivity());
        recyclerView.setAdapter(adapter);
    }

}
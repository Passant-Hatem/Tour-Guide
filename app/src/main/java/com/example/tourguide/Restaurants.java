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

public class Restaurants extends Fragment {
    static ArrayList<Place> restaurants;
    View view;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_resturants, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        restaurants = new ArrayList<>();
        restaurants.add(new Place(getString(R.string.seafood_rest), R.drawable.seafood_rest, getString(R.string.seafood_factory_rest_detail)));
        restaurants.add(new Place(getString(R.string.alkhal_rest), R.drawable.alkhal_rest, getString(R.string.elkhal_rest_detail)));
        restaurants.add(new Place(getString(R.string.tejano_rest), R.drawable.tejano_rest, getString(R.string.tegano_rest_detail)));
        restaurants.add(new Place(getString(R.string.aisha_rest), R.drawable.aisha_rest, getString(R.string.aisha_rest_detail)));
        restaurants.add(new Place(getString(R.string.koshary_rest), R.drawable.koshary_rest, getString(R.string.koshary_rest_details)));
        restaurants.add(new Place(getString(R.string.solis_rest), R.drawable.solis_restaurant, getString(R.string.soils_rest_detail)));
        restaurants.add(new Place(getString(R.string.blue_rest), R.drawable.the_blue_restaurant, getString(R.string.blue_rest_detail)));

        recyclerView = view.findViewById(R.id.resturantsList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PlaceAdapter(restaurants, this.getActivity());
        recyclerView.setAdapter(adapter);
    }
}
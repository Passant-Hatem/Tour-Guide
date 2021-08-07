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

public class Hotels extends Fragment {

    static ArrayList<Place> hotels;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_hotels, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        hotels = new ArrayList<>();
        hotels.add(new Place(getString(R.string.sharm_hotel), R.drawable.rixos_hotel,
                getString(R.string.rixos_hotel_detail)));
        hotels.add(new Place(getString(R.string.hilton_luxor_hotel), R.drawable.hilton_luxor_hotel,
                getString(R.string.hilton_luxor_hotel_detail)));
        hotels.add(new Place(getString(R.string.baron_hotel), R.drawable.baron_hotel,
                getString(R.string.baron_hotel_detail)));
        hotels.add(new Place(getString(R.string.aqua_hotel), R.drawable.aqua_vista_hotel,
                getString(R.string.aqua_hotel_detail)));
        hotels.add(new Place(getString(R.string.albatros_hotel), R.drawable.albtros_hotel,
                getString(R.string.albatros_hotel_detail)));
        hotels.add(new Place(getString(R.string.movenpick_hotel), R.drawable.movenpick_hotel,
                getString(R.string.movenpick_hotel_detail)));
        hotels.add(new Place(getString(R.string.sofitel_hotel), R.drawable.sofitel,
                getString(R.string.sofitel_hotel_detail)));
        hotels.add(new Place(getString(R.string.hilton_alex_hotel), R.drawable.alex_hotel,
                getString(R.string.hilton_alex_hotel_detail)));

        recyclerView = view.findViewById(R.id.hotelList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PlaceAdapter(hotels, this.getActivity());
        recyclerView.setAdapter(adapter);
    }
}
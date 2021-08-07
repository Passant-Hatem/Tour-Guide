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

public class Beaches extends Fragment {
    static ArrayList<Place> beaches;
    View view;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_beachs, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        beaches = new ArrayList<>();
        beaches.add(new Place(getString(R.string.sharm_beach), R.drawable.sharm_el_luli, getString(R.string.no_data)));
        beaches.add(new Place(getString(R.string.ras_um_sidi), R.drawable.sharm_el_luli, getString(R.string.rasumsidi_beach_deatails)));
        beaches.add(new Place(getString(R.string.shark_beach), R.drawable.shark_s_bay_beach, getString(R.string.no_data)));
        beaches.add(new Place(getString(R.string.fanar_beach), R.drawable.elfnar_beach, getString(R.string.no_data)));
        beaches.add(new Place(getString(R.string.hankorab_beach), R.drawable.sharm_el_luli, getString(R.string.no_data)));

        recyclerView = view.findViewById(R.id.beachsList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PlaceAdapter(beaches, this.getActivity());
        recyclerView.setAdapter(adapter);
    }
}
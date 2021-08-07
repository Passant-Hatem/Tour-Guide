package com.example.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    static ItemClicked activity;
    private final ArrayList<Place> places;

    public PlaceAdapter(ArrayList<Place> list, Context context) {
        places = list;
        activity = (ItemClicked) context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(places.get(position));

        holder.placeNameTxtV.setText(places.get(position).getName());
        holder.imageView.setImageResource(places.get(position).getImageSource());
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public interface ItemClicked {
        void onItemClicked(int index);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView placeNameTxtV;
        ImageView imageView;

        public ViewHolder(final View itemView) {
            super(itemView);
            placeNameTxtV = itemView.findViewById(R.id.placeNameTextView);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(view -> activity.onItemClicked(places.indexOf(itemView.getTag())));
        }
    }
}

package com.example.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    ImageView placeImg;
    TextView placeNameText;
    TextView detailsText;
    Button getLocationButton;
    Place place;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        int index = getIntent().getIntExtra(getString(R.string.index),0);
        int type = getIntent().getIntExtra(getString(R.string.type) ,0);

        switch (type) {
            case 0:
                place = Hotels.hotels.get(index);
                break;
            case 1:
                place =  Restaurants.restaurants.get(index);
                break;
            case 2:
                place =  Cafes.cafes.get(index);
                break;
            case 3:
                place =  Museums.museums.get(index);
                break;
            case 4:
                place =  Beaches.beaches.get(index);
                break;
        }

        placeImg = findViewById(R.id.placeImageView);
        placeImg.setImageResource(place.getImageSource());

        placeNameText = findViewById(R.id.nameTextView);
        placeNameText.setText(place.getName());

        detailsText = findViewById(R.id.detailsTextView);
        detailsText.setText(place.getDetails());

        getLocationButton = findViewById(R.id.locationButton);
        getLocationButton.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse(getString(R.string.map_prefx) + place.getName()));
            startActivity(intent);
        });

    }
}
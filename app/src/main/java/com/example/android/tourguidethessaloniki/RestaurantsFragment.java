package com.example.android.tourguidethessaloniki;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        RecyclerView locationsList = (RecyclerView) rootView.findViewById(R.id.location_recycler_view);

        // Create a list of Landmarks in Thessaloniki
        final ArrayList<Location> restaurants = new ArrayList<>();
        restaurants.add(new Location(R.drawable.tavern_negroponte, getString(R.string.restaurants_location_1), getString(R.string.restaurants_attraction_1)));
        restaurants.add(new Location(R.drawable.tavern_molivos_mezze, getString(R.string.restaurants_location_2), getString(R.string.restaurants_attraction_2)));
        restaurants.add(new Location(R.drawable.tavern_sempriko, getString(R.string.restaurants_location_3), getString(R.string.restaurants_attraction_3)));
        restaurants.add(new Location(R.drawable.tavern_mageires, getString(R.string.restaurants_location_4), getString(R.string.restaurants_attraction_4)));
        restaurants.add(new Location(R.drawable.tavern_kichenbar, getString(R.string.restaurants_location_5), getString(R.string.restaurants_attraction_5)));
        restaurants.add(new Location(R.drawable.tavern_agioli, getString(R.string.restaurants_location_6), getString(R.string.restaurants_attraction_6)));
        restaurants.add(new Location(R.drawable.tavern_kouzina_kioupia, getString(R.string.restaurants_location_7), getString(R.string.restaurants_attraction_7)));


        // Set color to the Layout for the adapter
        int color = ContextCompat.getColor(getContext(), R.color.colorTransGreen);
        // Pass all landmarks data and context to adapter
        LocationAdapter adapter = new LocationAdapter(color, restaurants, getContext());
         /* Sets layout manager for recycler view */
        locationsList.setLayoutManager(new LinearLayoutManager(getContext()));
        /* Used as a divider between items separating each row. */
        locationsList.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        //Set default animations
        locationsList.setItemAnimator(new DefaultItemAnimator());
        /* Sets adapter for recycler view which is bound to a custom view holder */
        locationsList.setAdapter(adapter);

        /**
         * Sets up a custom on touch listener to detect clicks on recycler view since this
         * is the only way to handle clicks in recycler view
         */
        locationsList.addOnItemTouchListener(new RecyclerTouchListener(getContext(), locationsList, new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                // Opens up clicked location in google maps
                Location chosenPlace = restaurants.get(position);
                String address = chosenPlace.getmAttractionName() + ", " + chosenPlace.getmLocationName();
                /* Searching for a specific address will display a pin at that location */
                Uri intentUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, intentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                // Checks if there is an app to handle the Map Intent
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return rootView;
    }

}

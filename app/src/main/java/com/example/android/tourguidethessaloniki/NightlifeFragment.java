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
public class NightlifeFragment extends Fragment {


    public NightlifeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        RecyclerView locationsList = (RecyclerView) rootView.findViewById(R.id.location_recycler_view);

        // Create a list of Landmarks in Thessaloniki
        final ArrayList<Location> nightlife = new ArrayList<>();
        nightlife.add(new Location(R.drawable.dentro_sto_bar, getString(R.string.nightlife_location_1), getString(R.string.nightlife_attraction_1)));
        nightlife.add(new Location(R.drawable.arxegono_draft, getString(R.string.nightlife_location_2), getString(R.string.nightlife_attraction_2)));
        nightlife.add(new Location(R.drawable.rahati_shisha, getString(R.string.nightlife_location_3), getString(R.string.nightlife_attraction_3)));
        nightlife.add(new Location(R.drawable.pulp_bar, getString(R.string.nightlife_location_4), getString(R.string.nightlife_attraction_4)));
        nightlife.add(new Location(R.drawable.eightball_metal_club, getString(R.string.nightlife_location_5), getString(R.string.nightlife_attraction_5)));

        // Set color to the Layout for the adapter
        int color = ContextCompat.getColor(getContext(), R.color.colorTransPrimary);
        // Pass all landmarks data and context to adapter
        LocationAdapter adapter = new LocationAdapter(color, nightlife, getContext());
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
                Location chosenPlace = nightlife.get(position);
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

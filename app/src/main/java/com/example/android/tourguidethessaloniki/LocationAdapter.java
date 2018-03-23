package com.example.android.tourguidethessaloniki;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Thanassis on 7/1/2018.
 */

public class LocationAdapter extends RecyclerView.Adapter<LocationHolder> {

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;
    /**
     * List of locations
     */
    private ArrayList<Location> mLocationList = new ArrayList<>();
    /**
     * Context of the app
     */
    private Context mContext;

    public LocationAdapter(int mColorResourceId, ArrayList<Location> mLocationList, Context mContext) {
        this.mColorResourceId = mColorResourceId;
        this.mLocationList = mLocationList;
        this.mContext = mContext;
    }

    @Override
    public LocationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new LocationHolder(view);
    }

    @Override
    public void onBindViewHolder(LocationHolder holder, int position) {
        Location location = mLocationList.get(position);
        holder.bindView(location, getmColorResourceId());
    }

    public int getmColorResourceId() {
        return mColorResourceId;
    }

    @Override
    public int getItemCount() {
        return mLocationList.size();
    }

    /**
     * THIS METHOD IS CREATED TO PREVET RECYCLER VIEW TO DUPLICATE ITEMS
     */
    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    /**
     * THIS METHOD IS CREATED TO PREVET RECYCLER VIEW TO DUPLICATE ITEMS
     */
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

}

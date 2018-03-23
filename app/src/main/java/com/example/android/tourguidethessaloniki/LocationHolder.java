package com.example.android.tourguidethessaloniki;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Thanassis on 7/1/2018.
 */

public class LocationHolder extends RecyclerView.ViewHolder {
    /**
     * Holder of the Image
     */
    private ImageView mImageView;
    /**
     * Holder of the location name
     */
    private TextView mLocationName;
    /**
     * Holder of the attraction name
     */
    private TextView mAttractionName;
    /**
     * Holder of the LinearLayout
     */
    private RelativeLayout mRelativeLayour;

    /**
     * CONSTRUCTOR HOLDER CREATED FOR RECYCLERVIEW USAGE
     *
     * @param locationView
     */
    public LocationHolder(View locationView) {
        super(locationView);
        mImageView = (ImageView) locationView.findViewById(R.id.image_view_id);
        mLocationName = (TextView) locationView.findViewById(R.id.location_text_view_id);
        mAttractionName = (TextView) locationView.findViewById(R.id.attraction_text_view_id);
        mRelativeLayour = (RelativeLayout) locationView.findViewById(R.id.layout_color_id);

    }

    /**
     * METHOD BINDS LOCATION TO THE HOLDER
     *
     * @param location
     */
    public void bindView(Location location, int color) {
        if (location.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            mImageView.setImageResource(location.getmImageResourceId());
            // Make sure the view is visible
            mImageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            mImageView.setVisibility(View.GONE);
        }
        mLocationName.setText(location.getmLocationName());
        mAttractionName.setText(location.getmAttractionName());
        mRelativeLayour.setBackgroundColor(color);

    }
}

package com.example.android.tourguidethessaloniki;

/**
 * Created by Thanassis on 7/1/2018.
 */

public class Location {
    /**
     * Image representing the location , Drawable resource
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    /**
     * Constant value that represents no image was provided for this location
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * String representing the location
     */
    private String mLocationName;

    /**
     * String representing the attraction name
     */
    private String mAttractionName;

    /**
     * CREATE A NEW LOCATION OBJECT, CONSTRUCTOR with 3 PARAMETERS
     *
     * @param mImageResourceId preview of the location
     * @param mLocationName    the address name
     * @param mAttractionName  the name of the attraction
     */
    public Location(int mImageResourceId, String mLocationName, String mAttractionName) {
        this.mImageResourceId = mImageResourceId;
        this.mLocationName = mLocationName;
        this.mAttractionName = mAttractionName;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public String getmLocationName() {
        return mLocationName;
    }

    public String getmAttractionName() {
        return mAttractionName;
    }

    /**
     * Returns whether or not there is an image for this location.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}

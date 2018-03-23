package com.example.android.tourguidethessaloniki;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Thanassis on 8/1/2018.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    /* Context of the app */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */
    public CategoryAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MuseumFragment();
            case 1:
                return new LandmarksFragment();
            case 2:
                return new NightlifeFragment();
            case 3:
                return new RestaurantsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.museum_fragment);
            case 1:
                return mContext.getString(R.string.landmark_fragment);
            case 2:
                return mContext.getString(R.string.nightlife_fragment);
            case 3:
                return mContext.getString(R.string.restaurant_fragment);
            default:
                return null;
        }
    }
}

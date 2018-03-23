package com.example.android.tourguidethessaloniki;

import android.view.View;

/**
 * Created by Thanassis on 8/1/2018.
 */

public interface RecyclerViewItemClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}

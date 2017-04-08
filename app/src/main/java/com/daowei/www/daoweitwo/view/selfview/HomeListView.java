package com.daowei.www.daoweitwo.view.selfview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 *
 * Created by yulu on 2017/2/24.
 */

public class HomeListView extends ListView {

    public HomeListView(Context context) {
        this(context,null);
    }

    public HomeListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        return super.onTouchEvent(ev);
    }
}

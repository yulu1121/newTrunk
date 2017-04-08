package com.daowei.www.daoweitwo.view.selfview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 *
 * Created by Administrator on 2017/2/23.
 */

public class HomeRecelerView extends RecyclerView {
    public HomeRecelerView(Context context) {
       this(context,null);
    }

    public HomeRecelerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction()==MotionEvent.ACTION_MOVE){
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }
}

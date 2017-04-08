package com.daowei.www.daoweitwo.view.selfview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

/**
 *
 * Created by yulu on 2017/2/22.
 */

public class HomeGridView extends GridView {
    public HomeGridView(Context context) {
        this(context,null);
    }

    public HomeGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param ev
     * @return
     * 不让gridview滚动
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction()==MotionEvent.ACTION_MOVE){
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }
}

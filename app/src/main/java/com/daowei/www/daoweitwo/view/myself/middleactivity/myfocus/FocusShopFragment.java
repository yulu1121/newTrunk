package com.daowei.www.daoweitwo.view.myself.middleactivity.myfocus;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daowei.www.daoweitwo.R;

/**
 * Created by douwei on 2017/2/28.
 */
public class FocusShopFragment extends Fragment {
    private Context context;
    private  View view;

    public static FocusShopFragment  newInstance(){
        return new FocusShopFragment();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null){
            View view = inflater.inflate(R.layout.layout_focus_shop,container,false);
            return view;
        }
        return view;
    }
}

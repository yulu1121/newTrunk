package com.daowei.www.daoweitwo.view.myself.middleactivity.myfocus;

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
public class FocusServiceFragment extends Fragment{
    private View view;

    public static FocusServiceFragment newInstance(){
        return new FocusServiceFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view ==null){
            View view = inflater.inflate(R.layout.layout_focus_service,container,false);
            return view;
        }

        return view;
    }
}

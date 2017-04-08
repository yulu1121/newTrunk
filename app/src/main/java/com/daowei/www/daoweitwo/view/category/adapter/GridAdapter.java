package com.daowei.www.daoweitwo.view.category.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.module.category.bean.CategoryBean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class GridAdapter extends BaseAdapter {

    private List<CategoryBean.DataBean.TagsBean> list;
    private Context context;
    private LayoutInflater inflater;

    public GridAdapter(Context context, List<CategoryBean.DataBean.TagsBean> list){
        inflater = LayoutInflater.from(context);
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list == null ? 0 :list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.fragment_category_grid,parent,false);
        TextView viewById = (TextView) convertView.findViewById(R.id.fragment_category_grid_btn);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.fragment_category_grid_iv);
        CategoryBean.DataBean.TagsBean tagsBean = list.get(position);
        if(tagsBean.isHot()){
            imageView.setImageResource(R.drawable.img_hot);
        }
        if(!tagsBean.isHasService()){
            viewById.setTextColor(ContextCompat.getColor(context,R.color.hasService));
        }
        viewById.setText(tagsBean.getName());
        return convertView;
    }

}

package com.daowei.www.daoweitwo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.module.home.bean.HomeServiceBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * Created by Administrator on 2017/2/22.
 */

public class HomeGridAdapter extends BaseAdapter {
    private Context context;
    private List<HomeServiceBean.DataBean> mlist;
    public HomeGridAdapter(Context context,List<HomeServiceBean.DataBean> list){
        this.context = context;
        this.mlist = list;
    }
    @Override
    public int getCount() {
        return null==mlist?0:mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        GridViewHolder viewHolder;
        if(null==view){
            view = LayoutInflater.from(context).inflate(R.layout.home_grid_item,parent,false);
            viewHolder = new GridViewHolder(view);
        }else {
            viewHolder = (GridViewHolder) view.getTag();
        }
        HomeServiceBean.DataBean dataBean = mlist.get(position);
        switch (dataBean.getId()){
            case "36":
                viewHolder.imageView.setBackground(context.getResources().getDrawable(R.drawable.blue_rectangle));
                break;
            case "21":
                viewHolder.imageView.setBackground(context.getResources().getDrawable(R.drawable.blue_rectangle));
                break;
            case "35":
                viewHolder.imageView.setBackground(context.getResources().getDrawable(R.drawable.blue_rectangle));
                break;
            case "120":
                viewHolder.imageView.setBackground(context.getResources().getDrawable(R.drawable.blue_rectangle));
                break;
            case "22":
                viewHolder.imageView.setBackground(context.getResources().getDrawable(R.drawable.yellow_rectangle));
                break;
            case "20":
                viewHolder.imageView.setBackground(context.getResources().getDrawable(R.drawable.red_rectangle));
                break;
            case "70":
                viewHolder.imageView.setBackground(context.getResources().getDrawable(R.drawable.red_rectangle));
                break;
            case "26":
                viewHolder.imageView.setBackground(context.getResources().getDrawable(R.drawable.green_rectangle));
                break;
            case "60":
                viewHolder.imageView.setBackground(context.getResources().getDrawable(R.drawable.green_rectangle));
                break;
            case "110":
                viewHolder.imageView.setBackground(context.getResources().getDrawable(R.drawable.pink_rectangle));
                break;
        }
        Picasso.with(context).load(dataBean.getIconUrl2()).into(viewHolder.imageView);
        viewHolder.textView.setText(dataBean.getName());
        return view;
    }
    class GridViewHolder{
        @BindView(R.id.service_image)
        ImageView imageView;
        @BindView(R.id.service_title)
        TextView textView;
         GridViewHolder(View view){
            view.setTag(this);
            ButterKnife.bind(this,view);
        }
    }
}

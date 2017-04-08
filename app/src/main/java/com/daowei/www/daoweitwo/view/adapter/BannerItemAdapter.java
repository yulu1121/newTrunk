package com.daowei.www.daoweitwo.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.module.home.bean.BannerItemBean;
import com.daowei.www.daoweitwo.view.home.ServiceActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * Created by  on 2017/2/27.
 */

public class BannerItemAdapter extends BaseAdapter {
    private Context context;
    private List<BannerItemBean.DataBean.PricesBean> mlist;
    private String id;
    public BannerItemAdapter(Context context,List<BannerItemBean.DataBean.PricesBean> mlist,String id){
        this.context = context;
        this.mlist = mlist;
        this.id = id;
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
        ViewHolder viewHolder;
        if(null==view){
            view = LayoutInflater.from(context).inflate(R.layout.fragment_home_banner_oneitem,parent,false);
            viewHolder = new ViewHolder(view);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final BannerItemBean.DataBean.PricesBean pricesBean = mlist.get(position);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ServiceActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("itemId",pricesBean.getId());
                Log.e("xxx",id);
                bundle.putString("serviceId",id);
                intent.putExtra("formation",bundle);
                context.startActivity(intent);
            }
        });
        viewHolder.title.setText(pricesBean.getName());
        viewHolder.price.setText(pricesBean.getPrice()+ pricesBean.getPrice_unit());
        viewHolder.amount.setText("已售"+ pricesBean.getSalesNum());
        viewHolder.time.setText(pricesBean.getDescription());
        Picasso.with(context).load(pricesBean.getPic_url()).into(viewHolder.imageView);
        return view;
    }
    class ViewHolder{
        @BindView(R.id.home_banner_item_image)
        ImageView imageView;
        @BindView(R.id.home_banner_item_title)
        TextView title;
        @BindView(R.id.home_banner_item_time)
        TextView time;
        @BindView(R.id.home_banner_item_price)
        TextView price;
        @BindView(R.id.home_banner_item_sale)
        TextView amount;
        public ViewHolder(View view){
            view.setTag(this);
            ButterKnife.bind(this,view);
        }
    }
}

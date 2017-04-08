package com.daowei.www.daoweitwo.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.module.home.bean.HomeFooterBean;
import com.daowei.www.daoweitwo.utils.DesityUtil;
import com.daowei.www.daoweitwo.utils.SharedPreferenceUtils;
import com.daowei.www.daoweitwo.view.home.HomeBannerActivityTwo;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * Created by yulu on 2017/2/23.
 */

public class HomeFooterAdapter extends BaseAdapter {
    private Context context;
    private List<HomeFooterBean.DataBean> mlist;
    public HomeFooterAdapter(Context context,List<HomeFooterBean.DataBean> list){
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
        View view  = convertView;
        ViewHolder viewHolder;
        if(null==view){
            view = LayoutInflater.from(context).inflate(R.layout.home_footer_item,parent,false);
            viewHolder = new ViewHolder(view);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        int width = SharedPreferenceUtils.getInt(context, "width");
        int px = DesityUtil.dip2px(context, width);
        RelativeLayout.LayoutParams ll = new RelativeLayout.LayoutParams(px/2, px/2);
        ll.setMargins(0,0,3,0);
        viewHolder.imageView.setLayoutParams(ll);
        final HomeFooterBean.DataBean dataBean = mlist.get(position);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeBannerActivityTwo.class);
                intent.putExtra("targeting",dataBean.getServiceId());
                context.startActivity(intent);
            }
        });
        Picasso.with(context).load(dataBean.getImgUrl()).into(viewHolder.imageView);
        viewHolder.title.setText(dataBean.getTitle());
        viewHolder.business.setText("已接"+dataBean.getOrderTakingCount()+"单");
        viewHolder.positive.setText("好评"+dataBean.getPositiveCommentRate());
        return view;
    }
    class ViewHolder{
        @BindView(R.id.home_footer_iv)
        ImageView imageView;
        @BindView(R.id.home_footer_title)
        TextView title;
        @BindView(R.id.home_footer_businnes)
        TextView business;
        @BindView(R.id.home_footer_positive)
        TextView positive;
        ViewHolder(View view){
            view.setTag(this);
            ButterKnife.bind(this,view);
        }
    }
}

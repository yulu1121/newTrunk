package com.daowei.www.daoweitwo.view.category.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.module.category.bean.CategoryBean;
import com.daowei.www.daoweitwo.view.category.CategoryFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class TitleAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    private Context context;
    private List<CategoryBean.DataBean> mTitleList;

    public TitleAdapter(Context context, List<CategoryBean.DataBean> mTitleList){
        this.context = context;
        this.mTitleList = mTitleList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mTitleList == null ? 0 : mTitleList.size();
    }

    @Override
    public Object getItem(int position) {
        return mTitleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(null == convertView){
            convertView = mInflater.inflate(R.layout.fragment_category_title_item, parent, false);
            holder = new ViewHolder(convertView);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        CategoryBean.DataBean dataBean =  mTitleList.get(position);
        holder.textView.setText(dataBean.getName());
        Picasso.with(context).load(dataBean.getIconUrl()).into(holder.imageView);
        holder.view.setBackgroundColor(Color.WHITE);
        if(CategoryFragment.POSITION == position){
            holder.view.setBackgroundColor(Color.RED);
        }
        return convertView;
    }
    class ViewHolder{
        @BindView(R.id.fragment_category_title_item_iv)
        ImageView imageView;
        @BindView(R.id.fragment_category_title_item_tv)
        TextView textView;
        @BindView(R.id.fragment_category_title_view)
        View view;
        public ViewHolder(View view){
            view.setTag(this);
            ButterKnife.bind(this,view);
        }
    }
}

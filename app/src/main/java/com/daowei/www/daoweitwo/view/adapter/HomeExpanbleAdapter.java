package com.daowei.www.daoweitwo.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.module.home.bean.HomeExpanbleBean;
import com.daowei.www.daoweitwo.utils.DesityUtil;
import com.daowei.www.daoweitwo.utils.SharedPreferenceUtils;
import com.daowei.www.daoweitwo.view.home.ServiceActivity;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * Created by Administrator on 2017/2/20.
 */

public class HomeExpanbleAdapter extends BaseExpandableListAdapter{
    private Map<String,List<HomeExpanbleBean.DataBean>> map;
    private Context context;
    public HomeExpanbleAdapter(Context context,Map<String,List<HomeExpanbleBean.DataBean>> map){
        this.context = context;
        this.map = map;
    }
    @Override
    public int getGroupCount() {
        return map.keySet().toArray().length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        Object[] objects = map.keySet().toArray();
         String key= (String) objects[groupPosition];
         return map.get(key).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder viewHolder;
        View view = convertView;
        if(null==view){
           view=LayoutInflater.from(context).inflate(R.layout.expanble_group_view,null);
            viewHolder = new GroupViewHolder(view);
        }else {
            viewHolder = (GroupViewHolder) view.getTag();
        }
        if(groupPosition==0||groupPosition==1){
            viewHolder.colorText.setBackgroundColor(Color.RED);
        }
        Object[] objects = map.keySet().toArray();
        String key= (String) objects[groupPosition];
        viewHolder.title.setText(key);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View  view =LayoutInflater.from(context).inflate(R.layout.frament_home_expanableitem,parent,false);
        LinearLayout linear = (LinearLayout) view.findViewById(R.id.home_expanbleliner);
        int width = SharedPreferenceUtils.getInt(context, "width");
        int px = DesityUtil.dip2px(context, width);
        LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(px/3, px/3);
        LinearLayout.LayoutParams llTwo = new LinearLayout.LayoutParams(px/3, ViewGroup.LayoutParams.WRAP_CONTENT);
        Object[] objects = map.keySet().toArray();
        String key = (String) objects[groupPosition];
        HomeExpanbleBean.DataBean dataBean = map.get(key).get(childPosition);
        for (int i = 0; i < dataBean.getItems().size(); i++) {
            final HomeExpanbleBean.DataBean.ItemsBean itemsBean = dataBean.getItems().get(i);
            View view1 = LayoutInflater.from(context).inflate(R.layout.fragment_home_linearitem, parent, false);
            view1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ServiceActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("itemId",itemsBean.getId());
                    bundle.putString("serviceId",itemsBean.getServiceId());
                    intent.putExtra("formation",bundle);
                    context.startActivity(intent);
                }
            });
            ImageView imageView= (ImageView) view1.findViewById(R.id.recycler_image);
            imageView.setLayoutParams(ll);
            TextView title= (TextView) view1.findViewById(R.id.recycler_title);
            TextView  price= (TextView) view1.findViewById(R.id.recycler_price);
            TextView category = (TextView) view1.findViewById(R.id.recycler_category);
            Picasso.with(context).load(itemsBean.getPic_url()).into(imageView);
            title.setText(itemsBean.getName());
            price.setText(itemsBean.getPrice()+itemsBean.getPrice_unit());
            category.setText(itemsBean.getServiceTitle());
            view1.setLayoutParams(llTwo);
            linear.addView(view1);
        }
        return view;
    }
    class GroupViewHolder{
        @BindView(R.id.category_name)
        TextView title;
        @BindView(R.id.color_txt)
        TextView colorText;
        public GroupViewHolder(View view){
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

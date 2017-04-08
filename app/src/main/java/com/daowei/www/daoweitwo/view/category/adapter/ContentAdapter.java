package com.daowei.www.daoweitwo.view.category.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.daowei.www.daoweitwo.CateDetailsActivity;
import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.module.category.bean.CategoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class ContentAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<CategoryBean.DataBean> mTitleList;
    private Context context;

    public ContentAdapter(Context context, List<CategoryBean.DataBean> mTitleList ){
        this.mTitleList = mTitleList;
        inflater = LayoutInflater.from(context);
        this.context = context;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(null == convertView){
            convertView = inflater.inflate(R.layout.fragment_category_content_item,parent,false);
            holder = new ViewHolder(convertView);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        final CategoryBean.DataBean dataBean = mTitleList.get(position);
        holder.textView.setText(dataBean.getName());
        final List<CategoryBean.DataBean.TagsBean> list = dataBean.getTags();
        holder.gridView.setAdapter(new GridAdapter(context,list));
        if(position != 0){
            holder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int itemPosition, long id) {
                    Intent intent = new Intent(context, CateDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("list", (Serializable) list);
                    bundle.putInt("position",itemPosition);
                    bundle.putString("name",dataBean.getName());
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                 }
          });
        }
        if(position == 0){
            holder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int itemPosition, long id) {
                    Log.e("111", "onItemClick: "+position+"---"+itemPosition );
                    CategoryBean.DataBean.TagsBean tagsBean = list.get(itemPosition);
                    String tagsBeanName = tagsBean.getName();
                    int size = mTitleList.size();
                    for (int i = 1; i <size ; i++) {
                        CategoryBean.DataBean bean = mTitleList.get(i);
                        List<CategoryBean.DataBean.TagsBean> tags = bean.getTags();
                        int length = tags.size();
                        for (int j = 0; j < length; j++) {
                            String name = tags.get(j).getName();
                            if(tagsBeanName.equals(name)){
                                Intent intent = new Intent(context, CateDetailsActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("list", (Serializable) tags);
                                bundle.putInt("position",j);
                                bundle.putString("name",bean.getName());
                                intent.putExtras(bundle);
                                context.startActivity(intent);
                            }
                        }
                    }
                }
            });
        }

        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.fragment_category_content_name)
        TextView textView;
        @BindView(R.id.fragment_category_content_gv)
        GridView gridView;
        public  ViewHolder(View view){
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }
}

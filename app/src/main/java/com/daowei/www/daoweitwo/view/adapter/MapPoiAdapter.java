package com.daowei.www.daoweitwo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baidu.mapapi.search.core.PoiInfo;
import com.daowei.www.daoweitwo.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 *
 * Created by Administrator on 2017/3/2.
 */

public class MapPoiAdapter extends BaseAdapter {
    private List<PoiInfo> mlist ;
    private Context context;
    public MapPoiAdapter(Context context,List<PoiInfo> list){
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
        View view =convertView;
        ViewHolder viewHolder;
        if(null==view){
            view= LayoutInflater.from(context).inflate(R.layout.map_item_layout,parent,false);
            viewHolder = new ViewHolder(view);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        PoiInfo poiInfo = mlist.get(position);
        viewHolder.local.setText(poiInfo.address);
        return view;
    }
    class ViewHolder{
        @BindView(R.id.local_address)
        TextView local;
        ViewHolder(View view){
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }
}

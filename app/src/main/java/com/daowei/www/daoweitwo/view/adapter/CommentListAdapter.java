package com.daowei.www.daoweitwo.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.module.home.bean.CommentBean;
import com.daowei.www.daoweitwo.view.selfview.MyRatingBar;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * Created by yulu on 2017/3/1.
 */

public class CommentListAdapter extends BaseAdapter {
    private Context context;
    private List<CommentBean.DataBean.CommentsBean> mlist;
    public CommentListAdapter(Context context, List<CommentBean.DataBean.CommentsBean> list){
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
        ViewHolder viewHolder;
        if(null==view){
            view = LayoutInflater.from(context).inflate(R.layout.coment_item_layout,parent,false);
            viewHolder = new ViewHolder(view);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        CommentBean.DataBean.CommentsBean bean = mlist.get(position);
        if(bean.getIconUrl()!=null){
            Picasso.with(context).load(bean.getIconUrl()).into(viewHolder.imageView);
        }else {
            Picasso.with(context).load("http://wx.qlogo.cn/mmopen/UsichrXlnR9JpwD20tYrZIPTmXGsSkKojaM3icibficjoRicstXgBa8YaibZzEIBnnibMOqcMWWWrYqJfJnKr4xrDaPDQ/0").into(viewHolder.imageView);
        }
        viewHolder.name.setText(bean.getNick());
        viewHolder.ratingBar.setStar(bean.getStar());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(new Date(bean.getCreatetime()));
        viewHolder.time.setText(s);
        viewHolder.formation.setText(bean.getComment());
        viewHolder.place.setText(bean.getCity()+"\t\t"+bean.getArea());
        if(null!=bean.getReplyComment()){
            String comment = "商家回复:"+bean.getReplyComment();
            SpannableString ss = new SpannableString(comment);
            ss.setSpan(new ForegroundColorSpan(Color.BLUE),0,4, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            viewHolder.company.setText(ss);
        }else {
            viewHolder.company.setVisibility(View.GONE);
        }
        return view;
    }
    class ViewHolder{
        @BindView(R.id.coment_item_image)
        ImageView imageView;
        @BindView(R.id.coment_item_name)
        TextView name;
        @BindView(R.id.coment_ratingBar)
        MyRatingBar ratingBar;
        @BindView(R.id.coment_time)
        TextView time;
        @BindView(R.id.coment_formation)
        TextView formation;
        @BindView(R.id.coment_item_place)
        TextView place;
        @BindView(R.id.company_comment)
        TextView company;
        ViewHolder(View view) {
            view.setTag(this);
            ButterKnife.bind(this,view);
        }
    }
}

package com.daowei.www.daoweitwo.view.category;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daowei.www.daoweitwo.CateDetailsActivity;
import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.module.category.bean.CategoryBean;
import com.daowei.www.daoweitwo.module.category.bean.ItemBean;
import com.daowei.www.daoweitwo.module.category.bean.SearchGridBean;
import com.daowei.www.daoweitwo.module.category.bean.SortBean;
import com.daowei.www.daoweitwo.module.category.bean.StoreAllBean;
import com.daowei.www.daoweitwo.presenter.category.ICategoryPresenter;
import com.daowei.www.daoweitwo.presenter.category.impl.CategoryPresenter;
import com.daowei.www.daoweitwo.view.home.HomeBannerActivityTwo;
import com.daowei.www.daoweitwo.view.home.ServiceActivity;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/22 0022.
 */

public class CommonFragment extends Fragment implements ICategoryPresenter.CatePresentCallBack {
    public static final String TAG = "tag";
    public static final String DATA_LIST = "list";
    private String sort_by = "recommend";
    public static final String POSITION = "position";
    private CategoryPresenter categoryPresenter;
    private Context context;
    //上下拉刷新的布局文件中高度应该写成match_parent,否则不显示数据
    @BindView(R.id.fragment_common_lv)
    PullToRefreshListView mListView;
    @BindView(R.id.fragment_common_rg)
    LinearLayout mRadiogrouop;
    @BindView(R.id.fragment_common_btn1)
    CheckBox mRadioBtn1;
    @BindView(R.id.fragment_common_btn2)
    CheckBox mRadioBtn2;
    @BindView(R.id.fragment_common_btn3)
    CheckBox mRadioBtn3;
    @BindView(R.id.fragment_common_btn4)
    CheckBox mRadioBtn4;
    @BindView(R.id.fragment_common_relative)
    RelativeLayout relativeLayout;
    private List<SortBean.DataBean> mRightGridList;
    private List<ItemBean> dataList = new ArrayList<>();
    GridView mSortGridView;
    TextView mReset;
    TextView mYes;
    private int size;
    private List<String> mSortList;
    private SortGridAdapter sortGridAdapter;
    private PopupWindow popupWindow;
    private RadioButton mCurrentBtn = null;
    private String string;

    private PullToRefreshGridView mRightGridView;
    private RightGridAdapter rightGridAdapter;
    private PopupWindow mRankWindow;
    private CategoryBean.DataBean.TagsBean tagsBean;
    private CommAdapter commAdapter;
    private CommAdapter mCommonAdapter;
    private Handler handler = new Handler();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public static CommonFragment newInstance(String tag, List<CategoryBean.DataBean.TagsBean> list, int position){
        Bundle bundle = new Bundle();
        Log.e("111", "newInstance: "+tag );
        CommonFragment commonFragment = new CommonFragment();
        bundle.putString(TAG,tag);
        bundle.putSerializable(DATA_LIST, (Serializable) list);
        bundle.putInt(POSITION,position);
        commonFragment.setArguments(bundle);
        return commonFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        size = 20;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        Bundle bundle = getArguments();
        List<CategoryBean.DataBean.TagsBean> dataList = (List<CategoryBean.DataBean.TagsBean>)bundle.getSerializable(DATA_LIST);
        string = bundle.getString(TAG);
        int position = bundle.getInt(POSITION);
        categoryPresenter = new CategoryPresenter();
        if("left".equals(string)){
            view = inflater.inflate(R.layout.fragment_common, container, false);
            ButterKnife.bind(this,view);
            sort();
            setCommAdapter();
            if(position > 0){
                tagsBean = dataList.get(position-1);
                if(!tagsBean.isHasService()){
                    setForNoService();
                }else {
                    categoryPresenter.querydetails(context,size, tagsBean.getCatId(), tagsBean.getName(), sort_by, this);
                    categoryPresenter.querySort(context, tagsBean.getCatId(), tagsBean.getName(), sort_by, this);
                    listenerForDetails(tagsBean);
                }
            }else if(position == 0){
                CategoryBean.DataBean.TagsBean tagsBean = dataList.get(1);
                categoryPresenter.queryAll(context,size,tagsBean.getCatId(),sort_by,this);
                listenerForAll(tagsBean);
            }
            listener();
        }else if("right".equals(string)){
            Log.e("111", "onCreateView: right" );
            view = inflater.inflate(R.layout.fragment_common_right, container, false);
            mRightGridList = new ArrayList<>();
            initViews(view);
            initData();
            if(position > 0){
                CategoryBean.DataBean.TagsBean tagsBean = dataList.get(position-1);
                if(!tagsBean.isHasService()){
                    setForNoService();
                }else{
                    categoryPresenter.querySort(context,tagsBean.getCatId(),tagsBean.getName(),sort_by,this);
                }
            }else if (position == 0){
                CategoryBean.DataBean.TagsBean tagsBean = dataList.get(1);
                categoryPresenter.queryStoreAll(context,size,tagsBean.getCatId(),sort_by,this);
            }
            listenerForRight();
        }
        return view;
    }

    private void listenerForRight() {
        mRightGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SortBean.DataBean dataBean = mRightGridList.get(position);
                CateDetailsActivity activity = (CateDetailsActivity) getActivity();
                Intent intent = new Intent(activity,HomeBannerActivityTwo.class);
                intent.putExtra("targeting",dataBean.getServiceId());
                startActivity(intent);
            }
        });
    }

    private void listenerForAll(final CategoryBean.DataBean.TagsBean tagsBean) {
        mListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                size+=10;
                categoryPresenter.queryAll(context,size,tagsBean.getCatId(),sort_by,CommonFragment.this);
                mCommonAdapter.notifyDataSetChanged();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mListView.onRefreshComplete();
                    }
                }, 1000);
            }
        });

    }

    private void listenerForDetails(final CategoryBean.DataBean.TagsBean tagsBean) {
        mListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                size+=10;
                categoryPresenter.querydetails(context,size, tagsBean.getCatId(), tagsBean.getName(), sort_by, CommonFragment.this);
                mCommonAdapter.notifyDataSetChanged();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mListView.onRefreshComplete();
                    }
                }, 1000);
            }
        });
    }


    private void setCommAdapter() {
        mCommonAdapter = new CommAdapter(dataList);
        mListView.setMode(PullToRefreshBase.Mode.BOTH);
        mListView.setAdapter(mCommonAdapter);
    }

    private void setForNoService(){
        View view1 = LayoutInflater.from(context).inflate(R.layout.fragment_common_default_background, null);
        RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rl.addRule(RelativeLayout.CENTER_IN_PARENT);
        view1.setLayoutParams(rl);
        relativeLayout.addView(view1);
    }

    private void initViews(View view) {
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int widthPixels = metrics.widthPixels;
        mRightGridView = (PullToRefreshGridView) view.findViewById(R.id.fragment_common_right);
        mRightGridView.setMode(PullToRefreshBase.Mode.BOTH);
        GridView gridView = mRightGridView.getRefreshableView();
        gridView.setColumnWidth((widthPixels-20)/2);
        gridView.setHorizontalSpacing(10);
        gridView.setVerticalSpacing(10);

    }

    private void initData() {
        rightGridAdapter = new RightGridAdapter();
        mRightGridView.setAdapter(rightGridAdapter);
    }

    private void listener() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemBean itemBean = dataList.get(position);
                CateDetailsActivity activity = (CateDetailsActivity) getActivity();
                Intent intent  = new Intent(activity,ServiceActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("itemId",itemBean.getId());
                bundle.putString("serviceId",itemBean.getServiceId());
                intent.putExtra("formation",bundle);
                startActivity(intent);
            }
        });
        mRadioBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mRadioBtn1.isChecked()){
                    popupWindow.showAsDropDown(mRadiogrouop);
                    mRadioBtn2.setChecked(false);
                    mRadioBtn3.setChecked(false);
                    mRadioBtn4.setChecked(false);
                }
                if(!mRadioBtn1.isChecked()&&!mRadioBtn2.isChecked()&&!mRadioBtn3.isChecked()){
                    popupWindow.dismiss();
                }
            }
        });
        mRadioBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mRadioBtn2.isChecked()){
                    popupWindow.showAsDropDown(mRadiogrouop);
                    mRadioBtn1.setChecked(false);
                    mRadioBtn3.setChecked(false);
                    mRadioBtn4.setChecked(false);
                }
                if(!mRadioBtn1.isChecked()&&!mRadioBtn2.isChecked()&&!mRadioBtn3.isChecked()){
                    popupWindow.dismiss();
                }
            }
        });
        mRadioBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mRadioBtn3.isChecked()){
                    popupWindow.showAsDropDown(mRadiogrouop);
                    mRadioBtn2.setChecked(false);
                    mRadioBtn1.setChecked(false);
                    mRadioBtn4.setChecked(false);
                }
                if(!mRadioBtn1.isChecked()&&!mRadioBtn2.isChecked()&&!mRadioBtn3.isChecked()){
                    popupWindow.dismiss();
                }
            }
        });
        mRadioBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mRadioBtn4.isChecked()){
                    mRankWindow.showAsDropDown(mRadiogrouop);
                    mRadioBtn2.setChecked(false);
                    mRadioBtn1.setChecked(false);
                    mRadioBtn3.setChecked(false);
                }else {
                    mRankWindow.dismiss();
                }
                if(!mRadioBtn1.isChecked()&&!mRadioBtn2.isChecked()&&!mRadioBtn3.isChecked()){
                    popupWindow.dismiss();
                }
            }
        });
    }

    private void sort() {
        mSortList = new ArrayList<>();
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_common_sort, null);
        mSortGridView = (GridView) view.findViewById(R.id.fragment_common_sort_gv);
        mReset = (TextView) view.findViewById(R.id.fragment_common_sort_reset);
        mYes = (TextView) view.findViewById(R.id.fragment_common_sort_yes);
        sortGridAdapter = new SortGridAdapter();
        mSortGridView.setAdapter(sortGridAdapter);
        popupWindow = new PopupWindow(context);
        Drawable drawable = ContextCompat.getDrawable(context, R.color.white);
        popupWindow.setBackgroundDrawable(drawable);
        popupWindow.setContentView(view);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setOutsideTouchable(true);
        ListView listView = new ListView(context);
        List<String> rankList = new ArrayList<>();
        rankList.add("推荐排序");
        rankList.add("销量高");
        rankList.add("好评多");
        rankList.add("上门快");
        rankList.add("价格低");
        listView.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,rankList));
        mRankWindow = new PopupWindow(context);
        mRankWindow.setBackgroundDrawable(drawable);
        mRankWindow.setContentView(listView);
        mRankWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        mRankWindow.setOutsideTouchable(true);
    }

    @Override
    public void getData(CategoryBean categoryBean) {

    }

    @Override
    public void getDetais(List<ItemBean> list) {
        dataList.clear();
        dataList.addAll(list);
        mCommonAdapter.notifyDataSetChanged();
    }

    @Override
    public void getAll(List<ItemBean> list) {
        dataList.clear();
        dataList.addAll(list);
        mCommonAdapter.notifyDataSetChanged();
    }

    @Override
    public void getSort(SortBean sortBean) {
        if("left".equals(string)){
            List<SortBean.DataBean> data = sortBean.getData();
            int size = data.size();
            for (int i = 0; i < size; i++) {
                SortBean.DataBean dataBean = data.get(i);
                mSortList.add(dataBean.getTitle());
            }
            sortGridAdapter.notifyDataSetChanged();
        }else if("right".equals(string)){
            mRightGridList.addAll(sortBean.getData());
            rightGridAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getStoreAll(StoreAllBean storeAllBean) {
        List<StoreAllBean.DataBean> data = storeAllBean.getData();
        int size = data.size();
        for (int i = 0; i < size; i++) {
            SortBean.DataBean dataBean = new SortBean.DataBean();
            StoreAllBean.DataBean storeBean = data.get(i);
            dataBean.setImgUrl(storeBean.getImgUrl());
            dataBean.setTitle(storeBean.getTitle());
            dataBean.setOrderTakingCount(storeBean.getOrderTakingCount());
            dataBean.setPositiveCommentRate(storeBean.getPositiveCommentRate());
            mRightGridList.add(dataBean);
        }
        rightGridAdapter.notifyDataSetChanged();
    }

    @Override
    public void getSearchGrid(SearchGridBean searchGridBean) {

    }

    @Override
    public void getSearchList(SearchGridBean searchGridBean) {

    }

    class RightGridAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mRightGridList == null ? 0 : mRightGridList.size();
        }

        @Override
        public Object getItem(int position) {
            return mRightGridList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView == null){
                convertView = LayoutInflater.from(context).inflate(R.layout.fragment_common_right_item,parent,false);
                holder = new ViewHolder(convertView);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            SortBean.DataBean dataBean = mRightGridList.get(position);
            Picasso.with(context).load(dataBean.getImgUrl()).into(holder.imageView);
            holder.titleTxt.setText(dataBean.getTitle());
            holder.orderTxt.setText("已接"+dataBean.getOrderTakingCount()+"单");
            holder.positiveTxt.setText("好评"+dataBean.getPositiveCommentRate());
            return convertView;
        }
        class ViewHolder{
            @BindView(R.id.fragment_common_right_iv)
            ImageView imageView;
            @BindView(R.id.fragment_common_right_title)
            TextView titleTxt;
            @BindView(R.id.fragment_common_right_order)
            TextView orderTxt;
            @BindView(R.id.fragment_common_right_positive)
            TextView positiveTxt;
            public ViewHolder(View view){
                ButterKnife.bind(this,view);
                view.setTag(this);
                DisplayMetrics metrics = new DisplayMetrics();
                getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
                int widthPixels = metrics.widthPixels;
                imageView.setMinimumHeight((widthPixels-20)/2);
            }

        }
    }

    class SortGridAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mSortList == null ? 0 : mSortList.size();
        }

        @Override
        public Object getItem(int position) {
            return mSortList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_common_sort_text,parent,false);
            TextView text = (TextView) convertView.findViewById(R.id.fragment_common_sort_tv);
            text.setText(mSortList.get(position));
            return convertView;
        }
    }

    class CommAdapter extends BaseAdapter{
        private List<ItemBean> list;
        public CommAdapter(List<ItemBean> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list == null ? 0 : list.size();
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
            ViewHolder holder = null;
            if(null == convertView){
                convertView = LayoutInflater.from(context).inflate(R.layout.fragment_common_item, parent, false);
                holder = new ViewHolder(convertView);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            ItemBean itemBean = list.get(position);
            holder.imageView.setImageResource(R.drawable.img_pic_default);
            Picasso.with(context).load(itemBean.getPic_url()).into(holder.imageView);
            holder.nameTxt.setText(itemBean.getName());
            holder.descriptionTxt.setText(itemBean.getDescription());
//            String price = String.valueOf(itemBean.getPrice());
//            SpannableString span = new SpannableString(price);
//            span.setSpan(new AbsoluteSizeSpan(50,true),0,price.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            holder.priceTxt.setText(itemBean.getPrice()+"");
            holder.priceUnit.setText(itemBean.getPrice_unit());
            holder.serviceTitleTxt.setText(itemBean.getServiceTitle());
            holder.positiveTxt.setText(itemBean.getPositiveCommentRate());
            holder.salesTxt.setText("已售"+itemBean.getSalesNum());
            holder.aheadHours.setText(itemBean.getAheadHours()+"小时");
            return convertView;
        }
        class ViewHolder{
            @BindView(R.id.fragment_common_item_iv)
            ImageView imageView;
            @BindView(R.id.fragment_common_item_name)
            TextView nameTxt;
            @BindView(R.id.fragment_common_item_description)
            TextView descriptionTxt;
            @BindView(R.id.fragment_common_item_price)
            TextView priceTxt;
            @BindView(R.id.fragment_common_item_price_unit)
            TextView priceUnit;
            @BindView(R.id.fragment_common_item_servicetitle)
            TextView serviceTitleTxt;
            @BindView(R.id.fragment_common_item_positive)
            TextView positiveTxt;
            @BindView(R.id.fragment_common_item_sales)
            TextView salesTxt;
            @BindView(R.id.fragment_common_item_hour)
            TextView aheadHours;

            public ViewHolder(View view){
                view.setTag(this);
                ButterKnife.bind(this,view);
            }
        }
    }
}

package com.daowei.www.daoweitwo.view.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.SearchActivity;
import com.daowei.www.daoweitwo.module.home.bean.HomeBannerBean;
import com.daowei.www.daoweitwo.module.home.bean.HomeExpanbleBean;
import com.daowei.www.daoweitwo.module.home.bean.HomeFooterBean;
import com.daowei.www.daoweitwo.module.home.bean.HomeRecommendBean;
import com.daowei.www.daoweitwo.module.home.bean.HomeServiceBean;
import com.daowei.www.daoweitwo.presenter.IBannerPresenter;
import com.daowei.www.daoweitwo.presenter.IFooterPresenter;
import com.daowei.www.daoweitwo.presenter.IHomePresenter;
import com.daowei.www.daoweitwo.presenter.IRecommendPresenter;
import com.daowei.www.daoweitwo.presenter.IServicePresenter;
import com.daowei.www.daoweitwo.presenter.home.impl.BannerPresenter;
import com.daowei.www.daoweitwo.presenter.home.impl.FooterPresenter;
import com.daowei.www.daoweitwo.presenter.home.impl.HomePresneter;
import com.daowei.www.daoweitwo.presenter.home.impl.RecommendPresenter;
import com.daowei.www.daoweitwo.presenter.home.impl.ServicePresenter;
import com.daowei.www.daoweitwo.utils.DesityUtil;
import com.daowei.www.daoweitwo.utils.SharedPreferenceUtils;
import com.daowei.www.daoweitwo.view.adapter.HomeExpanbleAdapter;
import com.daowei.www.daoweitwo.view.adapter.HomeFooterAdapter;
import com.daowei.www.daoweitwo.view.adapter.HomeGridAdapter;
import com.daowei.www.daoweitwo.view.category.MyGridView;
import com.daowei.www.daoweitwo.view.indent.TitleMsgActivity;
import com.daowei.www.daoweitwo.view.selfview.HomeGridView;
import com.daowei.www.daoweitwo.view.selfview.HomeRecelerView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *
 * Created by yulu on 2017/2/20 0020.
 */

public class HomeFragment extends Fragment implements IHomePresenter.SendHomeExpanbleData,IBannerPresenter.SendHomeBannerData,IServicePresenter.SendServiceData,IRecommendPresenter.SendRecommendData,IFooterPresenter.SendFooterBeanData{
    private Context context;
    private IHomePresenter presenter;
    private IBannerPresenter bannerPresenter;
    private IServicePresenter servicePresenter;
    private IRecommendPresenter recommendPresenter;
    private IFooterPresenter footerPresenter;
    private HomeExpanbleAdapter adapter;
    @BindView(R.id.street_text)
    TextView textView;
    @BindView(R.id.frg_search)
    RadioButton search;
    @BindView(R.id.message)
    RadioButton message;
    private String city;
    private RadioButton radioButton;
    private HomeRecelerView recyclerView;
    private HomeGridView homeGridView;
    private MyGridView homeFooterGridView;
    private HomeFooterAdapter homeFooterAdapter;
    private MyAdapter receclerAdapter;
    private HomeGridAdapter gridAdapter;
    private ConvenientBanner convenientBanner;
    private Boolean isFresh = true;//让下拉刷新只刷新一次
    private List<HomeRecommendBean.DataBean.RecommendBean> recommendList = new ArrayList<>();
    private List<HomeServiceBean.DataBean> serviceList = new ArrayList<>();
    private List<HomeBannerBean.DataBean> bannerList = new ArrayList<>();//存放广告的集合
    private List<HomeFooterBean.DataBean> footerList = new ArrayList<>();
    private Map<String,List<HomeExpanbleBean.DataBean>> dataBeanMap = new LinkedHashMap<>();
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        bannerPresenter = new BannerPresenter(context,this);
        presenter = new HomePresneter(context,this);
        servicePresenter = new ServicePresenter(context,this);
        recommendPresenter = new RecommendPresenter(context,this);
        footerPresenter = new FooterPresenter(context,this);
    }
    @BindView(R.id.home_expanblelistView)
    PullToRefreshExpandableListView expandableListView;
    public static HomeFragment newInstance(){
        return new HomeFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
        presenter.getHomeExpanbleData();
        bannerPresenter.getHomeBannerData();
        servicePresenter.getServiceData();
        recommendPresenter.getRecommendData();
        footerPresenter.getFooterBeanData();
        city=SharedPreferenceUtils.getString(context,"city");
        initView();
        initHeadView();
        initFooterView();
        initExpanbleList();
        return view;
    }

    private void initView() {
        String street = SharedPreferenceUtils.getString(context, "street");
        textView.setText(street);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MapActivity.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SearchActivity.class);
                startActivity(intent);
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TitleMsgActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 初始化头部视图
     */
    private void initHeadView(){
        final View view =  LayoutInflater.from(context).inflate(R.layout.home_header,null);
        HeaderViewHolder holder = new HeaderViewHolder(view);
        expandableListView.getRefreshableView().addHeaderView(view);
        convenientBanner = holder.banner;
        homeGridView = holder.gridView;
        radioButton = holder.recommond;
        recyclerView = holder.recycler;
    }

    /**
     * 初始化底部视图
     */
    private void  initFooterView(){
        final View view = LayoutInflater.from(context).inflate(R.layout.home_footer_layout,null);
        homeFooterGridView = (MyGridView) view.findViewById(R.id.home_footer_grid);
        expandableListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ExpandableListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ExpandableListView> refreshView) {
                    dataBeanMap.clear();
                    presenter.getHomeExpanbleData();
                    adapter.notifyDataSetChanged();
                    refreshView.onRefreshComplete();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ExpandableListView> refreshView) {
                if(isFresh){
                    isFresh = false;
                    homeFooterGridView.setAdapter(homeFooterAdapter);
                    refreshView.getRefreshableView().addFooterView(view);
                    expandableListView.onRefreshComplete();
                }else {
                    expandableListView.onRefreshComplete();
                }
            }
        });

    }
    @Override
    public void sendServiceData(HomeServiceBean bean) {
        List<HomeServiceBean.DataBean> data = bean.getData();
        for (int i = 0; i <10; i++) {
         serviceList.add(data.get(i));
        }
        gridAdapter = new HomeGridAdapter(context,serviceList);
        homeGridView.setAdapter(gridAdapter);
        gridAdapter.notifyDataSetChanged();
    }

    /**
     * 初始化头部视图的recyclerview
     */
    private void initRecyclerView(){
        LinearLayoutManager manager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(manager);
        receclerAdapter  = new MyAdapter();
        recyclerView.setAdapter(receclerAdapter);
    }

    /**
     * @param bean 获取底部view的实体类
     *             added by yulu 2017年2月23日 16:16:12
     */
       @Override
    public void sendFooterBeanData(HomeFooterBean bean) {
        footerList.addAll(bean.getData());
        homeFooterAdapter = new HomeFooterAdapter(context,footerList);
    }

    /**
     * 实现receclerview
     */
    class RececlerVH extends RecyclerView.ViewHolder implements View.OnClickListener{
        View view;
        ImageView backgroud;
        TextView title;
        TextView des;
        public RececlerVH(View itemView) {
            super(itemView);
            this.view = itemView;
            backgroud = (ImageView) itemView.findViewById(R.id.home_center_image);
            title = (TextView) itemView.findViewById(R.id.home_center_title);
            des = (TextView) itemView.findViewById(R.id.home_center_des);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {

        }
    }
    class MyAdapter extends RecyclerView.Adapter<RececlerVH>{

        @Override
        public RececlerVH onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);
            return new RececlerVH(view);
        }

        @Override
        public void onBindViewHolder(RececlerVH holder, final int position) {
            int width = SharedPreferenceUtils.getInt(context, "width");
            int px = DesityUtil.dip2px(context, width);
            LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(px/4-DesityUtil.dip2px(context,2f),DesityUtil.dip2px(context,120f));
            ll.setMargins(0,0,3,3);
            HomeRecommendBean.DataBean.RecommendBean bean = recommendList.get(position);
            Picasso.with(context).load(bean.getImg()).into(holder.backgroud);
            holder.title.setText(bean.getTitle());
            holder.des.setText(bean.getSubject());
            holder.view.setLayoutParams(ll);
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "v"+position, Toast.LENGTH_SHORT).show();
                }
            });
            switch (bean.getTitle()){
                case "热销":
                    holder.view.setBackgroundColor(getResources().getColor(R.color.hot));
                    break;
                case "新店":
                    holder.view.setBackgroundColor(getResources().getColor(R.color.newshop));
                    break;
                case "领券":
                    holder.view.setBackgroundColor(getResources().getColor(R.color.ticket));
                    break;
                case "充值":
                    holder.view.setBackgroundColor(getResources().getColor(R.color.charge));
                    break;
            }
        }

        @Override
        public int getItemCount() {
            return recommendList.size();
        }
    }
    @Override
    public void sendRecommendData(HomeRecommendBean bean) {
        int total_count = bean.getData().getRecommend_total_count();
        radioButton.setText("本地"+total_count+"个服务商");
        final List<HomeRecommendBean.DataBean.RecommendBean> recommendBeanList = bean.getData().getRecommend();
        Observable.from(recommendBeanList)
                .map(new Func1<HomeRecommendBean.DataBean.RecommendBean,HomeRecommendBean.DataBean.RecommendBean>() {
                    @Override
                    public HomeRecommendBean.DataBean.RecommendBean call(HomeRecommendBean.DataBean.RecommendBean recommendBean) {

                        return recommendBean;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HomeRecommendBean.DataBean.RecommendBean>() {
                    @Override
                    public void call(HomeRecommendBean.DataBean.RecommendBean recommendBean) {
                        recommendList.add(recommendBean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        initRecyclerView();
                        receclerAdapter.notifyDataSetChanged();
                    }
                });
    }

    class HeaderViewHolder{
        @BindView(R.id.home_banner)
        ConvenientBanner banner;
        @BindView(R.id.home_grid)
        HomeGridView gridView;
        @BindView(R.id.home_recommend_rb)
        RadioButton recommond;
        @BindView(R.id.home_head_recycler)
        HomeRecelerView recycler;
        HeaderViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
    private void setupBanner(ConvenientBanner convenientBanner){
        convenientBanner.setPages(new CBViewHolderCreator<HomeBannerCreater>() {
            @Override
            public HomeBannerCreater createHolder() {
                return new HomeBannerCreater();
            }
        },bannerList)
        .setPageIndicator(new int[]{R.drawable.dot_unselected,R.drawable.dot_selected})
        .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
        .setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String target = bannerList.get(position).getTarget();
                if(target.contains("http")){
                    Intent intent = new Intent(context,HomeBannerActivityOne.class);
                    intent.putExtra("target",target);
                    startActivity(intent);
                }else if(target.contains("app")){
                    if(target.contains("105097")){
                            Intent intent = new Intent(context,ServiceActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("itemId","105097");
                            bundle.putString("serviceId","ab65512d16b745f1b420c915cbd399f2");
                            intent.putExtra("formation",bundle);
                            startActivity(intent);
                    }else {
                    Toast.makeText(context, "详情", Toast.LENGTH_SHORT).show();}
                }else {
                    Intent intent = new Intent(context,HomeBannerActivityTwo.class);
                    intent.putExtra("targeting",target);
                    startActivity(intent);
                }
            }
        })
        ;

    }
    class HomeBannerCreater implements Holder<HomeBannerBean.DataBean>{
        private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, HomeBannerBean.DataBean data) {
            Picasso.with(context).load(data.getImgUrl()).into(imageView);
        }
    }
    /**
     * 初始化分组视图
     * added by yulu 2017年2月21日 14:05:19
     */
    private void initExpanbleList(){
        adapter = new HomeExpanbleAdapter(context,dataBeanMap);
        expandableListView.getRefreshableView().setAdapter(adapter);
        expandableListView.setMode(PullToRefreshBase.Mode.BOTH);
        expandableListView.getRefreshableView().setGroupIndicator(null);
        expandableListView.getRefreshableView().setDividerHeight(0);
    }

    /**
     * @param bean
     * 完成map和list的数据注入
     * added by yulu 2017年2月21日 14:05:04
     */
    @Override
    public void sendHomeExpanbleData(HomeExpanbleBean bean) {
        List<HomeExpanbleBean.DataBean> dataBeanList = bean.getData();
        Observable.from(dataBeanList)
                .flatMap(new Func1<HomeExpanbleBean.DataBean, Observable<HomeExpanbleBean.DataBean.ItemsBean>>() {
                    @Override
                    public Observable<HomeExpanbleBean.DataBean.ItemsBean> call(HomeExpanbleBean.DataBean dataBean) {
                        String categoryName = dataBean.getCategoryName();
                        if(!dataBeanMap.containsKey(categoryName)){
                            dataBeanMap.put(categoryName,new ArrayList<HomeExpanbleBean.DataBean>());
                        }
                        dataBeanMap.get(categoryName).add(dataBean);
                        return Observable.from(dataBean.getItems());
                    }
                })
                .map(new Func1<HomeExpanbleBean.DataBean.ItemsBean,HomeExpanbleBean.DataBean.ItemsBean>() {
                    @Override
                    public HomeExpanbleBean.DataBean.ItemsBean call(HomeExpanbleBean.DataBean.ItemsBean itemsBean) {
                        return itemsBean;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HomeExpanbleBean.DataBean.ItemsBean>() {
                    @Override
                    public void call(HomeExpanbleBean.DataBean.ItemsBean itemsBean) {

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        adapter.notifyDataSetChanged();
                        expandListView();
                    }
                })
                ;
    }
    /**
     * 使组无法收缩
     * added by yulu 2017年2月21日 14:02:06
     */
    private void expandListView() {
        Object[] objects = dataBeanMap.keySet().toArray();
        int size = objects.length ;
        for (int i = 0; i < size; i++) {
            ExpandableListView refreshableView = expandableListView.getRefreshableView();
            refreshableView.expandGroup(i);
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        //设置轮播时间
        convenientBanner.startTurning(3000);
    }

    @Override
    public void onStop() {
        super.onStop();
        //停止轮播
        convenientBanner.stopTurning();
    }
    @Override
    public void sendHomeBannerData(HomeBannerBean bean) {
        final List<HomeBannerBean.DataBean> data = bean.getData();
        Observable.from(data)
                .map(new Func1<HomeBannerBean.DataBean, HomeBannerBean.DataBean>() {
                    @Override
                    public HomeBannerBean.DataBean call(HomeBannerBean.DataBean dataBean) {
                        return dataBean;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HomeBannerBean.DataBean>() {
                    @Override
                    public void call(HomeBannerBean.DataBean dataBean) {
                        if( dataBean.getCity().contains(city)){
                          bannerList.add(dataBean);
                      }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        setupBanner(convenientBanner);
                    }
                });
    }

}

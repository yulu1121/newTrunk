package com.daowei.www.daoweitwo.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.module.home.bean.BannerItemBean;
import com.daowei.www.daoweitwo.module.home.bean.CommentBean;
import com.daowei.www.daoweitwo.presenter.IBannerItemPresenter;
import com.daowei.www.daoweitwo.presenter.ICommentPresenter;
import com.daowei.www.daoweitwo.presenter.home.impl.BannerItemPresenter;
import com.daowei.www.daoweitwo.presenter.home.impl.CommentPresenter;
import com.daowei.www.daoweitwo.utils.SharedPreferenceUtils;
import com.daowei.www.daoweitwo.view.adapter.BannerItemAdapter;
import com.daowei.www.daoweitwo.view.adapter.CommentListAdapter;
import com.daowei.www.daoweitwo.view.selfview.HomeListView;
import com.daowei.www.daoweitwo.view.selfview.MyViewPager;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
public class HomeBannerActivityTwo extends AppCompatActivity implements IBannerItemPresenter.SendBannerItemData,ICommentPresenter.SendCommentData{
    @BindView(R.id.home_formation_tab)
    TabLayout tabLayout;
    @BindView(R.id.home_banner_vp)
    MyViewPager viewPager;
    @BindView(R.id.home_banner_image)
    ImageView imgageView;
    @BindView(R.id.home_gureen_one)
    TextView textViewOne;
    @BindView(R.id.home_gureen_imageOne)
    ImageView imageViewOne;
    @BindView(R.id.home_gureen_two)
    TextView textViewTwo;
    @BindView(R.id.home_gureen_imageTwo)
    ImageView imageViewTwo;
    @BindView(R.id.home_gureen_three)
    TextView textViewThree;
    @BindView(R.id.home_gureen_imagethree)
    ImageView imageViewThree;
    @BindView(R.id.home_gureen_linear)
    LinearLayout gureenLinear;
    @BindView(R.id.banner_two_toolbar)
    Toolbar toolBar;
    @BindView(R.id.toolbar_title)
    TextView toolBarTxt;
    @BindView(R.id.banner_item_appBarLayout)
    AppBarLayout barLayout;
    HomeListView listView;
    private TextView company;
    private TextView information;
    private IBannerItemPresenter presenter;
    private List<String> mlist = new ArrayList<>();
    private TextView all;
    private TextView good;
    private TextView center;
    private TextView bad;
    private TextView pic;
    private int start = 0;
    private int size = 20;
    private List<View> viewList = new ArrayList<>();
    private String id;
    private PullToRefreshListView listViewing;
    private CommentListAdapter listAdapter;
    private List<CommentBean.DataBean.CommentsBean> commentList = new ArrayList<>();
    private BannerItemAdapter adapter;
    private ICommentPresenter commentPresenter;
    private List<BannerItemBean.DataBean.PricesBean> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String target=intent.getStringExtra("targeting");
        SharedPreferenceUtils.saveString(this,"target",target);
        setContentView(R.layout.activity_home_banner_two);
        presenter = new BannerItemPresenter(this,this,target);
        presenter.getBannerItemData();
        ButterKnife.bind(this);
        setTitle("");
        setSupportActionBar(toolBar);
        initTitles();
        initView();
    }

    private void initTitles(){
        mlist.add("服务项目");
        mlist.add("商家推荐");
        mlist.add("评价");
    }
    private void initViewList(){
        View viewOne = LayoutInflater.from(this).inflate(R.layout.fragment_home_banner_frg_one,null);
        View viewTwo = LayoutInflater.from(this).inflate(R.layout.fragment_home_banner_frg_two,null);
        View viewThree = LayoutInflater.from(this).inflate(R.layout.service_frgthree,null);
        listView = (HomeListView) viewOne.findViewById(R.id.home_banner_listview);
        company = (TextView) viewTwo.findViewById(R.id.home_banner_company);
        information = (TextView) viewTwo.findViewById(R.id.home_banner_information);
        all= (TextView) viewThree.findViewById(R.id.allcoment);
        good = (TextView) viewThree.findViewById(R.id.goodcoment);
        center = (TextView) viewThree.findViewById(R.id.centercoment);
        bad = (TextView) viewThree.findViewById(R.id.badcoment);
        pic = (TextView) viewThree.findViewById(R.id.piccoment);
        listViewing = (PullToRefreshListView) viewThree.findViewById(R.id.coment_list);
        listAdapter = new CommentListAdapter(this,commentList);
        listViewing.setAdapter(listAdapter);
        viewList.add(viewOne);
        viewList.add(viewTwo);
        viewList.add(viewThree);
        listViewing.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        listViewing.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                    refreshView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                start = size;
                size+=10;
                commentPresenter =new CommentPresenter(HomeBannerActivityTwo.this, new ICommentPresenter.SendCommentData() {
                    @Override
                    public void sendCommentData(CommentBean bean) {
                        commentList.addAll(bean.getData().getComments());
                        listAdapter.notifyDataSetChanged();
                    }
                },id,start,size);
                commentPresenter.getCommentData();
                listViewing.onRefreshComplete();
            }
        });
    }
    private void initView(){
        initViewList();
        viewPager.setAdapter(new MyPagerAdapter());
        tabLayout.setupWithViewPager(viewPager);
    }
    public void onClikFinish(View view) {
        finish();
    }

    @Override
    public void sendBannerItemData(BannerItemBean bean) {
        id=bean.getData().getId();
        commentPresenter = new CommentPresenter(this,this,id,start,size);
        commentPresenter.getCommentData();
        list.addAll(bean.getData().getPrices());
        adapter = new BannerItemAdapter(this,list,id);
        listView.setAdapter(adapter);
        company.setText(bean.getData().getCompanyName());
        information.setText(bean.getData().getDescription());
        List<BannerItemBean.DataBean.ImgsBean> imgs = bean.getData().getImgs();
        for (int i = 0; i < imgs.size() ; i++) {
            Picasso.with(this).load(imgs.get(i).getUrl()).into(imgageView);
        }
        String title = bean.getData().getTitle();
        toolBarTxt.setText(title);
        BannerItemBean.DataBean.GuaranteeBean guarantee = bean.getData().getGuarantee();
        if(null!=guarantee){
            List<BannerItemBean.DataBean.GuaranteeBean.ItemsBean> items = guarantee.getItems();
            textViewOne.setText(items.get(0).getLabel());
            Picasso.with(this).load(items.get(0).getIconUrl()).into(imageViewOne);
            textViewTwo.setText(items.get(1).getLabel());
            Picasso.with(this).load(items.get(1).getIconUrl()).into(imageViewTwo);
            textViewThree.setText(items.get(2).getLabel());
            Picasso.with(this).load(items.get(2).getIconUrl()).into(imageViewThree);}
        else {
            gureenLinear.setVisibility(View.GONE);
        }
    }

    @Override
    public void sendCommentData(CommentBean bean) {
        commentList.addAll(bean.getData().getComments());
        listAdapter.notifyDataSetChanged();
        good.setText(bean.getData().getGoodCount()+"\r\n"+"好评");
        bad.setText(bean.getData().getBadCount()+"\r\n"+"差评");
        all.setText(bean.getData().getTotalCount()+"\r\n"+"全部");
        center.setText(bean.getData().getAverageCount()+"\r\n"+"中评");
        pic.setText(bean.getData().getHasImgCount()+"\r\n"+"有图");
    }

    class MyPagerAdapter extends PagerAdapter{

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
        }

        @Override
        public int getCount() {
            return null==viewList?0:viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mlist.get(position);
        }
    }

}

package com.daowei.www.daoweitwo.view.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.module.home.bean.ServiceItemBean;
import com.daowei.www.daoweitwo.presenter.IServiceItemPresenter;
import com.daowei.www.daoweitwo.presenter.home.impl.ServiceItemPresenter;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 *
 * Created by yulu on 2017/2/28.
 */

public class ServiceFraOne extends Fragment implements IServiceItemPresenter.SendServiceItemData {
    private Context context;
    private IServiceItemPresenter presenter;
    public static final String TYPE_ID = "id";
    @BindView(R.id.service_item_image)
    ImageView backImage;
    @BindView(R.id.service_item_title)
    TextView title;
    @BindView(R.id.service_sale_amount)
    TextView sale;
    @BindView(R.id.service_price)
    TextView price;
    @BindView(R.id.service_time)
    TextView serviceTime;
    @BindView(R.id.service_today)
    TextView nextService;
    @BindView(R.id.service_formation)
    TextView serviceFormation;
    @BindView(R.id.service_company)
    TextView serviceCompany;
    @BindView(R.id.go_formation)
    TextView goForamtion;
    @BindView(R.id.service_notification)
    TextView notify;
    @BindView(R.id.service_positive_rate)
    TextView positvie;
    @BindView(R.id.scrolling)
    ScrollView scrollView;
    private OnButtonClick onButtonClick;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
    public static ServiceFraOne newInstance(String id){
        ServiceFraOne fraOne = new ServiceFraOne();
        Bundle bundle = new Bundle();
        bundle.putString(TYPE_ID,id);
        fraOne.setArguments(bundle);
        return fraOne;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        String id = bundle.getString(TYPE_ID);
        presenter = new ServiceItemPresenter(context,this,id);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.service_frgone, container, false);
        ButterKnife.bind(this,view);
        initView();
        presenter.getServiceItemData();
        return view;
    }

    private void initView() {
        goForamtion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onButtonClick!=null){
                    onButtonClick.onClick(goForamtion);
                }
            }
        });
    }

    @Override
    public void sendServiceItemData(ServiceItemBean bean) {
        ServiceItemBean.DataBean.SericePriceBean priceBean= bean.getData().getSericePrice();
        final ServiceItemBean.DataBean.ServiceBean service = bean.getData().getService();
        Picasso.with(context).load(priceBean.getOriginalPicUrl()).into(backImage);
        backImage.setTag(priceBean.getOriginalPicUrl());
        title.setText(priceBean.getName());
        sale.setText("已售"+priceBean.getSalesNum());
        price.setText(Html.fromHtml("<big>"+priceBean.getPrice()+"</big>"+priceBean.getPriceUnit()));
        serviceTime.setText("服务时间"+service.getStartTime()+"-"+service.getEndTime());
        long appointTime = service.getNextAppointTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm");
        String format = dateFormat.format(new Date(appointTime));
        SpannableString ss = new SpannableString(format);
        ss.setSpan(new ForegroundColorSpan(Color.RED),0,format.length(),SpannableString.SPAN_INCLUSIVE_INCLUSIVE);
        nextService.setText("最近可约"+ss);
        String title = "此服务由"+service.getTitle()+"提供";
        SpannableString spannableString = new SpannableString(title);
        spannableString.setSpan(new ForegroundColorSpan(Color.RED),4,title.length()-2,SpannableString.SPAN_INCLUSIVE_INCLUSIVE);
        serviceCompany.setText(spannableString);
        serviceCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,HomeBannerActivityTwo.class);
                intent.putExtra("targeting",service.getId());
                startActivity(intent);
            }
        });
        serviceFormation.setText(priceBean.getDescription());
        notify.setText(service.getOrderingNotice());
        positvie.setText("接单率"+priceBean.getOrderTakingRate()+"\t"+"好评率"+priceBean.getPositiveCommentRate());
    }
    public  void share() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
        oks.setTitle(title.getText().toString());
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText(serviceFormation.getText().toString());
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl(backImage.getTag().toString());
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("ShareSDK");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(context);
    }
    /**
     * 此接口回调是让viewpager能设置当前项目
     */
    public interface OnButtonClick{
         void onClick(View view);
    }
    public OnButtonClick getOnButtonClick() {
        return onButtonClick;
    }
    public void setOnButtonClick(OnButtonClick onButtonClick) {
        this.onButtonClick = onButtonClick;
    }
}

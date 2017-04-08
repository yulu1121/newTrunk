package com.daowei.www.daoweitwo.view.myself;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daowei.www.daoweitwo.MainActivity;
import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.view.indent.TitleMsgActivity;
import com.daowei.www.daoweitwo.view.myself.bottomactivity.LixiKefuActivity;
import com.daowei.www.daoweitwo.view.myself.bottomactivity.MoreActivity;
import com.daowei.www.daoweitwo.view.myself.bottomactivity.myincome.MyIncomeActivity;
import com.daowei.www.daoweitwo.view.myself.bottomactivity.SharePersonalActivity;
import com.daowei.www.daoweitwo.view.myself.bottomactivity.ShopActivity;
import com.daowei.www.daoweitwo.view.myself.bottomactivity.UsuallyAddressActivity;
import com.daowei.www.daoweitwo.view.myself.headactivity.LoginActivity;
import com.daowei.www.daoweitwo.view.myself.headactivity.PersonalInformationActivity;
import com.daowei.www.daoweitwo.view.myself.middleactivity.myfocus.MyFocusActivity;
import com.daowei.www.daoweitwo.view.myself.middleactivity.mywallet.MyWalletActivity;
import com.daowei.www.daoweitwo.view.myself.middleactivity.useablechit.UseableChitActivty;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class MyselfFragment extends Fragment {
    private MainActivity mainActivity;
    @BindView(R.id.img_owner_chat)
    ImageView chat;
    @BindView(R.id.img_me_icon_default)
    ImageView icon;
    @BindView(R.id.text_login)
    TextView login;
    @BindView(R.id.btn_arrow_right_gray)
    ImageView gray;
    @BindView(R.id.text_set)
    TextView set;
    @BindView(R.id.wallet_linear_layout)
    LinearLayout wallet;
    @BindView(R.id.chit_linear_layout)
    LinearLayout chit;
    @BindView(R.id.focus_linear_layout)
    LinearLayout focus;
    @BindView(R.id.my_income)
    RelativeLayout myIncome;
    @BindView(R.id.share)
    RelativeLayout share;
    @BindView(R.id.usually_address)
    RelativeLayout address;
    @BindView(R.id.lian_xi_ke_fu)
    RelativeLayout lianXiKeFu;
    @BindView(R.id.more)
    RelativeLayout more;
    @BindView(R.id.shop)
    RelativeLayout shop;

    public static MyselfFragment newInstance() {
        return new MyselfFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myself, container, false);
        ButterKnife.bind(this, view);
        mainActivity = (MainActivity) getActivity();
        listener();
        return view;
    }

    public void listener() {
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                startActivity(new Intent(mainActivity, TitleMsgActivity.class));
                mainActivity.overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

            }
        });

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, PersonalInformationActivity.class));
                mainActivity.overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, LoginActivity.class));
                mainActivity.overridePendingTransition(R.anim.zoomin, R.anim.zoomout);


            }
        });

        gray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, PersonalInformationActivity.class));
                mainActivity.overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, PersonalInformationActivity.class));
                mainActivity.overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

            }
        });
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, MyWalletActivity.class));
                mainActivity.overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
            }
        });
        chit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, UseableChitActivty.class));
                mainActivity.overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

            }
        });
        focus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, MyFocusActivity.class));
                mainActivity.overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

            }
        });
        myIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, MyIncomeActivity.class));
                mainActivity.overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, SharePersonalActivity.class));
                mainActivity.overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

            }
        });
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, UsuallyAddressActivity.class));
                mainActivity.overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

            }
        });
        lianXiKeFu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, LixiKefuActivity.class));
                mainActivity.overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

            }
        });
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, MoreActivity.class));
                mainActivity.overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, ShopActivity.class));
                mainActivity.overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

            }
        });

    }

}

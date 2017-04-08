package com.daowei.www.daoweitwo.view.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Button;

import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.module.home.bean.ServiceItemBean;
import com.daowei.www.daoweitwo.presenter.IServiceItemPresenter;
import com.daowei.www.daoweitwo.presenter.home.impl.ServiceItemPresenter;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * Created by yulu on 2017/2/28.
 */

public class ServiceFraTwo extends Fragment implements IServiceItemPresenter.SendServiceItemData{
    private Context context;
    public static final String ID_TYPE = "type_id";
    private IServiceItemPresenter presenter;
    @BindView(R.id.service_formation_image)
    LinearLayout linear;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
    public static ServiceFraTwo newInstance(String id){
        ServiceFraTwo fraTwo = new ServiceFraTwo();
        Bundle bundle = new Bundle();
        bundle.putString(ID_TYPE,id);
        fraTwo.setArguments(bundle);
        return fraTwo;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        String id = bundle.getString(ID_TYPE);
        presenter = new ServiceItemPresenter(context,this,id);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.service_frgtwo, container, false);
        presenter.getServiceItemData();
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void sendServiceItemData(ServiceItemBean bean) {
        List<ServiceItemBean.DataBean.ImgsBean> imgs = bean.getData().getImgs();
        LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        for (int i = 0; i <imgs.size(); i++) {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.with(context).load(imgs.get(i).getImg()).into(imageView);
            linear.addView(imageView,ll);
        }
        Button button = new Button(context);
        button.setText("~已经到底了~");
        button.setGravity(Gravity.CENTER);
        button.setBackground(null);
        linear.addView(button,ll);
    }
}

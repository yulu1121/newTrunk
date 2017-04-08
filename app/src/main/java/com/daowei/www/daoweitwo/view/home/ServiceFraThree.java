package com.daowei.www.daoweitwo.view.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.module.home.bean.CommentBean;
import com.daowei.www.daoweitwo.presenter.ICommentPresenter;
import com.daowei.www.daoweitwo.presenter.home.impl.CommentPresenter;
import com.daowei.www.daoweitwo.view.adapter.CommentListAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * Created by yulu on 2017/2/28.
 */

public class ServiceFraThree extends Fragment implements ICommentPresenter.SendCommentData{
    private Context context;
    private ICommentPresenter presenter;
    public static final String COMMENTS = "comment";
    @BindView(R.id.allcoment)
    TextView all;
    @BindView(R.id.goodcoment)
    TextView good;
    @BindView(R.id.centercoment)
    TextView center;
    @BindView(R.id.badcoment)
    TextView bad;
    @BindView(R.id.piccoment)
    TextView picComment;
    @BindView(R.id.coment_list)
    PullToRefreshListView listView;
    private int start = 0;
    private int size = 20;
    private CommentListAdapter adapter;
    private String id;
    private List<CommentBean.DataBean.CommentsBean> mlist = new ArrayList<>();
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
    public static ServiceFraThree newInstance(String commentID){
        ServiceFraThree fraThree = new ServiceFraThree();
        Bundle bundle = new Bundle();
        bundle.putString(COMMENTS,commentID);
        fraThree.setArguments(bundle);
        return fraThree;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        id = bundle.getString(COMMENTS);
        presenter =new CommentPresenter(context,this,id,start,size);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.service_frgthree, container, false);
        presenter.getCommentData();
        ButterKnife.bind(this,view);
        initView();
        return view;
    }

    private void initView() {
        adapter = new CommentListAdapter(context,mlist);
        listView.setAdapter(adapter);
        listView.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                    listView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                start = size;
                size+=10;
                presenter =new CommentPresenter(context, new ICommentPresenter.SendCommentData() {
                    @Override
                    public void sendCommentData(CommentBean bean) {
                        mlist.addAll(bean.getData().getComments());
                        adapter.notifyDataSetChanged();
                    }
                },id,start,size);
                presenter.getCommentData();
                listView.onRefreshComplete();
            }
        });
    }

    @Override
    public void sendCommentData(CommentBean bean) {
        mlist.addAll(bean.getData().getComments());
        adapter.notifyDataSetChanged();
        good.setText(bean.getData().getGoodCount()+"\r\n"+"好评");
        bad.setText(bean.getData().getBadCount()+"\r\n"+"差评");
        all.setText(bean.getData().getTotalCount()+"\r\n"+"全部");
        center.setText(bean.getData().getAverageCount()+"\r\n"+"中评");
        picComment.setText(bean.getData().getHasImgCount()+"\r\n"+"有图");
    }
}

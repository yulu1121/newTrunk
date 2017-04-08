package com.daowei.www.daoweitwo.presenter.home.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.module.home.ICommentModel;
import com.daowei.www.daoweitwo.module.home.bean.CommentBean;
import com.daowei.www.daoweitwo.module.home.impl.CommentModel;
import com.daowei.www.daoweitwo.presenter.ICommentPresenter;

/**
 *
 * Created by yulu on 2017/3/1.
 */

public class CommentPresenter implements ICommentPresenter,ICommentModel.SendCommentResult {
    private Context context;
    private ICommentModel model;
    private SendCommentData data;
    private String serviceID;
    private int start;
    private int size;
    public CommentPresenter(Context context,SendCommentData data,String serviceID,int start,int size){
        this.context = context;
        this.data = data;
        this.serviceID = serviceID;
        this.start = start;
        this.size = size;
        model = new CommentModel();
    }
    @Override
    public void getCommentData() {
        model.getCommentResult(context,this,serviceID,start,size);
    }

    @Override
    public void sendCommentResult(CommentBean bean) {
        data.sendCommentData(bean);
    }
}

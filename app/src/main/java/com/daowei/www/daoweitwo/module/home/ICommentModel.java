package com.daowei.www.daoweitwo.module.home;

import android.content.Context;

import com.daowei.www.daoweitwo.module.home.bean.CommentBean;

/**
 *
 * Created by yulu on 2017/3/1.
 */

public interface ICommentModel {
    void getCommentResult(Context context,SendCommentResult result,String serviceId,int start,int size);
    interface SendCommentResult{
        void sendCommentResult(CommentBean bean);
    }
}

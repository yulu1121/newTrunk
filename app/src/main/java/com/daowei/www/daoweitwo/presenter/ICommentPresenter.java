package com.daowei.www.daoweitwo.presenter;

import com.daowei.www.daoweitwo.module.home.bean.CommentBean;

/**
 *
 * Created by yulu on 2017/3/1.
 */

public interface ICommentPresenter {
    void getCommentData();
    interface SendCommentData{
        void sendCommentData(CommentBean bean);
    }
}

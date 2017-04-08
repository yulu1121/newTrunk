package com.daowei.www.daoweitwo.module.category.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class SearchGridBean {

    /**
     * status : ok
     * data : ["按摩","推拿","足疗","SPA","小时工","家庭保洁","开荒","保姆","家电维修","电脑维修","手机维修","空调维修","家修","安装","开锁","管道疏通","家电清洗","洗衣","洗鞋","擦玻璃","搬家","上门养车","月嫂","育儿嫂","化妆","美容","美甲","美睫","家教","护士上门","鲜花","蛋糕"]
     */

    private String status;
    private List<String> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}

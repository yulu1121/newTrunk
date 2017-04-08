package com.daowei.www.daoweitwo.module.home.bean;

import java.util.List;

/**
 *
 * Created by Administrator on 2017/2/22.
 */

public class HomeServiceBean {

    /**
     * status : ok
     * data : [{"id":"20","name":"家庭保洁","count":0,"iconUrl":"http://img.daoway.cn/img/icon/jiazheng3.png","iconUrl2":"http://img.daoway.cn/img/icon/new/jiazhen.png","order":20,"tags":["小时工","深度保洁","擦玻璃","开荒保洁","家电清洗","家居养护","洗衣洗鞋","空气净化","杀虫灭鼠"],"description":"小时工  擦玻璃 开荒"},{"id":"22","name":"上门按摩","count":0,"iconUrl":"http://img.daoway.cn/img/icon/anmo.png","iconUrl2":"http://img.daoway.cn/img/icon/new/anmo.png","order":21,"tags":["中医推拿","油压/SPA","局部理疗","足疗套餐","母婴保健"],"description":"推拿 足疗 SPA"},{"id":"36","name":"维修","count":0,"iconUrl":"http://img.daoway.cn/img/icon/weixiu3.png","iconUrl2":"http://img.daoway.cn/img/icon/new/weixiu.png","order":22,"tags":["手机维修","家电维修","家装家修","电脑维修","安装打孔","管道疏通","开锁换锁"],"description":"手机 家电 家修"},{"id":"21","name":"家电清洗","count":0,"iconUrl":"http://img.daoway.cn/img/icon/jiadian.png","iconUrl2":"http://img.daoway.cn/img/icon/new/jiadian_no_border.png","order":23,"tags":["油烟机清洗","洗衣机清洗","冰箱清洗","空调清洗","燃气灶清洗","热水器清洗","微波炉清洗","饮水机清洗"],"description":"全方位深度清洁"},{"id":"26","name":"衣物洗护","count":0,"iconUrl":"http://img.daoway.cn/img/icon/xiyi_border1219.png","iconUrl2":"http://img.daoway.cn/img/icon/xiyi_noorder1219.png","order":55,"tags":["洗衣","洗鞋/修鞋","家纺清洗","箱包洗护","定制改衣"],"description":"专业洗涤上门取送"},{"id":"35","name":"搬家","count":0,"iconUrl":"http://img.daoway.cn/img/icon/paotui3.png","iconUrl2":"http://img.daoway.cn/img/icon/new/peisong.png","order":75,"tags":["搬家租车","拆装搬运","搬家套餐"],"description":"货车搬家一站服务"},{"id":"110","name":"美容美妆","count":0,"iconUrl":"http://img.daoway.cn/img/icon/liren.png","iconUrl2":"http://img.daoway.cn/img/icon/new/meirong.png","order":77,"tags":["化妆","美容","美体塑形","美睫/美眉","美甲","上门美发"],"description":"化妆 美容 美体 美睫"},{"id":"70","name":"保姆月嫂","count":0,"iconUrl":"http://img.daoway.cn/img/icon/baomu.png","iconUrl2":"http://img.daoway.cn/img/icon/new/baomu_noborder.png","order":78,"tags":["月嫂","育儿嫂","家务保姆","老人陪护"],"description":"免支付预约更有保障"},{"id":"60","name":"养车用车","count":0,"iconUrl":"http://img.daoway.cn/img/icon/yangche.png","iconUrl2":"http://img.daoway.cn/img/icon/new/yangche_no_border.png","order":80,"tags":["上门养车","汽车陪练","上门洗车","验车","租车"],"description":"洗车 保养 维修"},{"id":"120","name":"上门医护","count":0,"iconUrl":"http://img.daoway.cn/img/icon/yihu_border.png","iconUrl2":"http://img.daoway.cn/img/icon/yihu_noborder2.png","order":83,"tags":["护士上门","挂号/陪诊","私人医生","康复陪护"],"description":"护士 挂号 陪诊 陪护"},{"id":"50","name":"鲜花蛋糕","count":0,"iconUrl":"http://img.daoway.cn/img/icon/xianhua.png","iconUrl2":"http://img.daoway.cn/img/icon/new/xianhua_no_border.png","order":85,"tags":["礼品用花","包月鲜花","蛋糕"],"description":"全城速递 新鲜送达"},{"id":"34","name":"更多","count":0,"iconUrl":"http://img.daoway.cn/img/icon/qita4.png","iconUrl2":"http://img.daoway.cn/img/icon/qita_no_border.png","order":300,"tags":["家教/私教","上门回收","送水","外卖","上门摄影","大厨上门","宠物服务","律师上门"],"description":"各种服务都能上门"}]
     */

    private String status;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 20
         * name : 家庭保洁
         * count : 0
         * iconUrl : http://img.daoway.cn/img/icon/jiazheng3.png
         * iconUrl2 : http://img.daoway.cn/img/icon/new/jiazhen.png
         * order : 20
         * tags : ["小时工","深度保洁","擦玻璃","开荒保洁","家电清洗","家居养护","洗衣洗鞋","空气净化","杀虫灭鼠"]
         * description : 小时工  擦玻璃 开荒
         */

        private String id;
        private String name;
        private int count;
        private String iconUrl;
        private String iconUrl2;
        private int order;
        private String description;
        private List<String> tags;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getIconUrl2() {
            return iconUrl2;
        }

        public void setIconUrl2(String iconUrl2) {
            this.iconUrl2 = iconUrl2;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }
    }
}

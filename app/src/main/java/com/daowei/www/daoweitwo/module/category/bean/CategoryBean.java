package com.daowei.www.daoweitwo.module.category.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/21 0021.
 */

public class CategoryBean implements Serializable{

    /**
     * status : ok
     * data : [{"id":"300","name":"热门","iconUrl":"http://img.daoway.cn/img/icon/hot.png","tags":[{"id":null,"catId":"20","name":"小时工","hot":false,"hasService":true},{"id":null,"catId":"22","name":"油压/SPA","hot":false,"hasService":true},{"id":null,"catId":"22","name":"中医推拿","hot":false,"hasService":true},{"id":null,"catId":"36","name":"手机维修","hot":false,"hasService":true},{"id":null,"catId":"35","name":"搬家租车","hot":false,"hasService":true},{"id":null,"catId":"20","name":"家电清洗","hot":false,"hasService":true}]},{"id":"20","name":"家庭保洁","iconUrl":"http://img.daoway.cn/img/icon/new/jiazhen.png","tags":[{"id":null,"catId":"20","name":"小时工","hot":true,"hasService":true},{"id":null,"catId":"20","name":"深度保洁","hot":false,"hasService":true},{"id":null,"catId":"20","name":"擦玻璃","hot":false,"hasService":true},{"id":null,"catId":"20","name":"开荒保洁","hot":false,"hasService":true},{"id":null,"catId":"20","name":"家电清洗","hot":true,"hasService":true},{"id":null,"catId":"20","name":"家居养护","hot":false,"hasService":true},{"id":null,"catId":"20","name":"洗衣洗鞋","hot":false,"hasService":true},{"id":null,"catId":"20","name":"空气净化","hot":false,"hasService":true},{"id":null,"catId":"20","name":"杀虫灭鼠","hot":false,"hasService":false}]},{"id":"22","name":"上门按摩","iconUrl":"http://img.daoway.cn/img/icon/new/anmo.png","tags":[{"id":null,"catId":"22","name":"中医推拿","hot":true,"hasService":true},{"id":null,"catId":"22","name":"油压/SPA","hot":true,"hasService":true},{"id":null,"catId":"22","name":"局部理疗","hot":false,"hasService":true},{"id":null,"catId":"22","name":"足疗套餐","hot":false,"hasService":false},{"id":null,"catId":"22","name":"母婴保健","hot":false,"hasService":true}]},{"id":"36","name":"维修","iconUrl":"http://img.daoway.cn/img/icon/new/weixiu.png","tags":[{"id":null,"catId":"36","name":"手机维修","hot":true,"hasService":true},{"id":null,"catId":"36","name":"家电维修","hot":false,"hasService":true},{"id":null,"catId":"36","name":"家装家修","hot":false,"hasService":true},{"id":null,"catId":"36","name":"电脑维修","hot":false,"hasService":true},{"id":null,"catId":"36","name":"安装打孔","hot":false,"hasService":true},{"id":null,"catId":"36","name":"管道疏通","hot":false,"hasService":true},{"id":null,"catId":"36","name":"开锁换锁","hot":false,"hasService":true}]},{"id":"21","name":"家电清洗","iconUrl":"http://img.daoway.cn/img/icon/new/jiadian_no_border.png","tags":[{"id":null,"catId":"21","name":"油烟机清洗","hot":false,"hasService":true},{"id":null,"catId":"21","name":"洗衣机清洗","hot":false,"hasService":true},{"id":null,"catId":"21","name":"冰箱清洗","hot":false,"hasService":true},{"id":null,"catId":"21","name":"空调清洗","hot":false,"hasService":true},{"id":null,"catId":"21","name":"燃气灶清洗","hot":false,"hasService":true},{"id":null,"catId":"21","name":"热水器清洗","hot":false,"hasService":true},{"id":null,"catId":"21","name":"微波炉清洗","hot":false,"hasService":true},{"id":null,"catId":"21","name":"饮水机清洗","hot":false,"hasService":true}]},{"id":"26","name":"衣物洗护","iconUrl":"http://img.daoway.cn/img/icon/xiyi_noorder1219.png","tags":[{"id":null,"catId":"26","name":"洗衣","hot":false,"hasService":true},{"id":null,"catId":"26","name":"洗鞋/修鞋","hot":false,"hasService":true},{"id":null,"catId":"26","name":"家纺清洗","hot":false,"hasService":true},{"id":null,"catId":"26","name":"箱包洗护","hot":false,"hasService":true},{"id":null,"catId":"26","name":"定制改衣","hot":false,"hasService":false}]},{"id":"35","name":"搬家","iconUrl":"http://img.daoway.cn/img/icon/new/peisong.png","tags":[{"id":null,"catId":"35","name":"搬家租车","hot":true,"hasService":true},{"id":null,"catId":"35","name":"拆装搬运","hot":false,"hasService":true},{"id":null,"catId":"35","name":"搬家套餐","hot":false,"hasService":false}]},{"id":"110","name":"美容美妆","iconUrl":"http://img.daoway.cn/img/icon/new/meirong.png","tags":[{"id":null,"catId":"110","name":"化妆","hot":false,"hasService":true},{"id":null,"catId":"110","name":"美容","hot":false,"hasService":true},{"id":null,"catId":"110","name":"美体塑形","hot":false,"hasService":false},{"id":null,"catId":"110","name":"美睫/美眉","hot":false,"hasService":true},{"id":null,"catId":"110","name":"美甲","hot":false,"hasService":false},{"id":null,"catId":"110","name":"上门美发","hot":false,"hasService":false}]},{"id":"70","name":"保姆月嫂","iconUrl":"http://img.daoway.cn/img/icon/new/baomu_noborder.png","tags":[{"id":null,"catId":"70","name":"月嫂","hot":false,"hasService":true},{"id":null,"catId":"70","name":"育儿嫂","hot":false,"hasService":true},{"id":null,"catId":"70","name":"家务保姆","hot":false,"hasService":true},{"id":null,"catId":"70","name":"老人陪护","hot":false,"hasService":true}]},{"id":"60","name":"养车用车","iconUrl":"http://img.daoway.cn/img/icon/new/yangche_no_border.png","tags":[{"id":null,"catId":"60","name":"上门养车","hot":false,"hasService":true},{"id":null,"catId":"60","name":"汽车陪练","hot":false,"hasService":false},{"id":null,"catId":"60","name":"上门洗车","hot":false,"hasService":false},{"id":null,"catId":"60","name":"验车","hot":false,"hasService":false},{"id":null,"catId":"60","name":"租车","hot":false,"hasService":false}]},{"id":"120","name":"上门医护","iconUrl":"http://img.daoway.cn/img/icon/yihu_noborder2.png","tags":[{"id":null,"catId":"120","name":"护士上门","hot":false,"hasService":true},{"id":null,"catId":"120","name":"挂号/陪诊","hot":false,"hasService":true},{"id":null,"catId":"120","name":"私人医生","hot":false,"hasService":false},{"id":null,"catId":"120","name":"康复陪护","hot":false,"hasService":false}]},{"id":"50","name":"鲜花蛋糕","iconUrl":"http://img.daoway.cn/img/icon/new/xianhua_no_border.png","tags":[{"id":null,"catId":"50","name":"礼品用花","hot":false,"hasService":true},{"id":null,"catId":"50","name":"包月鲜花","hot":false,"hasService":true},{"id":null,"catId":"50","name":"蛋糕","hot":false,"hasService":true}]},{"id":"34","name":"更多","iconUrl":"http://img.daoway.cn/img/icon/qita_no_border.png","tags":[{"id":null,"catId":"34","name":"家教/私教","hot":false,"hasService":false},{"id":null,"catId":"34","name":"上门回收","hot":false,"hasService":true},{"id":null,"catId":"34","name":"送水","hot":false,"hasService":false},{"id":null,"catId":"34","name":"外卖","hot":false,"hasService":false},{"id":null,"catId":"34","name":"上门摄影","hot":false,"hasService":false},{"id":null,"catId":"34","name":"大厨上门","hot":false,"hasService":false},{"id":null,"catId":"34","name":"宠物服务","hot":false,"hasService":false},{"id":null,"catId":"34","name":"律师上门","hot":false,"hasService":true}]}]
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

    public static class DataBean implements Serializable{
        /**
         * id : 300
         * name : 热门
         * iconUrl : http://img.daoway.cn/img/icon/hot.png
         * tags : [{"id":null,"catId":"20","name":"小时工","hot":false,"hasService":true},{"id":null,"catId":"22","name":"油压/SPA","hot":false,"hasService":true},{"id":null,"catId":"22","name":"中医推拿","hot":false,"hasService":true},{"id":null,"catId":"36","name":"手机维修","hot":false,"hasService":true},{"id":null,"catId":"35","name":"搬家租车","hot":false,"hasService":true},{"id":null,"catId":"20","name":"家电清洗","hot":false,"hasService":true}]
         */

        private String id;
        private String name;
        private String iconUrl;
        private List<TagsBean> tags;

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

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class TagsBean implements Serializable{
            /**
             * id : null
             * catId : 20
             * name : 小时工
             * hot : false
             * hasService : true
             */

            private Object id;
            private String catId;
            private String name;
            private boolean hot;
            private boolean hasService;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public String getCatId() {
                return catId;
            }

            public void setCatId(String catId) {
                this.catId = catId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public boolean isHot() {
                return hot;
            }

            public void setHot(boolean hot) {
                this.hot = hot;
            }

            public boolean isHasService() {
                return hasService;
            }

            public void setHasService(boolean hasService) {
                this.hasService = hasService;
            }
        }
    }
}

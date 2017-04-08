package com.daowei.www.daoweitwo.module.category.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/27 0027.
 */

public class SortBean {

    /**
     * status : ok
     * data : [{"serviceId":"e2ec99bf24734220b96586b852c262ac","title":"爱心到家","description":"全身推拿","star":5,"completeOrderNum":84,"modifytime":1488195839000,"state":1,"h5url":null,"h5enable":0,"inTimeScope":true,"inDistanceScope":false,"categoryId":"22","categoryName":"上门按摩","catIconUrl":"http://img.daoway.cn/img/icon/anmo.png","priceId":"2436566","price":88,"priceUnit":"/项","priceName":"全身推拿","width":320,"height":320,"imgUrl":"http://img.daoway.cn/img/2016/10/03/a2d9090f-d5df-4c73-ac96-6babd8227734_thumb.jpg","userId":"f34cc4aa1a254c99913fddfac42ce1b6","nick":"爱心到家客服","location":{"lot":null,"lat":null,"detailAddress":"武汉","province":null,"city":null,"district":null,"areaByIp":null,"displayAddress":"武汉"},"distance":-1,"showDistance":false,"score":4.681324E-10,"booster":{"star":1,"orderNum":1,"modifyTime":1,"distance":1.0E-10,"relevance":1,"level":0.2,"coverArea":1,"finalBooster":4.681324E-10,"timeScope":1,"sex":1,"tag":1,"yesterdaySale":0,"monthSale":2.041224,"takeRate":0.02,"commentRate":1.0E-4,"repeatRate":0.42,"docId":658},"ext":null,"tagIcons":[],"orderTakingRate":"100%","positiveCommentRate":"100%","orderTakingCount":83,"repeatPurchaseRate":"21%","promotion":null}]
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
         * serviceId : e2ec99bf24734220b96586b852c262ac
         * title : 爱心到家
         * description : 全身推拿
         * star : 5.0
         * completeOrderNum : 84
         * modifytime : 1488195839000
         * state : 1
         * h5url : null
         * h5enable : 0
         * inTimeScope : true
         * inDistanceScope : false
         * categoryId : 22
         * categoryName : 上门按摩
         * catIconUrl : http://img.daoway.cn/img/icon/anmo.png
         * priceId : 2436566
         * price : 88.0
         * priceUnit : /项
         * priceName : 全身推拿
         * width : 320
         * height : 320
         * imgUrl : http://img.daoway.cn/img/2016/10/03/a2d9090f-d5df-4c73-ac96-6babd8227734_thumb.jpg
         * userId : f34cc4aa1a254c99913fddfac42ce1b6
         * nick : 爱心到家客服
         * location : {"lot":null,"lat":null,"detailAddress":"武汉","province":null,"city":null,"district":null,"areaByIp":null,"displayAddress":"武汉"}
         * distance : -1
         * showDistance : false
         * score : 4.681324E-10
         * booster : {"star":1,"orderNum":1,"modifyTime":1,"distance":1.0E-10,"relevance":1,"level":0.2,"coverArea":1,"finalBooster":4.681324E-10,"timeScope":1,"sex":1,"tag":1,"yesterdaySale":0,"monthSale":2.041224,"takeRate":0.02,"commentRate":1.0E-4,"repeatRate":0.42,"docId":658}
         * ext : null
         * tagIcons : []
         * orderTakingRate : 100%
         * positiveCommentRate : 100%
         * orderTakingCount : 83
         * repeatPurchaseRate : 21%
         * promotion : null
         */

        private String serviceId;
        private String title;
        private String description;
        private double star;
        private int completeOrderNum;
        private long modifytime;
        private int state;
        private Object h5url;
        private int h5enable;
        private boolean inTimeScope;
        private boolean inDistanceScope;
        private String categoryId;
        private String categoryName;
        private String catIconUrl;
        private String priceId;
        private double price;
        private String priceUnit;
        private String priceName;
        private int width;
        private int height;
        private String imgUrl;
        private String userId;
        private String nick;
        private LocationBean location;
        private int distance;
        private boolean showDistance;
        private double score;
        private BoosterBean booster;
        private Object ext;
        private String orderTakingRate;
        private String positiveCommentRate;
        private int orderTakingCount;
        private String repeatPurchaseRate;
        private Object promotion;
        private List<?> tagIcons;

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getStar() {
            return star;
        }

        public void setStar(double star) {
            this.star = star;
        }

        public int getCompleteOrderNum() {
            return completeOrderNum;
        }

        public void setCompleteOrderNum(int completeOrderNum) {
            this.completeOrderNum = completeOrderNum;
        }

        public long getModifytime() {
            return modifytime;
        }

        public void setModifytime(long modifytime) {
            this.modifytime = modifytime;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public Object getH5url() {
            return h5url;
        }

        public void setH5url(Object h5url) {
            this.h5url = h5url;
        }

        public int getH5enable() {
            return h5enable;
        }

        public void setH5enable(int h5enable) {
            this.h5enable = h5enable;
        }

        public boolean isInTimeScope() {
            return inTimeScope;
        }

        public void setInTimeScope(boolean inTimeScope) {
            this.inTimeScope = inTimeScope;
        }

        public boolean isInDistanceScope() {
            return inDistanceScope;
        }

        public void setInDistanceScope(boolean inDistanceScope) {
            this.inDistanceScope = inDistanceScope;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCatIconUrl() {
            return catIconUrl;
        }

        public void setCatIconUrl(String catIconUrl) {
            this.catIconUrl = catIconUrl;
        }

        public String getPriceId() {
            return priceId;
        }

        public void setPriceId(String priceId) {
            this.priceId = priceId;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getPriceUnit() {
            return priceUnit;
        }

        public void setPriceUnit(String priceUnit) {
            this.priceUnit = priceUnit;
        }

        public String getPriceName() {
            return priceName;
        }

        public void setPriceName(String priceName) {
            this.priceName = priceName;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public boolean isShowDistance() {
            return showDistance;
        }

        public void setShowDistance(boolean showDistance) {
            this.showDistance = showDistance;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public BoosterBean getBooster() {
            return booster;
        }

        public void setBooster(BoosterBean booster) {
            this.booster = booster;
        }

        public Object getExt() {
            return ext;
        }

        public void setExt(Object ext) {
            this.ext = ext;
        }

        public String getOrderTakingRate() {
            return orderTakingRate;
        }

        public void setOrderTakingRate(String orderTakingRate) {
            this.orderTakingRate = orderTakingRate;
        }

        public String getPositiveCommentRate() {
            return positiveCommentRate;
        }

        public void setPositiveCommentRate(String positiveCommentRate) {
            this.positiveCommentRate = positiveCommentRate;
        }

        public int getOrderTakingCount() {
            return orderTakingCount;
        }

        public void setOrderTakingCount(int orderTakingCount) {
            this.orderTakingCount = orderTakingCount;
        }

        public String getRepeatPurchaseRate() {
            return repeatPurchaseRate;
        }

        public void setRepeatPurchaseRate(String repeatPurchaseRate) {
            this.repeatPurchaseRate = repeatPurchaseRate;
        }

        public Object getPromotion() {
            return promotion;
        }

        public void setPromotion(Object promotion) {
            this.promotion = promotion;
        }

        public List<?> getTagIcons() {
            return tagIcons;
        }

        public void setTagIcons(List<?> tagIcons) {
            this.tagIcons = tagIcons;
        }

        public static class LocationBean {
            /**
             * lot : null
             * lat : null
             * detailAddress : 武汉
             * province : null
             * city : null
             * district : null
             * areaByIp : null
             * displayAddress : 武汉
             */

            private Object lot;
            private Object lat;
            private String detailAddress;
            private Object province;
            private Object city;
            private Object district;
            private Object areaByIp;
            private String displayAddress;

            public Object getLot() {
                return lot;
            }

            public void setLot(Object lot) {
                this.lot = lot;
            }

            public Object getLat() {
                return lat;
            }

            public void setLat(Object lat) {
                this.lat = lat;
            }

            public String getDetailAddress() {
                return detailAddress;
            }

            public void setDetailAddress(String detailAddress) {
                this.detailAddress = detailAddress;
            }

            public Object getProvince() {
                return province;
            }

            public void setProvince(Object province) {
                this.province = province;
            }

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
            }

            public Object getDistrict() {
                return district;
            }

            public void setDistrict(Object district) {
                this.district = district;
            }

            public Object getAreaByIp() {
                return areaByIp;
            }

            public void setAreaByIp(Object areaByIp) {
                this.areaByIp = areaByIp;
            }

            public String getDisplayAddress() {
                return displayAddress;
            }

            public void setDisplayAddress(String displayAddress) {
                this.displayAddress = displayAddress;
            }
        }

        public static class BoosterBean {
            /**
             * star : 1.0
             * orderNum : 1.0
             * modifyTime : 1.0
             * distance : 1.0E-10
             * relevance : 1.0
             * level : 0.2
             * coverArea : 1.0
             * finalBooster : 4.681324E-10
             * timeScope : 1.0
             * sex : 1.0
             * tag : 1.0
             * yesterdaySale : 0.0
             * monthSale : 2.041224
             * takeRate : 0.02
             * commentRate : 1.0E-4
             * repeatRate : 0.42
             * docId : 658
             */

            private double star;
            private double orderNum;
            private double modifyTime;
            private double distance;
            private double relevance;
            private double level;
            private double coverArea;
            private double finalBooster;
            private double timeScope;
            private double sex;
            private double tag;
            private double yesterdaySale;
            private double monthSale;
            private double takeRate;
            private double commentRate;
            private double repeatRate;
            private int docId;

            public double getStar() {
                return star;
            }

            public void setStar(double star) {
                this.star = star;
            }

            public double getOrderNum() {
                return orderNum;
            }

            public void setOrderNum(double orderNum) {
                this.orderNum = orderNum;
            }

            public double getModifyTime() {
                return modifyTime;
            }

            public void setModifyTime(double modifyTime) {
                this.modifyTime = modifyTime;
            }

            public double getDistance() {
                return distance;
            }

            public void setDistance(double distance) {
                this.distance = distance;
            }

            public double getRelevance() {
                return relevance;
            }

            public void setRelevance(double relevance) {
                this.relevance = relevance;
            }

            public double getLevel() {
                return level;
            }

            public void setLevel(double level) {
                this.level = level;
            }

            public double getCoverArea() {
                return coverArea;
            }

            public void setCoverArea(double coverArea) {
                this.coverArea = coverArea;
            }

            public double getFinalBooster() {
                return finalBooster;
            }

            public void setFinalBooster(double finalBooster) {
                this.finalBooster = finalBooster;
            }

            public double getTimeScope() {
                return timeScope;
            }

            public void setTimeScope(double timeScope) {
                this.timeScope = timeScope;
            }

            public double getSex() {
                return sex;
            }

            public void setSex(double sex) {
                this.sex = sex;
            }

            public double getTag() {
                return tag;
            }

            public void setTag(double tag) {
                this.tag = tag;
            }

            public double getYesterdaySale() {
                return yesterdaySale;
            }

            public void setYesterdaySale(double yesterdaySale) {
                this.yesterdaySale = yesterdaySale;
            }

            public double getMonthSale() {
                return monthSale;
            }

            public void setMonthSale(double monthSale) {
                this.monthSale = monthSale;
            }

            public double getTakeRate() {
                return takeRate;
            }

            public void setTakeRate(double takeRate) {
                this.takeRate = takeRate;
            }

            public double getCommentRate() {
                return commentRate;
            }

            public void setCommentRate(double commentRate) {
                this.commentRate = commentRate;
            }

            public double getRepeatRate() {
                return repeatRate;
            }

            public void setRepeatRate(double repeatRate) {
                this.repeatRate = repeatRate;
            }

            public int getDocId() {
                return docId;
            }

            public void setDocId(int docId) {
                this.docId = docId;
            }
        }
    }
}

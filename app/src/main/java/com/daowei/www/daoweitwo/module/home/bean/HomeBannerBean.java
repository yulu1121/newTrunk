package com.daowei.www.daoweitwo.module.home.bean;

import java.util.List;

/**
 *
 * Created by Administrator on 2017/2/22.
 */

public class HomeBannerBean {

    /**
     * status : ok
     * gold_banners : []
     * data : [{"imgUrl":"http://img.daoway.cn/img/banners/2016/05/23/d0a6b043-8f43-4d35-9d14-42e5d32c61fd.jpg","target":"app://category/openSuper/99","type":"webpage","platform":"all","areaInclude":"0","city":"北京,上海,广州,深圳,","sharePicUrl":"","shareTitile":"无","shareContent":"无","version":"","serviceId":"","isChaoshi":1,"h5Url":"","start":null,"end":null,"goldBanner":0,"channel":"daoway"},{"imgUrl":"http://img.daoway.cn/img/banners/2017/02/17/3001d6b6-82fb-4b83-90fe-c1c1fc9fc5de.jpg","target":"dab8bd7932194f07ba754b116f196bbd","type":"service","platform":"all","areaInclude":"1","city":"北京 上海 深圳 杭州 南京 广州 成都 郑州 天津 重庆 东莞 武汉","sharePicUrl":"","shareTitile":"无","shareContent":"无","version":"","serviceId":"","isChaoshi":0,"h5Url":"","start":1487347200000,"end":1487951999000,"goldBanner":0,"channel":"daoway,nuomi"},{"imgUrl":"http://img.daoway.cn/img/banners/2017/02/16/f9713611-85cd-40c8-83f6-1370086be0f0.jpg","target":"app://detail/openSuper/105097?type=service","type":"webpage","platform":"all","areaInclude":"1","city":"北京 上海 广州 郑州 济南 西安 成都 南京 苏州 长沙 合肥 福州 重庆 厦门 青岛 南昌 石家庄 无锡 沈阳 徐州 温州 佛山 南通 深圳 武汉 宁波 杭州 天津","sharePicUrl":"","shareTitile":"无","shareContent":"无","version":"","serviceId":"","isChaoshi":0,"h5Url":"","start":1487209454000,"end":1488211199000,"goldBanner":0,"channel":"daoway,nuomi"},{"imgUrl":"http://img.daoway.cn/img/banners/2017/02/20/8d2ae7d2-da10-414b-9ac5-377df3af1158.jpg","target":"e2ec99bf24734220b96586b852c262ac","type":"service","platform":"all","areaInclude":"1","city":"上海,深圳,武汉,","sharePicUrl":"","shareTitile":"无","shareContent":"无","version":"","serviceId":"","isChaoshi":0,"h5Url":"","start":1487606399000,"end":1488211199000,"goldBanner":0,"channel":"daoway"},{"imgUrl":"http://img.daoway.cn/img/banners/2017/02/15/dc6a308f-6c2e-4205-a3c8-1994c4d9ee3b.jpg","target":"72a82db2d6054afda2698c6bf57b75ec","type":"service","platform":"all","areaInclude":"0","city":"北京,","sharePicUrl":"","shareTitile":"无","shareContent":"无","version":"","serviceId":"","isChaoshi":0,"h5Url":"","start":null,"end":null,"goldBanner":0,"channel":"daoway,nuomi"},{"imgUrl":"http://img.daoway.cn/img/banners/2016/11/03/ca053544-a2c9-45eb-a35f-4703b8c0008a.jpg","target":"app://me/openCoupon","type":"webpage","platform":"all","areaInclude":"0","city":"北京,上海,广州,深圳,","sharePicUrl":"","shareTitile":"无","shareContent":"无","version":"","serviceId":"0c816da55f6e4d34830e7800a88c8795","isChaoshi":1,"h5Url":"","start":null,"end":null,"goldBanner":0,"channel":"daoway"},{"imgUrl":"http://img.daoway.cn/img/banners/2016/11/03/b580dec5-4a8e-49ad-84f9-afb094c5262f.jpg","target":"app://category/openSuper/99","type":"webpage","platform":"all","areaInclude":"1","city":"","sharePicUrl":"","shareTitile":"无","shareContent":"无","version":"","serviceId":"0c816da55f6e4d34830e7800a88c8795","isChaoshi":1,"h5Url":"","start":null,"end":null,"goldBanner":0,"channel":null},{"imgUrl":"http://img.daoway.cn/img/banners/2016/11/03/c4112ff0-20f1-4fd9-a1a0-68c55d47989f.jpg","target":"app://category/openSuper/99","type":"service","platform":"all","areaInclude":"1","city":"","sharePicUrl":"","shareTitile":"无","shareContent":"无","version":"","serviceId":"0c816da55f6e4d34830e7800a88c8795","isChaoshi":1,"h5Url":"","start":null,"end":null,"goldBanner":0,"channel":"daoway"},{"imgUrl":"http://img.daoway.cn/img/banners/2016/03/25/f02a332a-b572-44ce-9d85-f2d66f775ca0.jpg","target":"6aef46ed7b1746ba8efad67f383c8686","type":"service","platform":"all","areaInclude":"0","city":"北京,上海,广州,","sharePicUrl":"","shareTitile":"无","shareContent":"无","version":"","serviceId":"100d0603145848118f865afc3b57d4ec","isChaoshi":1,"h5Url":"","start":null,"end":null,"goldBanner":0,"channel":null}]
     */

    private String status;
    private List<?> gold_banners;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<?> getGold_banners() {
        return gold_banners;
    }

    public void setGold_banners(List<?> gold_banners) {
        this.gold_banners = gold_banners;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * imgUrl : http://img.daoway.cn/img/banners/2016/05/23/d0a6b043-8f43-4d35-9d14-42e5d32c61fd.jpg
         * target : app://category/openSuper/99
         * type : webpage
         * platform : all
         * areaInclude : 0
         * city : 北京,上海,广州,深圳,
         * sharePicUrl :
         * shareTitile : 无
         * shareContent : 无
         * version :
         * serviceId :
         * isChaoshi : 1
         * h5Url :
         * start : null
         * end : null
         * goldBanner : 0
         * channel : daoway
         */

        private String imgUrl;
        private String target;
        private String type;
        private String platform;
        private String areaInclude;
        private String city;
        private String sharePicUrl;
        private String shareTitile;
        private String shareContent;
        private String version;
        private String serviceId;
        private int isChaoshi;
        private String h5Url;
        private Object start;
        private Object end;
        private int goldBanner;
        private String channel;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getAreaInclude() {
            return areaInclude;
        }

        public void setAreaInclude(String areaInclude) {
            this.areaInclude = areaInclude;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getSharePicUrl() {
            return sharePicUrl;
        }

        public void setSharePicUrl(String sharePicUrl) {
            this.sharePicUrl = sharePicUrl;
        }

        public String getShareTitile() {
            return shareTitile;
        }

        public void setShareTitile(String shareTitile) {
            this.shareTitile = shareTitile;
        }

        public String getShareContent() {
            return shareContent;
        }

        public void setShareContent(String shareContent) {
            this.shareContent = shareContent;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }

        public int getIsChaoshi() {
            return isChaoshi;
        }

        public void setIsChaoshi(int isChaoshi) {
            this.isChaoshi = isChaoshi;
        }

        public String getH5Url() {
            return h5Url;
        }

        public void setH5Url(String h5Url) {
            this.h5Url = h5Url;
        }

        public Object getStart() {
            return start;
        }

        public void setStart(Object start) {
            this.start = start;
        }

        public Object getEnd() {
            return end;
        }

        public void setEnd(Object end) {
            this.end = end;
        }

        public int getGoldBanner() {
            return goldBanner;
        }

        public void setGoldBanner(int goldBanner) {
            this.goldBanner = goldBanner;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }
    }
}

package com.daowei.www.daoweitwo.module.category.bean;

/**
 * Created by hezijie on 2017/2/23 0023.
 */

public class ItemBean {
    /*
    * {
                "id":"2384557",
                "serviceId":"ab65512d16b745f1b420c915cbd399f2",
                "serviceTitle":"来人到家",
                "salesNum":36,
                "name":"厨房保养一套",
                "description":"服务内容： 厨房保养，工人携带专业工具上门服务。 服务保障...",
                "pic_url":"http://img.daoway.cn/img/2016/06/23/e141c4a6-577e-4c0f-82d3-6bbb1443b62c_thumb.jpg",
                "price":450,
                "price_unit":"元/套",
                "tags":"深度保洁",
                "originalPrice":650,
                "minBuyNum":"1",
                "tagIcons":[

                ],
                "positiveCommentRate":"85%",
                "orderTakingRate":"98%",
                "orderTakingCount":0,
                "repeatPurchaseRate":"28%",
                "inDistanceScope":true,
                "isCanChooseTechnician":0,
                "promotion":{
                    "total_reduce":[
                        {
                            "total":500,
                            "reduce":50
                        }
                    ],
                    "first_reduce":null,
                    "first_total":0
                },
                "aheadHours":4,
                "showFatestDay":false,
                "fastestDay":null,
                "notice":null,
                "booster":Object{...},
                "recommend":false
            }
    * */
    private int aheadHours;

    public int getAheadHours() {
        return aheadHours;
    }

    public void setAheadHours(int aheadHours) {
        this.aheadHours = aheadHours;
    }

    private String id;
    private String serviceId;
    private String serviceTitle;
    private int salesNum;
    private String name;
    private String description;
    private String pic_url;
    private int price;
    private String price_unit;
    private String tags;
    private int originalPrice;
    private int minBuyNum;
    private String positiveCommentRate;
    private String orderTakingRate;
    private boolean isCanChooseTechnician;
    private boolean inDistanceScope;
    private int total;
    private int reduce;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemBean itemBean = (ItemBean) o;

        if (salesNum != itemBean.salesNum) return false;
        if (price != itemBean.price) return false;
        if (originalPrice != itemBean.originalPrice) return false;
        if (minBuyNum != itemBean.minBuyNum) return false;
        if (isCanChooseTechnician != itemBean.isCanChooseTechnician) return false;
        if (inDistanceScope != itemBean.inDistanceScope) return false;
        if (total != itemBean.total) return false;
        if (reduce != itemBean.reduce) return false;
        if (id != null ? !id.equals(itemBean.id) : itemBean.id != null) return false;
        if (serviceId != null ? !serviceId.equals(itemBean.serviceId) : itemBean.serviceId != null)
            return false;
        if (serviceTitle != null ? !serviceTitle.equals(itemBean.serviceTitle) : itemBean.serviceTitle != null)
            return false;
        if (name != null ? !name.equals(itemBean.name) : itemBean.name != null) return false;
        if (description != null ? !description.equals(itemBean.description) : itemBean.description != null)
            return false;
        if (pic_url != null ? !pic_url.equals(itemBean.pic_url) : itemBean.pic_url != null)
            return false;
        if (price_unit != null ? !price_unit.equals(itemBean.price_unit) : itemBean.price_unit != null)
            return false;
        if (tags != null ? !tags.equals(itemBean.tags) : itemBean.tags != null) return false;
        if (positiveCommentRate != null ? !positiveCommentRate.equals(itemBean.positiveCommentRate) : itemBean.positiveCommentRate != null)
            return false;
        return orderTakingRate != null ? orderTakingRate.equals(itemBean.orderTakingRate) : itemBean.orderTakingRate == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (serviceId != null ? serviceId.hashCode() : 0);
        result = 31 * result + (serviceTitle != null ? serviceTitle.hashCode() : 0);
        result = 31 * result + salesNum;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (pic_url != null ? pic_url.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (price_unit != null ? price_unit.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + originalPrice;
        result = 31 * result + minBuyNum;
        result = 31 * result + (positiveCommentRate != null ? positiveCommentRate.hashCode() : 0);
        result = 31 * result + (orderTakingRate != null ? orderTakingRate.hashCode() : 0);
        result = 31 * result + (isCanChooseTechnician ? 1 : 0);
        result = 31 * result + (inDistanceScope ? 1 : 0);
        result = 31 * result + total;
        result = 31 * result + reduce;
        return result;
    }

    @Override

    public String toString() {
        return "ItemBean{" +
                "id='" + id + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", serviceTitle='" + serviceTitle + '\'' +
                ", salesNum=" + salesNum +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", price=" + price +
                ", price_unit='" + price_unit + '\'' +
                ", tags='" + tags + '\'' +
                ", originalPrice=" + originalPrice +
                ", minBuyNum=" + minBuyNum +
                ", positiveCommentRate='" + positiveCommentRate + '\'' +
                ", orderTakingRate='" + orderTakingRate + '\'' +
                ", isCanChooseTechnician=" + isCanChooseTechnician +
                ", inDistanceScope=" + inDistanceScope +
                ", total=" + total +
                ", reduce=" + reduce +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getReduce() {
        return reduce;
    }

    public void setReduce(int reduce) {
        this.reduce = reduce;
    }

    public void setInDistanceScope(boolean inDistanceScope) {
        this.inDistanceScope = inDistanceScope;
    }

    public boolean isInDistanceScope() {

        return inDistanceScope;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public void setSalesNum(int salesNum) {
        this.salesNum = salesNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPrice_unit(String price_unit) {
        this.price_unit = price_unit;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public void setMinBuyNum(int minBuyNum) {
        this.minBuyNum = minBuyNum;
    }

    public void setPositiveCommentRate(String positiveCommentRate) {
        this.positiveCommentRate = positiveCommentRate;
    }

    public void setOrderTakingRate(String orderTakingRate) {
        this.orderTakingRate = orderTakingRate;
    }

    public void setCanChooseTechnician(boolean canChooseTechnician) {
        isCanChooseTechnician = canChooseTechnician;
    }

    public String getId() {

        return id;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public int getSalesNum() {
        return salesNum;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPic_url() {
        return pic_url;
    }

    public int getPrice() {
        return price;
    }

    public String getPrice_unit() {
        return price_unit;
    }

    public String getTags() {
        return tags;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public int getMinBuyNum() {
        return minBuyNum;
    }

    public String getPositiveCommentRate() {
        return positiveCommentRate;
    }

    public String getOrderTakingRate() {
        return orderTakingRate;
    }

    public boolean isCanChooseTechnician() {
        return isCanChooseTechnician;
    }
}

package com.daowei.www.daoweitwo.module.home.bean;

import java.util.List;

/**
 *
 * Created by yulu on 2017/3/1.
 */

public class CommentBean {

    /**
     * status : ok
     * data : {"goodCount":42,"totalCount":42,"averageCount":0,"badCount":0,"hasImgCount":0,"comments":[{"iconUrl":null,"nick":"LoveMina","star":5,"comment":"技师很好，很满意","createtime":1488291003000,"hasOrder":true,"id":"c4e9a5eb224143fa96a1b3eec095169e","replyComment":null,"replyTime":null,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"罗湖区","name":null,"firstPriceName":"全身推拿","myComment":false},{"iconUrl":"http://wx.qlogo.cn/mmopen/UsichrXlnR9JpwD20tYrZIPTmXGsSkKojaM3icibficjoRicstXgBa8YaibZzEIBnnibMOqcMWWWrYqJfJnKr4xrDaPDQ/0","nick":"大鹏14","star":5,"comment":"好","createtime":1488281198000,"hasOrder":true,"id":"a85ac78521984c79940f4db8b87d37ad","replyComment":null,"replyTime":null,"imgPath":null,"imgThumbPath":null,"city":"武汉","area":"武昌区","name":null,"firstPriceName":"全身推拿","myComment":false},{"iconUrl":"http://wx.qlogo.cn/mmopen/UsichrXlnR9L4W0hHUKCJYub4m50HaS0BVAT9ufzicSadW1ZZrIM9GehDiar4lb5OXAfE7GlSUuOG9zXYTeOtRamZG1JECWKgzp/0","nick":"程明","star":5,"comment":"按的很舒服，很到位","createtime":1488195839000,"hasOrder":true,"id":"1cbb89a9f7d64f64863a56398a368c8d","replyComment":null,"replyTime":null,"imgPath":null,"imgThumbPath":null,"city":"武汉","area":"江汉区","name":null,"firstPriceName":"精油推背","myComment":false},{"iconUrl":"http://q.qlogo.cn/qqapp/1103839060/D77FB8E878B4512100CB279219AC5B51/100","nick":"花开无声2","star":5,"comment":"这个技师很专业，人又漂亮，谢谢","createtime":1487843263000,"hasOrder":true,"id":"4a6af8f254f84c43bcc9b985ef13f13b","replyComment":null,"replyTime":null,"imgPath":null,"imgThumbPath":null,"city":"上海","area":"浦东新区","name":null,"firstPriceName":"全身推拿","myComment":false},{"iconUrl":null,"nick":"user441558","star":5,"comment":"不错\n","createtime":1487565106000,"hasOrder":true,"id":"e5fa78db5f3d496a8e6ab0f7e3848731","replyComment":" 亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，感谢你对老师高评价，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487684370000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"盐田区","name":null,"firstPriceName":"全身推拿","myComment":false},{"iconUrl":"http://wx.qlogo.cn/mmopen/oqjmvaMlmycJOmAVL7prn3kRtq9kpVpAONyDtLWhnDmg9eJvickoggF2VKjXYWwNbuoqq6joEQvxpjfzZ0aR1XVpW1nyHnKu6/0","nick":"林雨涵","star":5,"comment":"一点也不舒服，这哪是spa，简直就是安排个中医的人来做，一开始还以为主要胸和腹部，肩颈都得不到放松舒缓，胸部还给我刮痧，根本不是spa按摩师，不懂spa是舒缓的嘛，差评，越按越累！","createtime":1487483536000,"hasOrder":true,"id":"cd1774ce0c6a4798b3d554ce7737881d","replyComment":" 亲，感谢你的用心评价，感谢你使用到位生活平台，我们加紧跟进后期服务，尽最大努力满足客户需求。爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487684569000,"imgPath":null,"imgThumbPath":null,"city":"上海","area":"普陀","name":null,"firstPriceName":"同性芳香SPA","myComment":false},{"iconUrl":"http://wx.qlogo.cn/mmopen/Q5xPxqRgZicXwI4Pg9xiaicZXPD5Z5zuvAuIaWyh4icFZTsMLGWIVLGy9HH1hy2pbWeVO0jgzCZomdJJr28t2yEDmw/0","nick":"wendy","star":5,"comment":"超级细心的美女技师，很能把准需求，技术超级好，推荐哦","createtime":1487388679000,"hasOrder":true,"id":"73f8586f8409463b98a23b9cc71241c5","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，感谢你对老师高评价，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487388994000,"imgPath":null,"imgThumbPath":null,"city":"上海","area":"闵行区","name":null,"firstPriceName":"深度经络调理","myComment":false},{"iconUrl":"http://wx.qlogo.cn/mmopen/Q5xPxqRgZicXHJFFA0cvdyUBSZ0tAAk7NQTFxMsxrDzMzDWCEBfDEwjXajibicsxN7DHhyplNa8A3EyGG7oMmPv0HjznYJMiaKIl/0","nick":"《~》","star":5,"comment":"经络手法很棒，专业，整个过程下来，使人轻松很多，及时到家","createtime":1487152047000,"hasOrder":true,"id":"33c7973668a647db9bffda581854dedd","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487263960000,"imgPath":null,"imgThumbPath":null,"city":"上海","area":"嘉定区","name":null,"firstPriceName":"深度经络调理","myComment":false},{"iconUrl":null,"nick":"iceyeye","star":5,"comment":"非常好 非常舒服 老师非常专业","createtime":1486561285000,"hasOrder":true,"id":"115ba01c8256452b885506dcb1918835","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487263976000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"宝安区","name":null,"firstPriceName":"精油推背","myComment":false},{"iconUrl":null,"nick":"猥琐男","star":5,"comment":"不错不错，服务到位\u2026\u2026","createtime":1485847750000,"hasOrder":true,"id":"828a5aba4e944ebdaf3668fb6ef27890","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487263987000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"福田区","name":null,"firstPriceName":"精油推背","myComment":false},{"iconUrl":"http://wx.qlogo.cn/mmopen/GtS5XXtiaCDYvWfQIAXjFFlomPELS2Anewe4zUvqm6Mjtc1L16iaibCAksr6vu3PtQUcDLibLylR2MrGR4dzrfGZraVdibVaDFydz/0","nick":"庚午夫","star":5,"comment":"师傅按的很不错，可以继续点~","createtime":1485071302000,"hasOrder":true,"id":"986dfd41255e4c41aff8b72c22041a0d","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487264006000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"宝安区","name":null,"firstPriceName":"同性芳香SPA","myComment":false},{"iconUrl":null,"nick":"stephyC","star":5,"comment":"按压之后舒服了很多，很好","createtime":1485004966000,"hasOrder":true,"id":"07d5b2d7e0f24712a161ab42c82b8497","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487263999000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"宝安区","name":null,"firstPriceName":"深度经络调理","myComment":false},{"iconUrl":null,"nick":"user353029","star":5,"comment":"韦技师按摩的确实很好！赞！","createtime":1484558879000,"hasOrder":true,"id":"24ab59c4c5c446a087e2e696a2516f8a","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487264021000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"南山区","name":null,"firstPriceName":"精油推背","myComment":false},{"iconUrl":null,"nick":"user505666","star":5,"comment":"手法很好","createtime":1484145806000,"hasOrder":true,"id":"a06c736f052245cbb7430d78eba6b31a","replyComment":null,"replyTime":null,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"宝安区","name":null,"firstPriceName":"精油推背","myComment":false},{"iconUrl":null,"nick":"Linbaatz","star":5,"comment":"非常好  按完之后立竿见影","createtime":1483183780000,"hasOrder":true,"id":"c1d7a7f365d8495f871fc8adb5c7b60c","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487264039000,"imgPath":null,"imgThumbPath":null,"city":"武汉","area":"武昌区","name":null,"firstPriceName":"中老年爱心套餐","myComment":false},{"iconUrl":"http://wx.qlogo.cn/mmopen/Q5xPxqRgZicWMI1HH0PD4SXd1N4Bt7avwzIJB9iclYDRubMtZBTvkFGTodwmnLouePFI6J7EWWsL82ZNuP5zggbAugIOy59tWU/0","nick":"温宇","star":5,"comment":"郭师傅人很好，手法到位，服务专业，人很善良，感谢。点赞。","createtime":1483156479000,"hasOrder":true,"id":"b28f4719e5824f01b1ef6f6df225a404","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487264046000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"宝安区","name":null,"firstPriceName":"同性芳香SPA","myComment":false},{"iconUrl":null,"nick":"吕小波","star":5,"comment":"一如既往地好！！！","createtime":1482934263000,"hasOrder":true,"id":"411cbae8db8045418b83426d7b5e74f8","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487264056000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"宝安区","name":null,"firstPriceName":"精油推背","myComment":false},{"iconUrl":null,"nick":"13868805880","star":5,"comment":"很好很好","createtime":1482518784000,"hasOrder":true,"id":"3d66ffe1524f420383712163a239e3fb","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487264157000,"imgPath":null,"imgThumbPath":null,"city":"武汉","area":"武昌","name":null,"firstPriceName":"精油推背","myComment":false},{"iconUrl":null,"nick":"小巨Allen","star":5,"comment":"非常好 服务很细致 结束后还加了点时间","createtime":1482154601000,"hasOrder":true,"id":"c413c831eb7d4392993560715c5c913c","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487264140000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"福田区","name":null,"firstPriceName":"全身推拿","myComment":false},{"iconUrl":null,"nick":"小小仙女","star":5,"comment":"服务很好，很满意！","createtime":1481641038000,"hasOrder":true,"id":"ec9a76ca008f4ce980e45145a61240c4","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487264163000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"南山区","name":null,"firstPriceName":"全身推拿","myComment":false}]}
     */

    private String status;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * goodCount : 42
         * totalCount : 42
         * averageCount : 0
         * badCount : 0
         * hasImgCount : 0
         * comments : [{"iconUrl":null,"nick":"LoveMina","star":5,"comment":"技师很好，很满意","createtime":1488291003000,"hasOrder":true,"id":"c4e9a5eb224143fa96a1b3eec095169e","replyComment":null,"replyTime":null,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"罗湖区","name":null,"firstPriceName":"全身推拿","myComment":false},{"iconUrl":"http://wx.qlogo.cn/mmopen/UsichrXlnR9JpwD20tYrZIPTmXGsSkKojaM3icibficjoRicstXgBa8YaibZzEIBnnibMOqcMWWWrYqJfJnKr4xrDaPDQ/0","nick":"大鹏14","star":5,"comment":"好","createtime":1488281198000,"hasOrder":true,"id":"a85ac78521984c79940f4db8b87d37ad","replyComment":null,"replyTime":null,"imgPath":null,"imgThumbPath":null,"city":"武汉","area":"武昌区","name":null,"firstPriceName":"全身推拿","myComment":false},{"iconUrl":"http://wx.qlogo.cn/mmopen/UsichrXlnR9L4W0hHUKCJYub4m50HaS0BVAT9ufzicSadW1ZZrIM9GehDiar4lb5OXAfE7GlSUuOG9zXYTeOtRamZG1JECWKgzp/0","nick":"程明","star":5,"comment":"按的很舒服，很到位","createtime":1488195839000,"hasOrder":true,"id":"1cbb89a9f7d64f64863a56398a368c8d","replyComment":null,"replyTime":null,"imgPath":null,"imgThumbPath":null,"city":"武汉","area":"江汉区","name":null,"firstPriceName":"精油推背","myComment":false},{"iconUrl":"http://q.qlogo.cn/qqapp/1103839060/D77FB8E878B4512100CB279219AC5B51/100","nick":"花开无声2","star":5,"comment":"这个技师很专业，人又漂亮，谢谢","createtime":1487843263000,"hasOrder":true,"id":"4a6af8f254f84c43bcc9b985ef13f13b","replyComment":null,"replyTime":null,"imgPath":null,"imgThumbPath":null,"city":"上海","area":"浦东新区","name":null,"firstPriceName":"全身推拿","myComment":false},{"iconUrl":null,"nick":"user441558","star":5,"comment":"不错\n","createtime":1487565106000,"hasOrder":true,"id":"e5fa78db5f3d496a8e6ab0f7e3848731","replyComment":" 亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，感谢你对老师高评价，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487684370000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"盐田区","name":null,"firstPriceName":"全身推拿","myComment":false},{"iconUrl":"http://wx.qlogo.cn/mmopen/oqjmvaMlmycJOmAVL7prn3kRtq9kpVpAONyDtLWhnDmg9eJvickoggF2VKjXYWwNbuoqq6joEQvxpjfzZ0aR1XVpW1nyHnKu6/0","nick":"林雨涵","star":5,"comment":"一点也不舒服，这哪是spa，简直就是安排个中医的人来做，一开始还以为主要胸和腹部，肩颈都得不到放松舒缓，胸部还给我刮痧，根本不是spa按摩师，不懂spa是舒缓的嘛，差评，越按越累！","createtime":1487483536000,"hasOrder":true,"id":"cd1774ce0c6a4798b3d554ce7737881d","replyComment":" 亲，感谢你的用心评价，感谢你使用到位生活平台，我们加紧跟进后期服务，尽最大努力满足客户需求。爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487684569000,"imgPath":null,"imgThumbPath":null,"city":"上海","area":"普陀","name":null,"firstPriceName":"同性芳香SPA","myComment":false},{"iconUrl":"http://wx.qlogo.cn/mmopen/Q5xPxqRgZicXwI4Pg9xiaicZXPD5Z5zuvAuIaWyh4icFZTsMLGWIVLGy9HH1hy2pbWeVO0jgzCZomdJJr28t2yEDmw/0","nick":"wendy","star":5,"comment":"超级细心的美女技师，很能把准需求，技术超级好，推荐哦","createtime":1487388679000,"hasOrder":true,"id":"73f8586f8409463b98a23b9cc71241c5","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，感谢你对老师高评价，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487388994000,"imgPath":null,"imgThumbPath":null,"city":"上海","area":"闵行区","name":null,"firstPriceName":"深度经络调理","myComment":false},{"iconUrl":"http://wx.qlogo.cn/mmopen/Q5xPxqRgZicXHJFFA0cvdyUBSZ0tAAk7NQTFxMsxrDzMzDWCEBfDEwjXajibicsxN7DHhyplNa8A3EyGG7oMmPv0HjznYJMiaKIl/0","nick":"《~》","star":5,"comment":"经络手法很棒，专业，整个过程下来，使人轻松很多，及时到家","createtime":1487152047000,"hasOrder":true,"id":"33c7973668a647db9bffda581854dedd","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487263960000,"imgPath":null,"imgThumbPath":null,"city":"上海","area":"嘉定区","name":null,"firstPriceName":"深度经络调理","myComment":false},{"iconUrl":null,"nick":"iceyeye","star":5,"comment":"非常好 非常舒服 老师非常专业","createtime":1486561285000,"hasOrder":true,"id":"115ba01c8256452b885506dcb1918835","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487263976000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"宝安区","name":null,"firstPriceName":"精油推背","myComment":false},{"iconUrl":null,"nick":"猥琐男","star":5,"comment":"不错不错，服务到位\u2026\u2026","createtime":1485847750000,"hasOrder":true,"id":"828a5aba4e944ebdaf3668fb6ef27890","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487263987000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"福田区","name":null,"firstPriceName":"精油推背","myComment":false},{"iconUrl":"http://wx.qlogo.cn/mmopen/GtS5XXtiaCDYvWfQIAXjFFlomPELS2Anewe4zUvqm6Mjtc1L16iaibCAksr6vu3PtQUcDLibLylR2MrGR4dzrfGZraVdibVaDFydz/0","nick":"庚午夫","star":5,"comment":"师傅按的很不错，可以继续点~","createtime":1485071302000,"hasOrder":true,"id":"986dfd41255e4c41aff8b72c22041a0d","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487264006000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"宝安区","name":null,"firstPriceName":"同性芳香SPA","myComment":false},{"iconUrl":null,"nick":"stephyC","star":5,"comment":"按压之后舒服了很多，很好","createtime":1485004966000,"hasOrder":true,"id":"07d5b2d7e0f24712a161ab42c82b8497","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487263999000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"宝安区","name":null,"firstPriceName":"深度经络调理","myComment":false},{"iconUrl":null,"nick":"user353029","star":5,"comment":"韦技师按摩的确实很好！赞！","createtime":1484558879000,"hasOrder":true,"id":"24ab59c4c5c446a087e2e696a2516f8a","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487264021000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"南山区","name":null,"firstPriceName":"精油推背","myComment":false},{"iconUrl":null,"nick":"user505666","star":5,"comment":"手法很好","createtime":1484145806000,"hasOrder":true,"id":"a06c736f052245cbb7430d78eba6b31a","replyComment":null,"replyTime":null,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"宝安区","name":null,"firstPriceName":"精油推背","myComment":false},{"iconUrl":null,"nick":"Linbaatz","star":5,"comment":"非常好  按完之后立竿见影","createtime":1483183780000,"hasOrder":true,"id":"c1d7a7f365d8495f871fc8adb5c7b60c","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487264039000,"imgPath":null,"imgThumbPath":null,"city":"武汉","area":"武昌区","name":null,"firstPriceName":"中老年爱心套餐","myComment":false},{"iconUrl":"http://wx.qlogo.cn/mmopen/Q5xPxqRgZicWMI1HH0PD4SXd1N4Bt7avwzIJB9iclYDRubMtZBTvkFGTodwmnLouePFI6J7EWWsL82ZNuP5zggbAugIOy59tWU/0","nick":"温宇","star":5,"comment":"郭师傅人很好，手法到位，服务专业，人很善良，感谢。点赞。","createtime":1483156479000,"hasOrder":true,"id":"b28f4719e5824f01b1ef6f6df225a404","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487264046000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"宝安区","name":null,"firstPriceName":"同性芳香SPA","myComment":false},{"iconUrl":null,"nick":"吕小波","star":5,"comment":"一如既往地好！！！","createtime":1482934263000,"hasOrder":true,"id":"411cbae8db8045418b83426d7b5e74f8","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487264056000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"宝安区","name":null,"firstPriceName":"精油推背","myComment":false},{"iconUrl":null,"nick":"13868805880","star":5,"comment":"很好很好","createtime":1482518784000,"hasOrder":true,"id":"3d66ffe1524f420383712163a239e3fb","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487264157000,"imgPath":null,"imgThumbPath":null,"city":"武汉","area":"武昌","name":null,"firstPriceName":"精油推背","myComment":false},{"iconUrl":null,"nick":"小巨Allen","star":5,"comment":"非常好 服务很细致 结束后还加了点时间","createtime":1482154601000,"hasOrder":true,"id":"c413c831eb7d4392993560715c5c913c","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487264140000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"福田区","name":null,"firstPriceName":"全身推拿","myComment":false},{"iconUrl":null,"nick":"小小仙女","star":5,"comment":"服务很好，很满意！","createtime":1481641038000,"hasOrder":true,"id":"ec9a76ca008f4ce980e45145a61240c4","replyComment":"亲，感谢你的五星好评，感谢你使用到位生活平台，感谢你对爱心到家的服务认可，爱心到家以品牌质量技术为主导，做你的专业健康管家，伴你健康每一天，期待你的再次预约。","replyTime":1487264163000,"imgPath":null,"imgThumbPath":null,"city":"深圳","area":"南山区","name":null,"firstPriceName":"全身推拿","myComment":false}]
         */

        private int goodCount;
        private int totalCount;
        private int averageCount;
        private int badCount;
        private int hasImgCount;
        private List<CommentsBean> comments;

        public int getGoodCount() {
            return goodCount;
        }

        public void setGoodCount(int goodCount) {
            this.goodCount = goodCount;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getAverageCount() {
            return averageCount;
        }

        public void setAverageCount(int averageCount) {
            this.averageCount = averageCount;
        }

        public int getBadCount() {
            return badCount;
        }

        public void setBadCount(int badCount) {
            this.badCount = badCount;
        }

        public int getHasImgCount() {
            return hasImgCount;
        }

        public void setHasImgCount(int hasImgCount) {
            this.hasImgCount = hasImgCount;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class CommentsBean {
            /**
             * iconUrl : null
             * nick : LoveMina
             * star : 5
             * comment : 技师很好，很满意
             * createtime : 1488291003000
             * hasOrder : true
             * id : c4e9a5eb224143fa96a1b3eec095169e
             * replyComment : null
             * replyTime : null
             * imgPath : null
             * imgThumbPath : null
             * city : 深圳
             * area : 罗湖区
             * name : null
             * firstPriceName : 全身推拿
             * myComment : false
             */

            private String iconUrl;
            private String nick;
            private int star;
            private String comment;
            private long createtime;
            private boolean hasOrder;
            private String id;
            private String replyComment;
            private Object replyTime;
            private Object imgPath;
            private Object imgThumbPath;
            private String city;
            private String area;
            private Object name;
            private String firstPriceName;
            private boolean myComment;

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }

            public String getNick() {
                return nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public int getStar() {
                return star;
            }

            public void setStar(int star) {
                this.star = star;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public long getCreatetime() {
                return createtime;
            }

            public void setCreatetime(long createtime) {
                this.createtime = createtime;
            }

            public boolean isHasOrder() {
                return hasOrder;
            }

            public void setHasOrder(boolean hasOrder) {
                this.hasOrder = hasOrder;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getReplyComment() {
                return replyComment;
            }

            public void setReplyComment(String replyComment) {
                this.replyComment = replyComment;
            }

            public Object getReplyTime() {
                return replyTime;
            }

            public void setReplyTime(Object replyTime) {
                this.replyTime = replyTime;
            }

            public Object getImgPath() {
                return imgPath;
            }

            public void setImgPath(Object imgPath) {
                this.imgPath = imgPath;
            }

            public Object getImgThumbPath() {
                return imgThumbPath;
            }

            public void setImgThumbPath(Object imgThumbPath) {
                this.imgThumbPath = imgThumbPath;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public String getFirstPriceName() {
                return firstPriceName;
            }

            public void setFirstPriceName(String firstPriceName) {
                this.firstPriceName = firstPriceName;
            }

            public boolean isMyComment() {
                return myComment;
            }

            public void setMyComment(boolean myComment) {
                this.myComment = myComment;
            }
        }
    }
}

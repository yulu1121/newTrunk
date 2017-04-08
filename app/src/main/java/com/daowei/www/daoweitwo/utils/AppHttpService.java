package com.daowei.www.daoweitwo.utils;

import com.daowei.www.daoweitwo.module.category.bean.CategoryBean;
import com.daowei.www.daoweitwo.module.category.bean.SearchGridBean;
import com.daowei.www.daoweitwo.module.category.bean.SortBean;
import com.daowei.www.daoweitwo.module.category.bean.StoreAllBean;
import com.daowei.www.daoweitwo.module.home.bean.BannerItemBean;
import com.daowei.www.daoweitwo.module.home.bean.CommentBean;
import com.daowei.www.daoweitwo.module.home.bean.HomeBannerBean;
import com.daowei.www.daoweitwo.module.home.bean.HomeExpanbleBean;
import com.daowei.www.daoweitwo.module.home.bean.HomeFooterBean;
import com.daowei.www.daoweitwo.module.home.bean.HomeRecommendBean;
import com.daowei.www.daoweitwo.module.home.bean.HomeServiceBean;
import com.daowei.www.daoweitwo.module.home.bean.ServiceItemBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 用来请求网络数据的接口
 * Created by yulu on 2017/2/20.
 */

public interface AppHttpService {
    //注意：version，imei,udid(imei和udid相同)在Constants中有常量，直接取出； added by yulu 2017年2月20日 22:07:16
    //http://api.daoway.cn/daoway/rest/service_items/recommend_top?start=0&size=10&lot=114.32044324876&lat=30.580713370154&manualCity=%E6%AD%A6%E6%B1%89&imei=133524447081935&includeNotInScope=true&udid=133524447081935&appVersion=4.9.2
    @GET("service_items/recommend_top")
    Observable<HomeExpanbleBean> getHomeExpanbleBean(
                        @Query("start")int start,
                        @Query("size")int size,
                        @Query("lot")double lot,
                        @Query("lat")double lat,
                        @Query("manualCity")String city);
    //http://api.daoway.cn/daoway/rest/category/withtags?manualCity=%E6%AD%A6%E6%B1%89&communityId=279969&hasChaoshi=false&udid=133524447081935&appVersion=4.9.2")
    @GET("category/withtags")
    Observable<CategoryBean> getCategoryBean(@Query("manualCity") String city,
                                             @Query("communityId")int id,
                                             @Query("hasChaoshi") boolean hasChaoshi, @Query("udid") String udid,
                                             @Query("appVersion") String versition);
    //http://api.daoway.cn/daoway/rest/service_items/filter?
    // start=0&size=20&lot=114.32044324876&lat=30.580713370154&imei=133524447081935&
    // category=20&tag=%E6%B7%B1%E5%BA%A6%E4%BF%9D%E6%B4%81&manualCity=%E6%AD%A6%E6%B1%89&
    // sort_by=recommend&udid=133524447081935&appVersion=4.9.2
    @GET("service_items/filter")
    Observable<HomeExpanbleBean.DataBean> getCategoryDetails(
            @Query("start") int start,
            @Query("size") int size,
            @Query("lot") float lot,
            @Query("lat") float lat,
            @Query("imei") String imei,
            @Query("category") String category,
            @Query("tag") String tag,
            @Query("manualCity") String city,
            @Query("sort_by") String sortBy,
            @Query("udid") String udid,
            @Query("appVersion") String version
    );
   // http://api.daoway.cn/daoway/rest/config/banners?platform=android&city=%E5%AE%9C%E6%98%8C
    @GET("config/banners?platform=android")
    Observable<HomeBannerBean> getBannerBean(@Query("city") String city);
    //http://api.daoway.cn/daoway/rest/category/for_filter?manualCity=%E6%AD%A6%E6%B1%89
    @GET("category/for_filter")
    Observable<HomeServiceBean> getServiceBean(
            @Query("manualCity") String city);
    //http://api.daoway.cn/daoway/rest/indexEvent/all?city=%E6%AD%A6%E6%B1%89&market=false&version=v2&serviceMinLimit=4&type=all&marketMinLimit=2&udid=133524447081935&appVersion=4.9.2
    @GET("indexEvent/all")
    Observable<HomeRecommendBean> getRecommendBean(@Query("city") String city,
                                                   @Query("market") boolean flag,
                                                   @Query("version") String version,
                                                   @Query("serviceMinLimit") int limit,
                                                   @Query("type")String type,
                                                   @Query("marketMinLimit") int numMarket,
                                                   @Query("udid")String udid,
                                                   @Query("appVersion")String appVersion);
    //http://api.daoway.cn/daoway/rest/services?start=0&size=20&lot=111.3254318237305&lat=30.73299980163574&manualCity=%E6%AD%A6%E6%B1%89&imei=133524447081935&includeNotInScope=true&udid=133524447081935&appVersion=4.9.2
    @GET("services")
    Observable<HomeFooterBean> getFooterBean(@Query("start") int start,
                                             @Query("size") int size,
                                             @Query("lot") double lot,
                                             @Query("lat") double lat,
                                             @Query("manualCity")String city);

    /**created by hezijie
     * @return
     */
    //http://api.daoway.cn/daoway/rest/services/filter?start=0&size=20&lot=114.43604618483677&lat=30.424651061321562&category=20&tags=%E5%B0%8F%E6%97%B6%E5%B7%A5&manualCity=%E6%AD%A6%E6%B1%89&imei=865931028521318&includeNotInScope=true&userId=ffde4e5800494a048bc383e3c5c051dc&udid=865931028521318&appVersion=4.10.0
    @GET("services/filter")
    Observable<SortBean> getSortBean(@Query("start") int start,@Query("size") int size,@Query("lot") float lot,@Query("lat") float lat,@Query("category") String category,@Query("tags") String tags,@Query("manualCity") String manualCity,@Query("imei") String imei,@Query("includeNotInScope") boolean includeNotInScope,@Query("userId") String userId,@Query("udid") String udid,@Query("appVersion") String appVersion);


    /**
     * @param start
     * @param size
     * @param lot
     * @param lat
     * @param category
     * @param
     * @param manualCity
     * @param imei
     * @param includeNotInScope
     * @param userId
     * @param udid
     * @param appVersion
     *
     * http://api.daoway.cn/daoway/rest/services/filter?start=0&size=20&lot=114.43604618483677&
     * lat=30.424651061321562&category=20&manualCity=%E6%AD%A6%E6%B1%89&imei=865931028521318&
     * includeNotInScope=true&userId=ffde4e5800494a048bc383e3c5c051dc&udid=865931028521318&
     * appVersion=4.10.0
     * @return
     */
    @GET("services/filter")
    Observable<StoreAllBean> getStoreAllBean(@Query("start") int start,
                                             @Query("size") int size,
                                             @Query("lot") float lot,
                                             @Query("lat") float lat,
                                             @Query("category") String category,
                                             @Query("manualCity") String manualCity,
                                             @Query("imei") String imei,
                                             @Query("includeNotInScope") boolean includeNotInScope,
                                             @Query("userId") String userId,
                                             @Query("udid") String udid,
                                             @Query("appVersion") String appVersion);
    //http://api.daoway.cn/daoway/rest/service/e2ec99bf24734220b96586b852c262ac?userId=&lot=111.3254318237305&lat=30.73299980163574
    @GET("service/{target}")
    Observable<BannerItemBean> getBannerItemBean(@Path("target") String target,
                                                 @Query("userId") String userId,
                                                 @Query("lot") double lot,
                                                 @Query("lat") double lat);
    //http://api.daoway.cn/daoway/rest/service/full/2461747?lat=30.586776733398438&lot=114.33287048339844&manualCity=%E6%AD%A6%E6%B1%89&udid=133524531270097&appVersion=4.10.0
    @GET("service/full/{serviceId}")
    Observable<ServiceItemBean> getServiceItemBean(@Path("serviceId") String serviceId,
                                                   @Query("lat") double lat,
                                                   @Query("lot") double lot,
                                                   @Query("manualCity")String city);
    //http://api.daoway.cn/daoway/rest/service/e2ec99bf24734220b96586b852c262ac/comments?start=0&size=20&filter=all&udid=133524531270097&appVersion=4.10.0
    @GET("service/{serviceId}/comments")
    Observable<CommentBean> getCommentBean(@Path("serviceId") String id,
                                           @Query("start") int start,
                                           @Query("size") int size,
                                           @Query("filter") String filter

    );

    /**created by hezijie
     * 获取search界面gridview的数据
     * @return
     * url:http://api.daoway.cn/daoway/rest/services/hot_search?userId=ffde4e5800494a048bc383e3c5c051dc&
     * lot=114.43604618483677&lat=30.424651061321562&udid=865931028521318&appVersion=4.10.0
     */
    @GET("services/hot_search")
    Observable<SearchGridBean> getSearchGrid(@Query("userId") String userId,
                                             @Query("lot") float lot,
                                             @Query("lat") float lat,
                                             @Query("udid") String udid,
                                             @Query("appVersion") String appVersion);

    /**
     * @return
     * http://api.daoway.cn/daoway/rest/services/auto_complete_words?
     * word=%E6%B4%97%E8%A1%A3&udid=865931028521318&appVersion=4.10.0
     */
    @GET("services/auto_complete_words")
    Observable<SearchGridBean> getSearchList(@Query("word") String word,@Query("udid") String udid,@Query("appVersion")String appVersion);
}

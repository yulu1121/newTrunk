package com.daowei.www.daoweitwo.view.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.view.adapter.MapPoiAdapter;
import com.daowei.www.daoweitwo.view.home.city.PickCityActivity;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapActivity extends AppCompatActivity {
    @BindView(R.id.city)
    RadioButton city;
    @BindView(R.id.baidu_map)
    MapView mMapView;
    @BindView(R.id.map_list)
    ListView listView;
    @BindView(R.id.search_city)
    EditText editText;
    private String mCity;
    private BaiduMap baiduMap;
    private LocationClient client;
    private boolean isFirstLoc = true;
    private LatLng currentLocation;
    private GeoCoder geoCoder;
    private PoiSearch poiSearch;
    private BitmapDescriptor mCurrentMarker;
    private String cityName;
    public static final int REQUEST_CODE = 2;
    private List<PoiInfo> mlist = new ArrayList<>();
    private MapPoiAdapter adapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);
        initCurrentLocation();
        initView();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void initView() {
        adapter = new MapPoiAdapter(this, mlist);
        listView.setAdapter(adapter);
        mCurrentMarker = BitmapDescriptorFactory
                .fromResource(R.mipmap.map_state_edit_icon);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, EditCityActivity.class);
                startActivity(intent);
            }
        });
        city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, PickCityActivity.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (null != data) {
            String cityName = data.getStringExtra("cityName");
            switch (requestCode) {
                case REQUEST_CODE:
                    city.setText(cityName);
                    break;
            }
        }
    }

    public void end_map(View view) {
        finish();
    }

    private void initCurrentLocation() {
        //获得百度地图对象
        baiduMap = mMapView.getMap();
        //开启定位图层
        baiduMap.setMyLocationEnabled(true);
        //创建定位客户
        client = new LocationClient(this);
        //设置定位的选项
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true);
        option.setCoorType("bd09ll");
        option.setScanSpan(5000);//设置扫描间隔
        option.setIsNeedAddress(true);
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        client.setLocOption(option);
        client.start();
        client.registerLocationListener(new BDLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                if (bdLocation != null) {
                    //创建数据
                    MyLocationData data = new MyLocationData.Builder()
                            .accuracy(bdLocation.getRadius())
                            .direction(bdLocation.getDirection())
                            .latitude(bdLocation.getLatitude())
                            .longitude(bdLocation.getLongitude())
                            .build();
                    //给地图设置定位数据
                    baiduMap.setMyLocationData(data);
                    if (isFirstLoc) {
                        isFirstLoc = false;
                        LatLng latLng = new LatLng(bdLocation.getLatitude(),
                                bdLocation.getLongitude());
                        MapStatusUpdate upadate = MapStatusUpdateFactory.newLatLng(latLng);
                        //移动地图
                        baiduMap.animateMapStatus(upadate);
                        //保存当前位置
                        currentLocation = latLng;
                        initGeoCoder(latLng);
                    }
                }
            }

            @Override
            public void onConnectHotSpotMessage(String s, int i) {

            }
        });
        baiduMap.setOnMapStatusChangeListener(new BaiduMap.OnMapStatusChangeListener() {
            @Override
            public void onMapStatusChangeStart(MapStatus mapStatus) {

            }

            @Override
            public void onMapStatusChange(MapStatus mapStatus) {
                baiduMap.clear();
                baiduMap.addOverlay(new MarkerOptions().position(mapStatus.target)
                        .icon(mCurrentMarker));
// 反Geo搜索
                geoCoder.reverseGeoCode(new ReverseGeoCodeOption()
                        .location(mapStatus.target));
            }

            @Override
            public void onMapStatusChangeFinish(MapStatus mapStatus) {

            }
        });
    }

    private void initGeoCoder(LatLng ll) {
        geoCoder = GeoCoder.newInstance();
        //进行反向编码
        geoCoder.reverseGeoCode(new ReverseGeoCodeOption().location(ll));
        geoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {

            @Override
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {

            }

            @Override
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result) {
                if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                    Toast.makeText(MapActivity.this, "抱歉，未能找到结果",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                mCity = result.getAddressDetail().city;
                city.setText(mCity);
                List<PoiInfo> poiList = result.getPoiList();
                if (poiList != null && poiList.size() > 0) {
                    mlist.clear();
                    mlist.addAll(poiList);
                    adapter.notifyDataSetChanged();
                }

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理

    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Map Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2.connect();
        AppIndex.AppIndexApi.start(client2, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client2, getIndexApiAction());
        client2.disconnect();
    }
}


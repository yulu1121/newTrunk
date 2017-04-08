package com.daowei.www.daoweitwo;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.daowei.www.daoweitwo.module.category.bean.CategoryBean;
import com.daowei.www.daoweitwo.module.category.bean.ItemBean;
import com.daowei.www.daoweitwo.module.category.bean.SearchGridBean;
import com.daowei.www.daoweitwo.module.category.bean.SortBean;
import com.daowei.www.daoweitwo.module.category.bean.StoreAllBean;
import com.daowei.www.daoweitwo.presenter.category.ICategoryPresenter;
import com.daowei.www.daoweitwo.presenter.category.impl.CategoryPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity implements ICategoryPresenter.CatePresentCallBack {
    private static final String TAG = "111";
    @BindView(R.id.activity_search_lv)
    ListView mSearchList;
    @BindView(R.id.activity_search_back)
    ImageView mBackBtn;
    @BindView(R.id.activity_search_edit)
    EditText mSearchEdit;
    @BindView(R.id.activity_search_toolbar)
    Toolbar toolbar;
    private List<String> mGridList;
    private CategoryPresenter categoryPresenter;
    private GridView mSearchGridView;
    private SearchGridAdapter searchGridAdapter;
    private List<String> mHistoryList;
    private HistoryAdapter historyAdapter;
    private PopupWindow popupWindow;
    private ListView mHintLV;
    private List<String> mHintList;
    private HintAdapter hintAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initData();
        initHintData();
        listener();
    }

    private void initHintData() {
        popupWindow = new PopupWindow(this);
        mHintList = new ArrayList<>();
        Drawable drawable = ContextCompat.getDrawable(this, R.color.white);
        popupWindow.setBackgroundDrawable(drawable);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        View hintView = LayoutInflater.from(this).inflate(R.layout.activity_search_hint_listview, null);
        mHintLV = (ListView)hintView.findViewById(R.id.search_list_message);
        hintAdapter = new HintAdapter();
        mHintLV.setAdapter(hintAdapter);
        popupWindow.setContentView(hintView);
    }

    private void listener() {
        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mSearchEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            /**
             * @param s
             * @param start
             * @param before
             * @param count
             * 键盘的显示方法来源于http://blog.csdn.net/ccpat/article/details/46717573
             */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(mSearchEdit.getText()!= null && !mSearchEdit.getText().toString().equals("")){
                    categoryPresenter.querySearchList(SearchActivity.this,mSearchEdit.getText().toString(),SearchActivity.this);
                    popupWindow.showAsDropDown(toolbar);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                InputMethodManager imm = (InputMethodManager) getSystemService(SearchActivity.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    mSearchEdit.requestFocus();
                    imm.showSoftInput(mSearchEdit,0);
                }
            }
        });
    }

    private void initData() {
        mGridList = new ArrayList<>();
        mHistoryList = new ArrayList<>();
        mHistoryList.add("历史搜索");
        categoryPresenter = new CategoryPresenter();
        categoryPresenter.querySearchGrid(this,this);
        searchGridAdapter = new SearchGridAdapter();
        View view = LayoutInflater.from(SearchActivity.this).inflate(R.layout.activity_search_head, null);
        mSearchGridView = (GridView) view.findViewById(R.id.activity_search_gridview);
        mSearchGridView.setAdapter(searchGridAdapter);
        mSearchList.addHeaderView(view);
        historyAdapter = new HistoryAdapter();
        mSearchList.setAdapter(historyAdapter);
    }
    class HistoryAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mHistoryList == null ? 0 : mHistoryList.size();
        }

        @Override
        public Object getItem(int position) {
            return mHistoryList.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(SearchActivity.this).inflate(R.layout.activity_search_history_text,parent,false);
            TextView textView = (TextView) convertView.findViewById(R.id.activity_search_history_textview);
            if(position == 0){
                textView.setTextColor(Color.GRAY);
            }
            textView.setText(mHistoryList.get(position));
            return convertView;
        }
    }

    class HintAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mHintList == null ? 0 : mHintList.size();
        }

        @Override
        public Object getItem(int position) {
            return mHintList.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(SearchActivity.this).inflate(R.layout.activity_search_history_text,parent,false);
            TextView textView = (TextView) convertView.findViewById(R.id.activity_search_history_textview);
            textView.setText(mHintList.get(position));
            return convertView;
        }
    }

    class SearchGridAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mGridList == null ? 0 :mGridList.size();
        }

        @Override
        public Object getItem(int position) {
            return mGridList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override

        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(SearchActivity.this).inflate(R.layout.activity_search_gridview_item,parent,false);
            TextView textView = (TextView) convertView.findViewById(R.id.activity_search_gridview_item_tv);
            textView.setText(mGridList.get(position));
            return convertView;
        }
    }

    @Override
    public void getSearchGrid(SearchGridBean searchGridBean) {
        mGridList.addAll(searchGridBean.getData());
        searchGridAdapter.notifyDataSetChanged();
    }

    @Override
    public void getSearchList(SearchGridBean searchGridBean) {
        mHintList.addAll(searchGridBean.getData());
        hintAdapter.notifyDataSetChanged();
    }

    @Override
    public void getData(CategoryBean categoryBean) {

    }

    @Override
    public void getDetais(List<ItemBean> list) {

    }

    @Override
    public void getSort(SortBean sortBean) {

    }

    @Override
    public void getAll(List<ItemBean> list) {

    }

    @Override
    public void getStoreAll(StoreAllBean storeAllBean) {

    }
}

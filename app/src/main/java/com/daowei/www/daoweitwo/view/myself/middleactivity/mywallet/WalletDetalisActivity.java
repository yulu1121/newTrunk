package com.daowei.www.daoweitwo.view.myself.middleactivity.mywallet;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.daowei.www.daoweitwo.R;

public class WalletDetalisActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    private RelativeLayout relativeLayout;
    private PopupWindow mPopWindow;
    private TextView textTitle;
    private TextView textAll;
    private TextView textOnlyWeek;
    private ImageView upDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_detalis);
        linearLayout = (LinearLayout) findViewById(R.id.layout_details_title);
        relativeLayout = (RelativeLayout) findViewById(R.id.layout_details);
        textTitle = (TextView) findViewById(R.id.text_title);
        upDown = (ImageView) findViewById(R.id.image_up_down);
        listener();
    }
   //实现activity的跳转
    public void detailsBack(View view) {
        finish();
        overridePendingTransition(R.anim.zoomcarin, R.anim.zoomcarout);

    }

    public void listener() {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopWindow();
                upDown.setImageResource(R.drawable.arraw_up);

            }

        });

    }

    public void showPopWindow() {
        WindowManager windowManager = this.getWindowManager();
        View contentView = LayoutInflater.from(this).inflate(R.layout.activity_popup_window, null, false);
        mPopWindow = new PopupWindow(contentView,
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.WRAP_CONTENT,
                true);

        //设置透明度
        WindowManager.LayoutParams params = this.getWindow().getAttributes();
        params.alpha = 0.7f;
        this.getWindow().setAttributes(params);
        //将popupwindow设置在title下面显示
        mPopWindow.showAsDropDown(relativeLayout);
        //点击其他地方关闭popupWindow
        contentView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                closePopuWindow();
                return false;
            }
        });
        //点击条目实现title的切换
        textAll = (TextView) contentView.findViewById(R.id.text_all);
        textOnlyWeek = (TextView) contentView.findViewById(R.id.text_only_week);
        textAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textTitle.setText(textAll.getText());
                closePopuWindow();
                upDown.setImageResource(R.drawable.arraw_down);
            }
        });
        textOnlyWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textTitle.setText(textOnlyWeek.getText());
                closePopuWindow();
                upDown.setImageResource(R.drawable.arraw_down);
            }
        });
        if ((textTitle.getText()) == (textAll.getText())){
            textAll.setTextColor(getResources().getColor(R.color.AccountTextColor));
        }else if ((textTitle.getText()) == (textOnlyWeek.getText())){
            textOnlyWeek.setTextColor(getResources().getColor(R.color.AccountTextColor));
        }


    }

    //关闭popupWindow
    public void closePopuWindow() {
        if (mPopWindow != null && mPopWindow.isShowing()) {
            mPopWindow.dismiss();
            WindowManager.LayoutParams params = this.getWindow().getAttributes();
            params.alpha = 1f;
            this.getWindow().setAttributes(params);
        }
    }

}

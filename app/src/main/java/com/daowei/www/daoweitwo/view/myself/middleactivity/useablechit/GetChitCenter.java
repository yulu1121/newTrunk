package com.daowei.www.daoweitwo.view.myself.middleactivity.useablechit;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.daowei.www.daoweitwo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GetChitCenter extends AppCompatActivity {
    @BindView(R.id.conversion_code)
    TextView conversionCode;
    private EditText editText;
    private PopupWindow pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_chit_center);
        ButterKnife.bind(this);
        listener();
    }

    public void getChitCenterBack(View view){
        finish();
        overridePendingTransition(R.anim.zoomcarin,R.anim.zoomcarout);
    }

    public void listener(){
        conversionCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCodePopupWindow();

            }
        });
    }

    private void showCodePopupWindow() {
        View contentview = LayoutInflater.from(this).inflate(R.layout.code_popup_window,null,false);
        pw = new PopupWindow(contentview, ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT,true);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_get_chit_center,null,false);
        pw.showAtLocation(view, Gravity.CENTER,0,0);

        //改变透明度
        WindowManager.LayoutParams params = this.getWindow().getAttributes();
        params.alpha = 0.7f;
        this.getWindow().setAttributes(params);
        //点击其他地方关闭popupwindow
        pw.setOutsideTouchable(true);

        //为取消  和 确定按钮设置点击事件
        TextView textCancle = (TextView) contentview.findViewById(R.id.text_cancle);
        TextView textSure = (TextView) contentview.findViewById(R.id.text_sure);
        editText = (EditText) contentview.findViewById(R.id.editText);
        textCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeCodePopupWindow();
            }
        });
        textSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if(text==null ||text.equals("")){
                    Toast.makeText(GetChitCenter.this, "请输入兑换码", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(GetChitCenter.this, "充值成功", Toast.LENGTH_SHORT).show();
                    closeCodePopupWindow();
                }
            }
        });




    }

    public void closeCodePopupWindow(){
        if(pw != null && pw.isShowing()){
            pw.dismiss();
            //恢复透明度
            WindowManager.LayoutParams params = this.getWindow().getAttributes();
            params.alpha = 1f;
            this.getWindow().setAttributes(params);
        }
    }

}

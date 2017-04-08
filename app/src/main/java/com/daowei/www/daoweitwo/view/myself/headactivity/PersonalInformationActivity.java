package com.daowei.www.daoweitwo.view.myself.headactivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daowei.www.daoweitwo.R;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonalInformationActivity extends AppCompatActivity {
    @BindView(R.id.back_to_left)
    ImageButton imageButton;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.man_button)
    RadioButton manButton;
    @BindView(R.id.woman_button)
    RadioButton womanButton;
    @BindView(R.id.set_password)
    RelativeLayout setPassword;
    @BindView(R.id.login_out)
    TextView loginOut;
    @BindView(R.id.header_picture)
    ImageView headerPicture;

    private PopupWindow pwOutLogin;
    private PopupWindow pwSelectHeader;
    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final String IMAGE_FILE_NAME = "temp_head_image.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        ButterKnife.bind(this);
        listener();
    }

    public void btnBack(View view) {
        finish();
        overridePendingTransition(R.anim.zoomcarin, R.anim.zoomcarout);
    }

    public void listener() {
        //默认选择“男”
        manButton.setTextColor(Color.RED);
        manButton.setChecked(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.man_button:
                        setColor();
                        manButton.setTextColor(Color.RED);
                        break;
                    case R.id.woman_button:
                        setColor();
                        womanButton.setTextColor(Color.RED);
                        break;
                }
            }
        });

        setPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PersonalInformationActivity.this, SetPassWordActivity.class));
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
            }
        });
        loginOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOutLoginPw();

            }
        });

        headerPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelectHeaderImgPw();
            }
        });


    }


    public void setColor() {
        manButton.setTextColor(ContextCompat.getColor(this, R.color.colorOfSex));
        womanButton.setTextColor(ContextCompat.getColor(this, R.color.colorOfSex));
    }

    public void showOutLoginPw() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.activity_login_out, null, false);
        TextView cancle = (TextView) contentView.findViewById(R.id.text_cancle);
        TextView sure = (TextView) contentView.findViewById(R.id.text_sure);
        pwOutLogin = new PopupWindow(contentView, ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT, true);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_personal_information, null, false);
        pwOutLogin.showAtLocation(view, Gravity.CENTER, 0, 0);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 0.7f;
        getWindow().setAttributes(params);
        contentView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                closePwOutLogin();
                return false;
            }
        });


        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePwOutLogin();
            }
        });

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PersonalInformationActivity.this, "退出成功", Toast.LENGTH_SHORT).show();
                closePwOutLogin();
                finish();
                overridePendingTransition(R.anim.zoomcarin,R.anim.zoomcarout);
            }
        });

    }


    public void closePwOutLogin() {
        if (pwOutLogin != null && pwOutLogin.isShowing()) {
            pwOutLogin.dismiss();
            WindowManager.LayoutParams params = getWindow().getAttributes();
            params.alpha = 1f;
            getWindow().setAttributes(params);
        }
    }

    private void showSelectHeaderImgPw() {
        View selectHeader = LayoutInflater.from(this).inflate(R.layout.activity_select_head_pw, null, false);
        pwSelectHeader = new PopupWindow(selectHeader, ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT, true);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_personal_information, null, false);
        pwSelectHeader.showAtLocation(view, Gravity.CENTER, 0, 0);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 0.7f;
        getWindow().setAttributes(params);

        selectHeader.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                closePwSelectHeader();
                return false;
            }
        });
        TextView fromGallery = (TextView) selectHeader.findViewById(R.id.select_from_gallery);
        TextView fromCamera = (TextView) selectHeader.findViewById(R.id.select_camera);
        Button selectCancle = (Button) selectHeader.findViewById(R.id.select_cancle);
        selectCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePwSelectHeader();
            }
        });

        fromGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectHeaderImgFromGallery();

            }
        });


        fromCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectHeaderImgFromCamera();

            }
        });


    }

    private void closePwSelectHeader() {
        if (pwSelectHeader != null && pwSelectHeader.isShowing()) {
            pwSelectHeader.dismiss();
            WindowManager.LayoutParams params = getWindow().getAttributes();
            params.alpha = 1f;
            getWindow().setAttributes(params);
        }
    }

    private void selectHeaderImgFromGallery() {
        Intent intentFromGallery = new Intent();
        intentFromGallery.setType("image/*");
        intentFromGallery.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intentFromGallery,CODE_GALLERY_REQUEST);

    }
    private void selectHeaderImgFromCamera(){
        Intent intentFromCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (hasSkd()){
            intentFromCamera.putExtra(MediaStore.EXTRA_OUTPUT,
                                      Uri.fromFile(new File(Environment.getExternalStorageDirectory(),IMAGE_FILE_NAME)));
        }
        startActivityForResult(intentFromCamera,CODE_CAMERA_REQUEST);
    }

    private boolean hasSkd() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }else {
            return false;
        }

    }

}

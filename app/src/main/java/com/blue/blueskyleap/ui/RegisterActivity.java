package com.blue.blueskyleap.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blue.blueskyleap.R;
import com.blue.blueskyleap.utils.CountDownTimerUtils;
import com.blue.blueskyleap.utils.ToastUtil;

public class RegisterActivity extends AppCompatActivity {

    private EditText registerName;
    private EditText registerNum;
    private EditText veCode;
    private Button vecodeButton;
    private EditText registerCode;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
    }

    private void initViews() {
        registerName = ((EditText) findViewById(R.id.et_register_name));
        registerNum = ((EditText) findViewById(R.id.ed_register_num));
        veCode = ((EditText) findViewById(R.id.vecode));
        vecodeButton = ((Button) findViewById(R.id.btn_vecode));
        registerCode = ((EditText) findViewById(R.id.et_registercode));
        registerButton = ((Button) findViewById(R.id.btn_register));
        String num = registerName.getText().toString().trim();
        setOnclick();
    }

    private void setOnclick() {
        registerButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(registerName.getText().toString().trim())) {
                    ToastUtil.shotShortToast("请输入姓名");
                }
                if (TextUtils.isEmpty(registerNum.getText().toString().trim())) {
                    ToastUtil.shotShortToast("请输入手机号");
                }
                if (TextUtils.isEmpty(veCode.getText().toString().trim()) ) {
                    ToastUtil.shotShortToast("请输入验证码");
                }
                if (TextUtils.isEmpty(registerCode.getText().toString().trim()) ) {
                    ToastUtil.shotShortToast("请输入密码");
                }
                if(!TextUtils.isEmpty(registerName.getText().toString().trim()) && !TextUtils.isEmpty(registerNum.getText().toString().trim()) && !TextUtils.isEmpty(veCode.getText().toString().trim()) && !TextUtils.isEmpty(registerCode.getText().toString().trim())){
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    ToastUtil.shotShortToast("注册成功");
                    finish();
                }



            }
        });
        vecodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(registerNum.getText().toString().trim())||registerNum.getText().length()!=11) {
                    ToastUtil.shotShortToast("请输入正确的手机号");
                }else{

                    CountDownTimerUtils countDownTimerUtils = new CountDownTimerUtils(vecodeButton, 60000, 1000);
                    countDownTimerUtils.start();
                }
            }
        });
    }


}

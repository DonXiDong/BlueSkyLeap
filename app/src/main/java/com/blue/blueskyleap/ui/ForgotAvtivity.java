package com.blue.blueskyleap.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blue.blueskyleap.R;
import com.blue.blueskyleap.utils.CountDownTimerUtils;
import com.blue.blueskyleap.utils.ToastUtil;


public class ForgotAvtivity extends AppCompatActivity {

    private Button forButton;
    private TextView titleName;
    private EditText registerName;
    private EditText codeEdit;
    private EditText vodeEdit;
    private String phonenum;
    private String password;
    private String code;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_avtivity);
        initViews();
    }

    private void initViews() {
        forButton = ((Button) findViewById(R.id.btn_vecode_fo));
        titleName = ((TextView) findViewById(R.id.tv_titleName));
        registerName = ((EditText) findViewById(R.id.ed_register_num_fo));
        codeEdit = ((EditText) findViewById(R.id.et_registercode_fo));
        vodeEdit = ((EditText) findViewById(R.id.vecode_fo));
        registerButton = ((Button) findViewById(R.id.btn_fo_register_1));
        phonenum = registerName.getText().toString().trim();
        password = codeEdit.getText().toString().trim();
        code = vodeEdit.getText().toString().trim();
        titleName.setText("更改密码");
        setOnclick();

    }

    private void setOnclick() {
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(phonenum)||TextUtils.isEmpty(password)||TextUtils.isEmpty(code)) {
                    ToastUtil.shotShortToast("请输入手机号或验证码");
                }
                if ( !TextUtils.isEmpty(  registerName.getText().toString().trim() ) && !TextUtils.isEmpty(codeEdit.getText().toString().trim()) && !TextUtils.isEmpty(vodeEdit.getText().toString().trim())) {
                    Intent intent = new Intent(ForgotAvtivity.this, MainActivity.class);
                    startActivity(intent);
                ToastUtil.shotShortToast("更改成功");
                    finish();
                }
            }
        });

        forButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (registerName.getText().length() != 11) {
                    ToastUtil.shotShortToast("请输入正确的手机号");
                } else {
                    CountDownTimerUtils countDownTimerUtils = new CountDownTimerUtils(forButton, 60000, 1000);
                    countDownTimerUtils.start();
                }
            }
        });

    }
}

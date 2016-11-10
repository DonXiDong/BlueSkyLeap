package com.blue.blueskyleap.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blue.blueskyleap.R;
import com.blue.blueskyleap.utils.ToastUtil;

public class MainActivity extends AppCompatActivity {

    private Button loginBtn;
    private EditText phoneEdit;
    private EditText passwordEdit;
    private TextView registerTxt;
    private LinearLayout phoneLayout;
    private LinearLayout passwordLayout;
    private TextView forgot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        loginBtn = (Button) findViewById(R.id.btn_login);
        phoneEdit = ((EditText) findViewById(R.id.et_phone));
        passwordEdit = ((EditText) findViewById(R.id.et_password));
        registerTxt = ((TextView) findViewById(R.id.tv_zc));
        phoneLayout = ((LinearLayout) findViewById(R.id.ll_phonenum));
        passwordLayout = ((LinearLayout) findViewById(R.id.ll_password));
        forgot = ((TextView) findViewById(R.id.tv_forgot));

        phoneEdit.setFocusable(true);
        setOnclick();
    }

    private void setOnclick() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(phoneEdit.getText().toString().trim())||TextUtils.isEmpty(passwordEdit.getText().toString().trim())) {
                    ToastUtil.shotShortToast("请输入手机号或密码");
                }
                if (phoneEdit.getText().length()!=11&&phoneEdit.getText().length()>0) {
                    ToastUtil.shotShortToast("请输入正确的手机号");
                }
                if (!TextUtils.isEmpty(phoneEdit.getText().toString().trim()) && phoneEdit.getText().length()==11 && !TextUtils.isEmpty(passwordEdit.getText())) {
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class );
                    startActivity(intent);
                }





            }
        });
        registerTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class );
                startActivity(intent);
            }
        });
        phoneEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                phoneLayout.setSelected(true);
                passwordLayout.setSelected(false);
                phoneEdit.setFocusable(true);
                phoneLayout.setFocusable(false);
                passwordEdit.setFocusable(false);
            }
        });
        passwordEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordLayout.setSelected(true);
                phoneLayout.setSelected(false);
                passwordLayout.setFocusable(false);
                passwordEdit.setFocusable(true);
                phoneEdit.setFocusable(false);
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ForgotAvtivity.class);
            startActivity(intent);
            }
        });
    }

}

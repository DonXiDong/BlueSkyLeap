package com.blue.blueskyleap.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blue.blueskyleap.R;
import com.blue.blueskyleap.adapter.MyViewPagerAdapter;
import com.blue.blueskyleap.fragment.FirstFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private TextView firstPager;
    private TextView messageText;
    private TextView recordText;
    private LinearLayout linearLayout;
    private List<Fragment> baseFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews();
    }

    private void initViews() {

        viewPager = ((ViewPager) findViewById(R.id.viewpager));
        firstPager = ((TextView) findViewById(R.id.tv_fpager));
        messageText = ((TextView) findViewById(R.id.tv_message));
        recordText = ((TextView) findViewById(R.id.tv_record));
        linearLayout = ((LinearLayout) findViewById(R.id.ll_linearLayout));
        firstPager.setSelected(true);

        setOnclick();
         baseFragments = new ArrayList<>();
        baseFragments.add(FirstFragment.newInstance());
        baseFragments.add(FirstFragment.newInstance());
        baseFragments.add(FirstFragment.newInstance());
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(),baseFragments  );
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    if (i == position) {
                        linearLayout.getChildAt(i).setSelected(true);
                    } else {
                        linearLayout.getChildAt(i).setSelected(false);

                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    private void setOnclick() {
        firstPager.setOnClickListener(this);
        messageText.setOnClickListener(this);
        recordText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_fpager:
                viewPager.setCurrentItem(0);

                break;
            case R.id.tv_record:
                viewPager.setCurrentItem(1);

                break;
            case R.id.tv_message:
                viewPager.setCurrentItem(2);

                break;

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click(); //调用双击退出函数
        }
        return false;
    }

    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            finish();
            System.exit(0);
        }
    }


}

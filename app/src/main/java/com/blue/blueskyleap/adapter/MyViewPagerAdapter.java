package com.blue.blueskyleap.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> datas;
    public MyViewPagerAdapter(FragmentManager fm, List<Fragment> datas) {

        super(fm);
        this.datas = datas;
    }

    @Override
    public Fragment getItem(int position) {
        return datas.get(position);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

}

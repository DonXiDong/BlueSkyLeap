package com.blue.blueskyleap.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blue.blueskyleap.R;

/**
 * Created by Administrator on 2016/11/10.
 */
public class FirstFragment extends  BaseFragment {

    public static FirstFragment newInstance() {
        FirstFragment firstFragment = new FirstFragment();
        return firstFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View  view= inflater.inflate(R.layout.fragment_firsts,container,false);
        return view ;
    }
}

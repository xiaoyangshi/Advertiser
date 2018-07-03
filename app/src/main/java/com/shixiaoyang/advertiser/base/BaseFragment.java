package com.shixiaoyang.advertiser.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by shxioyang on 2018/7/2.
 */

public abstract class BaseFragment extends Fragment{
    public Context mContext;
    private View rootView;
    private Unbinder mUnbinder;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        
        if(rootView==null) {
            rootView = inflater.inflate(getRootViewId(), container, false);
            mUnbinder = ButterKnife.bind(this, rootView);
            initUI();
        }
        initData();
        return rootView;
    }
    
    public View getRootView() {
        return rootView;
    }
    
    public abstract int getRootViewId();
    
    public abstract void initUI();
    
    public abstract void initData();
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null)
            mUnbinder.unbind();
    }
}

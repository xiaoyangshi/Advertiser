package com.shixiaoyang.advertiser.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.SoftReference;

import butterknife.ButterKnife;

/**
 * Created by shxioyang on 2018/7/2.
 */

public class BaseActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        getIntentData();
        initUI();
    }
    public void getIntentData() {
    }
    
    protected void initUI() {
    }
    
    
    
    
    public class MyHandler<T> extends Handler {
        T clazz;
        public MyHandler(T clazz) {
            this.clazz = clazz;
        }
        
        private SoftReference<T> mSoftReference = new SoftReference<T>(clazz);
        
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            T t = mSoftReference.get();
            if (t != null) {
                ((BaseActivity) t).handleMessage(msg);
            }
        }
    }
    
    protected void handleMessage(Message msg) {
    }
}

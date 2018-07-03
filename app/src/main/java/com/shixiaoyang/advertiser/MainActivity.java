package com.shixiaoyang.advertiser;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.shixiaoyang.advertiser.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    
    @BindView(R.id.frame_container)
    FrameLayout mFrameContainer;
    @BindView(R.id.bottom_home)
    RadioButton mBottomHome;
    @BindView(R.id.bottom_info)
    RadioButton mBottomInfo;
    @BindView(R.id.bottom_mine)
    RadioButton mBottomMine;
    @BindView(R.id.rg_buttons)
    RadioGroup mRgButtons;
    @BindView(R.id.activity_main)
    LinearLayout mActivityMain;
    private HomeFragment mHomeFragment;
    private NewsFlashFragment mNewsFlashFragment;
    private MineFragment mMineFragment;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    @Override
    protected void initUI() {
        mRgButtons.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bottom_home:
                        if (mHomeFragment == null) {
                            mHomeFragment = new HomeFragment();
                        }
                        changeFragment(mHomeFragment);
                        break;
                    case R.id.bottom_info:
                        if (mNewsFlashFragment == null) {
                            mNewsFlashFragment = new NewsFlashFragment();
                        }
                        changeFragment(mNewsFlashFragment);
                        break;
                    case R.id.bottom_mine:
                        if (mMineFragment == null) {
                            mMineFragment = new MineFragment();
                        }
                        changeFragment(mMineFragment);
                        break;
                }
            }
        });
    }
    
    public void changeFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_container, fragment);
        ft.commit();
    }
}

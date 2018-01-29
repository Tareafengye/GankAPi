package com.tiantianapp.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.tiantianapp.R;
import com.tiantianapp.base.BaseActivity;
import com.tiantianapp.fragment.CalulatorFragment;
import com.tiantianapp.fragment.HomeTouFragment;
import com.tiantianapp.home.AgentFragment;
import com.tiantianapp.home.HomeFragment;

import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseActivity {
    private BottomNavigationBar bottom_navbar;
    private static int MODE = BottomNavigationBar.MODE_DEFAULT;
    private static int STYLE = BottomNavigationBar.BACKGROUND_STYLE_DEFAULT;
    private FragmentManager fragmentManager;
    private HomeFragment homeFragment;
    private AgentFragment agentFragment;//代理商
    private AgentFragment orderFragment;//订单

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        setTabSelection(0);
        setBarColor(this,112);
        initNavBar();
    }

    @Override
    public void onClick(View view) {

    }
    /**
     * 初始化 BottomNavigationBar
     */
    private void initNavBar() {
        bottom_navbar.clearAll();
        //生成一个标记
        //生成BottomNavigationBar中的每一个item
        BottomNavigationItem item1 = new BottomNavigationItem(R.mipmap.icon_home, "首页");
        BottomNavigationItem item2 = new BottomNavigationItem(R.mipmap.icon_video, "视频");
        BottomNavigationItem item3 = new BottomNavigationItem(R.mipmap.me1, "我的");
        //将item添加到BottomNavigationBar中
        bottom_navbar.addItem(item1);
        bottom_navbar.addItem(item2);
        bottom_navbar.addItem(item3);
        //设置BottomNavigationBar的模式
        bottom_navbar.setMode(MODE);
        //设置背景模式
        bottom_navbar.setBackgroundStyle(STYLE);
        //默认选中项
        bottom_navbar.setFirstSelectedPosition(0);
        //统一设置点击颜色
        bottom_navbar.setActiveColor(R.color.main_color);
        //统一设置未点击颜色
        bottom_navbar.setInActiveColor(R.color.c_5151);
        //统一设置BottomNavigationBar的背景色
        bottom_navbar.setBarBackgroundColor(R.color.white);
        //生成BottomNavigationBar
        bottom_navbar.initialise();
        bottom_navbar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                setTabSelection(position);
            }

            @Override
            public void onTabUnselected(int position) {
            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index 每个tab页对应的下标。0表示消息，1表示联系人，2表示动态，3表示设置。
     */
    @SuppressLint("ResourceAsColor")
    public void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                // 当点击了首页tab时，改变控件的图片和文字颜色
                if (homeFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.content, homeFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                if (agentFragment == null) {
                    // 如果ContactsFragment为空，则创建一个并添加到界面上
                    Intent intent = new Intent("tuandui");
                    sendBroadcast(intent);
                    agentFragment = new AgentFragment();
                    transaction.add(R.id.content, agentFragment);
                } else {
                    // 如果ContactsFragment不为空，则直接将它显示出来
                    transaction.show(agentFragment);
                }
                break;
            case 2:


                if (orderFragment == null) {
                    // 如果SettingFragment为空，则创建一个并添加到界面上
                    orderFragment = new AgentFragment();
                    transaction.add(R.id.content, orderFragment);
                } else {
                    // 如果SettingFragment不为空，则直接将它显示出来
                    transaction.show(orderFragment);
                }
//                }
                break;

            default:

                break;
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (agentFragment != null) {
            transaction.hide(agentFragment);
        }
        if (orderFragment != null) {
            transaction.hide(orderFragment);
        }
    }

    @Override
    public boolean addRxDestroy(Disposable disposable) {
        return false;
    }
}

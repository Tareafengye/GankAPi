package com.tiantianapp.home;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.tiantianapp.R;
import com.tiantianapp.activity.Main2Activity;
import com.tiantianapp.activity.SearchActivity;
import com.tiantianapp.base.BaseFragment;
import com.tiantianapp.fragment.AndroidFragment;
import com.tiantianapp.fragment.HomeTouFragment;
import com.tiantianapp.weight.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

public class HomeFragment extends BaseFragment {
    private TabLayout tablayoutFication;
    private ViewPager viewpager;
    private List<String> mTitle = new ArrayList<>();
    private List<Fragment> mFragment = new ArrayList<>();
    private String title[] = {"福利", "Android", "前端", "休息视频", "瞎推荐"};
    private TextView tv_search;
    private CircleImageView civ;


    @Override
    public int initView() {
        return R.layout.fragment_home;
    }

    @Override
    public void onMyActivityCreated() {
        init();
    }

    public void init() {

        tablayoutFication.setTabGravity(TabLayout.GRAVITY_FILL);
        tablayoutFication.setTabMode(TabLayout.MODE_SCROLLABLE);
        TabAdapter adapter = new TabAdapter(getChildFragmentManager(), title);
        viewpager.setAdapter(adapter);
        tablayoutFication.setupWithViewPager(viewpager);
        tablayoutFication.setTabTextColors(getResources().getColor(R.color.black_dft), getResources().getColor(R.color.main_color));
        tablayoutFication.setSelectedTabIndicatorColor(getResources().getColor(R.color.main_color));
        tablayoutFication.setSelectedTabIndicatorHeight(3);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.civ:
                startActivity(new Intent(getActivity(), Main2Activity.class));
                break;
        }
    }

    @Override
    public boolean addRxDestroy(Disposable disposable) {
        return false;
    }

    public class TabAdapter extends FragmentPagerAdapter {
        String[] title;

        public TabAdapter(FragmentManager fm, String[] title) {
            super(fm);
            this.title = title;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            if (position == 0) {
                fragment = HomeTouFragment.newInstance(title[position]);
            } else {
                fragment = AndroidFragment.newInstance(title[position]);
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}

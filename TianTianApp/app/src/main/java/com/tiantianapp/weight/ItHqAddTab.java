package com.tiantianapp.weight;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * Created by Administrator on 2018/1/4 0004.
 */

public class ItHqAddTab {
    public  static   void addTab(final TabLayout tabLayout, ViewPager viewPager, final List<Fragment> fragment, final List<String> title, FragmentManager fragmentManager){
        /**
         * 预加载
         */
        viewPager.setOffscreenPageLimit(fragment.size());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.setScrollPosition(position, 0, false);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return fragment.get(position);
            }
            @Override
            public int getCount() {
                return fragment.size();
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return title.get(position);
            }
        });
        // TabLayout关联ViewPager
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }
}

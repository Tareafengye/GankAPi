package com.tiantianapp.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.tiantianapp.R;
import com.tiantianapp.base.BaseActivity;
import com.tiantianapp.fragment.AddClassFragment;
import com.tiantianapp.fragment.IncomeClassFragment;
import com.tiantianapp.home.AgentFragment;
import com.tiantianapp.util.KeyboardUtil;
import com.tiantianapp.weight.SyncHorizontalScrollView;

public class AddClassActivity extends BaseActivity {
    public static final String ARGUMENTS_NAME = "arg";
    private RelativeLayout rl_nav;
    private SyncHorizontalScrollView mHsv;
    private RadioGroup rg_nav_content;
    private ImageView iv_nav_indicator;
    private ImageView iv_nav_left;
    private ImageView iv_nav_right;
    private ViewPager mViewPager;
    private int indicatorWidth;
    public static String[] tabTitle = {"支出", "收入", "转账", "借贷"};    //标题
    private LayoutInflater mInflater;
    private TabFragmentPagerAdapter mAdapter;
    private int currentIndicatorLeft = 0;
    private KeyboardUtil keyboardUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        setBarColor(this, 112);
        initView();
        setListener();
        keyboardUtil = new KeyboardUtil(this);
    }

    @Override
    public void onClick(View view) {

    }

    private void setListener() {
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

                if (rg_nav_content != null && rg_nav_content.getChildCount() > position) {
                    ((RadioButton) rg_nav_content.getChildAt(position)).performClick();
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

        rg_nav_content.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (rg_nav_content.getChildAt(checkedId) != null) {

                    TranslateAnimation animation = new TranslateAnimation(
                            currentIndicatorLeft,
                            ((RadioButton) rg_nav_content.getChildAt(checkedId)).getLeft(), 0f, 0f);
                    animation.setInterpolator(new LinearInterpolator());
                    animation.setDuration(100);
                    animation.setFillAfter(true);

                    //执行位移动画
                    iv_nav_indicator.startAnimation(animation);

                    mViewPager.setCurrentItem(checkedId);    //ViewPager 跟随一起 切换

                    //记录当前 下标的距最左侧的 距离
                    currentIndicatorLeft = ((RadioButton) rg_nav_content.getChildAt(checkedId)).getLeft();

                    mHsv.smoothScrollTo(
                            (checkedId > 1 ? ((RadioButton) rg_nav_content.getChildAt(checkedId)).getLeft() : 0) - ((RadioButton) rg_nav_content.getChildAt(2)).getLeft(), 0);
                }
            }
        });
    }

    private void initView() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        indicatorWidth = dm.widthPixels / 4;
        ViewGroup.LayoutParams cursor_Params = iv_nav_indicator.getLayoutParams();
        cursor_Params.width = indicatorWidth;// 初始化滑动下标的宽
        iv_nav_indicator.setLayoutParams(cursor_Params);
        mHsv.setSomeParam(rl_nav, iv_nav_left, iv_nav_right, this);
        //获取布局填充器
        mInflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        //另一种方式获取
        initNavigationHSV();
        mViewPager.setOffscreenPageLimit(0);
        mAdapter = new TabFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
    }

    private void initNavigationHSV() {
        rg_nav_content.removeAllViews();
        for (int i = 0; i < tabTitle.length; i++) {
            RadioButton rb = (RadioButton) mInflater.inflate(R.layout.nav_radiogroup_item, null);
            rb.setId(i);
            rb.setText(tabTitle[i]);
            rb.setLayoutParams(new ViewGroup.LayoutParams(indicatorWidth,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            rg_nav_content.addView(rb);
        }
    }

    public static class TabFragmentPagerAdapter extends FragmentPagerAdapter {

        public TabFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int arg0) {
            Fragment ft = null;
            switch (arg0) {
                case 0:
                    ft = new IncomeClassFragment();
                    break;
                case 1:
                    ft = new AddClassFragment();
                    break;
                default:
                    ft = new AddClassFragment();
                    Bundle args = new Bundle();
                    args.putString(ARGUMENTS_NAME, tabTitle[arg0]);
                    ft.setArguments(args);

                    break;
            }
            return ft;
        }

        @Override
        public int getCount() {
            return tabTitle.length;
        }

    }
}

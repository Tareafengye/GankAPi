package com.tiantianapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.actionsheet.ActionSheet;
import com.tiantianapp.R;
import com.tiantianapp.adapter.SkinAdpater;
import com.tiantianapp.base.BaseActivity;
import com.tiantianapp.model.SkinModel;
import com.tiantianapp.photo.activity.PhotoPickerActivity;
import com.tiantianapp.rxjava.Constant;
import com.tiantianapp.util.LogUtil;
import com.tiantianapp.util.SPUtils;
import com.tiantianapp.weight.MyGradview;

import java.util.ArrayList;
import java.util.List;

public class SkinActivity extends BaseActivity {
    private MyGradview my_gridview;
    private SkinAdpater adpater;
    private List<SkinModel> skinModels = new ArrayList<>();
    SkinModel m = new SkinModel();
    private ImageView back;
    private TextView tv_back;
    private TextView tv_right;
    private boolean iskin = false;
    private boolean is_occk = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin);
        back.setImageResource(R.drawable.icon_clar);
        tv_back.setVisibility(View.GONE);
        setBarColor(this, 112);
        getAdapter(iskin);
        my_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == parent.getChildCount() - 1) {
                    getActionSheet();
                }
            }
        });
    }
    /**
     *
     */
    public void getActionSheet() {
        ActionSheet.createBuilder(SkinActivity.this, getSupportFragmentManager())
                .setCancelButtonTitle("取消")
                .setOtherButtonTitles("热搜小说", "添加本地")
                .setCancelableOnTouchOutside(true)
                .setListener(new ActionSheet.ActionSheetListener() {
                    @Override
                    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {
                    }

                    @Override
                    public void onOtherButtonClick(ActionSheet actionSheet, int index) {
                    }
                })
                .show();
    }

    public void getAdapter(boolean iskin) {
        skinModels.clear();
        for (int i = 0; i < 7; i++) {
            m.setUser_name("颜色");
            skinModels.add(m);
        }
        adpater = new SkinAdpater(skinModels, this, iskin);
        my_gridview.setAdapter(adpater);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                iskin = true;
                if (is_occk) {
                    is_occk = false;
                    iskin = false;
                } else {
                    is_occk = true;
                    iskin = true;
                }
                getAdapter(iskin);
                adpater.notifyDataSetChanged();
                break;
        }
    }
}

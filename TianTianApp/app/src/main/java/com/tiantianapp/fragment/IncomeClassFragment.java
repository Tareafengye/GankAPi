package com.tiantianapp.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.tiantianapp.R;
import com.tiantianapp.base.BaseFragment;

import java.util.HashMap;
import java.util.LinkedHashMap;

import io.reactivex.disposables.Disposable;

public class IncomeClassFragment extends BaseFragment {
    private EditText ed_price;
    private EditText ed_day_text;
    private ImageView iv_netx;
    // 用HashMap存储听写结果
    private HashMap<String, String> mIatResults = new LinkedHashMap<String, String>();

    public IncomeClassFragment() {
    }

    public static IncomeClassFragment newInstance() {
        IncomeClassFragment fragment = new IncomeClassFragment();
        return fragment;
    }

    @Override
    public int initView() {
        return R.layout.fragment_selection_common;

    }

    @Override
    public void onMyActivityCreated() {


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_netx:
                break;
        }
    }


    @Override
    public boolean addRxDestroy(Disposable disposable) {
        return false;
    }
}

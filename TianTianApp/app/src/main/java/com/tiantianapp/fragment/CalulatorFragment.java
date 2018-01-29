package com.tiantianapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.tiantianapp.R;
import com.tiantianapp.activity.CalculatorActivity;
import com.tiantianapp.activity.WebActivity;
import com.tiantianapp.adapter.HomeAdpater;
import com.tiantianapp.base.BaseFragment;
import com.tiantianapp.model.HomeBean;
import com.tiantianapp.rxjava.DefaultObserver;
import com.tiantianapp.rxjava.IdeaApi;
import com.tiantianapp.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CalulatorFragment extends BaseFragment {
    private ImageView back;

    public CalulatorFragment() {
    }

    public static CalulatorFragment newInstance() {
        CalulatorFragment fragment = new CalulatorFragment();
        return fragment;
    }

    @Override
    public int initView() {
        return R.layout.calulator_fragment;

    }

    @Override
    public void onMyActivityCreated() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                startActivity(new Intent(getActivity(), CalculatorActivity.class));
                break;
        }
    }

    @Override
    public boolean addRxDestroy(Disposable disposable) {
        LogUtil.d("disposable" + disposable);
        return false;
    }
}

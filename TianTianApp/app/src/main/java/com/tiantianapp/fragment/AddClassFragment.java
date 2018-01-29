package com.tiantianapp.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tiantianapp.R;
import com.tiantianapp.activity.CalculatorActivity;
import com.tiantianapp.base.BaseFragment;
import com.tiantianapp.util.ByAlert;
import com.tiantianapp.util.KeyboardUtil;
import com.tiantianapp.util.LogUtil;
import com.tiantianapp.weight.NumberKeyboardView;

import io.reactivex.disposables.Disposable;

public class AddClassFragment extends BaseFragment {
    private EditText ed_price;

    public AddClassFragment() {
    }

    public static AddClassFragment newInstance() {
        AddClassFragment fragment = new AddClassFragment();
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
            case R.id.ed_price:
                break;
        }
    }

    @Override
    public boolean addRxDestroy(Disposable disposable) {
        LogUtil.d("disposable" + disposable);
        return false;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}

package com.tiantianapp.home;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tiantianapp.R;
import com.tiantianapp.activity.AddClassActivity;
import com.tiantianapp.activity.SkinActivity;
import com.tiantianapp.base.BaseFragment;
import com.tiantianapp.model.HomeBean;
import com.tiantianapp.rxjava.Constant;
import com.tiantianapp.rxjava.DefaultObserver;
import com.tiantianapp.rxjava.IdeaApi;
import com.tiantianapp.util.LogUtil;
import com.tiantianapp.util.SPUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class AgentFragment extends BaseFragment {
    private TextView tvRememberPen;
    private ImageView iv_skin;

    @Override
    public int initView() {
        return R.layout.fragment_home_app;

    }

    @Override
    public void onMyActivityCreated() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvRememberPen:
                startActivity(new Intent(getActivity(), AddClassActivity.class));
                break;
            case R.id.iv_skin:
                SPUtils.put(getActivity(), null, Constant.DAY_BIAN_JI + "", "");
                startActivity(new Intent(getActivity(), SkinActivity.class));
                break;
        }
    }

    @Override
    public boolean addRxDestroy(Disposable disposable) {
        return false;
    }
}

package com.tiantianapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.tiantianapp.R;
import com.tiantianapp.activity.WebActivity;
import com.tiantianapp.adapter.AndroidAdpater;
import com.tiantianapp.adapter.GankUrlAdpater;
import com.tiantianapp.base.BaseFragment;
import com.tiantianapp.itface.ItemClickListener;
import com.tiantianapp.itface.MulitiTypeSupport;
import com.tiantianapp.model.GankUrlBean;
import com.tiantianapp.rxjava.DefaultObserver;
import com.tiantianapp.rxjava.IdeaApi;
import com.tiantianapp.util.DensityUtils;
import com.tiantianapp.util.LogUtil;
import com.tiantianapp.weight.ScrollLinearLayoutManager;
import com.tiantianapp.weight.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AndroidFragment extends BaseFragment implements MulitiTypeSupport<GankUrlBean.ResultsBean>, XRecyclerView.LoadingListener {
    private static final String ARG_PARAM1 = "param1";
    private String UserName;
    private XRecyclerView recycler;
    private AndroidAdpater adapter;
    private List<GankUrlBean.ResultsBean> list = new ArrayList<>();
    private ImageView back;
    private TextView tv_back;
    private TextView tv_title;
    private ImageView kong_iv;
    private int pgaeNum = 1;
    public AndroidFragment() {
    }
    public static AndroidFragment newInstance(String param1) {
        AndroidFragment fragment = new AndroidFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int initView() {
        return R.layout.fragment_list_home;

    }
    @Override
    public void onMyActivityCreated() {
        UserName = getArguments().getString(ARG_PARAM1);
        LogUtil.d("UserName" + UserName);

        init();
    }

    public void init() {
        getResult(UserName,pgaeNum);
        recycler.setLimitNumberToCallLoadMore(2);
        recycler.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recycler.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        recycler.setArrowImageView(R.drawable.iconfont_downgrey);
        recycler.setLoadingListener(this);
        ScrollLinearLayoutManager scrollLinearLayoutManager = new ScrollLinearLayoutManager(getActivity());
        scrollLinearLayoutManager.setScrollEnabled(true);
        recycler.setLayoutManager(scrollLinearLayoutManager);
        recycler.setHasFixedSize(true);
        recycler.addItemDecoration(new SpaceItemDecoration(getActivity(), SpaceItemDecoration.VERTICAL_LIST, R.drawable.item_love, DensityUtils.dp2px( 0.2f)));
        adapter = new AndroidAdpater(getActivity(), list,this);
        recycler.setAdapter(adapter);
        adapter.setmItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("url", list.get(position).getUrl() + "");
                intent.putExtra("title", list.get(position).getType() + "");
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View v, int position) {
                return false;
            }
        });
    }

    public void getResult(String name,  int pgaeNum) {
        IdeaApi.getApiService().getLogin(name, 10, pgaeNum)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultObserver<GankUrlBean>(this, false) {
                               @Override
                               public void onSuccess(GankUrlBean response) {
                                   if (response.getResults() == null || response.getResults().size() == 0) {
                                       kong_iv.setVisibility(View.VISIBLE);
                                   } else {
                                       kong_iv.setVisibility(View.GONE);
                                   }
                                   list.addAll(response.getResults());
                                   adapter.notifyDataSetChanged();
                               }
                           }
                );
    }

    @Override
    public void onClick(View v) {
    }
    @Override
    public boolean addRxDestroy(Disposable disposable) {
        LogUtil.d("disposable" + disposable);
        return false;
    }

    @Override
    public int getLayoutId(GankUrlBean.ResultsBean item) {
        return R.layout.item_android;
    }

    @Override
    public void onRefresh() {
        pgaeNum = 1;
        getResult(UserName,pgaeNum);
        recycler.refreshComplete();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMore() {
        pgaeNum ++;
        getResult(UserName,pgaeNum);
        recycler.loadMoreComplete();
        adapter.notifyDataSetChanged();
    }
}

package com.tiantianapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tiantianapp.R;
import com.tiantianapp.app.App;
import com.tiantianapp.baseadapter.RecyclerCommonAdapter;
import com.tiantianapp.houder.ViewHolders;
import com.tiantianapp.itface.LoaderListener;
import com.tiantianapp.itface.MulitiTypeSupport;
import com.tiantianapp.model.GankUrlBean;
import com.tiantianapp.model.HomeBean;
import com.tiantianapp.util.FitPopupUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class GankUrlAdpater<T> extends RecyclerCommonAdapter<GankUrlBean.ResultsBean> {
    Context mContext;
    public GankUrlAdpater(Context context, List<GankUrlBean.ResultsBean> mDatas, MulitiTypeSupport<GankUrlBean.ResultsBean> typeSupport) {
        super(context, mDatas, typeSupport);
        this.mContext = context;
    }

    @Override
    protected void convert(ViewHolders holder, GankUrlBean.ResultsBean item, int position) {
        ImageView gank_iv = holder.getView(R.id.gank_iv);


        Glide.with(mContext).load(item.getUrl()).into(gank_iv);
    }
}

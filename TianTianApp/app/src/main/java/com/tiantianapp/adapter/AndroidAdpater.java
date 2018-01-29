package com.tiantianapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tiantianapp.R;
import com.tiantianapp.baseadapter.RecyclerCommonAdapter;
import com.tiantianapp.houder.ViewHolders;
import com.tiantianapp.itface.LoaderListener;
import com.tiantianapp.itface.MulitiTypeSupport;
import com.tiantianapp.model.GankUrlBean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class AndroidAdpater<T> extends RecyclerCommonAdapter<GankUrlBean.ResultsBean> {
    Context mContext;
    public AndroidAdpater(Context context, List<GankUrlBean.ResultsBean> mDatas, MulitiTypeSupport<GankUrlBean.ResultsBean> typeSupport) {
        super(context, mDatas, typeSupport);
        this.mContext = context;

    }

    @Override
    protected void convert(ViewHolders holder, GankUrlBean.ResultsBean item, int position) {
        holder.setText(R.id.gank_title,item.getDesc());
        holder.setText(R.id.gank_time,item.getCreatedAt());
//        item_gank
    }
}

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
import com.tiantianapp.util.FitPopupUtil;
import com.tiantianapp.itface.LoaderListener;
import com.tiantianapp.model.HomeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class HomeAdpater<T> extends CommonAdapter<HomeBean.ResultBean.DataBean> implements LoaderListener {
    public HomeAdpater(Context context, List<HomeBean.ResultBean.DataBean> mDatas) {
        super(context, mDatas);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent,
                R.layout.re_item_home, position);
        ImageView iv_leift = holder.getView(R.id.iv_leift);
        ImageView iv_center = holder.getView(R.id.iv_center);
        ImageView iv_right = holder.getView(R.id.iv_right);
        ImageView iv_top = holder.getView(R.id.iv_top);
        LinearLayout rught_llt = holder.getView(R.id.rught_llt);
        RelativeLayout leift_lat = holder.getView(R.id.leift_lat);
        TextView tv_home_title = holder.getView(R.id.tv_home_title);
        TextView tv_coument = holder.getView(R.id.tv_coument);
        TextView tv_laiyuan = holder.getView(R.id.tv_laiyuan);
        TextView tv_delete = holder.getView(R.id.tv_delete);
        TextView tv_zhiding = holder.getView(R.id.tv_zhiding);//置顶
        String str1 = mDatas.get(position).getThumbnail_pic_s();
        String str2 = mDatas.get(position).getThumbnail_pic_s02();
        String str3 = mDatas.get(position).getThumbnail_pic_s03();
        tv_coument.setText(mDatas.get(position).getTitle() + "");
        tv_home_title.setText(mDatas.get(position).getTitle() + "");
        tv_laiyuan.setText(mDatas.get(position).getDate() + "\t\t\t来源:" + mDatas.get(position).getAuthor_name());
        if (position == 0) {
            tv_zhiding.setVisibility(View.VISIBLE);
        } else {
            tv_zhiding.setVisibility(View.GONE);
        }
        //判断第二张图片与第三张图片是否为null，为空则显示不同的布局页面
        if (TextUtils.isEmpty(str2)) {
            leift_lat.setVisibility(View.VISIBLE);
            rught_llt.setVisibility(View.GONE);
            Glide.with(mContext).load(str1).into(iv_top);
            tv_home_title.setVisibility(View.GONE);
        } else if (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2)) {
            leift_lat.setVisibility(View.GONE);
            rught_llt.setVisibility(View.VISIBLE);
            tv_home_title.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(str1).into(iv_leift);
            Glide.with(mContext).load(str2).into(iv_center);
            Glide.with(mContext).load(str3).into(iv_right);
        }
        tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FitPopupUtil fitPopupUtil = new FitPopupUtil((Activity) mContext);
                fitPopupUtil.setOnClickListener(new FitPopupUtil.OnCommitClickListener() {
                    @Override
                    public void onClick(String reason) {
                        Toast.makeText(mContext, reason, Toast.LENGTH_SHORT).show();
                    }
                });
                fitPopupUtil.showPopup(v);
            }
        });
        return holder.getConvertView();
    }

    @Override
    public void onSuccess() {
    }

    @Override
    public void onError() {
    }
}

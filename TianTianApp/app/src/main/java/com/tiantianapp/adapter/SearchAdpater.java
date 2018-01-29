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
import com.tiantianapp.itface.LoaderListener;
import com.tiantianapp.model.CoordinateAlterSample;
import com.tiantianapp.model.HomeBean;
import com.tiantianapp.util.ByAlert;
import com.tiantianapp.util.FitPopupUtil;
import com.tiantianapp.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class SearchAdpater<T> extends CommonAdapter<CoordinateAlterSample> {
    public SearchAdpater(Context context, List<CoordinateAlterSample> mDatas) {
        super(context, mDatas);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent,
                R.layout.item_search, position);
        TextView textView = holder.getView(R.id.tv_item_search);
        ImageView iv_cler = holder.getView(R.id.iv_cler);
        textView.setText(mDatas.get(position).getName() + "");
        iv_cler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mOnItemDeleteListener.onDeleteExpress(position, view);
                }catch (Exception e){}

            }
        });
        return holder.getConvertView();
    }

    private DeleteExpress mOnItemDeleteListener;

    public void setOnItemDeleteClickListener(DeleteExpress mOnItemDeleteListener) {
        this.mOnItemDeleteListener = mOnItemDeleteListener;
    }
    public interface DeleteExpress {
        //删除
        void onDeleteExpress(int position, View view);

    }

}

package com.tiantianapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tiantianapp.R;
import com.tiantianapp.model.SkinModel;
import com.tiantianapp.view.RoundAngleImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/12 0012.
 */

public class SkinAdpater extends BaseAdapter {
    List<SkinModel> list = new ArrayList<>();
    private Context mContext;
    private boolean skin;

    public SkinAdpater(List<SkinModel> list, Context mContext, boolean skin) {
        this.list = list;
        this.mContext = mContext;
        this.skin = skin;
    }

    @Override
    public int getCount() {
        return list.size() + 1;
    }


    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHouder houder;
        if (convertView == null) {
            houder = new ViewHouder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.skin_item, null);
            houder.imageView = (RoundAngleImageView) convertView.findViewById(R.id.c_xx_view);
            houder.tv_day_name = (TextView) convertView.findViewById(R.id.tv_day_name);
            houder.iv_bianji = (ImageView) convertView.findViewById(R.id.iv_bianji);
            convertView.setTag(houder);
        } else {
            houder = (ViewHouder) convertView.getTag();
        }
        if (skin == true) {
            houder.iv_bianji.setVisibility(View.VISIBLE);
        } else {
            houder.iv_bianji.setVisibility(View.GONE);
        }
        if (position < list.size()) {
            houder.imageView.setImageResource(R.drawable.bac);
            houder.tv_day_name.setText(list.get(position).getUser_name());
        } else {
            houder.tv_day_name.setText("");
            houder.imageView.setBackgroundColor(R.color.c_5151);
            houder.imageView.setImageResource(R.drawable.layerlist);
            houder.iv_bianji.setVisibility(View.GONE);
        }
        return convertView;
    }

    public class ViewHouder {
        private RoundAngleImageView imageView;
        private TextView tv_day_name;
        private ImageView iv_bianji;
    }
}

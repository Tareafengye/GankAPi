package com.tiantianapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tiantianapp.R;
import com.tiantianapp.model.GankUrlBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/26 0026.
 */

public class StaggeredRecyclerAdapter extends RecyclerView.Adapter<StaggeredRecyclerAdapter.MyViewHolder> {

    private LayoutInflater mInflate;
    private Context mContext;
    private List<GankUrlBean.ResultsBean> mData;
    private List<Integer> mHeigh;
    public StaggeredRecyclerAdapter(Context context, LayoutInflater mInflate, List<GankUrlBean.ResultsBean> mData) {
        this.mContext=context;
        this.mInflate = mInflate;
        this.mData = mData;
        //创建mHeigh
        mHeigh=new ArrayList<>();
        //为mHeigh赋值，后面用于设置高度
        for(int i=0;i<mData.size();i++){
            mHeigh.add((int)(80+Math.random()*100));
        }
    }

    /**
     *
     * @param viewGroup 父布局 RecyclerView
     * @param i 相当于position
     * @return ViewHolder
     */
    @Override
    public StaggeredRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view=mInflate.inflate(R.layout.item_gank,viewGroup,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);



        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(StaggeredRecyclerAdapter.MyViewHolder myViewHolder, int position   ) {
        //获得布局参数
        ViewGroup.LayoutParams lp=myViewHolder.itemView.getLayoutParams();
        //设置高度  lp.height=mHeigh.get(position)+myViewHolder.itemView.getHeight();
        //设置参数，使得每个子view的高度都不相同
        myViewHolder.itemView.setLayoutParams(lp);
        Glide.with(mContext).load(mData.get(position).getUrl()).into(myViewHolder.mImageview);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    /**
     * MyViewHolder中获得子布局中的view
     */
    class MyViewHolder extends RecyclerView.ViewHolder{


        ImageView mImageview;
        public MyViewHolder(View itemView) {
            super(itemView);

            mImageview= (ImageView) itemView.findViewById(R.id.gank_iv);
        }
    }
}

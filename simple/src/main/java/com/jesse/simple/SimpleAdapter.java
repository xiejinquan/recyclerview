package com.jesse.simple;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * 作者：jesse
 * 创建时间：2016 2016/1/19 17:53
 * 联系邮箱：774202859@qq.com
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleHolder> {
    private Context mContext;
    private int mResID;
    private List<Data> mDatas;

    public SimpleAdapter(Context mContext, int mResID,  List<Data> mDatas) {
        this.mContext = mContext;
        this.mResID = mResID;
        this.mDatas = mDatas;
    }

    @Override
    public SimpleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(mResID,parent,false);
        return new SimpleHolder(view);//加载item的布局
    }

    @Override
    public void onBindViewHolder(final SimpleHolder holder, int position) {
        //item的单击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    int layoutPosition = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, layoutPosition);
                }
            }
        });
        //设置item的子view设置数据
        holder.tv_name.setText(mDatas.get(position).getName());
        holder.tv_title.setText(mDatas.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mDatas==null?0:mDatas.size();
    }

    public class SimpleHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_title;
        public SimpleHolder(View itemView) {
            super(itemView);
            //初始化id
            tv_name= (TextView) itemView.findViewById(R.id.tv_name);
            tv_title= (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public void addData(int pos, Data t) {
        mDatas.add(pos, t);
//        notifyDataSetChanged();
        notifyItemInserted(pos);
    }

    public void addData(Data t) {
        mDatas.add(t);
        notifyDataSetChanged();
    }

    public void removeData(int pos) {
        mDatas.remove(pos);
//        notifyDataSetChanged();
        notifyItemRemoved(pos);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

}

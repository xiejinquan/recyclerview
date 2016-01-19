package com.jesse.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;


public class JesseHolder extends RecyclerView.ViewHolder {

    private final SparseArray<View> mViews;
    private View mItemView;

    public JesseHolder(View mItemView) {
        super(mItemView);
        this.mItemView = mItemView;
        this.mViews = new SparseArray<View>();
    }

    public View getItemView() {
        return mItemView;
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mItemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }
}

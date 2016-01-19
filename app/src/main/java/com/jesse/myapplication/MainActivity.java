package com.jesse.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.jesse.recyclerview.JesseAdapter;
import com.jesse.recyclerview.JesseHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：jesse
 * 创建时间：2016 2016/1/19 12:21
 * 联系邮箱：774202859@qq.com
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        assignViews();
        initRecyclerview();
    }

    private JesseAdapter<Data> mAdapter;

    /**
         * 设置Recyclerview
         */
    private void initRecyclerview() {
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mAdapter=new JesseAdapter<Data>(this,R.layout.item_data,mDatas) {
            @Override
            public void onBindView(JesseHolder holder, int position) {
                TextView tv_name=holder.getView(R.id.tv_name);
                tv_name.setText(mDatas.get(position).getName());
                TextView tv_title=holder.getView(R.id.tv_title);
                tv_title.setText(mDatas.get(position).getTitle());
            }
        };
        mRecyclerview.setAdapter(mAdapter);
    }

    private List<Data> mDatas;

    /**
     * 初始化数据
     */
    private void initDatas() {
        mDatas=new ArrayList<>();
        for (int i=0;i<10;i++){
            mDatas.add(new Data("jesse"+i,"title"+i));
        }
    }

    private RecyclerView mRecyclerview;

    /**
     * 初始化布局的id
     */
    private void assignViews() {
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
    }

}

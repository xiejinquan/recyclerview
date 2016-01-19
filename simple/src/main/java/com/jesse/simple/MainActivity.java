package com.jesse.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        assignViews();
        initRecyclerview();
    }

    private SimpleAdapter mAdapter;
    private void initRecyclerview() {
        //设置mRecyclerview的item向下排列
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mAdapter=new SimpleAdapter(this,R.layout.item_data,mDatas);
        mRecyclerview.setAdapter(mAdapter);
        //设置mRecyclerview的item单击事件
        mAdapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,"toast"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<Data> mDatas;
    //初始化数据
    private void initDatas() {
        mDatas=new ArrayList<>();
        for (int i=0;i<10;i++){
            mDatas.add(new Data("jesse"+i,"title"+i));
        }
    }

    private RecyclerView mRecyclerview;
    //初始化布局id
    private void assignViews() {
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
    }

}

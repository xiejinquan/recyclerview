# recyclerview
这是一个recyclerview的Adapter帮助类


## 用法

* Android Studio

	使用前，对于Android Studio的用户，可以选择添加:

	```
	compile project(':recyclerview')
	```
	
	或者
	
	```
	compile 'com.jesse.recyclerview:recyclerview:23.1.1'
	```
	
* Eclipse
	
	自行copy源码。


##用法示例

在oncreate调用initRecyclerview();

```java
    private JesseAdapter<Data> mAdapter;

    /**
     * 设置Recyclerview
     */
    private void initRecyclerview() {
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mAdapter=new JesseAdapter<Data>(this,R.layout.item_data,mDatas) {
            @Override
            public void onBindView(JesseHolder holder, int position) {
            	//根据id获取view
                TextView tv_name=holder.getView(R.id.tv_name);
                //对view设值
                tv_name.setText(mDatas.get(position).getName());
                TextView tv_title=holder.getView(R.id.tv_title);
                tv_title.setText(mDatas.get(position).getTitle());
            }
        };
        mRecyclerview.setAdapter(mAdapter);
    }
```

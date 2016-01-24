# recyclerview
这是一个recyclerview的Adapter万能适配类，帮助开发者减少写Adapter类

##博客地址：http://blog.csdn.net/xiejinquan_


## 注意
* 这个包已经包含compile 'com.android.support:recyclerview-v7:23.1.1'
* 使用时候不用引入compile 'com.android.support:recyclerview-v7:23.1.1'


## 用法

* Android Studio

	使用前，对于Android Studio的用户，在module的build.gradle添加:
	
	```
	dependencies {
    	  compile fileTree(dir: 'libs', include: ['*.jar'])
    	  testCompile 'junit:junit:4.12'
    	  compile 'com.android.support:appcompat-v7:23.1.1'
    	  
    	  compile 'com.jesse.recyclerview:recyclerview:23.1.1'//引入recyclerview包
	}
	```
	
* Eclipse
	
	自行copy源码。


##用法示例

在Activity类的oncreate()方法里面调用initRecyclerview();

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
        
        /**
         * item的单击事件
         */
        mAdapter.setOnItemClickListener(new JesseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "toast" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
```

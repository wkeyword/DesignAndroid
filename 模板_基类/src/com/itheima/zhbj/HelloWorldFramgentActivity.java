package com.itheima.zhbj;

import android.os.Bundle;
import android.util.Log;

//集合
public class HelloWorldFramgentActivity extends BaseFragmentActivity{
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_hello_fragment);
		//添元素到集合
//		ImageFragment img=new ImageFragment();
//		add(R.id.layout_root, img, "ImageFragment");
		MainFramgnet img=new MainFramgnet();
		add(R.id.layout_root, img, "ImageFragment");
//		ImageFragment f=(ImageFragment) find("ImageFragment");
//		Log.i("wzx", f+"");
	}
}

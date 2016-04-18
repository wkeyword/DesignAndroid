package com.itheima.zhbj;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private List<NewInfo> list = new ArrayList<NewInfo>();

	private ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview=(ListView) findViewById(R.id.listview);
		// ①　创建Activity
		// ②　布局 listview
		for (int i = 0; i < 20; i++) {
			NewInfo info = new NewInfo();
			info.id = i + "";
			info.title = i + "标题";
			list.add(info);
		}
		// ③　初始化集合
		// ④　创建 内容
	
		// ⑤　设置给适配器
		listview.setAdapter(new NewAdapter());
	}
	//以后 如果碰到 一个知识点  使用了适配器设计模式
	//掌握适配器方法的含义
	private class NewAdapter extends BaseAdapter
	{

		//返回行数
		@Override
		public int getCount() {
			return list.size();
		}

		//返回指定下标的实例
		@Override
		public Object getItem(int position) {
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		//返回  行视图  显示指定下标的数据
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view=View.inflate(getBaseContext(), R.layout.item_listview_new, null);
		
			return view;
		}
		
	}

}

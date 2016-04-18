package com.itheima.zhbj;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private List<NewInfo> list = new ArrayList<NewInfo>();
	private ListView listview;

	//0-->1 -->2 -->3
	public void add(View view)
	{
		NewInfo info = new NewInfo();
		info.id = System.currentTimeMillis()+"";
		info.title =info.id+ "标题";
		list.add(info);
		adapter.notifyDataSetChanged();//给列表 发信号   内容改变
	}
	NewAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview = (ListView) findViewById(R.id.listview);
		// ①　创建Activity
		// ②　布局 listview
//		for (int i = 0; i < 20; i++) {
//			NewInfo info = new NewInfo();
//			info.id = i + "";
//			info.title = i + "标题";
//			list.add(info);
//		}
		// ③　初始化集合
		// ④　创建 内容
		 adapter = new NewAdapter(list);
		// ⑤　设置给适配器
		listview.setAdapter(adapter);
	}

	// 以后 如果碰到 一个知识点 使用了适配器设计模式
	// 掌握适配器方法的含义
	private class NewAdapter extends HMAdpater<NewInfo> {
		public NewAdapter(List<NewInfo> list) {
			super(list);
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view=View.inflate(getBaseContext(), R.layout.item_listview_new, null);
			
			NewInfo info=list.get(position);
			TextView title=(TextView) view.findViewById(R.id.title);
			title.setText(info.title);
			return view;
		}

	}

}

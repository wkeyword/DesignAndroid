package com.itheima.zhbj;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private GridView mGridView;
	private List<TypeInfo> list = new ArrayList<TypeInfo>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mGridView = (GridView) findViewById(R.id.gridview);
		// ①　布局GridView 3列
		// ②　初始化集合 真实项目：访问网络解析json
		for (int i = 0; i < 13; i++) {
			TypeInfo info = new TypeInfo();
			info.name = "频道" + i;
			list.add(info);
		}
		// ③　创建 内容
		TypeAdapter adapter = new TypeAdapter();
		mGridView.setAdapter(adapter);
	}

	private class TypeAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		//返回格式视图
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view=View.inflate(getBaseContext(), R.layout.item_gridview_new, null);
			TextView name=(TextView) view.findViewById(R.id.name);
			String nameStr=list.get(position).name;
			name.setText(nameStr);
			return view;
		}

	}

}

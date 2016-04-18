package com.itheima.zhbj;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public abstract class  BaseFragment extends Fragment {

	// 标题可以快速控制
	private ImageButton left;
	private ImageButton right;
	private TextView title;

	protected void setTile(String titleStr) {
		if (title != null) {
			title.setText(titleStr);
		}
	}
	protected void showLeft(int resId) {
		if (left != null) {
			left.setImageResource(resId);
			left.setVisibility(View.VISIBLE);
		}
	}
	protected void showRight(int resId) {
		if (right != null) {
			right.setImageResource(resId);
			right.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// return super.onCreateView(inflater, container, savedInstanceState);
		
		//1.思考 哪部是变化 的？ Alt+Shift+M
		//2.抽象 
		View view = initView();
		left = (ImageButton) view.findViewById(R.id.left);
		right = (ImageButton) view.findViewById(R.id.right);
		title = (TextView) view.findViewById(R.id.title);
		initTitle();
		return view;
	}
	public abstract View initView();
	public abstract void initTitle();
}

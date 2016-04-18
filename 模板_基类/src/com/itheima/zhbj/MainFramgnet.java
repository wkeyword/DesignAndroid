package com.itheima.zhbj;

import android.view.View;

public class MainFramgnet extends BaseFragment{

	@Override
	public View initView() {
		View view=View.inflate(getActivity(), R.layout.fragment_main, null);
		return view;
	}

	@Override
	public void initTitle() {
		setTile("智慧北京");
		showRight(R.drawable.search);
	}

}

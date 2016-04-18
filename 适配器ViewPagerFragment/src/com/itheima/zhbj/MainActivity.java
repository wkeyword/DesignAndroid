package com.itheima.zhbj;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

//android.support.v4.app.FragmentActivity
public class MainActivity extends FragmentActivity {
	private ViewPager viewpager;
	private Button go;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		go = (Button) findViewById(R.id.go);
		// ①　布局ViewPager android-support-v4.jar
		// ②　创建集合 页面View
		ImageViewAdapter adpater = new ImageViewAdapter(getSupportFragmentManager());// Support
																						// Default
																						// 不加getFragmentManager
		// ③　创建内容
		viewpager.setAdapter(adpater);
		// OnPageChangeListener listener = new MyOnPageChangeListener();
		// viewpager.setOnPageChangeListener(listener);
	}
	// PagerAdapter 显示的是View
	// |--FragmentPagerAdapter 显示的是Fragment
	private class ImageViewAdapter extends FragmentPagerAdapter {
		private List<ImageFragment> fragments = new ArrayList<ImageFragment>();
		// android.support.v4.app.FragmentManager 对Framgent进行增删改查
		public ImageViewAdapter(FragmentManager fm) {
			super(fm);
			fragments.add(new ImageFragment(R.drawable.guide_1));
			fragments.add(new ImageFragment(R.drawable.guide_2));
			fragments.add(new ImageFragment(R.drawable.guide_3));
		}
		//返回片段
		@Override
		public Fragment getItem(int arg0) {
			return fragments.get(arg0);
		}

		//返回页数据
		@Override
		public int getCount() {
			return fragments.size();
		}

	}

	@SuppressLint("ValidFragment")
	private class ImageFragment extends Fragment {

		int imgId=0;
		
		public ImageFragment(int imgId) {
			super();
			this.imgId = imgId;
		}

		// 返回片段的视图
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			// return super.onCreateView(inflater, container,
			// savedInstanceState);
			View view = View.inflate(getBaseContext(), R.layout.fragment_img, null);
			ImageView imgView=(ImageView) view.findViewById(R.id.img);
			imgView.setBackgroundResource(imgId);
			return view;
		}
	}

	// Activity 1.继承Activity 2.布局layout 3.重写onCreate 4.配置 5.Intent打开
	// Fragment 1.继承Fragment 2.布局layout 3.重写onCreateView
}

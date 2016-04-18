package com.itheima.zhbj;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
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
		ImageViewAdapter adpater = new ImageViewAdapter();
		// ③　创建内容
		viewpager.setAdapter(adpater);
		OnPageChangeListener listener = new MyOnPageChangeListener();
		viewpager.setOnPageChangeListener(listener);
	}

	private class MyOnPageChangeListener implements OnPageChangeListener {
		// 监听当前显示第几页
		@Override
		public void onPageSelected(int position) {

			if (position == 2) {
				go.setVisibility(View.VISIBLE);
			} else {
				go.setVisibility(View.INVISIBLE);
			}
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

	}

	// Button OnClickListener
	// ViewPager OnPageChangedListener On....Listener
	// 小说 跟踪 监视
	private class ImageViewAdapter extends PagerAdapter {

		int[] imgsId = new int[] { R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3 };

		public ImageViewAdapter() {

		}

		@Override
		public int getCount() {
			return imgsId.length;
		}

		// instantiate:init create
		// ViewGroup container ViewPager
		@Override
		public Object instantiateItem(ViewGroup container, int position) {// 0 1
			// TODO Auto-generated method stub
			// super.instantiateItem(container, position);//一定不要调 抛出异常
			ImageView img = new ImageView(getBaseContext());
			img.setBackgroundResource(imgsId[position]);
			container.addView(img);// 代码添加控件
			return img;
		}
		// 移除显示
		// Object object视图
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			// super.destroyItem(container, position, object);//一定不要调 抛出异常
			container.removeView((View) object);
		}

		// 官方要求
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

	}

}

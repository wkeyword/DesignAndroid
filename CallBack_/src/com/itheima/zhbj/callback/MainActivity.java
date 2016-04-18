package com.itheima.zhbj.callback;

import java.util.Arrays;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.itheima.zhbj.BaseFragmentActivity;
import com.itheima.zhbj.R;

public class MainActivity extends BaseFragmentActivity {

	private ProgressBar progressbar;
	private ProgressBar progressBarH;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);
		progressbar=(ProgressBar) findViewById(R.id.progressbar);
		progressBarH=(ProgressBar) findViewById(R.id.progressBarH);
	}

	public void start(View view) {
		WebView webview = (WebView) findViewById(R.id.webview);
//		webview.loadUrl("http://www.baidu.com");
//		webview.loadUrl("http://www.itheima.com");
		webview.loadUrl("http://www.itcast.cn");
		// WebChromeClient:提供进度变化的回调函数
		WebChromeClient client1 = new HMWebChromeClient();
		webview.setWebChromeClient(client1);
		//WebViewClient 1.蔽屏自带浏览器的打开 2.有页面载入开始 与结束回调函数
		WebViewClient client2 = new HMWebViewClient();
		webview.setWebViewClient(client2);
	}

	private class HMWebViewClient extends WebViewClient {

		// 2M 0M 0.1M--->2M
		// 当载入内容为0
		//实际项目用来控制 等待视图
		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
			// 重写
			progressbar.setVisibility(View.VISIBLE);
		}

		// 当载入内容为100%
		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);
			progressbar.setVisibility(View.INVISIBLE);
		}

	}

	private class HMWebChromeClient extends WebChromeClient {
		//2M  0M--1M--2M
		//条件:载入网页进度变化时调用
		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			super.onProgressChanged(view, newProgress);
			Log.i("wzx", "newProgress="+newProgress);
			if(newProgress==100)
			{
				progressBarH.setVisibility(View.GONE);
			}else
			{
				progressBarH.setVisibility(View.VISIBLE);
				progressBarH.setProgress(newProgress);
			}
		}
	}

	// 1.on..2.开发者实现 3.系统调用
	// 条件 :点击物理键盘或者软件盘
	// int keyCode按键编号
	long[] times = new long[2];

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Log.i("wzx", "KEYCODE_BACK 我点返回键");
			// ①　找出回调函数
			// ②　点击时间 time1 time2
			// ③　时间 间隔 <2000 退出
			// ④　提示再点一次
			times[0] = times[1];
			times[1] = System.currentTimeMillis();
			Log.i("wzx", Arrays.toString(times));
			if (times[1] - times[0] < 2000) {
				finish();
			} else {
				Toast.makeText(getBaseContext(), "再点一次退出", 0).show();
			}
			return true;// 消费事件
		}

		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}

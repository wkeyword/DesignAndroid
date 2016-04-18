package com.itheima.zhbj.http;

import java.io.File;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.itheima.zhbj.BaseFragmentActivity;
import com.itheima.zhbj.R;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class HttpActivity extends BaseFragmentActivity {
	private TextView result = null;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_http);
		result = (TextView) findViewById(R.id.result);
	}

	public void get(View view) {
		String url = "http://192.168.32.10:8080/web/";
		// 创建HttpUtils 3~5
		HttpUtils http = new HttpUtils(5000);
		// 向服务器发送请求
		RequestCallBack<String> callBack = new MyRequestCallBack();
		http.send(HttpMethod.GET, url, callBack);
	}
	public void post(View view) {
		String url = "http://192.168.32.10:8080/web/LoginServlet";
		// 创建HttpUtils 3~5
		HttpUtils http = new HttpUtils(5000);
		// 向服务器发送请求
		RequestCallBack<String> callBack = new MyRequestCallBack();
		// 实际项目中 评论 登录 注册都 是使用post
		RequestParams form = new RequestParams();
		// xutils处理了中文问题
		form.addBodyParameter("username", "中国xxx");
		form.addBodyParameter("password", "日本000");
		// RequestParams一个Map集合 表单
		http.send(HttpMethod.POST, url, form, callBack);
	}
	public void upload(View view) {
		String url = "http://192.168.32.10:8080/web/UploadFileServlet";
		// 创建HttpUtils 3~5
		HttpUtils http = new HttpUtils(5000);
		// 向服务器发送请求
		RequestCallBack<String> callBack = new MyRequestCallBack();
		// 实际项目中 评论 登录 注册都 是使用post
		RequestParams form = new RequestParams();
		// xutils处理了中文问题
		File file=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/im.db");
		form.addBodyParameter("formfile", file);
		// RequestParams一个Map集合 表单
		http.send(HttpMethod.POST, url, form, callBack);
	}
	// 微信 QQ 上传头像 
	// 陌陌 自拍照
	private class MyRequestCallBack extends RequestCallBack<String> {
		// 条件:失败 服务器 打开飞行模式
		@Override
		public void onFailure(HttpException arg0, String arg1) {
		}
		// 成功 200
		@Override
		public void onSuccess(ResponseInfo<String> arg0) {
			Log.i("wzx", "onSuccess--" + arg0.result);
			result.setText(arg0.result);
		}

	}
}

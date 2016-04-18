package com.itheima.xutils;

import java.io.File;

import android.app.Activity;
import android.app.DownloadManager.Request;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void get(View view) {
		// ①　添加jar 确认已经加到Buildpath
		// ②　配置权限
		// ③　发送请求
		HttpUtils utils = new HttpUtils(5000);
		RequestCallBack<String> call = new RequestCallBack<String>() {
			@Override
			public void onSuccess(ResponseInfo<String> ri) {
				Log.i("wzx", "onSuccess---" + ri.result);
			}

			@Override
			public void onFailure(HttpException e, String arg1) {
				Log.i("wzx", "onSuccess---" + e.getMessage());
			}
		};
		utils.send(HttpMethod.GET, "http://www.baidu.com", call);
		// ④　接收响应数据
	}

	public void post(View view) {
		HttpUtils utils = new HttpUtils(5000);
		RequestParams rp = new RequestParams("utf-8");
		rp.addBodyParameter("username", "中国");
		rp.addBodyParameter("password", "中国2");
		RequestCallBack<String> call = new RequestCallBack<String>() {
			@Override
			public void onSuccess(ResponseInfo<String> ri) {
				Log.i("wzx", "onSuccess---" + ri.result);
			}

			@Override
			public void onFailure(HttpException e, String arg1) {
				Log.i("wzx", "onFailure---" + e.getMessage());
			}
		};
		utils.send(HttpMethod.POST, "http://192.168.1.100:8080/web/LoginServlet", rp, call);
	}

	public void upload(View view) {
		HttpUtils utils = new HttpUtils(5000);
		RequestParams rp = new RequestParams("utf-8");
		rp.addBodyParameter("filename", "中国");
		rp.addBodyParameter("filedes", "中国2");
		File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/2015.log");
		rp.addBodyParameter("formfile", file);
		RequestCallBack<String> call = new RequestCallBack<String>() {
			@Override
			public void onSuccess(ResponseInfo<String> ri) {
				Log.i("wzx", "onSuccess---" + ri.result);
			}

			@Override
			public void onFailure(HttpException e, String arg1) {
				Log.i("wzx", "onFailure---" + e.getMessage());
			}
		};
		utils.send(HttpMethod.POST, "http://192.168.1.100:8080/web/UploadFileServlet", rp, call);
	}

}

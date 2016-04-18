package observer;

import android.content.ContentUris;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.itheima.zhbj.BaseFragmentActivity;
import com.itheima.zhbj.R;

public class TestActivity extends BaseFragmentActivity {
	Db db = null;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		db = new Db(this);
		setContentView(R.layout.activity_test);

		//创建观察者
		 observer = new MyContentObserver(new Handler());
		
		//Uri uri=Uri.parse("content://account/add/1);
		//Uri uri=Uri.parse("content://account/add/2);
		Uri uri=Uri.parse("content://account/add");
		//Descendents 子孙
		//notifyForDescendents  是否通知子路径
		getContentResolver().registerContentObserver(uri, true, observer);
	}
	ContentObserver observer;
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		getContentResolver().unregisterContentObserver(observer);
	}

	private class MyContentObserver extends ContentObserver {

		public MyContentObserver(Handler handler) {
			super(handler);
		}
//		//条件：接收信号  低版本 2.2
//		@Override
//		public void onChange(boolean selfChange) {
//		}
		//条件：接收信号  高版本  4.3
		@Override
		public void onChange(boolean selfChange, Uri uri) {
			Log.i("wzx", uri.toString());
			//10-07 09:17:55.852: I/wzx(21719): content://account/add/1100464397
			long id=ContentUris.parseId(uri);
			//通知 有人在修改数据
			Toast.makeText(getBaseContext(), "有 人创建新账号:"+id, 0).show();
		}

	}

	public void createAccount(View view) {
		Account account = new Account();
		account.id = (int) System.currentTimeMillis();
		account.accountName = "默认" + account.id;
		account.money = 0;
		db.add(account);
	}
}

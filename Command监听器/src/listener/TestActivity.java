package listener;

import listener.MyButton.OnHmClickListener;
import android.os.Bundle;
import android.util.Log;

import com.itheima.zhbj.BaseFragmentActivity;
import com.itheima.zhbj.R;

public class TestActivity extends BaseFragmentActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_test);
		MyButton mybutton = (MyButton) findViewById(R.id.mybutton);
		OnHmClickListener listener = new MyOnHmClickListener();
		mybutton.setOnHmClickListener(listener);
	}
	private class MyOnHmClickListener implements OnHmClickListener {
		@Override
		public void onHmClick() {
			// Log.i("wzx", "1000杀毒代码");
			// Log.i("wzx", "2000拨号");
			// Log.i("wzx", "1100卸载 ");
			Log.i("wzx", "100下载 ");
		}

	}
}

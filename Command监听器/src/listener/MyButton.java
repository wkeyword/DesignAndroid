package listener;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

public class MyButton extends Button {
	// .xml
	public MyButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	@Override
	public boolean performClick() {
		Log.i("wzx", "-performClick--");
		// onHmClick();
		if (listener != null) {
			listener.onHmClick();
		}
		// ①　抽取 不可生重用 事件处理代码
		// ②　抽象成接口
		// ③　添加监听器的方法 setOn..Listener
		// ④　内部调用监听器
		return super.performClick();
	}

	private OnHmClickListener listener;

	public void setOnHmClickListener(OnHmClickListener listener) {
		this.listener = listener;
	}

	public static interface OnHmClickListener {
		public void onHmClick();
	}
	// private void onHmClick() {
	// Log.i("wzx", "1000杀毒代码");
	// Log.i("wzx", "2000拨号");
	// Log.i("wzx", "1100卸载 ");
	// }

}

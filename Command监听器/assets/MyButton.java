package listener;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

public class MyButton extends Button {
	//.xml
	public MyButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	@Override
	public boolean performClick() {
		Log.i("wzx", "-performClick--");
		//1000杀毒代码
		//2000拨号
		//1100卸载 
//		①　抽取 不可生重用代码
//		②　抽象成接口
//		③　添加监听器的方法
//		④　内部调用监听器
		return super.performClick();
	}

}

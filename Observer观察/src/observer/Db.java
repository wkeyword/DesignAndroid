package observer;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.net.Uri;

public class Db {
	public List<Account> accounts = new ArrayList<Account>();
	private Context context;
	public Db(Context context) {
		super();
		this.context = context;
	}
	public void add(Account account) {
		accounts.add(account);
		//Uri 代表一个信号 
		Uri uri=Uri.parse("content://account/add/"+account.id);
		context.getContentResolver().notifyChange(uri, null);//null所有的观察者
	}
}

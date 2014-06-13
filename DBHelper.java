/**    
* @Title: DBHelper.java  
* @Package com.im_cmcc.db.datebase
*/
package com.im_cmcc.db.datebase;

import com.im_cmcc.common.Constants.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**  
 * @ClassName: DBHelper  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author WQ 
 * @date 2014-5-4 上午11:10:03
  
 */
public class DBHelper extends SQLiteOpenHelper {
	
	public DBHelper(Context context) {
		super(context, DB.NAME, null, DB.VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		}
}

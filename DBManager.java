/**    
 * @Title: DBManager.java  
 * @Package com.im_cmcc.db.datebase
 */
package com.im_cmcc.db.datebase;

import java.util.concurrent.atomic.AtomicInteger;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @ClassName: DBManager
 * @Description 数据库操作类，使用前需要先调用initializeInstance初始化。<br/>用法：<br/>
 				SQLiteDatabase database = DBManager.getInstance().openDatabase();<br/>
				 database.insert(...);<br/>
				 DBManager.getInstance().closeDatabase(); 
 * @author WQ
 * @date 2014-5-4 上午11:16:32
 */
public class DBManager {
	static final String tag = DBManager.class.getName();
	private AtomicInteger mOpenCounter = new AtomicInteger();
	private static DBManager instance;
	private static SQLiteOpenHelper mDatabaseHelper;
	private SQLiteDatabase mDatabase;

	public static synchronized void initializeInstance(SQLiteOpenHelper helper) {
		if (instance == null) {
			instance = new DBManager();
			mDatabaseHelper = helper;
		}
	}

	public static synchronized DBManager getInstance() {
		if (instance == null) {
			throw new IllegalStateException(
					DBManager.class.getSimpleName()
							+ " is not initialized, call initializeInstance(..) method first.");
		}
		return instance;
	}

	public synchronized SQLiteDatabase openDatabase() {
		if (mOpenCounter.incrementAndGet() == 1) {
			// Opening new database
			mDatabase = mDatabaseHelper.getWritableDatabase();
		}
		return mDatabase;
	}

	public synchronized void closeDatabase() {
		if (mOpenCounter.decrementAndGet() == 0) {
			// Closing database
			mDatabase.close();

		}
	}
}

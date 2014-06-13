SQLiteDatabaseManager
=====================

数据库操作类，使用前需要先调用initializeInstance初始化。

用法：<br/>

首先调用 initializeInstance 初始化，可以在application里做。<br/>

使用的时候<br/>

SQLiteDatabase database = DBManager.getInstance().openDatabase();<br/>
database.insert(...);<br/>
DBManager.getInstance().closeDatabase(); <br/>

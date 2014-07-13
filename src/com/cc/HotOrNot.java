package com.cc;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HotOrNot {

	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "food_name";
	public static final String KEY_HOTNESS = "food_hotness";
	private static final String DATABASE_TABLE = "foodTable";
	
	
	public static final String KEY_ID= "_autoID";
	public static final String KEY_WEEK= "_week";
	public static final String KEY_DAY = "_day";
	public static final String KEY_PLAN = "_plan";
	public static final String KEY_INTAKEN = "_intaken";
	private static final String RECORD_TABLE = "compareTable_database";
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "HotOrNotdb";
	
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}
		
		
		@Override
		public void onCreate(SQLiteDatabase db) {
				
			
			
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
					KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_NAME + " TEXT NOT NULL, " + 
					KEY_HOTNESS + " TEXT NOT NULL);"); 
			
			//data pre loaded for foodTable (EXAMPLE FOR DEMO)
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('CLEMENTINES','50');");	
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('PEARS','37');");	
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('APPLE','47');");	
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('PINEAPPLE','76');");	
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('BANANAS','36');");	
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('PLUMS','58');");	
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('POTATOS','98');");	
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('TOMATOS','76');");	
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('PARSNIPS','98');");	
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('PORK','102');");	
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('TURKEY','99');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('BACON','121');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('BEEF','130');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('LAMB','127');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('BEETROOT','73');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('CUCUMBER','44');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('ICEBERG','38');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('LETTUCE','89');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('ONIONS','82');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('CHERRY','79');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('PEPPERS','47');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('GAMMON','130');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('FISH','117');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('SALAMI','65');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('BURGERS','201');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('SAUSAGES','227');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('CHIPS','230');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('CHESSCAKE','320');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('TOFFEPUDDING','430');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('COOKIES','540');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('DUCK','219');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('WORMS','101');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('SNAKESOUP','329');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('SPIDERLEG','218');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('MUSHROOM','74');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('OXTAILSOUP','350');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('PIZZA','650');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('SUSHI','320');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('NOODLE','59');");
			db.execSQL("INSERT INTO " + DATABASE_TABLE + " (`" + 
					KEY_NAME + "`,`" +KEY_HOTNESS + "`)" + 
					" VALUES ('EGG','231');");
		
			
			
					
			//data pre load for compareTable_database (EXAMPLE FOR DEMO)
			db.execSQL("CREATE TABLE " + RECORD_TABLE + " (" +
					KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_WEEK+ " TEXT NOT NULL, " +
					KEY_DAY+ " TEXT NOT NULL, " +
					KEY_PLAN + " TEXT NOT NULL, " + 
					KEY_INTAKEN + " TEXT NOT NULL);");
			//1st week
			db.execSQL("INSERT INTO " + RECORD_TABLE + " (`" + 
					KEY_WEEK + "`,`" + KEY_DAY + "`,`" + KEY_PLAN + "`,`" + KEY_INTAKEN + "`)" +
					" VALUES ('1','MON','555','789');");
			db.execSQL("INSERT INTO " + RECORD_TABLE + " (`" + 
					KEY_WEEK + "`,`" + KEY_DAY + "`,`" + KEY_PLAN + "`,`" + KEY_INTAKEN + "`)" +
					" VALUES ('1','TUE','456','375');");
			db.execSQL("INSERT INTO " + RECORD_TABLE + " (`" + 
					KEY_WEEK + "`,`" + KEY_DAY + "`,`" + KEY_PLAN + "`,`" + KEY_INTAKEN + "`)" +
					" VALUES ('1','WED','897','636');");
			db.execSQL("INSERT INTO " + RECORD_TABLE + " (`" + 
					KEY_WEEK + "`,`" + KEY_DAY + "`,`" + KEY_PLAN + "`,`" + KEY_INTAKEN + "`)" +
					" VALUES ('1','THU','718','542');");
			//2nd week
			db.execSQL("INSERT INTO " + RECORD_TABLE + " (`" + 
					KEY_WEEK + "`,`" + KEY_DAY + "`,`" + KEY_PLAN + "`,`" + KEY_INTAKEN + "`)" +
					" VALUES ('2','MON','591','346');");
			db.execSQL("INSERT INTO " + RECORD_TABLE + " (`" + 
					KEY_WEEK + "`,`" + KEY_DAY + "`,`" + KEY_PLAN + "`,`" + KEY_INTAKEN + "`)" +
					" VALUES ('2','TUE','379','467');");
			db.execSQL("INSERT INTO " + RECORD_TABLE + " (`" + 
					KEY_WEEK + "`,`" + KEY_DAY + "`,`" + KEY_PLAN + "`,`" + KEY_INTAKEN + "`)" +
					" VALUES ('2','WED','546','389');");
			db.execSQL("INSERT INTO " + RECORD_TABLE + " (`" + 
					KEY_WEEK + "`,`" + KEY_DAY + "`,`" + KEY_PLAN + "`,`" + KEY_INTAKEN + "`)" +
					" VALUES ('2','THU','853','427');");
			
			//3td week
			db.execSQL("INSERT INTO " + RECORD_TABLE + " (`" + 
					KEY_WEEK + "`,`" + KEY_DAY + "`,`" + KEY_PLAN + "`,`" + KEY_INTAKEN + "`)" +
					" VALUES ('3','MON','628','365');");
			db.execSQL("INSERT INTO " + RECORD_TABLE + " (`" + 
					KEY_WEEK + "`,`" + KEY_DAY + "`,`" + KEY_PLAN + "`,`" + KEY_INTAKEN + "`)" +
					" VALUES ('3','TUE','234','423');");
			db.execSQL("INSERT INTO " + RECORD_TABLE + " (`" + 
					KEY_WEEK + "`,`" + KEY_DAY + "`,`" + KEY_PLAN + "`,`" + KEY_INTAKEN + "`)" +
					" VALUES ('3','WED','738','122');");
			db.execSQL("INSERT INTO " + RECORD_TABLE + " (`" + 
					KEY_WEEK + "`,`" + KEY_DAY + "`,`" + KEY_PLAN + "`,`" + KEY_INTAKEN + "`)" +
					" VALUES ('3','THU','427','632');");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			db.execSQL("DROP TABLE IF EXISTS " + RECORD_TABLE);
			onCreate(db);
			
		}
		
	}
	
	public HotOrNot(Context c){
		ourContext = c;   
	}
	
	public HotOrNot open() throws SQLException{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	
	//method for insert data from food_db to sqliteDB...how?
//	public int insertFromFile(Context context, int resourceId) throws IOException {
//		int result = 0;
//		InputStream insertsStream = context.getResources().openRawResource(resourceId);
//		BufferedReader insertReader = new BufferedReader(new InputStreamReader(insertsStream));
//		
//		while(insertReader.ready()){
//			String insertStmt = insertReader.readLine();
//			ourDatabase.execSQL(insertStmt);
//			result++;
//		}
//		insertReader.close();
//		return result;
//	}
	
	public void close(){
		ourHelper.close();
	}

	//for FoodDataBase ADD button
	public long createEntry(String name, String hotness) {
		ContentValues cv = new ContentValues();
		cv.put(KEY_NAME, name);
		cv.put(KEY_HOTNESS, hotness);
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
		
	}

	//for FoodDataBase.refreshFoodList()
	public String getDataName() {
		String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_HOTNESS};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result = "";
		
		int iName= c.getColumnIndex(KEY_NAME);
		
		
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			result = result + " " + c.getString(iName) + "\n";
		}
		return result;
	}
	
	//for FoodDataBase.refreshFoodList()
	public String getDataID() {
		String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_HOTNESS};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result = "";
		int iRow = c.getColumnIndex(KEY_ROWID);
		
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			result = result + " " + c.getString(iRow) + "\n";
		}
		return result;
	}

	//for FoodDataBase.refreshFoodList()
	public String getDataCalo() {
		String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_HOTNESS};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result = "";
		int iHotness = c.getColumnIndex(KEY_HOTNESS);
		
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			result = result + " " + c.getString(iHotness) + "\n";
		}
		return result;
	}
	
	//for FoodDataBase SEARCH  button
	public String getNameByFoodname(String l) throws SQLException{
	//	String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_HOTNESS};
		Cursor c = ourDatabase.query(DATABASE_TABLE, null, KEY_NAME + "=" + "'"+l+"'", null, null, null, null);
		if(c != null) {
			c.moveToFirst();
			String name = c.getString(1);
			return name;
		}
		return null;
	}
	
	//for FoodDataBase SEARCH  button
	public String getCaloByFoodname(String l) throws SQLException{
	//	String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_HOTNESS};
		Cursor c = ourDatabase.query(DATABASE_TABLE, null, KEY_NAME + "=" + "'"+l+"'", null, null, null, null);
		if(c != null) {
			c.moveToFirst();
			String name = c.getString(2);  
			return name;
		}
		return null;
	}

	//for FoodDataBase UPDATE button
	public void updateEntry(long lRow, String mName, long mHotness) throws SQLException{
		ContentValues cvUpdate = new ContentValues();
		cvUpdate.put(KEY_NAME, mName);
		cvUpdate.put(KEY_HOTNESS, mHotness);
		ourDatabase.update(DATABASE_TABLE, cvUpdate, KEY_ROWID + "=" + lRow, null);
		
	}


	//for FoodDataBase DELETE button
	public void deleteEntry(String ll) throws SQLException{
		ourDatabase.delete(DATABASE_TABLE, KEY_NAME + "=" + "'"+ll+"'", null);
		
	}

	//for DailyIntake eat button
	public String getNameByFN(String s) throws SQLException{
		//String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_HOTNESS};
		Cursor c = ourDatabase.query(DATABASE_TABLE, null, KEY_NAME + "=" + "'"+s+"'", null, null, null, null);
		if(c != null) {
			c.moveToFirst();
			String name = c.getString(1);
			return name;
		}
		return null;
	}

	//for DailyIntake eat button
	public String getCaloByFN(String s) throws SQLException{
		//String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_HOTNESS};
		Cursor c = ourDatabase.query(DATABASE_TABLE, null, KEY_NAME+ "=" + "'"+s+"'", null, null, null, null);
		if(c != null) {
			c.moveToFirst();
			String calo= c.getString(2);
			return calo;
		}
		return null;
	}

	//for DailyIntake submitToDataBase button
	public long createRecord(String week, String day, String plan, String intaken) throws SQLException{
		ContentValues cv = new ContentValues();
		cv.put(KEY_WEEK, week);
		cv.put(KEY_DAY, day);
		cv.put(KEY_PLAN, plan);
		cv.put(KEY_INTAKEN, intaken);
		return ourDatabase.insert(RECORD_TABLE, RECORD_TABLE, cv);
	}

	//for OverView geting info from database2
	public String getWeekInfo() throws SQLException{
		String[] columns = new String[]{KEY_ID, KEY_WEEK, KEY_DAY, KEY_PLAN, KEY_INTAKEN};
		Cursor c = ourDatabase.query(RECORD_TABLE, columns, null, null, null, null, null);
		String result = "";
		int iRow = c.getColumnIndex(KEY_WEEK);
		
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			result = result + " " + c.getString(iRow) + "\n";
		}
		return result;
	}

	//for OverView geting info from database2
	public String getDayInfo() throws SQLException{
		String[] columns = new String[]{KEY_ID, KEY_WEEK, KEY_DAY, KEY_PLAN, KEY_INTAKEN};		
		Cursor c = ourDatabase.query(RECORD_TABLE, columns, null, null, null, null, null);
		String result = "";
		int iRow = c.getColumnIndex(KEY_DAY);
		
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			result = result + " " + c.getString(iRow) + "\n";
		}
		return result;
	}

	//for OverView geting info from database2
	public String getMyPlanInfo() throws SQLException{
		String[] columns = new String[]{KEY_ID, KEY_WEEK, KEY_DAY, KEY_PLAN, KEY_INTAKEN};		
		Cursor c = ourDatabase.query(RECORD_TABLE, columns, null, null, null, null, null);
		String result = "";
		int iRow = c.getColumnIndex(KEY_PLAN);
		
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			result = result + " " + c.getString(iRow) + "\n";
		}
		return result;
	}

	//for OverView geting info from database2
	public String getActualyIntakeInfo() throws SQLException{
		String[] columns = new String[]{KEY_ID, KEY_WEEK, KEY_DAY, KEY_PLAN, KEY_INTAKEN};		
		Cursor c = ourDatabase.query(RECORD_TABLE, columns, null, null, null, null, null);
		String result = "";
		int iRow = c.getColumnIndex(KEY_INTAKEN);
		
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			result = result + " " + c.getString(iRow) + "\n";
		}
		return result;
	}
	
	//clean record table
	public void cleanTable(){
		ourDatabase.delete(RECORD_TABLE, null, null);
	}
	
	//for getting record data out, in order to fill the myPlan graph in Chart
	public ArrayList<String> getMyPlanIntake() {
		String[] columns = new String[]{KEY_ID, KEY_WEEK, KEY_DAY, KEY_PLAN, KEY_INTAKEN};
		Cursor c = ourDatabase.query(RECORD_TABLE, columns, null, null, null, null, null);
		ArrayList<String> list = new ArrayList<String>();
		int i = c.getColumnIndex(KEY_PLAN);
		
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			list.add(c.getString(i));
		}
		return list;
	}
	
	//for getting record data out, in order to fill the actualIntaken graph in Chart
	public ArrayList<String> getMyActualIntake() {
		String[] columns = new String[]{KEY_ID, KEY_WEEK, KEY_DAY, KEY_PLAN, KEY_INTAKEN};
		Cursor c = ourDatabase.query(RECORD_TABLE, columns, null, null, null, null, null);
		ArrayList<String> list = new ArrayList<String>();
		int i = c.getColumnIndex(KEY_INTAKEN);
		
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			list.add(c.getString(i));
		}
		return list;
	}
}

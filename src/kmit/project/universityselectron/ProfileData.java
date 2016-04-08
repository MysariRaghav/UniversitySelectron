package kmit.project.universityselectron;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ProfileData {
	 private static final String TAG = ProfileData.class.getSimpleName();
	 private static final String DB = "db";
	  static final int VERSION = 1;
	  static final String DATABASE = "university.db";
	  static final String TABLE = "Profile_Table";

	  public static final String C_EMAIL_ID = "_id";
	  public static final String C_NAME = "name";
	  public static final String C_PHONE = "phone";
	  public static final String C_COUNTRY = "country";
	  public static final String C_COURSE = "course";
	  public static final String C_AREA_OF_INTEREST = "area_of_interest";
	  public static final String C_NAME_OF_UNIVERSITY = "name_of_university";
	  public static final String C_GPA = "gpa";
	  public static final String C_NUMBER_OF_BACKLOGS = "numner_of_backlogs";
	  public static final String C_WORK_EXPERIENCE = "work_experience";
	  public static final String C_RESEARCH_WORK = "research_work";
	  public static final String C_OTHER_CERTIFICATIONS = "other_certifications";
	  public static final String C_LOCATIONS_PREFERED = "locations_prefered";
	  public static final String C_BUDGET = "budget";
	  public static final String C_INTERESTED_UNIVERSITIES = "interested_universities";
	  public static final String C_QUANT = "quant";
	  public static final String C_VERBAL = "verbal";
	  public static final String C_AWA = "awa";
	  public static final String C_TOEFL = "toefl";
	  public static final String C_IELTS = "ielts";
	  
	 /* // DbHelper implementations
	  class DbHelper extends SQLiteOpenHelper {

	    public DbHelper(Context context) {
	    	
	      super(context, DATABASE, null, VERSION);
	      Log.i(DB, "SQLiteOpenHelper");
	    }

	    @Override
	    public void onCreate(SQLiteDatabase db) {
	      Log.i(DB, "Creating database: " + DATABASE);
	      String CREATE_PROFILE_TABLE="CREATE TABLE " + 
	    		  						TABLE + 
	    		  						"(" + 
	    		  						C_EMAIL_ID + " TEXT primary key,"+ 
	    		  						C_NAME + " TEXT," + 
	    		  						C_PHONE + " TEXT," + 
	    		  						C_COUNTRY + " text,"+
	    		  						C_COURSE + " TEXT,"+
	    		  						C_AREA_OF_INTEREST + " TEXT,"+
	    		  						C_NAME_OF_UNIVERSITY + " TEXT,"+
	    		  						C_GPA + " TEXT,"+
	    		  						C_NUMBER_OF_BACKLOGS + " TEXT,"+
	    		  						C_WORK_EXPERIENCE + " TEXT,"+
	    		  						C_RESEARCH_WORK + " TEXT,"+
	    		  						C_OTHER_CERTIFICATIONS + " TEXT,"+
	    		  						C_LOCATIONS_PREFERED + " TEXT,"+
	    		  						C_BUDGET + " TEXT,"+
	    		  						C_INTERESTED_UNIVERSITIES + " TEXT,"+
	    		  						C_QUANT + " TEXT,"+
	    		  						C_VERBAL + " TEXT,"+
	    		  						C_AWA + " TEXT,"+
	    		  						C_TOEFL + " TEXT,"+
	    		  						C_IELTS + " TEXT )";
	      db.execSQL(CREATE_PROFILE_TABLE);
	    }

	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	      db.execSQL("drop table " + TABLE);
	      this.onCreate(db);
	    }
	  }
*/
	  private UnivDataDatabaseHandler dbHelper;

	  public ProfileData(Context context) {
	    this.dbHelper = new UnivDataDatabaseHandler(context);
	    Log.i(DB, "Initialized data");
	  }

	  public void close() {
	    this.dbHelper.close();
	  }

	  public void insertOrIgnore(ContentValues values) {
	    Log.d(TAG, "insertOrIgnore on " + values);
	    Log.d(App.CURSOR,"in INSERT");
	    SQLiteDatabase db = this.dbHelper.getWritableDatabase();
	    try {
	      db.insertWithOnConflict(TABLE, null, values,SQLiteDatabase.CONFLICT_REPLACE); 
	    } finally {
	      db.close();
	    }
	  }

	  /**
	   * 
	   * @return Cursor where the columns are _id, created_at, user, txt
	   */
	  public Cursor getEditTexts() {
		  Log.d(App.CURSOR,"in querry");
	    SQLiteDatabase db = this.dbHelper.getReadableDatabase();
	    return db.query(TABLE,
	    		null,
	    		C_EMAIL_ID+"="+"\""+App.profile+"\"",
	    		null,
	    		null,
	    		null,
	    		null);
	  }
	  
	  
	  public int getScore(){
		  SQLiteDatabase db = this.dbHelper.getReadableDatabase();
		 Cursor c= db.query(TABLE,
		    		new String[]{ C_QUANT,C_VERBAL}  ,
		    		C_EMAIL_ID+"="+"\""+App.profile+"\"",
		    		null,
		    		null,
		    		null,
		    		null);
		 
		 if(c!=null && c.moveToFirst())
		 { if(c.getString(c.getColumnIndex(C_QUANT))!=null && c.getString(c.getColumnIndex(C_VERBAL))!=null)
			 return Integer.parseInt(c.getString(c.getColumnIndex(C_QUANT)))+
			 Integer.parseInt(c.getString(c.getColumnIndex(C_VERBAL)));
		 }
		  
		  
		return 0;
		  
		  
	  }
	  
	  /**
	   * Deletes ALL the data
	   */
	  public void delete() {
	    // Open Database
	    SQLiteDatabase db = dbHelper.getWritableDatabase();

	    // Delete the data
	    db.delete(TABLE, null, null);

	    // Close Database
	    db.close();
	  }



	}

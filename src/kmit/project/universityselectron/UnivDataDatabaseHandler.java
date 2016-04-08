package kmit.project.universityselectron;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UnivDataDatabaseHandler extends SQLiteOpenHelper {
	 // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
    SQLiteDatabase db = this.getWritableDatabase();
    // Database Name
    private static final String DATABASE_NAME = "university.db";
 
    // Contacts table name
    private static final String UNIVERSITY_TABLE = "University_Table";
    static final String PROFILE_TABLE = "Profile_Table";
    private static final String univ_name="name";
    private static final String max_score="max_score";
    private static final String min_score="min_score";
    private static final String univ_addr="address";
    private static final String DB = "db";
    
    
    //columns of profile table
    
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
	  
    public UnivDataDatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		Log.i(DB, "UnivDataDatabaseHandler");
		// TODO Auto-generated constructor stub
	}
    

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.i(DB, "on creat of UnivDataDatabaseHandler");
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " +
				UNIVERSITY_TABLE + 
										"("+
										univ_name + " TEXT,"+ 
										univ_addr + " TEXT,"+ 
										min_score + " INTEGER ," + 
										max_score + " INTEGER " + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
        
        
        
        //vreating profile table
        
        String CREATE_PROFILE_TABLE="CREATE TABLE " + 
        			PROFILE_TABLE + 
					"(" + 
					C_EMAIL_ID + " TEXT primary key,"+ 
					C_NAME + " TEXT," + 
					C_PHONE + " TEXT," + 
					C_COUNTRY + " TEXT,"+
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
					C_IELTS + " TEXT)";
db.execSQL(CREATE_PROFILE_TABLE);
        
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		 db.execSQL("DROP TABLE IF EXISTS " + PROFILE_TABLE);
		 db.execSQL("DROP TABLE IF EXISTS " + UNIVERSITY_TABLE);
		 
	        // Create tables again
	        onCreate(db);
	}
	
	 public  void addUniversity(University university) {
	        SQLiteDatabase db = this.getWritableDatabase();
	 
	        ContentValues values = new ContentValues();
	        values.put(univ_name, university.get_name());
	        values.put(univ_addr, university.get_addr());
	        values.put(min_score, university.getMin_score()); 
	        values.put(max_score, university.getMax_score());
	        // Inserting Row
	        db.insert(UNIVERSITY_TABLE, null, values);
	        db.close(); // Closing database connection
	    }
	 public String getURLonName(String name)
	 {
		 String selectQuery = " SELECT  "+univ_addr+" FROM " + UNIVERSITY_TABLE+" where "+univ_name+"="+ "\""+name+"\"";
		Cursor c =db.rawQuery(selectQuery, null);
		
		if(c.moveToNext())
		{
			return c.getString(0);
		}
		 return null;
	 }
	 
	 public int getMinScoreonName(String name)
	 {
		
		 String selectQuery = " SELECT  "+min_score+" FROM " + UNIVERSITY_TABLE+" where "+univ_name+"="+ "\""+name+"\"";
		Cursor c =db.rawQuery(selectQuery, null);
		
		if(c.moveToNext())
		{
			Log.d("minScoreRetrieval","minScoreRetrieval");
			return c.getInt(0);
		}
		 return 0;
	 }
	 
	 public List<University> getAllUniversitys() {
	        List<University> universityList = new ArrayList<University>();
	        // Select All Query
	        String selectQuery = "SELECT  * FROM " + UNIVERSITY_TABLE;
	 
	        
	        Cursor cursor = db.rawQuery(selectQuery, null);
	 
	        // looping through all rows and adding to list
	        if (cursor.moveToFirst()) {
	            do {
	            	University university = new University();
	            	
	            	university.set_name(cursor.getString(0));
	            	university.set_addr(cursor.getString(1));
	            	university.setMin_score(Integer.parseInt(cursor.getString(2)));
	            	university.setMax_score(Integer.parseInt(cursor.getString(3)));
	                
	                universityList.add(university);
	            } while (cursor.moveToNext());
	        }
	 
	        // return contact list
	        return universityList;
	    }
	 public void delete() {
		    // Open Database
		    SQLiteDatabase db = getWritableDatabase();

		    // Delete the data
		    db.delete(UNIVERSITY_TABLE, null, null);

		    // Close Database
		    db.close();
		  }
	 

}

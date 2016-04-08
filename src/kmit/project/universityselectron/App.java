package kmit.project.universityselectron;

import android.app.Activity;
import android.app.Application;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class App extends Application {

	public static ContentValues values;
	public static ProfileData profileData;
	public GestureDetector gestureDetector;
	public static String profile;
	public static Cursor cursor;
	
	
	
	public static final String LIFE="lifecycle";
	public static final String PROFILE="profile";
	public static final String CURSOR = "cursor";
	
	
	
	// EDIT text strings
	
	  public static String email_id;
	  public static String name;
	  public static String phone;
	  public static String country;
	  public static String course;
	  public static String area_of_interest;
	  public static String name_of_university;
	  public static String gpa;
	  public static String numner_of_backlogs;
	  public static String work_experience;
	  public static String research_work;
	  public static String other_certifications;
	  public static String locations_prefered;
	  public static String budget;
	  public static String interested_universities;
	  public static String quant;
	  public static String verbal;
	  public static String awa;
	  public static String toefl;
	  public static String ielts;
	
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.d(LIFE,this.getClass().getSimpleName()+"----->onCreat");
		values=new ContentValues();
		profileData=new ProfileData(getApplicationContext());
		
		//cursor
		/*cursor=profileData.getEditTexts();
		if(cursor.moveToFirst()){
		Log.d(CURSOR,cursor.getString(0)+"\t"+
					cursor.getString(1)+"\t"+
					cursor.getString(2)+"\t"+
					cursor.getString(3)+"\t"+
					cursor.getString(4)+"\t"+
					cursor.getString(5)+"\t"+
					cursor.getString(6)+"\t"+
					cursor.getString(7)+"\t"+
					cursor.getString(8)+"\t"+
					cursor.getString(9)+"\t"+
					cursor.getString(10)+"\t"+
					cursor.getString(11)+"\t"+
					cursor.getString(12)+"\t"+
					cursor.getString(13)+"\t"+
					cursor.getString(14)+"\t"+
					cursor.getString(15)+"\t"+
					cursor.getString(16)+"\t"+
					cursor.getString(17)+"\t"+
					cursor.getString(18)+"\t"+
					cursor.getString(19));
		}*/
		super.onCreate();
	}
	
	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		Log.d(LIFE,this.getClass().getSimpleName()+"----->onTerminate");
		
		super.onTerminate();
	}

	public void gesture(Intent leftIntent,Intent rightIntent,Intent downIntent,Activity activity,View view)
	{

		leftIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		rightIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		downIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		gestureDetector = new GestureDetector(getApplicationContext(), new MyGestureDetector(getApplicationContext(), activity,leftIntent,rightIntent,downIntent));
		// Set the touch listener for the main view to be our custom gesture
		// listener
		
		view.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
			}
		});

	}
	
	
	// edit text entry
	public void generalInfo(String email_id, String name, String phone,
	  String country, String course, String area_of_interest,
	  String name_of_university, String gpa, String numner_of_backlogs,
	  String work_experience, String research_work, String other_certifications)
	{
		this.email_id=email_id;
		this.name=name;
		this.phone=phone;
		this.country=country;
		this.course=course;
		this.area_of_interest=area_of_interest;
		this.name_of_university=name_of_university;
		this.gpa=gpa;
		this.numner_of_backlogs=numner_of_backlogs;
		this.work_experience=work_experience;
		this.research_work=research_work;
		this.other_certifications=other_certifications;
		Log.d(PROFILE,"----->"+email_id+name+phone+
				  country+course+area_of_interest+
				  name_of_university+gpa+numner_of_backlogs+
				  work_experience+research_work+other_certifications+locations_prefered+
				  budget+
				  interested_universities
				  +quant+verbal+awa+toefl+
				  ielts);
		
		// insert into values
		
		values.put(profileData.C_EMAIL_ID,this.email_id);
		values.put(profileData.C_NAME,this.name);
		values.put(profileData.C_PHONE,this.phone);
		values.put(profileData.C_COUNTRY,this.country);
		values.put(profileData.C_COURSE,this.course);
		values.put(profileData.C_AREA_OF_INTEREST,this.area_of_interest);
		values.put(profileData.C_NAME_OF_UNIVERSITY,this.name_of_university);
		values.put(profileData.C_GPA,this.gpa);
		values.put(profileData.C_NUMBER_OF_BACKLOGS,this.numner_of_backlogs);
		values.put(profileData.C_WORK_EXPERIENCE,this.work_experience);
		values.put(profileData.C_RESEARCH_WORK,this.research_work);
		values.put(profileData.C_OTHER_CERTIFICATIONS,this.other_certifications);
/*		values.put(profileData.C_LOCATIONS_PREFERED,locations_prefered);
		values.put(profileData.C_BUDGET,budget);
		values.put(profileData.C_INTERESTED_UNIVERSITIES,interested_universities);
		values.put(profileData.C_QUANT,quant);
		values.put(profileData.C_VERBAL,verbal);
		values.put(profileData.C_AWA,awa);
		values.put(profileData.C_TOEFL,toefl);
		values.put(profileData.C_IELTS,ielts);*/
		//insert into db
		
		profileData.insertOrIgnore(values);
		
		
	}
	
	
	public void preference( String locations_prefered,
	  String budget,
	  String interested_universities)
	{
		this.locations_prefered=locations_prefered;
		this.budget=budget;
		this.interested_universities=interested_universities;
		Log.d(PROFILE,"----->"+locations_prefered+
				  budget+
				  interested_universities);
		
		values.put(profileData.C_LOCATIONS_PREFERED,locations_prefered);
		values.put(profileData.C_BUDGET,budget);
		values.put(profileData.C_INTERESTED_UNIVERSITIES,interested_universities);
	
		//insert into db
		
				profileData.insertOrIgnore(values);
	
	}
	
	
	public void scores(String quant,String verbal,String awa,String toefl,
	  String ielts)
	{
		this.quant=quant;
		this.verbal=verbal;
		this.awa=awa;
		this.toefl=toefl;
		this.ielts=ielts;
		Log.d(PROFILE,"----->"+quant+verbal+awa+toefl+
				  ielts);
		values.put(profileData.C_QUANT,quant);
		values.put(profileData.C_VERBAL,verbal);
		values.put(profileData.C_AWA,awa);
		values.put(profileData.C_TOEFL,toefl);
		values.put(profileData.C_IELTS,ielts);
	
		//insert into db
		
				profileData.insertOrIgnore(values);
	
	}
	
	

}

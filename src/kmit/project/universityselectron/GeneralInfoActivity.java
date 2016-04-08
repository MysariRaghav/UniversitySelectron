package kmit.project.universityselectron;

import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;

@SuppressLint("NewApi")
public class GeneralInfoActivity extends Activity{

	public static final String TAG = "cursor";
	public static final String DEFAULT_COUNTRY = "India";
	private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

	Spinner spinner;
	ArrayAdapter<CharSequence> adapter;
	
	private GestureDetector gestureDetector;
	private ScrollView scroll;
	private EditText eMail;
	Intent leftIntent;
	Intent rightIntent;
	Intent downIntent;
	App app;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onCreat");
		
		UnivDataDatabaseHandler udh=new UnivDataDatabaseHandler(this);
		
		setContentView(R.layout.activity_general_info);
		AssetManager assetManager = getAssets();
		
		// gesture code
		
				leftIntent = new Intent(getApplicationContext(),
						TipsActivity.class);
				rightIntent = new Intent(getApplicationContext(),
						PreferenceActivity.class);
				downIntent = new Intent(getApplicationContext(),
						NewsActivity.class);
				app=(App)getApplication();
				
		scroll=(ScrollView) findViewById(R.id.scrollView1);
		
		/*scroll=new Scroll(getApplicationContext(),this, leftIntent, rightIntent, downIntent);
		scroll.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));
		ScrollView.inflate(this, R.layout.activity_general_info, scroll);
		scroll.setId(generateViewId());
		setContentView(scroll);*/

		// Spinner code
		spinner = (Spinner) findViewById(R.id.country_list);
		adapter = ArrayAdapter.createFromResource(
				this, R.array.countries_array,
				android.R.layout.simple_spinner_item);
		//adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setSelection(adapter.getPosition(DEFAULT_COUNTRY));
		
		//setting the editText
				/*if(App.cursor.moveToFirst())
				setEditTexts();*/
		
		
		
		
		
		
		
		/*gestureDetector = new GestureDetector(getApplicationContext(), new MyGestureDetector(getApplicationContext(), this,leftIntent,rightIntent,downIntent));
		scroll.setOnTouchListener(this);*/
		
		
		/*// Set the touch listener for the main view to be our custom gesture
		// listener
		
		scroll.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (gestureDetector.onTouchEvent(event)) {
					return true;
				}
				return false;
			}
		});*/
		((EditText)findViewById(R.id.emailID)).setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if(!hasFocus)
				{
					App.profile=((EditText)findViewById(R.id.emailID)).getText().toString();
					getCursor();
				}
			}

			
		});
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onCreate----->university data");
		try {
			InputStream is=assetManager.open("universities.txt");
			UniversityData ud =new UniversityData(udh);
			Log.d(App.LIFE,this.getClass().getSimpleName()+ud);
			ud.getData(is);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void setEditTexts() {
		// TODO Auto-generated method stub
		((EditText)findViewById(R.id.emailID)).setText(App.cursor.getString(0));
		((EditText)findViewById(R.id.Name)).setText(App.cursor.getString(1));
		((EditText)findViewById(R.id.phoneNum)).setText(App.cursor.getString(2));
		((Spinner)findViewById(R.id.country_list)).setSelection(adapter.getPosition(App.cursor.getString(3)));
		((EditText)findViewById(R.id.course)).setText(App.cursor.getString(4));
		((EditText)findViewById(R.id.areaOfInterest)).setText(App.cursor.getString(5));
		((EditText)findViewById(R.id.UniversityName)).setText(App.cursor.getString(6));
		((EditText)findViewById(R.id.gpa)).setText(App.cursor.getString(7));
		((EditText)findViewById(R.id.backlogsCount)).setText(App.cursor.getString(8));
		((EditText)findViewById(R.id.workExperience)).setText(App.cursor.getString(9));
		((EditText)findViewById(R.id.reseachWork)).setText(App.cursor.getString(10));
		((EditText)findViewById(R.id.certification)).setText(App.cursor.getString(11));
	}
	
	private void getCursor() {
		// TODO Auto-generated method stub
		Log.d(App.CURSOR,App.profile);
        App.cursor=App.profileData.getEditTexts();
		if(App.cursor.moveToFirst()){
		Log.d(App.CURSOR,App.cursor.getString(0)+"\t"+
				App.cursor.getString(1)+"\t"+
				App.cursor.getString(2)+"\t"+
				App.cursor.getString(3)+"\t"+
				App.cursor.getString(4)+"\t"+
				App.cursor.getString(5)+"\t"+
				App.cursor.getString(6)+"\t"+
				App.cursor.getString(7)+"\t"+
				App.cursor.getString(8)+"\t"+
				App.cursor.getString(9)+"\t"+
				App.cursor.getString(10)+"\t"+
				App.cursor.getString(11)+"\t"+
				App.cursor.getString(12)+"\t"+
				App.cursor.getString(13)+"\t"+
				App.cursor.getString(14)+"\t"+
				App.cursor.getString(15)+"\t"+
				App.cursor.getString(16)+"\t"+
				App.cursor.getString(17)+"\t"+
				App.cursor.getString(18)+"\t"+
				App.cursor.getString(19));
		}
		
		if(App.cursor.moveToFirst())
			setEditTexts();
        }
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onCreateOptionsMenu");
		getMenuInflater().inflate(R.menu.general_info, menu);
		

		return true;

	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId())
		{
		case R.id.change_profile:
		{
			
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
	       
	        builder.setMessage("Title: ");

	        final EditText titleBox = new EditText(this);
            titleBox.setId(R.id.profile_id);
            builder.setView(titleBox);
            builder.setMessage("title")
            .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                App.profile=titleBox.getText().toString();
                getCursor();
                }
                
            })
            .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User cancelled the dialog
                }
            });
	        builder.create().show();
			break;
		
		}
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * Generate a value suitable for use in {@link #setId(int)}. This value will
	 * not collide with ID values generated at build time by aapt for R.id.
	 * 
	 * @return a generated ID value
	 */
	@SuppressLint("Override")
	public static int generateViewId() {
		for (;;) {
			final int result = sNextGeneratedId.get();
			// aapt-generated IDs have the high byte nonzero; clamp to the range
			// under that.
			int newValue = result + 1;
			if (newValue > 0x00FFFFFF)
				newValue = 1; // Roll over to 1, not 0.
			if (sNextGeneratedId.compareAndSet(result, newValue)) {
				return result;
			}
		}
	}

/*	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (gestureDetector.onTouchEvent(event)) {
			return true;
		}
		return false;
	}*/

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onDestroy");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onPause");
		Spinner s=(Spinner)findViewById(R.id.country_list);
		
		((App)getApplication()).generalInfo(idToString(R.id.emailID),
				idToString(R.id.Name),
				idToString(R.id.phoneNum),
				s.getSelectedItem().toString(), 
				idToString(R.id.course), 
				idToString(R.id.areaOfInterest), 
				idToString(R.id.UniversityName),
				idToString(R.id.gpa), 
				idToString(R.id.backlogsCount), 
				idToString(R.id.workExperience),
				idToString(R.id.reseachWork),
				idToString(R.id.certification));
		super.onPause();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onRestar");
		
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onResume");
		super.onResume();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onStart");
		app.gesture(leftIntent, rightIntent, downIntent, this, scroll);

		/*((EditText) findViewById(R.id.emailID)).
		setOnFocusChangeListener(new TextChange(getApplicationContext(),ProfileData.C_EMAIL_ID));*/
		
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onStop");
		
	super.onStop();
	}
	protected String idToString(int id)
	{
		return ((EditText)findViewById(id)).getText().toString();
	}
	
	
	
/*	class MyGestureDetector extends SimpleOnGestureListener {
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			Intent intent = new Intent(getBaseContext(),
					PreferenceActivity.class);
			if(e1!=null&&e2!=null)
			{
			if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH) {
				return false;
			}

			// right to left swipe
			if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
					&& Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
				startActivity(intent);
				GeneralInfoActivity.this.overridePendingTransition(
						R.anim.slide_in_right, R.anim.slide_out_left);
				// right to left swipe
			} 
			else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
					&& Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
				startActivity(intent);
				GeneralInfoActivity.this.overridePendingTransition(
						R.anim.slide_in_left, R.anim.slide_out_right);
			
			}
			}
			return false;
		}
	}*/
	
	
	
	
	
}

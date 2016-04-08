package kmit.project.universityselectron;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;

public class PreferenceActivity extends Activity {

	private GestureDetector gestureDetector;
	ScrollView scroll;
	Intent leftIntent;
	Intent rightIntent;
	Intent downIntent;
	App app;
	Spinner spinner;
	ArrayAdapter adapter;
	public static final String DEFAULT_COUNTRY = "India";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onCreat");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preference);
		scroll=(ScrollView) findViewById(R.id.scrollView2);
		
		
		// Spinner code
				spinner = (Spinner) findViewById(R.id.et_listOfColleges);
				adapter = ArrayAdapter.createFromResource(
						this, R.array.listOfColleges,
						android.R.layout.simple_spinner_item);
				//adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
				//spinner.setSelection(adapter.getPosition(""));
				
				//Log.d("newDebug", univName);
		// gesture code
		
		leftIntent = new Intent(getApplicationContext(),
				GeneralInfoActivity.class);
		rightIntent = new Intent(getApplicationContext(),
				ScoresActivity.class);
		downIntent = new Intent(getApplicationContext(),
				ScoresAdivceActivity.class);
		//downIntent.putExtra("UnivName", univName);
		app=(App)getApplication();
				
				
		
	}
	
	private void setEditTexts() {
		// TODO Auto-generated method stub
		((EditText)findViewById(R.id.et_location)).setText(App.cursor.getString(12));
		((EditText)findViewById(R.id.et_budget)).setText(App.cursor.getString(13));
		((Spinner)findViewById(R.id.et_listOfColleges)).setSelection(adapter.getPosition(App.cursor.getString(14)));
		
		

	}
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
		Spinner s=(Spinner)findViewById(R.id.et_listOfColleges);
		((App)getApplication()).preference(
				idToString(R.id.et_location),
				idToString(R.id.et_budget),
				s.getSelectedItem().toString());
		super.onPause();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onRestar");

		super.onRestart();
		String univName=spinner.getSelectedItem().toString();
		downIntent.putExtra("UnivName", univName);
		Log.d("newDebug", univName);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onResume");
		//setting the editText
				if(App.cursor!=null && App.cursor.moveToFirst())
				setEditTexts();
		super.onResume();
		
		
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onStart");
		app.gesture(leftIntent, rightIntent, downIntent, this, scroll);
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

	
//	@Override
//	public boolean onTouch(View v, MotionEvent event) {
//			if (gestureDetector.onTouchEvent(event)) {
//				return true;
//			}
//			return false;
//		}
	
	
	
	

}

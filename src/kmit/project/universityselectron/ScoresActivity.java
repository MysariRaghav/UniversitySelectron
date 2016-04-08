package kmit.project.universityselectron;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;

public class ScoresActivity extends Activity {

	private GestureDetector gestureDetector;
	ScrollView scroll;
	Intent leftIntent;
	Intent rightIntent;
	Intent downIntent;
	App app;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onCreat");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scores);
		
		scroll=(ScrollView) findViewById(R.id.scrollView3);
		
		
		
		// gesture code
		
				leftIntent = new Intent(getApplicationContext(),
						PreferenceActivity.class);
				rightIntent = new Intent(getApplicationContext(),
						TipsActivity.class);
				downIntent = new Intent(getApplicationContext(),
						CollegeAdviceActivity.class).putExtra("greScore",309);
				app=(App)getApplication();
				app.gesture(leftIntent, rightIntent, downIntent, this, scroll);
				
				
	}
	
	private void setEditTexts() {
		// TODO Auto-generated method stub
		((EditText)findViewById(R.id.et_quant)).setText(App.cursor.getString(15));
		((EditText)findViewById(R.id.et_verbal)).setText(App.cursor.getString(16));
		((EditText)findViewById(R.id.et_awa)).setText(App.cursor.getString(17));
		
		((EditText)findViewById(R.id.et_toefl)).setText(App.cursor.getString(18));
		((EditText)findViewById(R.id.et_ielts)).setText(App.cursor.getString(19));
		
		

	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
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
		((App)getApplication()).scores(
				idToString(R.id.et_quant),
				idToString(R.id.et_verbal),
				idToString(R.id.et_awa),
				idToString(R.id.et_toefl),
				idToString(R.id.et_ielts));
		
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

}

package kmit.project.universityselectron;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class NewsActivity extends Activity implements OnTouchListener {
	
	
	
	GestureDetector	gestureDetector;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onCreat");
		setContentView(R.layout.activity_latestnews);
		
		
		//View scroll=findViewById(R.id.linear_layout);
		Intent leftIntent = new Intent(getApplicationContext(),
				TipsActivity.class);
		Intent rightIntent = new Intent(getApplicationContext(),
				ScoresAdivceActivity.class);
		Intent downIntent = new Intent(getApplicationContext(),
				TipsActivity.class);
		gestureDetector = new GestureDetector(getApplicationContext(), new MyGestureDetector(getApplicationContext(), this,leftIntent,rightIntent,downIntent));
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

		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onStop");
		super.onStop();
	}


	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		if (gestureDetector.onTouchEvent(event)) {
			return true;
		}
		return false;
	}
	
}

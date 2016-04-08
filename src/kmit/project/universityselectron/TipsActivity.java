package kmit.project.universityselectron;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;

public class TipsActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onCreat");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tips);
		/*View scroll=findViewById(R.id.linear_layout);
		Intent leftIntent = new Intent(getApplicationContext(),
				GeneralInfoActivity.class);
		Intent rightIntent = new Intent(getApplicationContext(),
				ScoresActivity.class);
		Intent downIntent = new Intent(getApplicationContext(),
				ScoresAdivceActivity.class);
		App app=(App)getApplication();
		app.gesture(leftIntent, rightIntent, downIntent, this, scroll);*/
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


}

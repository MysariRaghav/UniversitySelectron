package kmit.project.universityselectron;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CollegeAdviceActivity extends Activity {

	
	int greScore;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(App.LIFE,this.getClass().getSimpleName()+"----->onCreat");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_college_advice);
		/*View scroll=findViewById(R.id.linear_layout);
		Intent leftIntent = new Intent(getApplicationContext(),
				ScoresAdivceActivity.class);
		Intent rightIntent = new Intent(getApplicationContext(),
				TipsActivity.class);
		Intent downIntent = new Intent(getApplicationContext(),
				TipsActivity.class);
		App app=(App)getApplication();
		app.gesture(leftIntent, rightIntent, downIntent, this, scroll);*/
		
		
		greScore=App.profileData.getScore();
		Log.d("greScore",""+ greScore);
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
		UnivDataDatabaseHandler db=new UnivDataDatabaseHandler(this);
		List<University> universities = db.getAllUniversitys();       
        
        for (University un : universities) {
            String log = "name: "+un.get_name()+" ,addr: " + un.get_addr() + " ,min: " + un.getMin_score()+ " ,max: " + un.getMax_score();
                // Writing Universities to log
        Log.d("Name", log);
        }
        UniversityDisplay univDisplay=new UniversityDisplay(universities);
       String[] array= univDisplay.searchUniversities(greScore);
		
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
			      R.layout.activity_listview, array);
			      
			      ListView listView = (ListView) findViewById(R.id.university_list);
			      listView.setAdapter(adapter);
			      
			      listView.setOnItemClickListener(new OnItemClickListener() {
			            
			            public void onItemClick(AdapterView<?> parent, View view, int position,
			                    long id) {
			                
			                String item = ((TextView)view).getText().toString();
			                
			                Toast.makeText(getBaseContext(), item, Toast.LENGTH_SHORT).show();
			                UnivDataDatabaseHandler uddh =new UnivDataDatabaseHandler(getApplicationContext());
			                String url =uddh.getURLonName(item);
			                Log.d("url", url);
			                Intent i=new Intent(getApplicationContext(), WebActivity.class);
			                i.putExtra("gotURL", url);
			                startActivity(i);
			            }
			      });
			      
			      
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

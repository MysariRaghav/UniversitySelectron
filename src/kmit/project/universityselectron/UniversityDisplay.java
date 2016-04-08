




package kmit.project.universityselectron;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class UniversityDisplay {
	List<University> univList;
	static String[] array;
	public UniversityDisplay(List<University> univList) {
		
		this.univList=univList;
	}
	
	int greScore=310;
	List<String> referredUniversities=new ArrayList<String>();
	public String[] searchUniversities(int greScore)
	{
	
		for (University un : univList)
		{
	        Log.d("Name", un.getMin_score()+"");
	    
		    if((greScore>=un.getMin_score()) )
		    {
		    	Log.d("Name", "true");
		    	referredUniversities.add(un.get_name());
		    }
	    }
		for(String univ : referredUniversities)
		 {
			 Log.d("Name", univ);
		 }
		 
		  array = referredUniversities.toArray(new String[referredUniversities.size()]);
		 
		 for(String str : array)
		 {
			 Log.d("referred univ", str);
		 }
		 
		 return array;
	}
		
	
}
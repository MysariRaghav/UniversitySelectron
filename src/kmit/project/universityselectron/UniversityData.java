package kmit.project.universityselectron;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import android.util.Log;


public class UniversityData {
	
	
	public UniversityData() {
		super();
	}

	public UniversityData(UnivDataDatabaseHandler db) {
		
		this.db = db;
		db.delete();
	}

	UnivDataDatabaseHandler db;
	
	public void getData(InputStream fstream)
	  {
	  try{
	  // Open the file that is the first 
	  // command line parameter
		
		  
	  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  String name;
		  String addr;
		  int min;
		  int max;
	  //Read File Line By Line
		  while ((strLine = br.readLine()) != null)  
		  {
			  // Print the content on the console
			//System.out.println (strLine);
			  String [] stringParts = strLine.split("\t");
			  name=stringParts[0];
			  addr=stringParts[1];
			  min=Integer.parseInt(stringParts[2]);
			  max=Integer.parseInt(stringParts[3]);
			 db.addUniversity(new University(name,addr,min,max));
			  
			  
		  }
		 // Log.d("Reading: ", "Reading all universities.."); 
	        /*List<University> universities = db.getAllUniversitys();       
	         
	        for (University un : universities) {
	            String log = "name: "+un.get_name()+" ,addr: " + un.get_addr() + " ,min: " + un.getMin_score()+ " ,max: " + un.getMax_score();
	                // Writing Universities to log
	        Log.d("Name", log);
	        }
	        UniversityDisplay univDisplay=new UniversityDisplay(universities);
	        univDisplay.searchUniversities();*/
	  //Close the input stream
		  in.close();
	    }
	  	catch (Exception e)
	  	{//Catch exception if any
	  		System.err.println("Error: " + e.getMessage());
	  	}
	  }

}

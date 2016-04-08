package kmit.project.universityselectron;

import java.util.concurrent.atomic.AtomicInteger;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.util.Log;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;


import android.widget.ScrollView;

@SuppressLint("NewApi")
public class Scroll extends ScrollView{
	public static final String TAG = "ScrollView";
	float deltaX ;
	float downX;
	float downY,upX,upY,deltaY;
	private Context context;
	private Activity activity;
	private Intent leftIntent;
	private Intent rightIntent;
	private Intent downIntent;
	MotionEvent ev1,ev2;
	public GestureDetector gestureDetector;
	private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
	
	
	

	public Scroll(Context context,Activity activity,Intent leftIntent,Intent rightIntent,Intent downIntent) {
		super(context);
		Log.d(TAG,"in scroll constructor");
		this.context=context;
		this.activity=activity;
		this.leftIntent=leftIntent;
		this.rightIntent=rightIntent;
		this.downIntent=downIntent;
		
		
		
		
		}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Log.d(TAG,"ONINTERCEPT");
		
		switch(event.getAction()){
		  case MotionEvent.ACTION_DOWN: {
		   downX = event.getX();
		   downY = event.getY();
		  ev1=event;
		   Log.d(TAG,"down");
		   break;
		   //return true;
		  }
		  case MotionEvent.ACTION_MOVE: {
		   upX = event.getX();
		   upY = event.getY();
		   deltaX = downX - upX;
		   deltaY = downY - upY;
		   ev2=event;
		   
		   Log.d(TAG,"up");
		  }
		  case MotionEvent.ACTION_UP:
			  return true;
		  
		  
		}
		   
		   
		   if(Math.abs(deltaX) > MyGestureDetector.SWIPE_MIN_DISTANCE)
			{
			   
			}
		  
		  
		   Log.d(TAG,"x:"+deltaX+"Y:"+deltaY);
		
		
		
		return super.onInterceptTouchEvent(event);
		
		}
	
	
	


	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Log.d(TAG,"IN OnTouch"+Math.abs(ev1.getX() - ev2.getX()));
		if(Math.abs(deltaX) > MyGestureDetector.SWIPE_MIN_DISTANCE)
		{
			Log.d(TAG,"Gesture success");
			gestureDetector = new GestureDetector(context, new MyGestureDetector(context, activity,leftIntent,rightIntent,downIntent));
			return gestureDetector.onTouchEvent(event);
		}
		return super.onTouchEvent(event);
		
		
	}

	@Override
	public void addView(View child) {
		// TODO Auto-generated method stub
		super.addView(child);
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	/**
	 * Generate a value suitable for use in {@link #setId(int)}.
	 * This value will not collide with ID values generated at build time by aapt for R.id.
	 *
	 * @return a generated ID value
	 */
	@SuppressLint("Override")
	public static int generateViewId() {
	    for (;;) {
	        final int result = sNextGeneratedId.get();
	        // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
	        int newValue = result + 1;
	        if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
	        if (sNextGeneratedId.compareAndSet(result, newValue)) {
	            return result;
	        }
	    }
	}
	

	
	
}

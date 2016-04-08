package kmit.project.universityselectron;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class MyGestureDetector extends SimpleOnGestureListener {
	
	public static final int SWIPE_MIN_DISTANCE = 125;
	public static final int SWIPE_MAX_OFF_PATH = 250;
	public static final int SWIPE_THRESHOLD_VELOCITY = 100;
	private Context context;
	private Activity activity;
	private Intent leftIntent;
	private Intent rightIntent;
	private Intent downIntent;
	
	public MyGestureDetector(Context context,Activity activity,Intent leftIntent,Intent rightIntent,Intent downIntent)
	{
		super();
		this.context=context;
		this.activity=activity;
		this.leftIntent=leftIntent;
		this.rightIntent=rightIntent;
		this.downIntent=downIntent;
	}
	
	
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		
		if(e1!=null&&e2!=null)
		{
		if (e1.getY() - e2.getY() > SWIPE_MAX_OFF_PATH
				&& Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
			activity.startActivity(downIntent);
			activity.overridePendingTransition(
					R.anim.push_up_in, R.anim.push_down_out);
			return true;
		}

		// right to left swipe
		if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
				&& Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
			activity.startActivity(rightIntent);
			activity.overridePendingTransition(
					R.anim.push_left_in,R.anim.push_right_out);
			return true;
		} 
		
		//left to right swipe
		else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
				&& Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
			activity.startActivity(leftIntent);
			activity.overridePendingTransition(
					R.anim.push_right_in,R.anim.push_left_out);
		return true;
		}
		}
		return false;
	}
	
	@Override
    public boolean onDown(MotionEvent e) {
            return true;
    }
}


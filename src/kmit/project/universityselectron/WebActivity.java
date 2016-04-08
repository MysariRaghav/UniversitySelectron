package kmit.project.universityselectron;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class WebActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d("url", "entered into wesiteActivity");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.website);
		Intent i=getIntent();
		String url=i.getStringExtra("gotURL");
		Log.d("url", "u got url from previous activity"+url);
		WebView browser = (WebView) findViewById(R.id.webview);
		browser.loadUrl(url);
	}

}

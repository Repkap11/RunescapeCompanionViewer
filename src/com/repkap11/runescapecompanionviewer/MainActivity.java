package com.repkap11.runescapecompanionviewer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

	private static final String TAG = "Paul";
	private WebView mWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mWebView = (WebView)findViewById(R.id.web_view);
		//mWebView.setBackgroundColor(Color.parseColor("#0D252F"));
		mWebView.setBackgroundColor(Color.BLACK);
		WebSettings webSettings = mWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setDomStorageEnabled(true);
		//webView.loadUrl("http://beta.html5test.com/");
		mWebView.loadUrl("http://www.runescape.com/companion/comapp.ws");
		Log.e(TAG,"Loaded URL");
	}

	@Override
    public void onBackPressed() {
		int n = -1;
		while (mWebView.canGoBackOrForward(n)&&n>-20){
			n--;
		}
		Log.e(TAG,"Back until: "+n);
        if(n>=-3) {
        	Log.e(TAG,"Can't go back");
        	 finish();
        	//android.os.Process.killProcess(android.os.Process.myPid());
        } else {
        	Log.e(TAG,"Can go back");
            mWebView.goBack();
        }
    }

	@Override
	protected void onDestroy() {
		android.os.Process.killProcess(android.os.Process.myPid());
		super.onDestroy();
	}

}

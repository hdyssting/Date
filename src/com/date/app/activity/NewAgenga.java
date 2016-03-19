package com.date.app.activity;

import com.date.app.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class NewAgenga extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.new_agenda_activity);
	}
	
}

package com.date.app.activity;

import com.date.app.R;
import com.date.app.fragment.Info;
import com.date.app.fragment.Person;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class ActivityOverview extends Activity implements OnClickListener {

	private Button person;
	
	private Button info;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_overview);
		person = (Button) findViewById(R.id.agenda);
		person.setOnClickListener(this);
		info = (Button) findViewById(R.id.info);
		info.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		Person personFragment = null;
		Info infoFragment = null;
		switch (v.getId()) {
		case R.id.agenda:
			if (! (infoFragment == null)) {
				infoFragment.onDestroy();
			}
			personFragment = new Person();
			
			transaction.replace(R.id.up_layout, personFragment);
			transaction.commit();
			break;
		case R.id.info:
			if (! (personFragment == null)) {
				personFragment.onDestroy();
			}
			infoFragment = new Info();
			transaction.replace(R.id.up_layout, infoFragment);
			transaction.commit();
			break;
		default:
			break;
		}
	}
	
}

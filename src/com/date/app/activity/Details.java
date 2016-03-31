package com.date.app.activity;

import com.date.app.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Details extends Activity implements OnClickListener {

	private Button detailsBack;
	
	private TextView detailName;
	
	private TextView detailTime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.details);
		Intent intent = getIntent();
		detailsBack = (Button) findViewById(R.id.details_back);
		detailsBack.setOnClickListener(this);
		detailName = (TextView) findViewById(R.id.detail_name);
		detailTime = (TextView) findViewById(R.id.detail_time);
		detailName.setText("日程名称：" + intent.getStringExtra("eventName"));
		detailTime.setText("日期" + intent.getIntExtra("year", 0) + "年" + intent.getIntExtra("month", 0) +"月" +
				intent.getIntExtra("day", 0) + "日");
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.details_back:
			finish();
			break;

		default:
			break;
		}
	}
	
}

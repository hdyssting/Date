package com.date.app.activity;

import com.date.app.R;
import com.date.app.model.DateDB;
import com.date.app.model.RecordDate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class NewAgenga extends Activity implements OnClickListener {

	private Button saveAgenda;
	
	private EditText eventName;
	
	private DatePicker datePicker;
	
	private DateDB dateDB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.new_agenda_activity);
		saveAgenda = (Button) findViewById(R.id.save_agenda);
		saveAgenda.setOnClickListener(this);
		eventName = (EditText) findViewById(R.id.event_name);
		datePicker = (DatePicker) findViewById(R.id.date_pick);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.save_agenda:
			dateDB = DateDB.getInstance(this);
			RecordDate recordDate = new RecordDate();
			recordDate.setEventName(eventName.getText().toString());
			recordDate.setDay(datePicker.getDayOfMonth());
			recordDate.setMonth(datePicker.getMonth());
			recordDate.setYear(datePicker.getYear());
			dateDB.saveDate(recordDate);
			Toast.makeText(this, "新建成功", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this, ActivityOverview.class);
			startActivity(intent);
			finish();
			break;

		default:
			break;
		}
	}
	
}

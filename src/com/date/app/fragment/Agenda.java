package com.date.app.fragment;

import java.util.ArrayList;
import java.util.List;

import com.date.app.R;
import com.date.app.activity.Details;
import com.date.app.activity.NewAgenga;
import com.date.app.model.DateDB;
import com.date.app.model.RecordDate;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Agenda extends Fragment implements OnItemClickListener {
	
	private Button addAgenda;
	
	private ListView listView;
	
	private List<RecordDate> dateList;
	
	private ArrayAdapter<RecordDate> adapter;
	
	private DateDB dateDB;
	
	private List<RecordDate> datalist = new ArrayList<RecordDate>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.agenda_fragment, container, false);
		addAgenda = (Button) view.findViewById(R.id.add_agenda);
		addAgenda.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), NewAgenga.class);
				startActivity(intent);
				getActivity().finish();
			}
		});
		listView = (ListView) view.findViewById(R.id.agenda_list);
		Log.d("MainActivity", "succeess");
		dateDB = DateDB.getInstance(getActivity());
		
		dateList = dateDB.loadDate();
		if (dateList.size() > 0) {
			datalist.clear();
			for (RecordDate r : dateList) {
				datalist.add(r);
			}
		}
		
		adapter = new ArrayAdapter<RecordDate>(getActivity(), android.R.layout.simple_list_item_1,
				datalist);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		RecordDate recordDate = datalist.get(position);
		Intent intent = new Intent(getActivity(), Details.class);
		intent.putExtra("eventName", recordDate.getEventName());
		intent.putExtra("year", recordDate.getYear());
		intent.putExtra("month", (recordDate.getMonth()+1));
		intent.putExtra("day", recordDate.getDay());
		startActivity(intent);
		//getActivity().finish();
	}
	
	
}
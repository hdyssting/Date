package com.date.app.fragment;

import com.date.app.R;
import com.date.app.activity.NewAgenga;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Agenda extends Fragment {
	
	private Button addAgenda;

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
			}
		});
		return view;
	}
	
	
}
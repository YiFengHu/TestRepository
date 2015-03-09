package com.example.moneybook.fragment;

import com.example.moneybook.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WeeklyDetailFragment extends Fragment{

	private View rootView=null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_weekly_detail, null);
		return rootView;
	}

	
}

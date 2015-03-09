package com.example.moneybook.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moneybook.R;
import com.example.moneybook.base.BaseFragment;

public class MonthlyDetailFragment extends BaseFragment{
private View rootView=null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_monthly_detail, null);
		return rootView;
	}
}

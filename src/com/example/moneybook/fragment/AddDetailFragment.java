package com.example.moneybook.fragment;

import com.example.moneybook.R;
import com.example.moneybook.base.BaseFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AddDetailFragment extends BaseFragment{

	private View rootView=null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_add_detail, null);
		return rootView;
	}

	
}

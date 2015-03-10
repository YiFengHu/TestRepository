package com.example.moneybook.fragment;

import com.example.moneybook.R;
import com.example.moneybook.base.BaseFragment;
import com.example.moneybook.customview.CircleButton;
import com.example.moneybook.util.AnimationUtil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AddDetailFragment extends BaseFragment{

	private View rootView=null;
	private CircleButton addButton = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_add_detail, null);
		addButton = (CircleButton) rootView.findViewById(R.id.addDetail_addButton);

		return rootView;
	}

	@Override
	public void onResume() {
		super.onResume();
		AnimationUtil.startViewAppearAnimation(addButton);

	}
}

package com.example.moneybook.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moneybook.R;
import com.example.moneybook.base.BaseFragment;
import com.example.moneybook.tool.chart.ChartViewBuilder;

public class DailyDetailFragment extends BaseFragment{

	private View rootView = null;
	private String[] mMonth = new String[] { "Jan", "Feb", "Mar", "Apr", "May",
			"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_daily_detail, null);
		
		int[] x = { 0,1,2,3,4,5,6,7, 8, 9, 10, 11 };
		int[] income = { 2000,2500,2700,3000,2800,3500,3700,3800, 0,0,0,0};
		int[] expense = {2200, 2700, 2900, 2800, 2600, 3000, 3300, 3400, 0, 0, 0, 0 };
		
		ChartViewBuilder.getInstance().startDrawLinChart(getActivity(), rootView, R.id.chart, x, income, expense, mMonth);
		
		return rootView;
	}
	
}

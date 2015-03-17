package com.example.moneybook.fragment;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.moneybook.R;
import com.example.moneybook.base.BaseFragment;
import com.example.moneybook.customview.PagerSlidingTabStrip;
import com.example.moneybook.home.MainActivity;

public class MainFragment extends BaseFragment  implements TabListener, OnPageChangeListener{
	
	private static final String TAG = MainFragment.class.getSimpleName();
	
	private static final int ID_MAIN_LAYOUT = R.layout.fragment_main;
	protected static final int TAB_DAILY_DETAIL= R.string.main_daily_detail;
	protected static final int TAB_WEEKLY_DETAIL= R.string.main_weekly_detail;
	protected static final int TAB_MONTHLY_DETAIL= R.string.main_monthly_detail;
	
	private Context context=null;
	
	private View rootView = null;
	private ViewPager viewPager=null;
	private ArrayList<TabItem> viewPagerDataList=null;
	private ArrayList<Tab> tabList=null;
	private MyPagerAdapter myPagerAdapter=null;
	private PagerSlidingTabStrip pagerSlidingTabStrip=null;
	
	private FragmentManager fragmentManager=null;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		context = activity;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		fragmentManager = ((MainActivity)getActivity()).getSupportFragmentManager();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(ID_MAIN_LAYOUT, null);
		
		viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
		pagerSlidingTabStrip = (PagerSlidingTabStrip)rootView.findViewById(R.id.pagerSlidingTabStrip);
		
		initViewPager();
		initTabStrip();
		return rootView;
	}
	
	private void initTabStrip() {
		pagerSlidingTabStrip.setViewPager(viewPager);
		pagerSlidingTabStrip.setIndicatorColor(Color.RED);
		pagerSlidingTabStrip.setOnPageChangeListener(this);
	}

	private void initViewPager() {
		tabList = new ArrayList<ActionBar.Tab>();
		viewPagerDataList = new ArrayList<TabItem>();
		viewPagerDataList.add(new TabItem(context.getString(TAB_DAILY_DETAIL), new DailyDetailFragment()));
		viewPagerDataList.add(new TabItem(context.getString(TAB_WEEKLY_DETAIL), new WeeklyDetailFragment()));
		viewPagerDataList.add(new TabItem(context.getString(TAB_MONTHLY_DETAIL), new MonthlyDetailFragment()));

		myPagerAdapter = new MyPagerAdapter(getActivity().getSupportFragmentManager(),viewPagerDataList);
		viewPager.setAdapter(myPagerAdapter);
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(this);

//		actionBar = getActionBar();
//		actionBar.setDisplayHomeAsUpEnabled(false);
//		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//
//		for (int i = 0; i < viewPagerDataList.size(); i++) {
//			Tab tab = actionBar.newTab()
//					.setText(viewPagerDataList.get(i).getTitle())
//					.setTabListener(this);
//			tab.setTag(i);
//			actionBar.addTab(tab);
//			tabList.add(tab);
//		}

	}

	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		viewPager.setCurrentItem((Integer)tab.getTag());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		
	}
	

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int page) {
//		actionBar.selectTab(tabList.get(page));
	}
	
	class TabItem{
		private String title;
		private Fragment fragment;
		
		TabItem(String title, Fragment fragment){
			this.title= title;
			this.fragment = fragment;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Fragment getFragment() {
			return fragment;
		}

		public void setFragment(Fragment fragment) {
			this.fragment = fragment;
		}
		
		
	}
	
	class MyPagerAdapter extends FragmentPagerAdapter{

		private ArrayList<TabItem> dataList=null;

		public MyPagerAdapter(FragmentManager fm, ArrayList<TabItem> dataList) {
			super(fm);
			this.dataList =dataList;
		}
		
		@Override
		public int getCount() {
			return dataList.size();
		}
		
		@Override
		public Fragment getItem(int position) {
			return dataList.get(position).getFragment();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return dataList.get(position).getTitle();
		}
	
	}
}

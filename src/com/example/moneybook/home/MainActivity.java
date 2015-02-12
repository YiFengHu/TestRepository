package com.example.moneybook.home;

import java.util.ArrayList;

import com.example.moneybook.R;
import com.example.moneybook.fragment.AddDetailFragment;
import com.example.moneybook.fragment.DailyDetailFragment;
import com.example.moneybook.fragment.MonthlyDetailFragment;

import android.app.ActionBar;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements TabListener, OnPageChangeListener{
	
	protected static final String TAB_ADD_DETAIL="Add Detail";
	protected static final String TAB_DAILY_DETAIL="Daily Detail";
	protected static final String TAB_MONTHLY_DETAIL="Monthly Detail";

	
	private ActionBar actionBar=null;
	private Context context=null;
	private TextView textView=null;
	
	private ViewPager viewPager=null;
	private ArrayList<TabItem> viewPagerDataList=null;
	private ArrayList<Tab> tabList=null;
	
	private FragmentManager fragmentManager=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = (Activity)this;
		fragmentManager = getSupportFragmentManager();
		textView = (TextView)findViewById(R.id.textView);
		
		initViewPager();
		initActionBar();
	}

	private void initViewPager() {
		LayoutInflater mInflater = getLayoutInflater().from(this);
        
        viewPagerDataList = new ArrayList<TabItem>();
        viewPagerDataList.add(new TabItem(TAB_ADD_DETAIL, new AddDetailFragment()));
        viewPagerDataList.add(new TabItem(TAB_DAILY_DETAIL, new DailyDetailFragment()));
        viewPagerDataList.add(new TabItem(TAB_MONTHLY_DETAIL, new MonthlyDetailFragment()));
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), viewPagerDataList));
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(this);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		  MenuInflater inflater = getMenuInflater();
		  inflater.inflate(R.menu.main, menu);
		  MenuItem searchItem = menu.findItem(R.id.action_search);  
		  SearchView searchView = (SearchView) searchItem.getActionView(); 
		  
		  return super.onCreateOptionsMenu(menu);  
	}
	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		
		case R.id.action_add_detail:
			
			Toast.makeText(context, "Add detail clicked!", Toast.LENGTH_SHORT).show();
			return true;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	protected void initActionBar(){
		tabList = new ArrayList<ActionBar.Tab>();
		actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		for(int i=0; i<viewPagerDataList.size(); i++){
			Tab tab = actionBar.newTab().setText(viewPagerDataList.get(i).getTitle()).setTabListener(this);
			tab.setTag(i);
			actionBar.addTab(tab);
		}
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		Toast.makeText(context, (String)tab.getText()+": "+ft.toString(), Toast.LENGTH_SHORT).show();
		viewPager.setCurrentItem((int)tab.getTag());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
//		Toast.makeText(context, (String)tab.getText()+": "+ft.toString(), Toast.LENGTH_SHORT).show();
//		textView.setText(tab.getText());
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
//		Toast.makeText(context, (String)tab.getText()+": "+ft.toString(), Toast.LENGTH_SHORT).show();
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
		public boolean isViewFromObject(View view, Object object) {
			return view == (View)object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(dataList.get(position).getFragment().getView());
			return container;
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}
	
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
		actionBar.selectTab(tabList.get(page));
	}
}

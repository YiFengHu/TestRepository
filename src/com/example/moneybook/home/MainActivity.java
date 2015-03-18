package com.example.moneybook.home;

import java.util.ArrayList;

import com.example.moneybook.R;
import com.example.moneybook.base.BaseFragmentActivity;
import com.example.moneybook.customview.PagerSlidingTabStrip;
import com.example.moneybook.fragment.AddDetailFragment;
import com.example.moneybook.fragment.DailyDetailFragment;
import com.example.moneybook.fragment.MainFragment;
import com.example.moneybook.fragment.MonthlyDetailFragment;
import com.example.moneybook.fragment.WeeklyDetailFragment;

import android.app.ActionBar;
import android.app.ActionBar.TabListener;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
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

public class MainActivity extends BaseFragmentActivity{
	
	
	public static final int LAYOUT_FRAME = R.id.main_frameLayout;
	private ActionBar actionBar=null;
	private Context context=null;
	private FragmentManager fragmentManager=null;
	private LayoutInflater mInflater=null;
	
	private AddDetailFragment addFragment = null;
	private MainFragment mainFragment = null;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fragmentManager = getSupportFragmentManager();
		mInflater = getLayoutInflater().from(this);
		context = (Activity)this;
		beginMainTransaction();
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
			beginAddDetailTransaction();
			Toast.makeText(context, "Add detail clicked!", Toast.LENGTH_SHORT).show();
			return true;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void beginMainTransaction(){
		if(mainFragment == null){
			mainFragment = new MainFragment();
		}

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(LAYOUT_FRAME, mainFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
		
		fragmentManager.beginTransaction();
	}
	
	public void beginAddDetailTransaction(){
		if(addFragment == null){
			addFragment = new AddDetailFragment();
		}

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(LAYOUT_FRAME, addFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null).commit();
		
		fragmentManager.beginTransaction();
	}
	
}

package com.smkn2.recyclerview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.smkn2.adapters.ViewPagerAdapter12;
import com.smkn2.cikarangbarat.R;

public class RecyclerView12 extends AppCompatActivity {
	
	private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
		
		toolbar = (Toolbar) findViewById(R.id.tab_toolbar);

        setupToolbar();

        viewPager = (ViewPager) findViewById(R.id.tab_view_pager);

        setupViewPager();

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        setupTab();
		
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
	}
	
	private void setupToolbar(){
        toolbar.setTitle(getString(R.string.recycler_view_12_title));
		toolbar.setSubtitle(getString(R.string.recycler_view_12_subtitle));
    }
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				onBackPressed();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	private void setupTab(){
        tabLayout.setupWithViewPager(viewPager);
		tabLayout.post(tabLayout_config);
    }
	
	Runnable tabLayout_config = new Runnable()
	{
		@Override
		public void run()
		{

			if(tabLayout.getWidth() < RecyclerView12.this.getResources().getDisplayMetrics().widthPixels)
			{
				tabLayout.setTabMode(TabLayout.MODE_FIXED);
				ViewGroup.LayoutParams mParams = tabLayout.getLayoutParams();
				mParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
				tabLayout.setLayoutParams(mParams);

			}
			else
			{
				tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
			}
		}
	};

    private void setupViewPager(){
        viewPager.setAdapter(new ViewPagerAdapter12(getSupportFragmentManager()));
    }
	
}

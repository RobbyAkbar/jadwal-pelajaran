package com.smkn2.recyclerview;

import android.os.*;
import com.smkn2.cikarangbarat.*;
import android.support.v7.widget.*;
import android.support.v7.app.*;
import android.view.*;
import android.support.design.widget.*;
import android.support.v4.view.*;
import com.smkn2.adapters.*;

public class RecyclerView1 extends AppCompatActivity {
	
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
        toolbar.setTitle(getString(R.string.recycler_view_1_title));
		toolbar.setSubtitle(getString(R.string.recycler_view_1_subtitle));
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

			if(tabLayout.getWidth() < RecyclerView1.this.getResources().getDisplayMetrics().widthPixels)
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
        viewPager.setAdapter(new ViewPagerAdapter1(getSupportFragmentManager()));
    }
	
}

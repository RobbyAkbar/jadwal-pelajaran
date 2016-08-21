package com.smkn2.cikarangbarat;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
NavigationView.OnNavigationItemSelectedListener{

    private final static String JADWAL_PELAJARAN_FRAGMENT_TAG = "jadwal_pelajaran";
    private final static String INFO_FRAGMENT_TAG = "info";
    private final static String CATATAN_FRAGMENT_TAG = "catatan";
    private final static String TENTANG_FRAGMENT_TAG = "tentang";
    private final static String SELECTED_TAG = "selected_index";
    private final static int JADWAL_PELAJARAN = 0;
    private final static int INFO = 1;
    private final static int CATATAN = 2;
    private final static int TENTANG = 3;
    private final static int KELUAR = 4;

    private static int selectedIndex;

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        if(savedInstanceState!=null){
            navigationView.getMenu().getItem(savedInstanceState.getInt(SELECTED_TAG)).setChecked(true);
            return;
        }

        selectedIndex = JADWAL_PELAJARAN;

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
														   new JadwalPelajaranFragment(),JADWAL_PELAJARAN_FRAGMENT_TAG).commit();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_TAG, selectedIndex);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        switch(menuItem.getItemId()){
            case R.id.jadwal_pelajaran:
                if(!menuItem.isChecked()){
                    selectedIndex = JADWAL_PELAJARAN;
                    menuItem.setChecked(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new JadwalPelajaranFragment(), JADWAL_PELAJARAN_FRAGMENT_TAG).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.info:
                if(!menuItem.isChecked()){
                    selectedIndex = INFO;
                    menuItem.setChecked(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new InfoFragment(), INFO_FRAGMENT_TAG).commit();
                }
            case R.id.catatan:
                if(!menuItem.isChecked()){
                    selectedIndex = CATATAN;
                    menuItem.setChecked(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new CatatanFragment(),CATATAN_FRAGMENT_TAG).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.tentang:
                if(!menuItem.isChecked()){
                    selectedIndex = TENTANG;
                    menuItem.setChecked(true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new TentangFragment(),TENTANG_FRAGMENT_TAG).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.keluar:
                if(!menuItem.isChecked()){
                    selectedIndex = KELUAR;
                    menuItem.setChecked(true);
                    keluar();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
        }
        return false;
    }

    public void setupNavigationDrawer(Toolbar toolbar){
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.open_drawer,R.string.close_drawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
	
	private Toast toast;
    private long lastBackPressTime = 0;

    @Override
    public void onBackPressed() {
        if (this.lastBackPressTime < System.currentTimeMillis() - 4000) {
            toast = Toast.makeText(this, "Tekan sekali lagi untuk keluar",
								   Toast.LENGTH_LONG);
            toast.show();
            this.lastBackPressTime = System.currentTimeMillis();
        } else {
            if (toast != null) {
                toast.cancel();
            }
            super.onBackPressed();
        }
    }
	
	private void keluar() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
        builder.setMessage("Apakah anda yakin keluar dari aplikasi ini?")
                .setCancelable(false)
                .setPositiveButton("Ya", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                MainActivity.this.finish();
                            }
                        })
                .setNegativeButton("Tidak", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int arg1) {
                                dialog.cancel();
                            }
                        })
                .show();
    }

    public void website(View view) {
		startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, Uri.parse("http://smkn2cikbar.wordpress.com".trim())), "Open with"));
	}

}
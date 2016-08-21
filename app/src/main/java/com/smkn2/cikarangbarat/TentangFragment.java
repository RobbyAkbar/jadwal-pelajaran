package com.smkn2.cikarangbarat;

import android.support.v4.app.*;
import android.view.*;
import android.os.*;
import android.support.v7.widget.*;
import android.app.Activity;
import java.util.*;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.*;
import android.widget.ImageView;
import android.view.animation.*;
import android.graphics.drawable.*;
import android.widget.AdapterView;
import android.net.*;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

public class TentangFragment extends Fragment {

	ArrayList<DetilBaris> listdetil;
	DetilBaris db;
	AdapterKu adapter;
	ListView lv;
	ClipboardUtil clipboardUtil;
	private static final String[] text = new String[]{//text[].length dan ikon[].lenght harus slalu sama. pass null pada ikon jika tidk menggunakan. 
		"Jadwal Pelajaran V1.5",//0
		"Created by Robby Akbar",//1
		" PIN 5B55F5F0 (Klik untuk salin)", //2 untuk menambahkan PIN bb ikuti format penulisan ini agar saat user klik pin labgsung dikopi. perhatikan huruf besar dan spasi sesuai contoh
		" www.facebook.com/robby.akbar.75",//3
		" www.android-inyourhand.esy.es", //4 url akan otomatis klickable, jagn memakai http://. ikuti contoh penulisan url
		"Copyright © 2016 ICT Art-Tractive",//5
		" www.facebook.com/groups/1609683786018600",//6
		" www.artractivesite.wordpress.com",//7
	};

	private MainActivity mainActivity;
    private Toolbar toolbar;


    public TentangFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.tentang_fragment, container, false);

        toolbar = (Toolbar)view.findViewById(R.id.toolbar);

        setupToolbar();

		listdetil = new ArrayList<DetilBaris>();
		adapter = new AdapterKu(getActivity().getApplicationContext(), listdetil);
		lv = (ListView) view.findViewById(R.id.list_view_about);
		lv.setDividerHeight(0);
		lv.setAdapter(adapter);

		new Handler().postDelayed(new Runnable(){@Override public void run() {

					Drawable[] ikon=new Drawable[8];
					ikon[0] = getResources().getDrawable(R.drawable.ic_launcher);
					ikon[1] = null;
					ikon[2] = getResources().getDrawable(R.drawable.bbm);
					ikon[3] = getResources().getDrawable(R.drawable.fb);
					ikon[4] = getResources().getDrawable(R.drawable.www);
					ikon[5] = null;
					ikon[6] = getResources().getDrawable(R.drawable.fb);
					ikon[7] = getResources().getDrawable(R.drawable.www);

					listdetil.clear();
					for (int i=0;i < text.length;i++)
					{
						db = new DetilBaris();
						db.st = text[i];
						db.dw = ikon[i];
						listdetil.add(db);
					}
					adapter.notifyDataSetChanged();
					clipboardUtil = new ClipboardUtil();
					lv.setOnItemClickListener(detekKlik());
				}}, 100);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity.setupNavigationDrawer(toolbar);
    }

    private void setupToolbar(){
        toolbar.setTitle(getString(R.string.tentang_fragment_title));
		toolbar.setSubtitle(getString(R.string.tentang_fragment_subtitle));
        mainActivity.setSupportActionBar(toolbar);
    }

	private AdapterView.OnItemClickListener detekKlik() {
    	return new AdapterView.OnItemClickListener(){

    		public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4) {
    			if (text[p3].contains("PIN"))anim(null);
    			if (text[p3].contains("PIN")) if (clipboardUtil.copyToClipboard(getActivity().getApplicationContext(), text[p3].trim().split(" ")[1]))Toast.makeText(getActivity().getApplicationContext(), "PIN disalin", Toast.LENGTH_SHORT).show();
    			if (text[p3].contains(".com"))startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + text[p3].trim())), "Buka dengan"));
    			if (text[p3].contains(".esy.es"))startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + text[p3].trim())), "Buka dengan"));
    		}
    	};
    }

	private class DetilBaris {
		Drawable dw;
		String st;
	}

	private class AdapterKu extends BaseAdapter {
		List<DetilBaris> list = new ArrayList<DetilBaris>();
		LayoutInflater li;
		AdapterKu(Context c, ArrayList<DetilBaris> list) {
			li = LayoutInflater.from(c);
			this.list = list;
		}
		public int getCount() {
			return	list.size();
		}

		public Object getItem(int p1) {
			return list.get(p1);
		}

		public long getItemId(int p1) {
			return p1;
		}
		class Vh {
			ImageView iv;
			TextView tv;
		}

		public View getView(int p1, View p2, ViewGroup p3) {
			Vh h;

			if (p2 == null) {
				p2 = li.inflate(R.layout.row_list_view_about, null);

				h = new Vh();

				h.iv = (ImageView) p2.findViewById(R.id.about_row_ikon);
				h.tv = (TextView) p2.findViewById(R.id.about_row_text);
				p2.setTag(h);
			}
			else {
				h = (Vh) p2.getTag();
			}

			if (list.get(p1) != null)
			h.iv.setImageDrawable(list.get(p1).dw);
			h.tv.setText(list.get(p1).st);
			
			return p2;
			
		}
		
	}

	public static String JAGA() {
		return text[2];
	}

	public void anim(View view){
		LinearLayout ll = (LinearLayout) getActivity().findViewById(R.id.banner);
		Animation animation1 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.anim);
		ll.startAnimation(animation1);
	}

}

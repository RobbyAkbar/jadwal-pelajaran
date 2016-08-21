package com.smkn2.cikarangbarat;

import android.support.v4.app.*;
import android.view.*;
import android.os.*;
import android.support.v7.widget.*;
import android.app.Activity;
import java.util.*;
import com.smkn2.models.*;
import com.smkn2.adapters.*;
import android.widget.Toast;
import android.content.*;
import com.smkn2.recyclerview.*;

public class JadwalPelajaranFragment extends Fragment {
	
	private List<CardItemModel> cardItems = new ArrayList<>(42);
    private MainActivity mainActivity;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;

    public JadwalPelajaranFragment() {
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
        View view =  inflater.inflate(R.layout.jadwal_pelajaran_fragment, container, false);

        toolbar = (Toolbar)view.findViewById(R.id.toolbar);

        setupToolbar();
		
		recyclerView = (RecyclerView)view.findViewById(R.id.jadwal_recycler_view);

        setupRecyclerView();

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity.setupNavigationDrawer(toolbar);
    }

    private void setupToolbar(){
        toolbar.setTitle(getString(R.string.jadwalpelajaran_fragment_title));
		toolbar.setSubtitle(getString(R.string.jadwalpelajaran_fragment_subtitle));
        mainActivity.setSupportActionBar(toolbar);
    }
	
	private void setupRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(mainActivity));
        recyclerView.setHasFixedSize(true);
        initializeCardItemList();
        recyclerAdapter = new RecyclerAdapter(cardItems, new CustomItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				final Intent intent;
				switch (position) {
					case 0:
						intent = new Intent (getActivity(), RecyclerView0.class);
						startActivity(intent);
						break;
					case 1:
						intent = new Intent (getActivity(), RecyclerView1.class);
						startActivity(intent);
						break;
					case 2:
						intent = new Intent (getActivity(), RecyclerView2.class);
						startActivity(intent);
						break;
					case 3:
						intent = new Intent (getActivity(), RecyclerView3.class);
						startActivity(intent);
						break;
					case 4:
						intent = new Intent (getActivity(), RecyclerView4.class);
						startActivity(intent);
						break;
					case 5:
						intent = new Intent (getActivity(), RecyclerView5.class);
						startActivity(intent);
						break;
					case 6:
						intent = new Intent (getActivity(), RecyclerView6.class);
						startActivity(intent);
						break;
					case 7:
						intent = new Intent (getActivity(), RecyclerView7.class);
						startActivity(intent);
						break;
					case 8:
						intent = new Intent (getActivity(), RecyclerView8.class);
						startActivity(intent);
						break;
					case 9:
						intent = new Intent (getActivity(), RecyclerView9.class);
						startActivity(intent);
						break;
					case 10:
						intent = new Intent (getActivity(), RecyclerView10.class);
						startActivity(intent);
						break;
					case 11:
						intent = new Intent (getActivity(), RecyclerView11.class);
						startActivity(intent);
						break;
					case 12:
						intent = new Intent (getActivity(), RecyclerView12.class);
						startActivity(intent);
						break;
					case 13:
						intent = new Intent (getActivity(), RecyclerView13.class);
						startActivity(intent);
						break;
					case 14:
						intent = new Intent (getActivity(), RecyclerView14.class);
						startActivity(intent);
						break;
					case 15:
						intent = new Intent (getActivity(), RecyclerView15.class);
						startActivity(intent);
						break;
					case 16:
						intent = new Intent (getActivity(), RecyclerView16.class);
						startActivity(intent);
						break;
					case 17:
						intent = new Intent (getActivity(), RecyclerView17.class);
						startActivity(intent);
						break;
					case 18:
						intent = new Intent (getActivity(), RecyclerView18.class);
						startActivity(intent);
						break;
					case 19:
						intent = new Intent (getActivity(), RecyclerView19.class);
						startActivity(intent);
						break;
					case 20:
						intent = new Intent (getActivity(), RecyclerView20.class);
						startActivity(intent);
						break;
					case 21:
						intent = new Intent (getActivity(), RecyclerView21.class);
						startActivity(intent);
						break;
					case 22:
						intent = new Intent (getActivity(), RecyclerView22.class);
						startActivity(intent);
						break;
					case 23:
						intent = new Intent (getActivity(), RecyclerView23.class);
						startActivity(intent);
						break;
					case 24:
						intent = new Intent (getActivity(), RecyclerView24.class);
						startActivity(intent);
						break;
					case 25:
						intent = new Intent (getActivity(), RecyclerView25.class);
						startActivity(intent);
						break;
					case 26:
						intent = new Intent (getActivity(), RecyclerView26.class);
						startActivity(intent);
						break;
					case 27:
						intent = new Intent (getActivity(), RecyclerView27.class);
						startActivity(intent);
						break;
					case 28:
						intent = new Intent (getActivity(), RecyclerView28.class);
						startActivity(intent);
						break;
					case 29:
						intent = new Intent (getActivity(), RecyclerView29.class);
						startActivity(intent);
						break;
					case 30:
						intent = new Intent (getActivity(), RecyclerView30.class);
						startActivity(intent);
						break;
					case 31:
						intent = new Intent (getActivity(), RecyclerView31.class);
						startActivity(intent);
						break;
					case 32:
						intent = new Intent (getActivity(), RecyclerView32.class);
						startActivity(intent);
						break;
					case 33:
						intent = new Intent (getActivity(), RecyclerView33.class);
						startActivity(intent);
						break;
					case 34:
						intent = new Intent (getActivity(), RecyclerView34.class);
						startActivity(intent);
						break;
					case 35:
						intent = new Intent (getActivity(), RecyclerView35.class);
						startActivity(intent);
						break;
					case 36:
						intent = new Intent (getActivity(), RecyclerView36.class);
						startActivity(intent);
						break;
					case 37:
						intent = new Intent (getActivity(), RecyclerView37.class);
						startActivity(intent);
						break;
					case 38:
						intent = new Intent (getActivity(), RecyclerView38.class);
						startActivity(intent);
						break;
					case 39:
						intent = new Intent (getActivity(), RecyclerView39.class);
						startActivity(intent);
						break;
					case 40:
						intent = new Intent (getActivity(), RecyclerView40.class);
						startActivity(intent);
						break;
					case 41:
						intent = new Intent (getActivity(), RecyclerView41.class);
						startActivity(intent);
						break;
				}
			}
		});
        recyclerView.setAdapter(recyclerAdapter);
    }
	
	private void initializeCardItemList(){
        CardItemModel cardItemModel;
        String[] cardTitles = getResources().getStringArray(R.array.card_titles);
        String[] cardContents = getResources().getStringArray(R.array.card_contents);
        final int length = cardTitles.length;
        for(int i=0;i<length;i++){
            cardItemModel = new CardItemModel(cardTitles[i],cardContents[i]);
            cardItems.add(cardItemModel);
        }
    }

}
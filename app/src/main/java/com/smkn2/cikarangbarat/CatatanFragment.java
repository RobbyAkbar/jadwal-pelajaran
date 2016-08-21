package com.smkn2.cikarangbarat;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.*;
import android.view.*;
import android.os.*;
import android.support.v7.widget.*;
import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

public class CatatanFragment extends Fragment {

	private MainActivity mainActivity;
    private Toolbar toolbar;
    private EditText isi;

    public CatatanFragment() {
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
        View view =  inflater.inflate(R.layout.catatan_fragment, container, false);

        isi = (EditText) view.findViewById(R.id.isi);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("example", Context.MODE_PRIVATE);
        isi.setText(sharedPreferences.getString("save", null));

        toolbar = (Toolbar)view.findViewById(R.id.toolbar);

        setupToolbar();

        setHasOptionsMenu(true);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity.setupNavigationDrawer(toolbar);
    }

    private void setupToolbar(){
        toolbar.setTitle(getString(R.string.catatan_fragment_title));
		toolbar.setSubtitle(getString(R.string.catatan_fragment_subtitle));
        mainActivity.setSupportActionBar(toolbar);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_save, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.simpan){
            SharedPreferences shared = getActivity().getSharedPreferences("example", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = shared.edit();
            String word = isi.getText().toString();
            edit.putString("save", word);
            edit.commit();
            Toast.makeText(getActivity(), "Catatan Telah Diperbarui", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}
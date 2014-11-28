package edu.ucuccs.transmuter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class MyPreferenceActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pref_with_actionbar);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(edu.ucuccs.transmuter.R.id.toolbar);
        setSupportActionBar(toolbar);
        getFragmentManager().beginTransaction().replace(R.id.content_frame, new MyPreference()).commit();
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
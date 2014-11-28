package edu.ucuccs.transmuter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class OpenSource extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_open_source);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
}

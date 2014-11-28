package edu.ucuccs.transmuter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class AboutTransmuter extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_transmuter);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
}

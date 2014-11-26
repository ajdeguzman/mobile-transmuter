package edu.ucuccs.transmuter;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends ActionBarActivity  {

	Spinner mPercentage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPercentage = (Spinner) findViewById(R.id.eSpinnerPercentage);
    }

	@Override
	public void onStart(){
		super.onStart();
		ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(getApplicationContext(), R.array.array_percentage, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mPercentage.setAdapter(adapter);
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    private void showDialog(){
    	AlertDialog.Builder bldr = new AlertDialog.Builder(this);
		bldr.setTitle("Add to Favorites");
		bldr.setMessage("Setting this as ds");
		bldr.setCancelable(false);
		bldr.setPositiveButton("Yes", new DialogInterface.OnClickListener() { 
			public void onClick(DialogInterface dialog, int which) {
	
				}
			})
			.setNegativeButton("No", new DialogInterface.OnClickListener() { 
			public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			});
		final AlertDialog alt = bldr.create();
		alt.show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	startActivity(new Intent(MainActivity.this, MyPreference.class));
        	showDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void clickGenerate(View v){
    	startActivity(new Intent(MainActivity.this, ResultActivity.class));
    }

}

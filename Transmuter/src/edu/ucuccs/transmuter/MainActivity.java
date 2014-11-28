package edu.ucuccs.transmuter;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity  {

	Spinner mPercentage;
	EditText txtPassing, txtHigh;
	String keyHigh, keyLowest, passingGrade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPercentage = (Spinner) findViewById(R.id.eSpinnerPercentage);
        txtPassing = (EditText) findViewById(R.id.txtPassing);
        txtHigh = (EditText) findViewById(R.id.txtHigh);
        mPercentage.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				if(!isEmpty(txtHigh)){
					double high = Integer.parseInt(txtHigh.getText().toString());
					double passingScore = 0;
					switch(position){
						case 0:
							passingScore = high * 0.8;
							txtPassing.setText((int)passingScore + "");
							break;
						case 1:
							passingScore = high * 0.7;
							txtPassing.setText((int)passingScore + "");
							break;
						case 2:
							passingScore = high * 0.6;
							txtPassing.setText((int)passingScore + "");
							break;
						case 3:
							passingScore = high * 0.5;
							txtPassing.setText((int)passingScore + "");
							break;
						case 4:
							passingScore = high * 0.4;
							txtPassing.setText((int)passingScore + "");
							break;
						case 5:
							passingScore = high * 0.3;
							txtPassing.setText((int)passingScore + "");
							break;
					}
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
        });
    }

	@Override
	public void onStart(){
		super.onStart();
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.array_percentage, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mPercentage.setAdapter(adapter);
		getPreferencesValue();
		showToast(keyHigh + " " + keyLowest + " " + passingGrade);
		
	}

    public void clickGenerate(View v){
    	if(!isEmpty(txtPassing) || !isEmpty(txtHigh)){
    		int highScore = Integer.parseInt(txtHigh.getText().toString());
    		if(highScore >= 5){
	    		Intent i = new Intent(MainActivity.this, ResultActivity.class);
				Bundle bundle = new Bundle();
				bundle.putInt("highScore", highScore);
				i.putExtras(bundle);
				startActivity(i);
    		}
    	}
    }

 	public void showToast(String msg){
 		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
 	}
 	
	private void getPreferencesValue(){
 		SharedPreferences appPrefs = PreferenceManager.getDefaultSharedPreferences(this);
 		keyHigh = appPrefs.getString("keyHigh", "100");
 		keyLowest = appPrefs.getString("keyLowest", "70");
 		passingGrade = appPrefs.getString("passingGrade", "75");
	}	
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    //Check Text Fields if empty
   	private boolean isEmpty(EditText txt) {
   	    if (txt.getText().toString().trim().length() > 0) {
   	        return false;
   	    } else {
   	        return true;
   	    }
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
        	startActivity(new Intent(MainActivity.this, MyPreferenceActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    

}

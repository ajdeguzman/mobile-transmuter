package edu.ucuccs.transmuter;

import java.util.List;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ResultActivity extends ActionBarActivity {
	ListView lstResult;
	List<String> entries;
	int highScore;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		lstResult = (ListView) findViewById(R.id.lstResult);
		entries.add("haha");
		entries.add("haha");
		
	}

	@Override
	public void onStart(){
		super.onStart();
		try{
			Bundle extras = getIntent().getExtras();
			if (extras != null) {
				highScore = extras.getInt("highScore");
			}
			for(int i = highScore; i > 0; i--){
				entries.add(i + "");
			}
			populateListView();
			
		}catch(Exception e){
			showToast(e + "");
		}
	}
    public void populateListView(){
    	ArrayAdapter<String> arr = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, entries);
    	lstResult.setAdapter(arr);
    }

 	public void showToast(String msg){
 		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
 	}
	/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/
}

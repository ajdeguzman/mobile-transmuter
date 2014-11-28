package edu.ucuccs.transmuter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;
import android.widget.Toast;

public class MyPreference extends PreferenceFragment 
{
	Preference prefDev, aboutOpenSource, rateKey, aboutTransmuter;
    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
		prefDev = (Preference) findPreference("contactDevKey");
		aboutOpenSource = (Preference) findPreference("aboutOpenSource");
		rateKey = (Preference) findPreference("rateKey");
		aboutTransmuter = (Preference) findPreference("aboutTransmuter");
		prefDev.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(Preference arg0) {
				if(isMailClientPresent(getActivity())){
					Intent email = new Intent(Intent.ACTION_SEND);
					email.putExtra(Intent.EXTRA_EMAIL, new String[]{"teamucuccs@gmail.com"});	
					email.setType("message/rfc822");
					startActivity(Intent.createChooser(email, "Choose an Email Client"));	
            	}else{
            		showToast("No apps can perform this client");
            	}
				return false;
			}
        });
		aboutOpenSource.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(Preference arg0) {
	        	startActivity(new Intent(getActivity(), OpenSource.class));
				return false;
			}
        });
		rateKey.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(Preference arg0) {
				Uri uri = Uri.parse("market://details?id=edu.ucuccs.transmuter");
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);
				return false;
			}
        });
		aboutTransmuter.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(Preference arg0) {
	        	startActivity(new Intent(getActivity(), AboutTransmuter.class));
				return false;
			}
        });
    }
	public static boolean isMailClientPresent(Context context){
	    Intent intent = new Intent(Intent.ACTION_SEND);
	    intent.setType("text/html");
	    final PackageManager packageManager = context.getPackageManager();
	    List<ResolveInfo> list = packageManager.queryIntentActivities(intent, 0);
	    if(list.size() == 0)
	        return false;
	    else 
	        return true;
	}
 	public void showToast(String msg){
 		Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
 	}
}
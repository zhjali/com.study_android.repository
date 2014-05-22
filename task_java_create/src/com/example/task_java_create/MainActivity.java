package com.example.task_java_create;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	private LinearLayout nameContainer;
	private LinearLayout addresssContainer;
	private LinearLayout parentContainer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		createNameConatiner();
		createAddressCotainer();
		createParentCotainer();
		setContentView(parentContainer);
	}

	private void createAddressCotainer() {
		addresssContainer = new LinearLayout(this);
		addresssContainer.setLayoutParams(new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		addresssContainer.setOrientation(LinearLayout.VERTICAL);
		TextView addrLbl = new TextView(this);
		addrLbl.setText("Address: ");
		TextView addrValue = new TextView(this);
		addrValue.setText("911 HollyWood Blvd");
		addresssContainer.addView(addrLbl);
		addresssContainer.addView(addrValue);
	}

	private void createNameConatiner() {
		// TODO Auto-generated method stub
		nameContainer = new LinearLayout(this);
		nameContainer.setLayoutParams(new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		TextView nameLbl = new TextView(this);
		nameLbl.setText("Name: ");
		TextView nameValue = new TextView(this);
		nameValue.setText("John Doe");
		nameContainer.addView(nameLbl);
		nameContainer.addView(nameValue);
	}

	private void createParentCotainer() {
		// TODO Auto-generated method stub
		parentContainer = new LinearLayout(this);
		parentContainer.setLayoutParams(new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		parentContainer.setOrientation(LinearLayout.VERTICAL);
		parentContainer.addView(nameContainer);
		parentContainer.addView(addresssContainer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

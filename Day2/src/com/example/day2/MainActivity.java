package com.example.day2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText nName;
	private EditText nPawd;
	private Button load;
	private Button cancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		nName = (EditText) findViewById(R.id.editText1);
		nPawd = (EditText) findViewById(R.id.editText2);
		load = (Button) findViewById(R.id.button1);
		cancel = (Button) findViewById(R.id.button2);
		LoadListener l = new LoadListener();
		load.setOnClickListener(l);
		cancel.setOnClickListener(l);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public class LoadListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.button1:
				String userN = nName.getText().toString();
				String passW = nPawd.getText().toString();
				if (userN.equals("A") && passW.equals("A"))
					Toast.makeText(MainActivity.this, "success",
							Toast.LENGTH_LONG).show();
				else {
					nName.setError("’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
					nPawd.setError("’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
				}
				break;
			case R.id.button2:
				MainActivity.this.finish();
			default:
				break;
			}

			// if (userN.equals(passW))
			// Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT)
			// .show();
		}

	}

}

package com.example.zhaocha;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class SecondAc extends Activity {
	ProgressBar p1;
	SeekBar seekBar;
	public static final String tag = "SeekBar";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		p1 = (ProgressBar) findViewById(R.id.progressBar3);
		seekBar = (SeekBar) findViewById(R.id.seekBar1);

		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				Log.i(tag, "*******Stop");

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				Log.i(tag, "++++++Start");

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				Log.i(tag, "----------<" + progress + " " + fromUser);
			}
		});

		new Thread() {
			@Override
			public void run() {
				int value = 0;
				while (value < 1000) {
					value += 10;
					try {
						Thread.sleep(1000);
						p1.setProgress(value);
						seekBar.setProgress(value);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

}

package com.example.task_hardcode_animation;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {
	TextSwitcher textSwitcher;
	ImageSwitcher imageSwitcher;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher1);
		textSwitcher.setFactory(new ViewFactory() {

			@Override
			public View makeView() {
				TextView text = new TextView(MainActivity.this);
				text.setGravity(Gravity.RIGHT);
				text.setTextColor(Color.RED);
				return text;
			}
		});
		textSwitcher.setInAnimation(this, R.anim.bottom_top);
		textSwitcher.setOutAnimation(this, R.anim.this_over);
		textSwitcher.setText("aaaaaaaaaaaa");
		imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
		imageSwitcher.setFactory(new ViewFactory() {

			@Override
			public View makeView() {
				ImageView imageView = new ImageView(MainActivity.this);
				imageView.setImageResource(R.drawable.ic_launcher);

				return imageView;
			}
		});
		imageSwitcher.setInAnimation(this, R.anim.bottom_top);
		imageSwitcher.setOutAnimation(this, R.anim.this_over);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View view) {
		textSwitcher.setText("bbbbbbbbbbbb");
		imageSwitcher.setImageResource(R.drawable.ic_launcher);
	}
}

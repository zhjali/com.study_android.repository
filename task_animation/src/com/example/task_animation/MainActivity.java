package com.example.task_animation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// this.setupButton();
	}

	private void setupButton() {
		// TODO Auto-generated method stub
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				parentButtonClick(v);
			}

			private void parentButtonClick(View v) {
				// TODO Auto-generated method stub
				animate();
			}

			private void animate() {
				// TODO Auto-generated method stub
				ImageView imageView = (ImageView) findViewById(R.id.imageView1);
				imageView.setVisibility(ImageView.VISIBLE);
				imageView.setBackgroundResource(R.drawable.fram_ani);
				AnimationDrawable frameAnimation = (AnimationDrawable) imageView
						.getBackground();
				if (frameAnimation.isRunning()) {
					frameAnimation.stop();
					System.out.println("true");
				} else {
					frameAnimation.stop();
					frameAnimation.start();
					System.out.println("false");
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void alpha(final View view) {
		Animation utils = AnimationUtils.loadAnimation(this, R.anim.scale);
		view.setAnimation(utils);
		utils.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
			}
		});
	}
}

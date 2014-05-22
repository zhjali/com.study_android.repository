package com.example.task_kaoshi;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

public class SinglePic extends Activity {

	ViewFlipper viewFlipper;
	Float  spanX = 0.0f;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_pic);
		int position = getIntent().getIntExtra(MainActivity.POSITION, 0);
		
		LayoutInflater inflater = LayoutInflater.from(this);
		
		viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);
		TypedArray pictures = getResources().obtainTypedArray(R.array.picture);
		for(int i = 0; i<pictures.length() ; i++){
			LinearLayout layout = new LinearLayout(this);
			ImageView imageView = (ImageView) inflater.inflate(R.layout.picture_item, null).findViewById(R.id.imageView2);
			imageView.setImageDrawable(pictures.getDrawable(i));
			viewFlipper.addView(imageView);
		}
		for(int i = 0; i<position ; i++){
			viewFlipper.showNext();
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.single_pic, menu);
		return true;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			spanX = event.getX();
			break;
		case MotionEvent.ACTION_UP:
			spanX -= event.getX();
			if (spanX<0) {
				//left
				viewFlipper.showNext();
			}else if(spanX>0){
				//right
				viewFlipper.showPrevious();
			}
			spanX = 0.0f;
			break;
		}
		return true;
	}

}

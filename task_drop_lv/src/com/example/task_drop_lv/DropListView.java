package com.example.task_drop_lv;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

public class DropListView extends ListView {
	private static final String TAG = "DropListView";

	// ListView�����λ�õ�Y����
	private float origLY = 0;
	// �����¼���������λ�õ�Y����
	private float origPY = 0;
	// ������ĵ�ı�����
	private float offsetY = 0;
	private int action;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public DropListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		origLY = this.getY();
		Log.d(TAG, "origLY: " + origLY);

	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		action = ev.getAction();
		float eventY = ev.getY();

		switch (action) {
		case MotionEvent.ACTION_DOWN:
			origPY = eventY;
			break;
		case MotionEvent.ACTION_MOVE:
		case MotionEvent.ACTION_CANCEL:
			offsetY = eventY - origPY;
			if (offsetY > 30 && offsetY < 300) {
				Log.d(TAG, "offsetY: " + offsetY);

				invalidate();
			}
			break;
		case MotionEvent.ACTION_UP:
			Log.d(TAG, "up");

			invalidate();
		}
		return true;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		if (action != MotionEvent.ACTION_UP) {
			this.setY(origLY + offsetY);
		} else {
			// ��ԭ
			this.setY(origLY);
		}

		super.onDraw(canvas);
	}
}

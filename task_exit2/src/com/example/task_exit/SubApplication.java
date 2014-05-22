package com.example.task_exit;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Application;

public class SubApplication extends Application {
	private ArrayList<Activity> activities;

	@Override
	public void onCreate() {
		activities = new ArrayList<Activity>();
	}

	public void add(Activity activity) {
		activities.add(activity);
	}

	public void exit() {
		for (Activity act : activities) {
			act.finish();
		}
	}
}

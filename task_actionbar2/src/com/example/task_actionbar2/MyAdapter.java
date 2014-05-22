package com.example.task_actionbar2;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter{
	public MyAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		System.out.println("________");
		switch (arg0) {
		case 0:
			return new FragmentA();
		case 1:
			return new FragmentB();
		case 2:
			return new FragmentC();
		case 3:
			return new FragmentD();
		default:
			break;
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 4;
	}

}

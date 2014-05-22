package com.example.dialog;

import java.util.Arrays;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Calendar calendar;
	private String[] array;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		array = getResources().getStringArray(R.array.A);
		calendar = Calendar.getInstance();
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.button1: //
			AlertDialog dialog1 = new AlertDialog.Builder(this)
					.setTitle("普通dialog").setIcon(R.drawable.ic_launcher)
					.setMessage("helloWorld")
					.setPositiveButton("OK", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
						}
					}).setNegativeButton("Cancel", null)
					.setNeutralButton("Neutral", null).show();
			break;
		case R.id.button2:
			final ProgressDialog pDialog = new ProgressDialog(this);
			pDialog.setTitle("Progres");
			pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			pDialog.setMessage("Loadin...");
			pDialog.setMax(1000);
			pDialog.show();

			new Thread() {
				@Override
				public void run() {
					int progress = 0;
					while (progress < 1000) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						progress += 20;
						pDialog.setProgress(progress);
					}
				}
			}.start();
			break;
		case R.id.button3:
			final TimePickerDialog tDialog = new TimePickerDialog(this,
					new OnTimeSetListener() {

						@Override
						public void onTimeSet(TimePicker view, int hourOfDay,
								int minute) {
							// TODO Auto-generated method stub
							System.out.println("TimePicker Hour：" + hourOfDay
									+ "Minuet：" + minute);
						}
					}, calendar.get(Calendar.HOUR_OF_DAY),
					calendar.get(Calendar.MINUTE), true);
			tDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定",
					new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							tDialog.dismiss();
						}
					});
			tDialog.setTitle("TimePicker");
			tDialog.show();
			break;
		case R.id.button4:
			DatePickerDialog datePickerDialog = new DatePickerDialog(this,
					new OnDateSetListener() {

						@Override
						public void onDateSet(DatePicker view, int year,
								int monthOfYear, int dayOfMonth) {
							System.out.println("DatePicker year: " + year
									+ "month: " + monthOfYear + "day: "
									+ dayOfMonth);
						}
					}, calendar.get(Calendar.YEAR),
					calendar.get(Calendar.MONTH),
					calendar.get(Calendar.DAY_OF_MONTH));
			datePickerDialog.setTitle("DatePicker");
			datePickerDialog.show();
			break;
		case R.id.button5:
			new AlertDialog.Builder(this).setTitle("列表对话框").setItems(R.array.A,
					new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this, array[which],
									Toast.LENGTH_SHORT).show();
						}
					});
			break;
		case R.id.button6:
			new AlertDialog.Builder(this).setTitle("单选对话框")
					.setSingleChoiceItems(R.array.A, 0, new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(MainActivity.this, array[which],
									Toast.LENGTH_SHORT).show();
						}
					}).setPositiveButton("OK", null).show();
			break;
		case R.id.button7:
			final boolean[] checkedItems = new boolean[6];
			new AlertDialog.Builder(this)
					.setTitle("多选对话框")
					.setMultiChoiceItems(R.array.A, checkedItems,
							new OnMultiChoiceClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which, boolean isChecked) {
									// TODO Auto-generated method stub
									Toast.makeText(
											MainActivity.this,
											getResources().getTextArray(
													R.array.A)[which]
													+ "is checked " + isChecked,
											Toast.LENGTH_SHORT).show();
								}
							}).setPositiveButton("OK", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(MainActivity.this,
									Arrays.toString(checkedItems),
									Toast.LENGTH_SHORT).show();

						}
					}).show();
			break;
		case R.id.button8:
			View layout = getLayoutInflater().inflate(R.layout.dialog, null);
			final EditText editText = (EditText) layout
					.findViewById(R.id.editText1);
			Button btn = (Button) layout.findViewById(R.id.button1);
			final AlertDialog show = new AlertDialog.Builder(this).setView(
					layout).show();

			show.setCancelable(false);

			btn.setOnClickListener(new Button.OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(MainActivity.this,
							editText.getText().toString(), Toast.LENGTH_SHORT)
							.show();
					show.dismiss();
				}
			});
			break;
		default:
			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

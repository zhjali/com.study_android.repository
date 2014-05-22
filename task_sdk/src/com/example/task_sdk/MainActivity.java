package com.example.task_sdk;

import java.io.File;
import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener,OnItemLongClickListener{
	
	private TextView currentPathView;
	private File currentFile;
	private File rootFile;
	private File[] listFiles;
	private MyAdapter adapter;
	private long backPressTime = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if(!SDCardHelper.isSDCardMounted()){
			Toast.makeText(this, "没有加载SDK", Toast.LENGTH_SHORT).show();
			finish();
		}
		
		rootFile = SDCardHelper.getSDCardRootFile();
		currentFile = rootFile;
		listFiles = rootFile.listFiles();
		
		currentPathView = (TextView) findViewById(R.id.textView1);
		currentPathView.setText(rootFile.getAbsolutePath()+"");
		
		adapter = new MyAdapter(this);
		adapter.setData(listFiles);	
		
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(this);
		listView.setOnItemLongClickListener(this);
		
//		printAllFile(rootFile);
	}

	@SuppressWarnings("unused")
	private void printAllFile(File file) {
		if (file.isDirectory()) {
			System.out.println("-----DIRECTORY-----:"+file.getName());
			for (int i = 0; i < file.listFiles().length; i++) {
				printAllFile(file.listFiles()[i]);
			}
		}else {
			System.out.println(file.getName());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
			File file = adapter.getData()[position];
			if (file.isDirectory()) {
				if (file.listFiles().length != 0) {
				currentFile = file;
				currentPathView.setText(""+file.getAbsolutePath());
				adapter.setData(file.listFiles());
				adapter.notifyDataSetChanged();
				return;
				}
				Toast.makeText(this, "空文件", Toast.LENGTH_SHORT).show();
			}else {
				Toast.makeText(this, "打开程序", Toast.LENGTH_SHORT).show();
			}
	}
	
	
	@Override
	public void onBackPressed() {
		System.out.println(currentFile);
		System.out.println(rootFile);
		
		if (!currentFile.getAbsolutePath().equals(rootFile.getAbsoluteFile())) {
			File file = currentFile.getParentFile();
			currentFile = file;
			currentPathView.setText(""+file.getAbsolutePath());
			adapter.setData(file.listFiles());
			adapter.notifyDataSetChanged();
		}else {
			backPressTime = SystemClock.uptimeMillis()-backPressTime;
			if (backPressTime < 1000) {
				finish();
			}else {
				Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
				backPressTime = SystemClock.uptimeMillis();
			}
		}
		
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		final File file = adapter.getData()[position];
		final File parentFile = file.getParentFile();
		String[] items = {"重命名","删除","复制"};
	    new AlertDialog.Builder(this).setTitle("文件操作").setItems(items, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch (which) {
				case 0:
					final EditText eText = new EditText(MainActivity.this);
					new AlertDialog.Builder(MainActivity.this)
					.setTitle("重命名")
					.setView(eText)
					.setPositiveButton("确认", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							file.renameTo(new File(file.getParentFile(),eText.getText()+""));
							System.out.println(file.getName()+"+++++++++++");
							refresh(file.getParentFile().listFiles());
						}
					}).setNegativeButton("取消", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					}).show();
					
					break;
				case 1:
					delet(file);
					refresh(parentFile.listFiles());
					break;
				case 2:
					
					break;
				}
			}
		}).show();
		
		return false;
	}

	
	protected void delet(File file) {
		if (file.isDirectory()) {
			if (file.listFiles().length == 0) {
				System.out.println("delet directory: "+file.getName());
				file.delete();
			}
			for (int i = 0; i < file.listFiles().length; i++) {
				delet(file.listFiles()[i]);
			}
		}
		System.out.println("delet file: "+file.getName());
			file.delete();
	}

	private void refresh(File[] files) {
		adapter.setData(files);
		adapter.notifyDataSetChanged();
	}


}

package com.example.task_phone;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView textView;
	EditText editText;
	ProgressDialog dialog;
	public static final int PHONE_RESULT = 1;
	public static final String CONTENT = "content";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textView1);
		editText = (EditText) findViewById(R.id.editText1);
	}

	public void onClick(View view) {
		dialog = new ProgressDialog(this);
		dialog.setMessage("≤È—Ø÷–...");
		dialog.show();
		String num = editText.getText().toString();
		new Search(num).start();
	}

	public Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case PHONE_RESULT:
				String content = msg.getData().getString(CONTENT);
				textView.setText(content);
				dialog.cancel();
				break;

			default:
				break;
			}
		};
	};

	public class Search extends Thread {
		private String num;

		public Search(String num) {
			super();
			this.num = num;
		}

		@Override
		public void run() {
			String content = getContent(num);
			Message message = handler.obtainMessage();
			message.what = PHONE_RESULT;
			Bundle bundle = new Bundle();
			bundle.putString(CONTENT, content);
			message.setData(bundle);
			message.sendToTarget();
		}

		private String getContent(String num) {
			String url = "http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo?mobileCode="
					+ num + "&userID=";
			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(url);
			try {
				HttpResponse response = client.execute(get);
				XmlPullParser parser = XmlPullParserFactory.newInstance()
						.newPullParser();
				parser.setInput(response.getEntity().getContent(), "utf-8");
				int eventType = parser.getEventType();

				while (eventType != XmlPullParser.END_DOCUMENT) {
					switch (eventType) {
					case XmlPullParser.START_DOCUMENT:
						break;

					case XmlPullParser.START_TAG:
						if ("string".equals(parser.getName())) {
							return parser.nextText();
						}

						break;

					case XmlPullParser.END_TAG:
						break;
					}
					eventType = parser.next();
				}
				return null;
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

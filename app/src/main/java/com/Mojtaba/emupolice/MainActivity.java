package com.Mojtaba.emupolice;




import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	private ImageButton make_a_report;
	private ImageButton contacts;
	private ImageButton call_emergency;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		  make_a_report = (ImageButton) findViewById(R.id.photo);
		  contacts = (ImageButton) findViewById(R.id.imageButton3);
		  call_emergency = (ImageButton) findViewById(R.id.imageButton1);
		
		call_emergency.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:155"));
				startActivity(intent);
			}
		});

		make_a_report.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				Intent intent = new Intent(MainActivity.this, make_a_report.class);
				startActivity(intent);
				

	}
});
		
		contacts.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				Intent intent = new Intent(MainActivity.this, contacts.class);
				startActivity(intent);

	
	}
});
	
		
	}
}


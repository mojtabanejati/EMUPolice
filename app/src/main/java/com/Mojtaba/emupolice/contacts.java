package com.Mojtaba.emupolice;




import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class contacts extends Activity {

	  SQLiteDatabase database;
	  private Button Send;
	  static ContentValues value;
		public static String email;
		public static String comment;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);
		final Intent intent = new Intent(this, MainActivity.class);
		
		Send = (Button) findViewById(R.id.btnsend);

	
		value = new ContentValues();
		
		Send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				EditText  email1 = (EditText) findViewById(R.id.editText1);
				EditText comment1 = (EditText) findViewById(R.id.editText2);
				email = email1.getText().toString();
				comment1.getText().toString();
				
				
				if (email1.length() == 0 || comment1.length() == 0) {
					Toast.makeText(getApplicationContext(),
							"Please fill in all the blanks", Toast.LENGTH_LONG)
							.show();
											
				
				}
				startActivity(intent);
			         
			   	
}
});
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		finish();
		Intent intent=new Intent(this, MainActivity.class);
		startActivity(intent);
		super.onBackPressed();
	}
}
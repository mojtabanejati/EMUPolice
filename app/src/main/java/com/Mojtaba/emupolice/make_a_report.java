package com.Mojtaba.emupolice;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class make_a_report extends Activity {

	public static String name;
	public static String phone;
	public static String organization;
	public static String crime1, crime2, crime3, crime4, crime5, crime6;
	public static String location;
	public static String summary;
	public static String action;
	private final String NAMESPACE = "http://tempuri.org/";
	private final String URL = "http://mojtabanejati-001-site1.smarterasp.net/WebService.asmx";
	private final String SOAP_ACTION = "http://tempuri.org/InsertClientInformation";
	private final String METHOD_NAME = "InsertClientInformation";
	private static String condition;
	SQLiteDatabase database;
	Intent intent;
	static ContentValues value;
	private ImageButton photo;
	private static final int CAMERA_REQUEST = 1888;
	private ImageView imageView;
	int TAKE_PHOTO_CODE = 0;
	Bitmap bitMap;
	ImageView thumbnail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_make_a_report);
		Button Submit = (Button) findViewById(R.id.action);
		
		photo = (ImageButton) findViewById(R.id.photo);

		value = new ContentValues();
		intent = new Intent(this, MainActivity.class);
		final EditText name1 = (EditText) findViewById(R.id.name);
		final EditText phone1 = (EditText) findViewById(R.id.editText1);
		final EditText organization1 = (EditText) findViewById(R.id.editText2);
		final CheckBox crme1 = (CheckBox) findViewById(R.id.checkBox1);
		final CheckBox crme2 = (CheckBox) findViewById(R.id.checkBox2);
		final CheckBox crme3 = (CheckBox) findViewById(R.id.checkBox3);
		final CheckBox crme4 = (CheckBox) findViewById(R.id.checkBox4);
		final CheckBox crme5 = (CheckBox) findViewById(R.id.checkBox5);
		final CheckBox crme6 = (CheckBox) findViewById(R.id.checkBox6);
		final EditText location1 = (EditText) findViewById(R.id.editText3);
		final EditText summary1 = (EditText) findViewById(R.id.editText4);

		
		
		photo.setOnClickListener(new OnClickListener() {
		///////for taking photo 1
			@Override
			public void onClick(View v) {
				finish();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
                startActivityForResult(cameraIntent, CAMERA_REQUEST); 
	}
	});
		

		
		
		// ///////////////////submitting the report/////////////////////

		Submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				name = name1.getText().toString();
				phone = phone1.getText().toString();
				organization = organization1.getText().toString();
				location = location1.getText().toString();
				summary = summary1.getText().toString();
				if (crme1.isChecked()) {
					crime1 = crme1.getText().toString();
				} else if (crme2.isChecked()) {
					crime2 = crme2.getText().toString();
				} else if (crme3.isChecked()) {
					crime3 = crme3.getText().toString();
				} else if (crme4.isChecked()) {
					crime4 = crme4.getText().toString();
				} else if (crme5.isChecked()) {
					crime5 = crme5.getText().toString();
				} else if (crme6.isChecked()) {
					crime6 = crme6.getText().toString();
				}

				// action = action1.getText().toString();

				if (name.length() == 0 || phone.length() == 0
						|| organization.length() == 0) {
					Toast.makeText(getApplicationContext(),
							"Please fill in all the blanks", Toast.LENGTH_LONG)
							.show();
				} else {
				
					ConnectingWS connectingWS = new ConnectingWS();
					connectingWS.execute();
				}
			}
		});
	}
	///////for taking photo 2
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
		 super.onActivityResult(requestCode, resultCode, data);  
		 if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {  
	            Bitmap photo = (Bitmap) data.getExtras().get("data"); 
	            imageView.setImageBitmap(photo);
 
        }
    }		
	
	private void InsertClientInformation(String f_name,String f_phone,String f_organization,String f_location,String f_summary,String f_crime1,String f_crime2,String f_crime3,String f_crime4,String f_crime5,String f_crime6){
		SoapObject request = new SoapObject(NAMESPACE,METHOD_NAME);
		
		PropertyInfo nameInfo = new PropertyInfo();
		nameInfo.setName("f_name");
		nameInfo.setValue(f_name);
		
		PropertyInfo phoneInfo = new PropertyInfo();
		phoneInfo.setName("f_phone");
		phoneInfo.setValue(f_phone);
		
		PropertyInfo organizationInfo = new PropertyInfo();
		organizationInfo.setName("f_organization");
		organizationInfo.setValue(f_organization);
		
		PropertyInfo locationInfo = new PropertyInfo();
		locationInfo.setName("f_location");
		locationInfo.setValue(f_location);
		
		PropertyInfo summaryInfo = new PropertyInfo();
		summaryInfo.setName("f_summary");
		summaryInfo.setValue(f_summary);
		
		PropertyInfo crime1Info = new PropertyInfo();
		crime1Info.setName("f_crime1");
		crime1Info.setValue(f_crime1);
		
		PropertyInfo crime2Info = new PropertyInfo();
		crime2Info.setName("f_crime2");
		crime2Info.setValue(f_crime2);
		
		PropertyInfo crime3Info = new PropertyInfo();
		crime3Info.setName("f_crime3");
		crime3Info.setValue(f_crime3);
		
		PropertyInfo crime4Info = new PropertyInfo();
		crime4Info.setName("f_crime4");
		crime4Info.setValue(f_crime4);
		
		PropertyInfo crime5Info = new PropertyInfo();
		crime5Info.setName("f_crime5");
		crime5Info.setValue(f_crime5);
		
		PropertyInfo crime6Info = new PropertyInfo();
		crime6Info.setName("f_crime6");
		crime6Info.setValue(f_crime6);
		
		
		request.addProperty(nameInfo);
		request.addProperty(phoneInfo);
		request.addProperty(organizationInfo);
		request.addProperty(locationInfo);
		request.addProperty(summaryInfo);
		request.addProperty(crime1Info);
		request.addProperty(crime2Info);
		request.addProperty(crime3Info);
		request.addProperty(crime4Info);
		request.addProperty(crime5Info);
		request.addProperty(crime6Info);
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransportSE = new HttpTransportSE(URL);
		try {
			httpTransportSE.call(SOAP_ACTION, envelope);
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			condition = response.toString();
		}
		catch (Exception e) {
				Log.e("error", e.getMessage());
			}
		}
	
	
	
	
	
	private class ConnectingWS extends AsyncTask<String, String, String>{

		private final ProgressDialog dialog = new ProgressDialog(make_a_report.this);
		@Override
		protected void onPreExecute() {
			this.dialog.setMessage("Please Waiting...");
			this.dialog.show();
			super.onPreExecute();
		}
		@Override
		protected String doInBackground(String... params) {
			
			InsertClientInformation(name,phone,organization,location,summary,crime1,crime2,crime3,crime4,crime5,crime6);
			return null;
		}
		@Override
		protected void onPostExecute(String result) {
			if (this.dialog.isShowing()) {
				this.dialog.dismiss();
			}
			if (condition.contains("Successful")) {
				Toast.makeText(make_a_report.this, "Successful.", Toast.LENGTH_SHORT).show();
			}else {
				Toast.makeText(make_a_report.this, "Not Successfull, Please try again.", Toast.LENGTH_LONG).show();
			}
			super.onPostExecute(result);
		}
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		finish();
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		super.onBackPressed();
	}


}


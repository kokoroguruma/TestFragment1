package com.example.kokoroguruma.testfragment1;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Main1Fragment.Main1FragmentListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.button1Click();
		this.button2Click();

	}

	// Main1FragmentListenerより
	@Override
	public void onMain1FragmentEvent1() {
		TextView textView = findViewById(R.id.mainTextView);
		textView.setText("Event1()");
	}

	// Main1FragmentListenerより
	@Override
	public void onMain1FragmentEvent2() {
		TextView textView = findViewById(R.id.mainTextView);
		textView.setText("Event2()");
	}


	// ここから Activity のボタン。フラグメントの操作を行う。

	private void button1Click() {
		Button button = findViewById(R.id.mainButton1);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Log.d("MainActivity", "button1: Click");

				// フラグメントのアクセス先を確保。
				FragmentManager manager = getSupportFragmentManager();
				Main1Fragment main1Fragment = (Main1Fragment) manager.findFragmentById(R.id.mainFragment);
				Log.d("MainActivity", "button1: main1Fragment: " + main1Fragment);

				main1Fragment.fragmentEvent1();


			}
		});
	}

	private void button2Click() {
		Button button = findViewById(R.id.mainButton2);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Log.d("MainActivity", "button2: Click");

				// フラグメントのアクセス先を確保。
				FragmentManager manager = getSupportFragmentManager();
				Main1Fragment main1Fragment = (Main1Fragment) manager.findFragmentById(R.id.mainFragment);

				Log.d("MainActivity", "button2: main1Fragment: " + main1Fragment);

				main1Fragment.fragmentEvent2();

			}
		});
	}


}

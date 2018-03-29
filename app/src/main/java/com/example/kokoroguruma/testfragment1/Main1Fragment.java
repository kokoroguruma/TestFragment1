package com.example.kokoroguruma.testfragment1;


import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Main1Fragment extends Fragment {

	// タグの設定用。
	public static final String TAG = Main1Fragment.class.getSimpleName();



	private MainActivity mainActivity = null;


	public Main1Fragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {


		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_main1, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

		this.button1Click();
		this.button2Click();


		super.onViewCreated(view, savedInstanceState);
	}

	private void button1Click() {
		Button button = getView().findViewById(R.id.fragmentButton1);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Log.d("Main1Fragment", "一応のnullチェック");
				if (main1FragmentListener != null) {
					Log.d("Main1Fragment", "MainActivityに実装されたEvent1()を実行する。");
					main1FragmentListener.onMain1FragmentEvent1();
				}

			}
		});
	}

	private void button2Click() {
		Button button = getView().findViewById(R.id.fragmentButton2);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Log.d("Main1Fragment", "一応のnullチェック");
				if (main1FragmentListener != null) {
					Log.d("Main1Fragment", "MainActivityに実装されたEvent2()を実行する。");
					main1FragmentListener.onMain1FragmentEvent2();
				}

			}
		});
	}

	/**
	 * Activityから呼び出された時の関連付け
	 *
	 * @param context
	 */
	@Override
	public void onAttach(Context context) {
		Log.d("Main1Fragment", "Activityから呼び出されて関連付け開始");

		if (context instanceof MainActivity) {
			Log.d("Main1Fragment", "MainActivityの時の関連付け");
			this.mainActivity = (MainActivity) context;

			Log.d("Main1Fragment", "MainActivityの時の関連付け（Listener用）");
			main1FragmentListener = (Main1FragmentListener) context;
		}
		super.onAttach(context);
	}


	// ここから「FragmentからActivityへの操作」
	private Main1FragmentListener main1FragmentListener = null;

	// インターフェースで動作があることを宣言する。
	// Activityでimplementsする。
	public interface Main1FragmentListener {
		void onMain1FragmentEvent1();

		void onMain1FragmentEvent2();
	}




	// ここから「ActivityからFragmentへの操作」

	public void fragmentEvent1() {
		TextView textView = getView().findViewById(R.id.fragmentTextView);
		textView.setText("Event1");
	}

	public void fragmentEvent2() {
		TextView textView = getView().findViewById(R.id.fragmentTextView);
		textView.setText("Event2");
	}


}

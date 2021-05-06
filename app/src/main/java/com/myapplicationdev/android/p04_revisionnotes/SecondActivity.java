package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView lv;
	ArrayAdapter aa;
	ArrayList<Note> al;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		//TODO implement the Custom ListView

		lv = (ListView) findViewById(R.id.lv);

		al = new ArrayList<Note>();

		DBHelper db = new DBHelper(SecondActivity.this);

		ArrayList<String> data = db.getNoteContent();
		db.close();

		for (int i = 0; i < data.size(); i++){
			Log.d("Database Content", i + ". " + data.get(i));
			if (data.get(i).equals("Revision Note ")){

			}
		}

		al = db.getAllNotes();
		aa = new RevisionNotesArrayAdapter(SecondActivity.this, R.layout.row , al);
		lv.setAdapter(aa);

	}


}

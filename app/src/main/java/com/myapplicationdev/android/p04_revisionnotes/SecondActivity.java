package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView lv;
	ArrayList<Note> aa;
	RevisionNotesArrayAdapter al;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//TODO implement the Custom ListView
		setContentView(R.layout.activity_second);

		lv = findViewById(R.id.lv);

		DBHelper db = new DBHelper(SecondActivity.this);
		aa = db.getAllNotes();

//		aa.add(new Note(5, "qwerty", 2));
//		aa.add(new Note(4, "ytrewq", 4));
//		aa.add(new Note(2, "poiuy", 5));

		al = new RevisionNotesArrayAdapter(SecondActivity.this, R.layout.row, aa);
		lv.setAdapter(al);


	}
}

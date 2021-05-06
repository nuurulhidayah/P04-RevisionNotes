package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText revisionNote;
    RadioGroup rg;
    Button btnInsert, btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        revisionNote = (EditText) findViewById(R.id.editTextNote);
        rg = findViewById(R.id.radioGroupStars);
        btnInsert = (Button) findViewById(R.id.buttonInsertNote);
        btnShowList = (Button) findViewById(R.id.buttonShowList);

    }
}

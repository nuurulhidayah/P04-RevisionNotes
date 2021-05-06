package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText revisionNote;
    RadioGroup rg;
    RadioButton rgButton;
    Button btnInsert, btnShowList;
    String note = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        revisionNote = (EditText) findViewById(R.id.editTextNote);
        rg = findViewById(R.id.radioGroupStars);
        btnInsert = (Button) findViewById(R.id.buttonInsertNote);
        btnShowList = (Button) findViewById(R.id.buttonShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create the DBHelper object, passing in the
                //activity's context
                rgButton = findViewById(rg.getCheckedRadioButtonId());
                DBHelper db = new DBHelper(MainActivity.this);

                if (revisionNote.getText() == null) {
                    note = "Revision Note ";
                }
                else{
                    note = "" + revisionNote.getText();
                }
                //Insert a task
                int selectedId = rgButton.getId();
                RadioButton rb = findViewById(selectedId);

                db.insertNote(note, Integer.valueOf(rb.getText().toString()));
                db.close();

                Toast.makeText(MainActivity.this, "Inserted",
                        Toast.LENGTH_LONG).show();
            }
        });
        
        btnShowList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                DBHelper db = new DBHelper(MainActivity.this);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}

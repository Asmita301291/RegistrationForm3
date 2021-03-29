package com.example.registrationform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText fname, mname, lname, email, phno, stdid, year, grade,bmonth,bday,byear;
    String FName, MName, LName, Email, Phno, Stdid, Year, Grade,Gender,Semister,BMonth,BDay,BYear;
    Spinner semister;
    RadioGroup gender;
    RadioButton radioButton;
    String stringvalues[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        semister = findViewById(R.id.semister);
        gender = findViewById(R.id.gender);
        fname = findViewById(R.id.fname);
        mname = findViewById(R.id.mname);
        lname = findViewById(R.id.lname);
        email = findViewById(R.id.email);
        phno = findViewById(R.id.cono);
        stdid = findViewById(R.id.stdid);
        year = findViewById(R.id.year);
        bmonth = findViewById(R.id.bm);
        bday = findViewById(R.id.bd);
        byear = findViewById(R.id.by);
        grade = findViewById(R.id.grade);
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, stringvalues);
        semister.setAdapter(adapter);
        semister.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Toast.makeText(MainActivity.this,"Course is "+stringvalues[i],Toast.LENGTH_SHORT).show();
                Semister = stringvalues[i];
                //Toast.makeText(MainActivity.this,"Semister is "+semi,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "You have not select any item", Toast.LENGTH_SHORT).show();
            }
        });

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                radioButton = radioGroup.findViewById(i);
            }
        });
        int selectedid = gender.getCheckedRadioButtonId();
        if (selectedid == -1) {
           // Toast.makeText(MainActivity.this, "You have not selected anything", Toast.LENGTH_SHORT).show();
        } else {
            Gender = radioButton.getText().toString();
            //Toast.makeText(MainActivity.this, "" + radioButton.getText(), Toast.LENGTH_SHORT).show();
        }

    }

    public void openSubmitData(View view) {
        FName = fname.getText().toString();
        MName = mname.getText().toString();
        LName = lname.getText().toString();
        BMonth = bmonth.getText().toString();
        BDay = bday.getText().toString();
        BYear = byear.getText().toString();
        Email = email.getText().toString();
        Phno = phno.getText().toString();
        Stdid = stdid.getText().toString();
        Year = year.getText().toString();
        Grade = grade.getText().toString();
        Gender = radioButton.getText().toString();
        Intent intent=new Intent(MainActivity.this,DisplyLogindata.class);
        intent.putExtra("fname",FName);
        intent.putExtra("mname",MName);
        intent.putExtra("lname",LName);
        intent.putExtra("bmonth",BMonth);
        intent.putExtra("bday",BDay);
        intent.putExtra("byear",BYear);
        intent.putExtra("email",Email);
        intent.putExtra("phno",Phno);
        intent.putExtra("gender",Gender);
        intent.putExtra("stdid",Stdid);
        intent.putExtra("eyear",Year);
        intent.putExtra("grade",Grade);
        intent.putExtra("semi",Semister);
        startActivity(intent);

    }

    // Code for Adding Menu Items Om Main Activity
    //Add Menu with icons
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.html:
                Toast.makeText(this, "HTML", Toast.LENGTH_SHORT).show();
                break;
            case R.id.css:
                Toast.makeText(this, "CSS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.java:
                Toast.makeText(this, "JAVA", Toast.LENGTH_SHORT).show();
                break;
            case R.id.android:
                Toast.makeText(this, "Android", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
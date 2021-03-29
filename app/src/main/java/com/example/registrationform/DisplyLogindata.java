package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplyLogindata extends AppCompatActivity {

    TextView FName,MName,LName,Email,Phno,Gender,Stdid,EYear,Grade,Semister,BirthDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disply_logindata);
        FName=findViewById(R.id.tname);
        Email=findViewById(R.id.temail);
        Phno=findViewById(R.id.tphno);
        Gender=findViewById(R.id.tgndr);
        BirthDate=findViewById(R.id.tbirth);
        Stdid=findViewById(R.id.tstdid);
        EYear=findViewById(R.id.tentyear);
        Grade=findViewById(R.id.tgrade);
        Semister=findViewById(R.id.tsemi);

        Intent intent=getIntent();

        String d_fname=intent.getStringExtra("fname");
        String d_mname=intent.getStringExtra("lname");
        String d_lname=intent.getStringExtra("mname");
        String d_bmonth=intent.getStringExtra("bmonth");
        String d_bday=intent.getStringExtra("bday");
        String d_byear=intent.getStringExtra("byear");
        String d_email=intent.getStringExtra("email");
        String d_phno=intent.getStringExtra("phno");
        String d_gndr=intent.getStringExtra("gender");
        String d_stdid=intent.getStringExtra("stdid");
        String d_eyear=intent.getStringExtra("eyear");
        String d_grade=intent.getStringExtra("grade");
        String d_semi=intent.getStringExtra("semi");

        FName.setText( "Name : "+d_fname+" "+d_mname+" "+d_lname);
        Email.setText("Email : "+d_email);
        Phno.setText("Phone No. : "+d_phno);
        Gender.setText("Gender : "+d_gndr);
        BirthDate.setText( "Birth Date : "+d_bmonth+"/ "+d_bday+"/ "+d_byear);
        Stdid.setText("Student Id : "+d_stdid);
        EYear.setText("Entry Year : "+d_eyear);
        Grade.setText("Grade : "+d_grade);
        Semister.setText("Semister : "+d_semi);

    }
}
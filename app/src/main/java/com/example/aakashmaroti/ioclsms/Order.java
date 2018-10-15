package com.example.aakashmaroti.ioclsms;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;


public class Order extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, DatePickerDialog.OnDateSetListener
{

    String phoneNo="9224992249";
    String OrderOptions[]={" HS 20"," HS 12"," MS 8 HS 12"," MS 4 HS 16"," MS 4 HS 8"};
    String SMStext="IOCL IND";
    Spinner options;
    String choice="";
    Button b;
    DatePicker dp;
    String FinalDate="";
    int day=0;
    int month=0;
    int year=0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        options=(Spinner)findViewById(R.id.spinner);
        b=(Button) findViewById(R.id.button);
        dp=(DatePicker) findViewById(R.id.datePicker);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, OrderOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        options.setAdapter(adapter);

        b.setOnClickListener(this);
        options.setOnItemSelectedListener(this);
    }

    @Override public void onDateSet(DatePicker view, int year1, int monthOfYear, int dayOfMonth)
    {
        year=year1;
        month=monthOfYear+1;
        day=dayOfMonth;
    }

    @Override public void onClick(View v)
    {
        if(v.getId()==R.id.button)
        {
            day=dp.getDayOfMonth();
            month=dp.getMonth()+1;
            year=dp.getYear();
            year-=2000;
            String m="",d="";
            m+=month;
            d+=day;
            if(month<10)
                m="0"+m;
            if(day<10)
                d="0"+d;

            FinalDate=FinalDate+" "+d+m+year;
            SMStext=SMStext+""+FinalDate+" "+choice;
            if (phoneNo.length()>0)
            {
                Toast.makeText(getApplicationContext(), SMStext,
                               Toast.LENGTH_LONG).show();

                try
                {
                    SmsManager smgr = SmsManager.getDefault();
                    smgr.sendTextMessage(phoneNo, null, SMStext, null, null);
                    Toast.makeText(getApplicationContext(), "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();
                }
            }
            FinalDate="";
            SMStext="IOCL IND";
        }
    }

    @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        choice = parent.getItemAtPosition(position).toString();
    }

    @Override public void onNothingSelected(AdapterView<?> parent)
    {

    }
}

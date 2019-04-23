package com.example.aakashmaroti.ioclsms;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Acknowledge extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener
{
    EditText et;
    Button b;
    protected Vibrator vibration;
    String SMStext = "IOCL ";
    Spinner acks;
    String phoneNo="9224992249";
    String choice=" ACK ";
    String ackOptions[]={" ACK "," ACK1 "," ACK2 "," ACK3 "," ACK4 "};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acknowledge);

        et=(EditText)findViewById(R.id.editText);
        b=(Button) findViewById(R.id.buttons);
        b.setOnClickListener(this);
        acks=(Spinner)findViewById(R.id.spinner);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ackOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        acks.setAdapter(adapter);
        acks.setOnItemSelectedListener(this);
    }

    @Override public void onClick(View v)
    {
        if(v.getId()==R.id.buttons)
        {
            String s;
            s=et.getText().toString();
            if(!s.equalsIgnoreCase(""))
            {
                SMStext = SMStext + choice + s;
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

                SMStext="IOCL IND";
            }
            else
                Toast.makeText(getApplicationContext(), "Please Enter a Value", Toast.LENGTH_SHORT).show();
            SMStext="IOCL IND";
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        choice = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        choice=" ACK ";
    }
}

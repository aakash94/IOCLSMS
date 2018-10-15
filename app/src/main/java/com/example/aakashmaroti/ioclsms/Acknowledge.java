package com.example.aakashmaroti.ioclsms;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Acknowledge extends AppCompatActivity implements View.OnClickListener
{
    EditText et;
    Button b;
    protected Vibrator vibration;
    String SMStext = "IOCL ACK ";
    String phoneNo="9224992249";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acknowledge);

        et=(EditText)findViewById(R.id.editText);
        b=(Button) findViewById(R.id.buttons);
        b.setOnClickListener(this);
    }

    @Override public void onClick(View v)
    {
        if(v.getId()==R.id.buttons)
        {
            String s;
            s=et.getText().toString();
            if(!s.equalsIgnoreCase(""))
            {
                SMStext+=s;
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
}

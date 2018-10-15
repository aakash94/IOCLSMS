package com.example.aakashmaroti.ioclsms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cancel extends AppCompatActivity implements View.OnClickListener
{
    Button bCan;
    EditText etCan;
    String SMStext = "IOCL CAN ";
    String phoneNo="9224992249";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);
        bCan = (Button) findViewById(R.id.buttonSendSMS);
        etCan=(EditText) findViewById(R.id.editTextCancel);
        bCan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.buttonSendSMS)
        {
            String s;
            s=etCan.getText().toString();
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

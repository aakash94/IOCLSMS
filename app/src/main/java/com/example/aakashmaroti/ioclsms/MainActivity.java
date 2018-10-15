package com.example.aakashmaroti.ioclsms;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button bPlaceOrder;
    Button bAcknowledge;
    Button bCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bCancel=(Button)findViewById(R.id.buttonCan);
        bPlaceOrder=(Button)findViewById(R.id.PlaceOrder);
        bAcknowledge=(Button)findViewById(R.id.Acknowledge);

        bCancel.setOnClickListener(this);
        bPlaceOrder.setOnClickListener(this);
        bAcknowledge.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.Acknowledge)
        {
            Intent AckIntent = new Intent(this, Acknowledge.class);
            startActivity(AckIntent);

        }
        if(v.getId()==R.id.PlaceOrder)
        {
            Intent OrderIntent = new Intent(this, Order.class);
            startActivity(OrderIntent);
        }
        if(v.getId()==R.id.buttonCan)
        {
            Intent OrderIntent = new Intent(this, Cancel.class);
            startActivity(OrderIntent);
        }

    }
}

package com.example.bluetooth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity";
    BluetoothAdapter mBluetoothAdpter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnonoff= findViewById(R.id.btnonoff);

mBluetoothAdpter =  BluetoothAdapter.getDefaultAdapter();


btnonoff.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        enableDisableBT();
    }

});



    }
    @SuppressLint("MissingPermission")
    public void enableDisableBT()
    {
        if (mBluetoothAdpter==null)
        {
            Log.d(TAG, "enabledisablebt: does not have btn capability.")

        }
        if(mBluetoothAdpter.isEnabled()){
            Intent enablebtIntent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enablebtIntent);

            IntentFilter BTIntent=new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mBroadCostReciever1,BTIntent);

        }
        if (mBluetoothAdpter.isEnabled()){
            mBluetoothAdpter.disable();
            IntentFilter BTIntent=new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mBroadCostReciever1,BTIntent);

        }
    }
}
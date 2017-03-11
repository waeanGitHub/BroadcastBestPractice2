package com.example.waean.broadcastbestpractice2;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by waean on 2017/03/11.
 */

public class BaseActivity extends AppCompatActivity {
    private ForceOfflineReceiver offlineReceiver;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter =new IntentFilter();
        intentFilter.addAction("com.example.waean.broadcastbestpractice2.FORCE_OFFLINE");
        offlineReceiver = new ForceOfflineReceiver();
        registerReceiver(offlineReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (offlineReceiver!=null){
            unregisterReceiver(offlineReceiver);
            offlineReceiver=null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    class ForceOfflineReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(final Context context, Intent intent) {

            AlertDialog.Builder builder =new AlertDialog.Builder(context);
            builder.setTitle("Warning");
            builder.setMessage("You are forced to be offline.please try to login.");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAll();
                    LoginActivity.actionStart(context);
                }
            });
            builder.show();
        }
    }
}

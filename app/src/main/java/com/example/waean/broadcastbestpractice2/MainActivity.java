package com.example.waean.broadcastbestpractice2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.force_offline)
    Button forceOffline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @OnClick(R.id.force_offline)
    public void onClick() {
        Intent intent = new Intent("com.example.waean.broadcastbestpractice2.FORCE_OFFLINE");
        sendBroadcast(intent);
    }
}

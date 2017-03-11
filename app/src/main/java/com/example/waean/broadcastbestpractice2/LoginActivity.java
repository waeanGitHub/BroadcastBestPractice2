package com.example.waean.broadcastbestpractice2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @Bind(R.id.account)
    EditText account;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.login)
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login)
    public void onClick() {
        String mAccount = account.getText().toString();
        String mPassword = password.getText().toString();
        if (mAccount.equals("admin")&&mPassword.equals("123456")){
            MainActivity.actionStart(this);
            finish();
        }else {
            Toast.makeText(this, "account or password is invaild", Toast.LENGTH_SHORT).show();
        }
    }

    public static void actionStart(Context context){
        Intent intent =new Intent(context,LoginActivity.class);
        context.startActivity(intent);
    }
}

package com.ajbe.primertaller.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ajbe.primertaller.R;

public class LoginActivity extends AppCompatActivity {

    private Button btnForget;
    private Button btnLogin;
    private EditText editUser;
    private EditText editPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initVariables();

        setEvents();

    }

    private void initVariables(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnForget = (Button) findViewById(R.id.btn_forget);
        btnLogin = (Button) findViewById(R.id.btn_login);
        editUser = (EditText) findViewById(R.id.edit_user);
        editPass = (EditText) findViewById(R.id.edit_password);
    }

    private void setEvents(){
        // Get colors from resources
        final int colorAction = ContextCompat.getColor(this, R.color.colorAccent);
        final int colorBackground = ContextCompat.getColor(this, R.color.colorPrimary);
        btnForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create SnackBar
                Snackbar snack = Snackbar.make(v, R.string.loginSnackMessage, Snackbar.LENGTH_LONG)
                        .setAction(R.string.loginSnackActionText, new View.OnClickListener() {
                            @Override
                            public void onClick(View v1) {
                                Toast.makeText(
                                        LoginActivity.this,
                                        R.string.toastMessageEmail,
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setActionTextColor(colorAction);
                View snackBarView = snack.getView();
                snackBarView.setBackgroundColor(colorBackground);
                snack.show();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validate if user and password isn't empty
                if (editUser.length() == 0) {
                    editUser.setError(getString(R.string.toastErrorUserField));
                    return;
                } else if (editPass.length() == 0) {
                    editPass.setError(getString(R.string.toastErrorUserField));
                    return;
                }
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                // To prevent from coming back without logout
                finish();
            }
        });
    }

}

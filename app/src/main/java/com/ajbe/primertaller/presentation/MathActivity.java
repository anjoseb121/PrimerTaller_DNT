package com.ajbe.primertaller.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ajbe.primertaller.R;

public class MathActivity extends AppCompatActivity {

    private Button mBtnMax, mBtnMin, mBtnMCM, mBtnPow;
    private EditText mEditFirstNumber, mEditSecondNumber;
    private TextView mTextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initVariables();

        setEvents();

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initVariables() {
        mBtnMax = (Button) findViewById(R.id.button_max);
        mBtnMin = (Button) findViewById(R.id.button_min);
        mBtnMCM = (Button) findViewById(R.id.button_mcm);
        mBtnPow = (Button) findViewById(R.id.button_pow);
        mEditFirstNumber = (EditText) findViewById(R.id.edit_first_number);
        mEditSecondNumber = (EditText) findViewById(R.id.edit_second_number);
        mTextResult = (TextView) findViewById(R.id.textView_result);
    }

    private void setEvents() {
        mBtnMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextResult.setText(String.valueOf(maxValue()));
            }
        });

        mBtnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextResult.setText(String.valueOf(minValue()));
            }
        });

        mBtnMCM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextResult.setText(String.valueOf(calcMCM()));
            }
        });

        mBtnPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextResult.setText(String.valueOf(calcPow()));
            }
        });
    }

    private int calcPow() {
        int a = Integer.parseInt(mEditFirstNumber.getText().toString());
        int b = Integer.parseInt(mEditSecondNumber.getText().toString());
        return (int) Math.pow(a, b);
    }

    private int calcMCM() {
        int a = Integer.parseInt(mEditFirstNumber.getText().toString());
        int b = Integer.parseInt(mEditSecondNumber.getText().toString());
        int mcm=1;
        int i=2;
        while(i <= a || i <= b) {
            if(a%i == 0 || b%i == 0) {
                mcm = mcm * i;
                if(a%i == 0)
                    a=a/i;
                if(b%i == 0)
                    b=b/i;
            } else
                i=i+1;
        }
        return mcm;
    }

    private int minValue() {
        int a = Integer.parseInt(mEditFirstNumber.getText().toString());
        int b = Integer.parseInt(mEditSecondNumber.getText().toString());
        // Ternary, if b is greater than a then return b, else return a
        return (a < b) ? a : b;
    }

    private int maxValue() {
        int a = Integer.parseInt(mEditFirstNumber.getText().toString());
        int b = Integer.parseInt(mEditSecondNumber.getText().toString());
        // Ternary, if a is greater than b then return a, else return b
        return (a > b) ? a : b;
    }

}

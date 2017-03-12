package com.ajbe.primertaller.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ajbe.primertaller.R;

public class ConvertTemperatureActivity extends AppCompatActivity {

    private EditText mEditTextTemperature;
    private RadioGroup mRadioGroupFrom, mRadioGroupTo;
    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conv_temperature);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initVariables();

        setEvents();
    }

    private void initVariables() {
        mEditTextTemperature = (EditText) findViewById(R.id.editText_temperature);
        mTextViewResult = (TextView) findViewById(R.id.textView_result_temperature);
        mRadioGroupFrom = (RadioGroup) findViewById(R.id.radioGroupFrom);
        mRadioGroupTo = (RadioGroup) findViewById(R.id.radioGroupTo);
    }

    private void setEvents() {
        // Calculate temperature on every change from RadioGroup
        mRadioGroupFrom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                mTextViewResult.setText(convertTemperature());
            }
        });
        mRadioGroupTo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                mTextViewResult.setText(convertTemperature());
            }
        });
        // Calculate temperature on every change from EditText
        mEditTextTemperature.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mTextViewResult.setText(convertTemperature());
            }
        });
    }

    private String convertTemperature() {
        if (mEditTextTemperature.getText().toString().length() != 0) {
            // Get both radio checked
            int fromRadioId = mRadioGroupFrom.getCheckedRadioButtonId();
            double result = 0;

            switch (fromRadioId) {
                case R.id.rb_from_celsius:
                    result = celsiusCases();
                    break;
                case R.id.rb_from_kelvin:
                    result = kelvinCases();
                    break;
                case R.id.rb_from_fah:
                    result = fahCases();
                    break;
                case R.id.rb_from_rankine:
                    result = rankineCases();
                    break;
            }
            return String.valueOf(result);
        } else
            return "Type a number";
    }

    private double celsiusCases() {
        int toRadioId = mRadioGroupTo.getCheckedRadioButtonId();
        double base = Double.parseDouble(mEditTextTemperature.getText().toString());
        double result = 0;
        switch (toRadioId) {
            case R.id.rb_to_celsius:
                result = base;
                break;
            case R.id.rb_to_kelvin:
                result = base + 273.15;
                break;
            case R.id.rb_to_fah:
                result = 32 + (base * 1.8);
                break;
            case R.id.rb_to_rankine:
                result = base * 1.8 + 32 + 459.67;
                break;
        }
        return result;
    }

    private double fahCases() {
        int toRadioId = mRadioGroupTo.getCheckedRadioButtonId();
        double base = Double.parseDouble(mEditTextTemperature.getText().toString());
        double result = 0;
        switch (toRadioId) {
            case R.id.rb_to_celsius:
                result = (base - 32.0 ) * 1.8;
                break;
            case R.id.rb_to_kelvin:
                result = (base + 459.67) * 1.8;
                break;
            case R.id.rb_to_fah:
                result = base;
                break;
            case R.id.rb_to_rankine:
                result = base + 459.67;
                break;
        }
        return result;
    }

    private double kelvinCases() {
        int toRadioId = mRadioGroupTo.getCheckedRadioButtonId();
        double base = Double.parseDouble(mEditTextTemperature.getText().toString());
        double result = 0;
        switch (toRadioId) {
            case R.id.rb_to_celsius:
                result = base - 273.15;
                break;
            case R.id.rb_to_kelvin:
                result = base;
                break;
            case R.id.rb_to_fah:
                result = base * 1.8  -  459.67;
                break;
            case R.id.rb_to_rankine:
                result = base * 1.8;
                break;
        }
        return result;
    }

    private double rankineCases() {
        int toRadioId = mRadioGroupTo.getCheckedRadioButtonId();
        double base = Double.parseDouble(mEditTextTemperature.getText().toString());
        double result = 0;
        switch (toRadioId) {
            case R.id.rb_to_celsius:
                result = (base - 491.67) * 1.8;
                break;
            case R.id.rb_to_kelvin:
                result = base * 1.8;
                break;
            case R.id.rb_to_fah:
                result = base - 459.67;
                break;
            case R.id.rb_to_rankine:
                result = base;
                break;
        }
        return result;
    }


}


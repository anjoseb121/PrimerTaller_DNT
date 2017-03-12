package com.ajbe.primertaller.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.ajbe.primertaller.R;

public class ConvertBaseActivity extends AppCompatActivity {

    private Spinner mSpinnerFrom, mSpinnerTo;
    private Button mButtonConvert;
    private TextView mTextViewResult;
    private EditText mEditTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initVariables();

        setEvents();

        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.bases,
                android.R.layout.simple_dropdown_item_1line);
        mSpinnerFrom.setAdapter(adapter);
        mSpinnerTo.setAdapter(adapter);
    }

    private void initVariables() {
        mSpinnerFrom = (Spinner) findViewById(R.id.spinner_bases_from);
        mSpinnerTo = (Spinner) findViewById(R.id.spinner_bases_to);
        mButtonConvert = (Button) findViewById(R.id.button_convert);
        mTextViewResult = (TextView) findViewById(R.id.textView_result_base);
        mEditTextValue = (EditText) findViewById(R.id.editText_first_number_base);
    }

    private void setEvents() {
        mButtonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(view.getContext(), "Value: "+value+"\n from: "+from+"\n to: "+to, Toast.LENGTH_SHORT).show();

                convertBases();


            }
        });
    }

    private void convertBases() {
        String value = mEditTextValue.getText().toString();
        String result = "";
        int from = mSpinnerFrom.getSelectedItemPosition();
        int to = mSpinnerTo.getSelectedItemPosition();

        switch (from) {
            // From decimal
            case 0:
                result = casesDecimal(value, to);
                break;
            // From binary
            case 1:
                result = casesBinary(value, to);
                break;
            // From octal
            case 2:
                result = casesOctal(value, to);
                break;
            // From hexadecimal
            case 3:
                result = casesHexadecimal(value, to);
                break;
        }
        mTextViewResult.setText(result);
    }

    private String casesHexadecimal(String value, int to) {
        String result = "";
        int decimal = Integer.parseInt(value, 16);
        switch (to) {
            // To decimal
            case 0:
                result = String.valueOf(decimal);
                break;
            // To binary
            case 1:
                result = Integer.toBinaryString(decimal);
                break;
            // To octal
            case 2:
                result = Integer.toOctalString(decimal);
                break;
            // To hexadecimal
            case 3:
                result = value;
                break;
        }
        return result;
    }

    private String casesOctal(String value, int to) {
        String result = "";
        int decimal = Integer.parseInt(value, 8);
        switch (to) {
            // To decimal
            case 0:
                result = String.valueOf(decimal);
                break;
            // To binary
            case 1:
                result = Integer.toBinaryString(decimal);
                break;
            // To octal
            case 2:
                result = value;
                break;
            // To hexadecimal
            case 3:
                result = Integer.toHexString(decimal);
                break;
        }
        return result;
    }

    private String casesBinary(String value, int to) {
        String result = "";
        int decimal = Integer.parseInt(value, 2);
        switch (to) {
            // To decimal
            case 0:
                result = String.valueOf(decimal);
                break;
            // To binary
            case 1:
                result = value;
                break;
            // To octal
            case 2:
                result = Integer.toOctalString(decimal);
                break;
            // To hexadecimal
            case 3:
                result = Integer.toHexString(decimal);
                break;
        }
        return result;
    }

    private String casesDecimal(String value, int to) {
        String result = "";
        switch (to) {
            // To decimal
            case 0:
                result = value;
                break;
            // To binary
            case 1:
                result = Integer.toBinaryString(Integer.parseInt(value));
                break;
            // To octal
            case 2:
                result = Integer.toOctalString(Integer.parseInt(value));
                break;
            // To hexadecimal
            case 3:
                result = Integer.toHexString(Integer.parseInt(value));
                break;
        }
        return result;
    }

}

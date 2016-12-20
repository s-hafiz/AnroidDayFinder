package com.begginers.dayfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etOutOne,etOutTwo,etOutThree;
    Button btnFind,btnClear;
    TextView tvOut;
    int yearValue,monthValue,dateValue;
    int dayOfWeek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        //Settng listner

        btnFind.setOnClickListener(this);
        btnClear.setOnClickListener(this);

    }

    private void getValues() {
        yearValue=Integer.parseInt(!etOutOne.getText().toString().isEmpty() ? etOutOne.getText().toString():"0");
        monthValue=Integer.parseInt(!etOutTwo.getText().toString().isEmpty() ? etOutTwo.getText().toString(): "0");
        dateValue=Integer.parseInt(!etOutThree.getText().toString().isEmpty() ? etOutThree.getText().toString() : "0");
    }

    private void initView() {
        etOutOne=(EditText)findViewById(R.id.etInOne);
        etOutTwo=(EditText)findViewById(R.id.etInTwo);
        etOutThree=(EditText)findViewById(R.id.etInThree);

        btnFind=(Button)findViewById(R.id.btnCalculate);
        btnClear=(Button)findViewById(R.id.btnClear);

        tvOut=(TextView)findViewById(R.id.tvOut);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCalculate:
                getValues();

                //Creating calender object and set the value

                Calendar myCalender = new GregorianCalendar(yearValue,monthValue,dateValue);
                dayOfWeek=myCalender.get(Calendar.DAY_OF_WEEK);

                switch (dayOfWeek){
                    case 1:
                        tvOut.setText("Yes, It is SUNDAY");
                        break;
                    case 2:
                        tvOut.setText("Yes, It is MONDAY");
                        break;
                    case 3:
                        tvOut.setText("Yes, It is TUESDAY");
                        break;
                    case 4:
                        tvOut.setText("Yes, It is WEDNESSDAY");
                        break;
                    case 5:
                        tvOut.setText("Yes, It is THURSDAY");
                        break;
                    case 6:
                        tvOut.setText("Yes, It is FRIDAY");
                        break;
                    case 7:
                        tvOut.setText("Yes, It is SATURDAY");
                        break;
                }//inner switch finished here
                break;
            case R.id.btnClear:
                etOutOne.setText("");
                etOutTwo.setText("");
                etOutThree.setText("");
                etOutOne.requestFocus();
                break;
        }//outer switch finished here

    }//onclick finished here
}//Launcher activity finished here

package sg.edu.rp.c346.id20017533.l04_reservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPhone;
    EditText etSize;
    CheckBox cb;
    DatePicker dp;
    TimePicker tp;
    Button reserve;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etPhone = findViewById(R.id.editTextPhone);
        etSize = findViewById(R.id.editTextSize);
        cb = findViewById(R.id.checkBoxSorNs);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker2);
        reserve = findViewById(R.id.reserveButton);
        reset = findViewById(R.id.resetButton);

        dp.updateDate(2021,5,1);

        reserve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                String pax = etSize.getText().toString();

                String isSmoke = "";
                if(cb.isChecked()){
                    isSmoke = "smoking";
                }else{
                    isSmoke = "non-smoking";
                }
                String date = dp.getYear() + "/" + (dp.getMonth() + 1) + "/" + dp.getDayOfMonth();
                String time = tp.getCurrentHour() + ":" + String.format("%02d, timePicker.getCurrentMinute()");

                String msg = "Hi, " + name + ", you have booked a " + pax + " person" + isSmoke + " table on " + date + " at " + time + ". Your phone number is " + phone + ',';

            }
        });

        reset.setOnClickListener((v) -> {
            etName.setText("");
            etPhone.setText("");
            etSize.setText("");
            cb.setChecked(false);
            dp.updateDate(2021,5,1);
            tp.setCurrentHour(20);
            tp.setCurrentMinute(30);


        });

    }
}
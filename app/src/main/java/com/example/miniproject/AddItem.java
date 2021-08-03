package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

public class AddItem extends AppCompatActivity {

    Spinner spinner;
    FloatingActionButton saveBtn;
    EditText itemName, date, amount;
    ImageView datePicker;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    ArrayList<String> addArray = new ArrayList<String>();
    String unitValue, expiryDate;
    private FirebaseAuth mAuth;
    private int day,month,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_item);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddItem.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerValue = adapterView.getItemAtPosition(i).toString();
                unitValue = spinnerValue;
                Toast.makeText(getBaseContext(),"Selected Item:" + spinnerValue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        saveBtn = findViewById(R.id.doneBtn);
        itemName = findViewById(R.id.itemName);
        date = findViewById(R.id.Date);
        amount = findViewById(R.id.amount);
        datePicker = findViewById(R.id.datePicker);

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                day = calendar.get(Calendar.DATE);
                month = calendar.get(Calendar.MONTH);
                year = calendar.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddItem.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int yr, int mnth, int dt) {
                        date.setText(dt+"-"+(mnth+1)+"-"+yr);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getName = itemName.getText().toString();
                String getAmount = amount.getText().toString();
                String getDate = date.getText().toString();
                expiryDate = getDate;

                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("items");
                    ItemHelperClass helperClass = new ItemHelperClass(getName, getAmount, getDate, unitValue);
                    reference.child(getName).setValue(helperClass);

                Intent intent = new Intent(AddItem.this, Inventory.class);
                startActivity(intent);
            }
        });
    }

}
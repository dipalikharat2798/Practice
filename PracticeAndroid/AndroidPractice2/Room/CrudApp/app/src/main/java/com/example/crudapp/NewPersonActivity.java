package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewPersonActivity extends AppCompatActivity {

    // creating a variables for our button and edittext.
    private EditText NameEdt, surnameEdt, adharEdt;
    private Button personBtn;

    // creating a constant string variable for our
    // course name, description and duration.
    public static final String EXTRA_ID = "com.example.crudapp.EXTRA_ID";
    public static final String EXTRA_NAME = "com.example.crudapp.EXTRA_PERSON_NAME";
    public static final String EXTRA_SURNAME = "com.example.crudapp.EXTRA_PERSON_Surname";
    public static final String EXTRA_ADHAR = "com.example.crudapp.EXTRA_PERSON_adhar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person);

        // initializing our variables for each view.
        NameEdt = findViewById(R.id.idEdtName);
        surnameEdt = findViewById(R.id.idEdtSurname);
        adharEdt = findViewById(R.id.idEdtadhar);
        personBtn = findViewById(R.id.idBtnSavePerson);

        // below line is to get intent as we
        // are getting data via an intent.
        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {
            // if we get id for our data then we are
            // setting values to our edit text fields.
            NameEdt.setText(intent.getStringExtra(EXTRA_NAME));
            surnameEdt.setText(intent.getStringExtra(EXTRA_SURNAME));
            adharEdt.setText(intent.getStringExtra(EXTRA_ADHAR));
        }
        // adding on click listener for our save button.
        personBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getting text value from edittext and validating if
                // the text fields are empty or not.
                String personName = NameEdt.getText().toString();
                String personSurname = surnameEdt.getText().toString();
                String personAdhar = adharEdt.getText().toString();
                if (personName.isEmpty() || personSurname.isEmpty() || personAdhar.isEmpty()) {
                    Toast.makeText(NewPersonActivity.this, "Please enter the valid  details.", Toast.LENGTH_SHORT).show();
                    return;
                }
                // calling a method to save our course.
                saveCourse(personName, personSurname, personAdhar);
            }
        });
    }

    private void saveCourse(String personName, String personSurname, String personAdhar) {
        // inside this method we are passing
        // all the data via an intent.
        Intent data = new Intent();

        // in below line we are passing all our course detail.
        data.putExtra(EXTRA_NAME, personName);
        data.putExtra(EXTRA_SURNAME, personSurname);
        data.putExtra(EXTRA_ADHAR, personAdhar);
        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {
            // in below line we are passing our id.
            data.putExtra(EXTRA_ID, id);
        }

        // at last we are setting result as data.
        setResult(RESULT_OK, data);

        // displaying a toast message after adding the data
        Toast.makeText(this, "Details has been saved to Room Database. ", Toast.LENGTH_SHORT).show();
    }
}

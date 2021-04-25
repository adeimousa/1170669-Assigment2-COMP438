package edu.birzeit.assigment2.activiteis;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.birzeit.assigment2.R;
import edu.birzeit.assigment2.models.Gender;
import edu.birzeit.assigment2.models.Person;

public class PersonalInfoActivity extends AppCompatActivity {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    boolean personFlag;
    EditText firstName;
    EditText lastName;
    EditText aboutMe;
    RadioButton male;
    RadioButton female;
    DatePicker dateOfBirth;
    Spinner countrySpinner;
    Gender gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
        setupViews();
    }

    private void setupViews() {
        firstName = findViewById(R.id.firstNameEdt);
        lastName = findViewById(R.id.lastNameEdt);
        aboutMe = findViewById(R.id.aboutMeEdt);
        male = findViewById(R.id.radioButtonMale);
        female = findViewById(R.id.radioButtonFemale);
        dateOfBirth = findViewById(R.id.datePicker);
        countrySpinner = findViewById(R.id.countrySpinner);
        setupSpinner();
        personFlag = prefs.getBoolean("personFlag", false);
        if (personFlag){
            Gson gson = new Gson();
            String personStr = prefs.getString("person", "");
            Person person = gson.fromJson(personStr, Person.class);
            firstName.setText(person.getFirstName());
            lastName.setText(person.getLastName());
            aboutMe.setText(person.getAbout());
            if (person.getGender() == Gender.MALE){
                male.toggle();
                gender = Gender.MALE;
            }else {
                female.toggle();
                gender = Gender.FEMALE;
            }
            //Set Date
            Calendar calender = Calendar.getInstance();
            calender.setTime(person.getDateOfBirth());
            int day = calender.get(Calendar.DAY_OF_MONTH);
            int month = calender.get(Calendar.MONTH);
            int year = calender.get(Calendar.YEAR);
            dateOfBirth.init(year,month,day,null);

            //Set Spinner Item
            for (int i=0;i<countrySpinner.getCount();i++){
                if (countrySpinner.getItemAtPosition(i).equals(person.getCountry())){
                    System.out.println(countrySpinner.getItemAtPosition(i));
                    countrySpinner.setSelection(i);
                }
            }
          }
    }
    private void setupSpinner() {
        countrySpinner = findViewById(R.id.countrySpinner);
        ArrayList<String> contries = new ArrayList<String>();
        contries.add("Palestine");
        contries.add("Jordan");
        contries.add("UAE");
        contries.add("Syria");
        contries.add("Egypt");
        contries.add("Lebanon");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, contries);
        countrySpinner.setAdapter(arrayAdapter);
    }
    public void goToEducation(View view) {
        Person person = new Person();
        if (personFlag){
            Gson gson = new Gson();
            String personStr = prefs.getString("person", "");
            person = gson.fromJson(personStr, Person.class);
        }

        person.setFirstName(firstName.getText().toString());
        person.setLastName(lastName.getText().toString());
        person.setAbout(aboutMe.getText().toString());
        person.setCountry(countrySpinner.getSelectedItem().toString());
        person.setGender(gender);
        int day = dateOfBirth.getDayOfMonth();
        int month = dateOfBirth.getMonth();
        int year = dateOfBirth.getYear();
        Calendar mCalender = Calendar.getInstance();
        mCalender.set(Calendar.YEAR, year);
        mCalender.set(Calendar.MONTH, month);
        mCalender.set(Calendar.DAY_OF_MONTH, day);
        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalender.getTime());
        person.setDateOfBirth(new Date(selectedDate));
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        System.out.println(person);
        editor.putString("person", personJson);
        editor.putBoolean("personFlag", true);
        editor.commit();
        Intent intent = new Intent(this, EducationActivity.class);
        startActivity(intent);
    }

    public void onRadioClick(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButtonMale:
                if (checked)
                    gender = Gender.MALE;
                    break;
            case R.id.radioButtonFemale:
                if (checked)
                    gender = Gender.FEMALE;
                    break;
        }
    }
}
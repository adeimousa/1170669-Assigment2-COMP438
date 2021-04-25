package edu.birzeit.assigment2.activiteis;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import edu.birzeit.assigment2.R;
import edu.birzeit.assigment2.models.Education;
import edu.birzeit.assigment2.models.Person;
import edu.birzeit.assigment2.models.Training;

public class EducationActivity extends AppCompatActivity {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    boolean personFlag;
    private EditText degree;
    private EditText educationOrganizationName;
    private EditText educationOrganizationAddress;
    private EditText trainingDescription;
    private EditText trainingOrganizationName;
    private EditText trainingOrganizationAddress;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
        setupViews();

    }

    private void setupViews() {
        degree = findViewById(R.id.degreeEdt);
        educationOrganizationName = findViewById(R.id.eduOrgNameEdt);
        educationOrganizationAddress = findViewById(R.id.eduOrgAddress);
        trainingDescription = findViewById(R.id.trainDescEdt);
        trainingOrganizationName = findViewById(R.id.trainOrgNameEdt);
        trainingOrganizationAddress = findViewById(R.id.trainOrgAddress);
        personFlag = prefs.getBoolean("personFlag", false);
        System.out.println(personFlag);
        if (personFlag){
            Gson gson = new Gson();
            String personStr = prefs.getString("person", "");
            Person person = gson.fromJson(personStr, Person.class);
            Education education = person.getEducation();
            Training training = person.getTraining();
            System.out.println(education);
            if (education != null){
                educationOrganizationName.setText(education.getOrganization());
                degree.setText(education.getDegree());
                educationOrganizationAddress.setText(education.getOrganizationAddress());
            }
            if(training != null){
                trainingDescription.setText(training.getDescription());
                trainingOrganizationName.setText(training.getOrganizationAddress());
                trainingOrganizationAddress.setText(training.getOrganizationAddress());
            }

        }
    }

    public void goToWork(View view) {
        Education education = new Education();
        Training training = new Training();
        education.setDegree(degree.getText().toString());
        education.setOrganization(educationOrganizationName.getText().toString());
        education.setOrganizationAddress(educationOrganizationAddress.getText().toString());
        training.setDescription(trainingDescription.getText().toString());
        training.setOrganization(trainingOrganizationName.getText().toString());
        training.setOrganizationAddress(trainingOrganizationAddress.getText().toString());
        Gson gson = new Gson();
        String str = prefs.getString("person","");
        Person person = gson.fromJson(str, Person.class);
        person.setEducation(education);
        person.setTraining(training);
        String personJson = gson.toJson(person);
        editor.putString("person", personJson);
        editor.commit();
        Intent intent = new Intent(this, WorkActivity.class);
        startActivity(intent);
    }
}
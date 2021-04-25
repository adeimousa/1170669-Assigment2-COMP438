package edu.birzeit.assigment2.activiteis;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import edu.birzeit.assigment2.R;
import edu.birzeit.assigment2.models.Education;
import edu.birzeit.assigment2.models.JobSkill;
import edu.birzeit.assigment2.models.Person;
import edu.birzeit.assigment2.models.Training;
import edu.birzeit.assigment2.models.WorkExperience;

public class WorkActivity extends AppCompatActivity {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    boolean personFlag;
    private EditText workDescription;
    private EditText organizationName;
    private EditText skill1Name;
    private EditText skill2Name;
    private EditText skill3Name;
    private SeekBar skill1ExpRate;
    private SeekBar skill2ExpRate;
    private SeekBar skill3ExpRate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
        setupViews();
    }

    private void setupViews() {
        workDescription = findViewById(R.id.workDescriptionEdt);
        organizationName = findViewById(R.id.workOrgNameEdt);
        skill1Name = findViewById(R.id.skill1NameEdt);
        skill2Name = findViewById(R.id.skill2NameEdt);
        skill3Name = findViewById(R.id.skill3NameEdt);
        skill1ExpRate = findViewById(R.id.skill1ExpRateSeek);
        skill2ExpRate = findViewById(R.id.skill2ExpRateSeek);
        skill3ExpRate = findViewById(R.id.skill3ExpRateSeek);
        personFlag = prefs.getBoolean("personFlag", false);
        if (personFlag) {
            Gson gson = new Gson();
            String personStr = prefs.getString("person", "");
            Person person = gson.fromJson(personStr, Person.class);
            WorkExperience workExperience = person.getWorkExperience();
            if (workExperience != null){
                workDescription.setText(workExperience.getDescription());
                organizationName.setText(workExperience.getOrganization());
                JobSkill skill1 = workExperience.getSkill1();
                JobSkill skill2 = workExperience.getSkill2();
                JobSkill skill3 = workExperience.getSkill3();
                if (skill1 != null){
                    skill1Name.setText(skill1.getSkillName());
                    skill1ExpRate.setProgress(skill1.getExperienceRate());
                }
                if (skill2 != null){
                    skill2Name.setText(skill2.getSkillName());
                    skill2ExpRate.setProgress(skill2.getExperienceRate());
                }
                if (skill3 != null){
                    skill3Name.setText(skill3.getSkillName());
                    skill3ExpRate.setProgress(skill3.getExperienceRate());

                }

            }
        }
    }

    public void goToContact(View view) {
        WorkExperience workExperience = new WorkExperience();
        workExperience.setDescription(workDescription.getText().toString());
        workExperience.setOrganization(organizationName.getText().toString());
        JobSkill skill1 = new JobSkill(skill1Name.getText().toString(), skill1ExpRate.getProgress());
        JobSkill skill2 = new JobSkill(skill2Name.getText().toString(), skill2ExpRate.getProgress());
        JobSkill skill3 = new JobSkill(skill3Name.getText().toString(), skill3ExpRate.getProgress());
        workExperience.setSkill1(skill1);
        workExperience.setSkill2(skill2);
        workExperience.setSkill3(skill3);
        Gson gson = new Gson();
        String str = prefs.getString("person","");
        Person person = gson.fromJson(str, Person.class);
        person.setWorkExperience(workExperience);
        String personJson = gson.toJson(person);
        editor.putString("person", personJson);
        editor.commit();
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }
}
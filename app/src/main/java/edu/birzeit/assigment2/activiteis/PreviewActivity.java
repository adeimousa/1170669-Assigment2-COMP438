package edu.birzeit.assigment2.activiteis;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.util.Calendar;

import edu.birzeit.assigment2.R;
import edu.birzeit.assigment2.models.ContactInfo;
import edu.birzeit.assigment2.models.Education;
import edu.birzeit.assigment2.models.JobSkill;
import edu.birzeit.assigment2.models.Person;
import edu.birzeit.assigment2.models.SocialMedia;
import edu.birzeit.assigment2.models.Training;
import edu.birzeit.assigment2.models.WorkExperience;

public class PreviewActivity extends AppCompatActivity {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    boolean personFlag;
    private TextView previewName;
    private TextView previewCountry;
    private TextView previewDOB;
    private TextView previewGender;
    private TextView previewEmail;
    private TextView previewPhone;
    private TextView previewSocialType;
    private TextView previewSocialLink;
    private TextView previewAddress1;
    private TextView previewAddress2;
    private TextView previewAboutMe;
    private TextView previewEduDegree;
    private TextView previewEduOrgName;
    private TextView previewEduOrgAddress;
    private TextView previewTrainDescription;
    private TextView previewTrainOrgName;
    private TextView previewTrainOrgAddress;
    private TextView previewWorkDescription;
    private TextView previewWorkOrg;
    private TextView previewSkill1Name;
    private TextView previewSkill2Name;
    private TextView previewSkill3Name;
    private ProgressBar previewSkill1Rate;
    private ProgressBar previewSkill2Rate;
    private ProgressBar previewSkill3Rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
        setupViews();
    }

    private void setupViews() {
        previewName = findViewById(R.id.previewName);
        previewCountry = findViewById(R.id.previewCountry);
        previewDOB = findViewById(R.id.previewDOB);
        previewGender = findViewById(R.id.previewGender);
        previewEmail = findViewById(R.id.previewEmail);
        previewPhone = findViewById(R.id.previewPhone);
        previewSocialType = findViewById(R.id.previewSocialType);
        previewSocialLink = findViewById(R.id.previewSocialLink);
        previewAddress1 = findViewById(R.id.previewAddress1);
        previewAddress2 = findViewById(R.id.previewAddress2);
        previewAboutMe = findViewById(R.id.previewAboutMe);
        previewEduDegree = findViewById(R.id.previewDegree);
        previewEduOrgName = findViewById(R.id.previewEduOrgName);
        previewEduOrgAddress = findViewById(R.id.previewEduOrgAddress);
        previewTrainDescription = findViewById(R.id.previewTrainingDescription);
        previewTrainOrgName = findViewById(R.id.previewTrainingOrgName);
        previewTrainOrgAddress = findViewById(R.id.previewTrainingOrgAddress);
        previewWorkDescription = findViewById(R.id.previewWorkDescription);
        previewWorkOrg = findViewById(R.id.previewWorkOrgName);
        previewSkill1Name = findViewById(R.id.previewSkill1Name);
        previewSkill2Name = findViewById(R.id.previewSkill2Name);
        previewSkill3Name = findViewById(R.id.previewSkill3Name);
        previewSkill1Rate = findViewById(R.id.previewSkill1Rate);
        previewSkill2Rate = findViewById(R.id.previewSkill2Rate);
        previewSkill3Rate = findViewById(R.id.previewSkill3Rate);
        personFlag = prefs.getBoolean("personFlag", false);
        if (personFlag) {
            Gson gson = new Gson();
            String personStr = prefs.getString("person", "");
            Person person = gson.fromJson(personStr, Person.class);
            previewName.setText(person.getFirstName() + " " + person.getLastName());
            previewCountry.setText(person.getCountry());

            previewDOB.setText( DateFormat.getDateInstance(DateFormat.FULL).format(person.getDateOfBirth()));
            previewGender.setText(person.getGender().toString());
            ContactInfo contactInfo = person.getContactInfo();
            if (contactInfo != null){
                previewEmail.setText(contactInfo.getEmail());
                previewPhone.setText(contactInfo.getPhone());
                previewSocialType.setText(contactInfo.getSocialMedia().toString());
                previewSocialLink.setText(contactInfo.getSocialMediaLink());
                previewAddress1.setText(contactInfo.getAddressLine1());
                previewAddress2.setText(contactInfo.getAddressLine2());
            }
            previewAboutMe.setText(person.getAbout());
            Education education = person.getEducation();
            if (education != null) {
                previewEduDegree.setText(education.getDegree());
                previewEduOrgName.setText(education.getOrganization());
                previewEduOrgAddress.setText(education.getOrganizationAddress());
            }

            Training training = person.getTraining();
            if (training !=null){
                previewTrainDescription.setText(training.getDescription());
                previewTrainOrgName.setText(training.getOrganization());
                previewTrainOrgAddress.setText(training.getOrganizationAddress());
            }
            WorkExperience workExperience = person.getWorkExperience();
            if (workExperience != null){
                previewWorkDescription.setText(workExperience.getDescription());
                previewWorkOrg.setText(workExperience.getOrganization());
                JobSkill skill1 = workExperience.getSkill1();
                JobSkill skill2 = workExperience.getSkill2();
                JobSkill skill3 = workExperience.getSkill3();
                if (skill1 != null){
                    previewSkill1Name.setText(skill1.getSkillName());
                    previewSkill1Rate.setProgress(skill1.getExperienceRate());
                }
                if (skill2 != null){
                    previewSkill2Name.setText(skill2.getSkillName());
                    previewSkill2Rate.setProgress(skill2.getExperienceRate());
                }
                if (skill3 != null){
                    previewSkill3Name.setText(skill3.getSkillName());
                    previewSkill3Rate.setProgress(skill3.getExperienceRate());
                }
            }
        }

    }
}
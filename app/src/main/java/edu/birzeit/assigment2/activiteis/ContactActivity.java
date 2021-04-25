package edu.birzeit.assigment2.activiteis;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;

import edu.birzeit.assigment2.R;
import edu.birzeit.assigment2.models.ContactInfo;
import edu.birzeit.assigment2.models.Education;
import edu.birzeit.assigment2.models.Person;
import edu.birzeit.assigment2.models.SocialMedia;

public class ContactActivity extends AppCompatActivity {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    boolean personFlag;
    private EditText email;
    private EditText phone;
    private Spinner socialSpinner;
    private EditText socialLink;
    private EditText addressLine1;
    private EditText addressLine2;
    private Spinner citiesSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
        setupViews();


    }

    private void setupViews() {
        email = findViewById(R.id.emailEdt);
        phone = findViewById(R.id.phoneEdt);
        socialSpinner = findViewById(R.id.socialSpinner);
        socialLink = findViewById(R.id.socialLinkEdt);
        addressLine1 = findViewById(R.id.adressLine1Edt);
        addressLine2 = findViewById(R.id.adressLine2Edt);
        citiesSpinner = findViewById(R.id.citySpinner);
        personFlag = prefs.getBoolean("personFlag", false);
        setupSocialSpinner();
        setupCitiesSpinner();
        if (personFlag) {
            Gson gson = new Gson();
            String personStr = prefs.getString("person", "");
            Person person = gson.fromJson(personStr, Person.class);
            ContactInfo contactInfo = person.getContactInfo();
            if (contactInfo != null){
                email.setText(contactInfo.getEmail());
                phone.setText(contactInfo.getPhone());
                socialLink.setText(contactInfo.getSocialMediaLink());
                addressLine1.setText(contactInfo.getAddressLine1());
                addressLine2.setText(contactInfo.getAddressLine2());
                //Set Spinner Item
                for (int i=0;i<socialSpinner.getCount();i++){
                    if (socialSpinner.getItemAtPosition(i).equals(contactInfo.getSocialMedia().toString())){
                        socialSpinner.setSelection(i);
                    }
                }
                for (int i=0;i<citiesSpinner.getCount();i++){
                    if (citiesSpinner.getItemAtPosition(i).equals(contactInfo.getCity())){
                        citiesSpinner.setSelection(i);
                    }
                }
            }
        }
    }
        private void setupSocialSpinner() {
        ArrayList<String> socials = new ArrayList<String>();
        socials.add("FACEBOOK");
        socials.add("TWITTER");
        socials.add("LINKEDIN");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, socials);
        socialSpinner.setAdapter(arrayAdapter);
    }
    private void setupCitiesSpinner() {
        ArrayList<String> cities = new ArrayList<String>();
        cities.add("Ramallah");
        cities.add("Salfeet");
        cities.add("Nablus");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities);
        citiesSpinner.setAdapter(arrayAdapter);
    }

    public void goToPreview(View view) {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setEmail(email.getText().toString());
        contactInfo.setPhone(phone.getText().toString());
        contactInfo.setSocialMedia(SocialMedia.valueOf(socialSpinner.getSelectedItem().toString()));
        contactInfo.setSocialMediaLink(socialLink.getText().toString());
        contactInfo.setAddressLine1(addressLine1.getText().toString());
        contactInfo.setAddressLine2(addressLine2.getText().toString());
        contactInfo.setCity(citiesSpinner.getSelectedItem().toString());
        Gson gson = new Gson();
        String str = prefs.getString("person","");
        Person person = gson.fromJson(str, Person.class);
        person.setContactInfo(contactInfo);
        String personJson = gson.toJson(person);
        editor.putString("person", personJson);
        editor.commit();
        System.out.println(personJson);
        Intent intent = new Intent(this, PreviewActivity.class);
//        //Select Preview Tap
//        intent.putExtra("tabIndex", 1);
        startActivity(intent);
    }


}
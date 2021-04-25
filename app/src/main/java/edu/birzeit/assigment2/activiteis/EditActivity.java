package edu.birzeit.assigment2.activiteis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import edu.birzeit.assigment2.R;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }
    public void goToPersonal(View view) {

        Intent intent = new Intent(this, PersonalInfoActivity.class);
        startActivity(intent);
    }



    public void goToContact(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }
}
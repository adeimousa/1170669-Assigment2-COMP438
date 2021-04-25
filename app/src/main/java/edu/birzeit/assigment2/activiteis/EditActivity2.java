package edu.birzeit.assigment2.activiteis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.birzeit.assigment2.R;

public class EditActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit2);
    }
    public void goToEducation(View view) {
        Intent intent = new Intent(this, EducationActivity.class);
        startActivity(intent);
    }

    public void goToWork(View view) {
        Intent intent = new Intent(this, WorkActivity.class);
        startActivity(intent);
    }
}
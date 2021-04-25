package edu.birzeit.assigment2.activiteis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import edu.birzeit.assigment2.R;
import edu.birzeit.assigment2.fragements.Tab1Fragment;
import edu.birzeit.assigment2.fragements.Tab2Fragment;
import edu.birzeit.assigment2.fragements.TabAdapter;

public class MainActivity extends AppCompatActivity {
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "Personal");
        adapter.addFragment(new Tab2Fragment(), "Experience");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        //Select Tap after finish editing : default edit tap
        Intent intent = getIntent();
        int selectedTabIndex = intent.getIntExtra("tabIndex",0);
        tabLayout.getTabAt(selectedTabIndex).select();
    }
    public void goToPersonal(View view) {

        Intent intent = new Intent(this, PersonalInfoActivity.class);
        startActivity(intent);
    }

    public void goToEducation(View view) {
        Intent intent = new Intent(this, EducationActivity.class);
        startActivity(intent);
    }

    public void goToWork(View view) {
        Intent intent = new Intent(this, WorkActivity.class);
        startActivity(intent);
    }

    public void goToContact(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }



}
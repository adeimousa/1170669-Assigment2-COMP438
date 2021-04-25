package edu.birzeit.assigment2.fragements;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import edu.birzeit.assigment2.R;
import edu.birzeit.assigment2.activiteis.PreviewActivity;
import edu.birzeit.assigment2.models.Person;

public class Tab2Fragment extends Fragment {

@Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

 return inflater.inflate(R.layout.activity_edit2, container, false);
 }

}
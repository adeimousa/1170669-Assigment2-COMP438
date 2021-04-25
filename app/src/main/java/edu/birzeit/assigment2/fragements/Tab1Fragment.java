package edu.birzeit.assigment2.fragements;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import edu.birzeit.assigment2.R;

public class Tab1Fragment extends Fragment {
@Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 return inflater.inflate(R.layout.activity_edit, container, false);
 }

}
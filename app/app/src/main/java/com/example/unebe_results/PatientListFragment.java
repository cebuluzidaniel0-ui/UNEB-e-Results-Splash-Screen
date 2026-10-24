package com.example.unebe_results;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PatientListFragment extends Fragment {

    // Required empty public constructor
    public PatientListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the patient list layout for this fragment
        return inflater.inflate(R.layout.fragment_patient_list, container, false);
    }
}
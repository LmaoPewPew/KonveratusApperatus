package com.example.konveratusapperatus.ui.Temp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.konveratusapperatus.R;

public class TempFragment extends Fragment {

    private TempViewModel tempViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tempViewModel = new ViewModelProvider(this).get(TempViewModel.class);
        View root = inflater.inflate(R.layout.fragment_temp, container, false);
        //Logic is Still Missing
        return root;
    }
}
package com.example.konveratusapperatus.ui.Length;

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

public class LengthFragment extends Fragment {

    private LengthViewModel lengthViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        lengthViewModel =
                new ViewModelProvider(this).get(LengthViewModel.class);
        View root = inflater.inflate(R.layout.fragment_lenght, container, false);
        return root;
    }
}
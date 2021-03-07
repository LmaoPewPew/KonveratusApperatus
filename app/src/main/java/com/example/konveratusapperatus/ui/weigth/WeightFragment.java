package com.example.konveratusapperatus.ui.weigth;

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

public class WeightFragment extends Fragment {

    private WeightViewModel weightViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        weightViewModel =
                new ViewModelProvider(this).get(WeightViewModel.class);
        View root = inflater.inflate(R.layout.fragment_weight, container, false);
        //Logic is Still Missing
        return root;
    }
}
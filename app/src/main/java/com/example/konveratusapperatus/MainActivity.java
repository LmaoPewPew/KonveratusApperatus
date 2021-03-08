package com.example.konveratusapperatus;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_lenght, R.id.nav_temp, R.id.nav_sweight)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //MUSS MANN NOCH FERTIG MACHEN!!!
/*
        //length
        Spinner spLengthIn = findViewById(R.id.spLengthIn);
        ArrayAdapter<CharSequence> adLengthIn = ArrayAdapter.createFromResource(this, R.array.length, android.R.layout.simple_spinner_item);
        adLengthIn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLengthIn.setAdapter(adLengthIn);
        spLengthIn.setOnItemSelectedListener(this);
/*
        Spinner spLengthOut = findViewById(R.id.spLengthOut);
        ArrayAdapter<CharSequence> adLengthOut = ArrayAdapter.createFromResource(this, R.array.length, android.R.layout.simple_spinner_item);
        adLengthOut.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLengthOut.setAdapter(adLengthOut);
        spLengthOut.setOnItemSelectedListener(this);

        //Temperatur
        Spinner spTempIn = findViewById(R.id.spTempIn);
        ArrayAdapter<CharSequence> adTempIn = ArrayAdapter.createFromResource(this, R.array.temp, android.R.layout.simple_spinner_item);
        adTempIn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTempIn.setAdapter(adLengthIn);
        spTempIn.setOnItemSelectedListener(this);

        Spinner spTempOut = findViewById(R.id.spTempOut);
        ArrayAdapter<CharSequence> adTempOut = ArrayAdapter.createFromResource(this, R.array.temp, android.R.layout.simple_spinner_item);
        adTempOut.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTempOut.setAdapter(adLengthOut);
        spTempOut.setOnItemSelectedListener(this);

        //weight
        Spinner spWeightIn = findViewById(R.id.spWeightIn);
        ArrayAdapter<CharSequence> adWeightIn = ArrayAdapter.createFromResource(this, R.array.weight, android.R.layout.simple_spinner_item);
        adWeightIn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spWeightIn.setAdapter(adLengthIn);
        spWeightIn.setOnItemSelectedListener(this);

        Spinner spWeightOut = findViewById(R.id.spWeightOut);
        ArrayAdapter<CharSequence> adWeightOut = ArrayAdapter.createFromResource(this, R.array.weight, android.R.layout.simple_spinner_item);
        adWeightOut.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spWeightOut.setAdapter(adLengthOut);
        spWeightOut.setOnItemSelectedListener(this);
       // */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
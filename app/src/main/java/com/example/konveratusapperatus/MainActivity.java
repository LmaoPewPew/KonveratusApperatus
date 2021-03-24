package com.example.konveratusapperatus;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
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

    //ads
    AdView adBanner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //DropInMenu Drawer
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

        //Ads
        //wenn published AndroidManifest.xml | content_main.xml | hier | die ca-app-pub-xxx ändern!
        adBanner = findViewById(R.id.adView);


        MobileAds.initialize(this, "ca-app-pub-2320726719972355~3050095120");
        AdRequest adReq = new AdRequest.Builder().build();
        adBanner.loadAd(adReq);

        /* Kann sein das wir das doch nicht brauchen
        //Spinner Settings
        //length
        View vLength = getLayoutInflater().inflate(R.layout.fragment_lenght, null);

        Spinner spLengthIn = vLength.findViewById(R.id.spLengthIn);
        ArrayAdapter<CharSequence> adLengthIn = ArrayAdapter.createFromResource(this, R.array.length, android.R.layout.simple_spinner_item);
        adLengthIn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLengthIn.setAdapter(adLengthIn);
        spLengthIn.setOnItemSelectedListener(this);

        Spinner spLengthOut = vLength.findViewById(R.id.spLengthOut);
        ArrayAdapter<CharSequence> adLengthOut = ArrayAdapter.createFromResource(this, R.array.length, android.R.layout.simple_spinner_item);
        adLengthOut.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLengthOut.setAdapter(adLengthOut);
        spLengthOut.setOnItemSelectedListener(this);

        //Temperatur
        View vTemp = getLayoutInflater().inflate(R.layout.fragment_temp, null);

        Spinner spTempIn = vTemp.findViewById(R.id.spTempIn);
        ArrayAdapter<CharSequence> adTempIn = ArrayAdapter.createFromResource(this, R.array.temp, android.R.layout.simple_spinner_item);
        adTempIn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTempIn.setAdapter(adLengthIn);
        spTempIn.setOnItemSelectedListener(this);

        Spinner spTempOut = vTemp.findViewById(R.id.spTempOut);
        ArrayAdapter<CharSequence> adTempOut = ArrayAdapter.createFromResource(this, R.array.temp, android.R.layout.simple_spinner_item);
        adTempOut.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTempOut.setAdapter(adLengthOut);
        spTempOut.setOnItemSelectedListener(this);

        //weight
        View vWeight = getLayoutInflater().inflate(R.layout.fragment_weight, null);

        Spinner spWeightIn = vWeight.findViewById(R.id.spWeightIn);
        ArrayAdapter<CharSequence> adWeightIn = ArrayAdapter.createFromResource(this, R.array.weight, android.R.layout.simple_spinner_item);
        adWeightIn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spWeightIn.setAdapter(adLengthIn);
        spWeightIn.setOnItemSelectedListener(this);

        Spinner spWeightOut = vWeight.findViewById(R.id.spWeightOut);
        ArrayAdapter<CharSequence> adWeightOut = ArrayAdapter.createFromResource(this, R.array.weight, android.R.layout.simple_spinner_item);
        adWeightOut.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spWeightOut.setAdapter(adLengthOut);
        spWeightOut.setOnItemSelectedListener(this);
        //*/

    }
    //button Logic
    public void getData(View v){
        //spinner ID
        Spinner spLI= findViewById(R.id.spLengthIn);
        Spinner spLO = findViewById(R.id.spLengthOut);
        Spinner spTI = findViewById(R.id.spTempIn);
        Spinner spTO = findViewById(R.id.spTempOut);
        Spinner spWI = findViewById(R.id.spWeightIn);
        Spinner spWO = findViewById(R.id.spWeightOut);

        //NumberInput
        EditText numLi = findViewById(R.id.numLengthIn);
        EditText numTi = findViewById(R.id.numTempIn);
        EditText numWi = findViewById(R.id.numWeightIn);

        //NumberOutput
        EditText numLo = findViewById(R.id.numLengthOut);
        EditText numTo = findViewById(R.id.numTempOut);
        EditText numWo = findViewById(R.id.numWeightOut);


        double li = 0,ti = 0,wi = 0;
        //li = Double.valueOf(numLi.getText().toString());
        //ti = Double.valueOf(numTi.getText().toString());
        //wi = Double.valueOf(numWi.getText().toString());

        //ausgabe in Logcat als Test
        //Log.d("info", li + " " + ti + " " + wi);

    }
    // Hier wird gerechnet
    public double calculate (){
        return 0;
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
       String ItemPosition = parent.getItemAtPosition(position).toString();
       Toast.makeText(this,ItemPosition,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
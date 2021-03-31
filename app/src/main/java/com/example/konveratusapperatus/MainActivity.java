package com.example.konveratusapperatus;

import android.os.Bundle;
import android.telephony.mbms.StreamingServiceInfo;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
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
    Spinner spLi, spLo, spTi, spTo, spWi, spWo;
    EditText numLi, numTi, numWi;
    TextView numLo, numTo, numWo;

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
        //wenn published content_main.xml die ca-app-pub-xxx ändern!
        adBanner = findViewById(R.id.adView);
        MobileAds.initialize(this, "ca-app-pub-2320726719972355~3050095120");
        AdRequest adReq = new AdRequest.Builder().build();
        adBanner.loadAd(adReq);

                    //Spinner
    /*      spLi = findViewById(R.id.spLengthIn);
        spLo = findViewById(R.id.spLengthOut);

        String[] length = {"Kilometer", "Meter", "Centimeter", "Milimeter", "Meilen", "Fuß", "Inch"};
        ArrayAdapter ad = new ArrayAdapter<String>{ this, R.layout.support_simple_spinner_dropdown_item, length};
        spLi.setAdapter(ad);

        String[] length2 = {"Kilometer", "Meter", "Centimeter", "Milimeter", "Meilen", "Fuß", "Inch"};
        ArrayAdapter ad2 = new ArrayAdapter<String>{ this, R.layout.support_simple_spinner_dropdown_item, length2};
        spLo.setAdapter(ad2);
    */

        /*  //length
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

    //button Logic Length
    public void Length(View v){
        double li = 0;

        spLi = findViewById(R.id.spLengthIn);
        spLo = findViewById(R.id.spLengthOut);

        numLi = findViewById(R.id.numLengthIn);
        numLo = findViewById(R.id.numLengthOut);

        try {
            li = Double.parseDouble(numLi.getText().toString());
        }
        catch(Exception e) {
            Log.d("Exeption","Keine Zahl eingegeben");
        }

        double value = calculate(li, spLi, spLo);
        numLo.setText(Double.toString(value));
    }

    //button Logic Temp
    public void Temp(View v){
        double ti = 0;

        spTi = findViewById(R.id.spTempIn);
        spTo = findViewById(R.id.spTempOut);

        numTi = findViewById(R.id.numTempIn);
        numTo = findViewById(R.id.numTempOut);

        try {
            ti = Double.parseDouble(numTi.getText().toString());
        }
        catch(Exception e) {
            Log.d("Exeption","Keine Zahl eingegeben");
        }

        double value = calculate(ti, spTi, spTo);
        numTo.setText(Double.toString(value));

    }

    //button Logic Weight
    public void Weight(View v){
        double wi = 0;

        spWi = findViewById(R.id.spWeightIn);
        spWo = findViewById(R.id.spWeightOut);

        numWi = findViewById(R.id.numWeightIn);
        numWo = findViewById(R.id.numWeightOut);

        try {
            wi = Double.parseDouble(numWi.getText().toString());
        }
        catch(Exception e) {
            Log.d("Exeption","Keine Zahl eingegeben");
        }

        double value = calculate(wi, spWi, spWo);
        numWo.setText(Double.toString(value));
    }

    // Hier wird gerechnet
    public double calculate (double num, Spinner spIn, Spinner spOut) {
        //Spinner
        String unitIn = spIn.getSelectedItem().toString();
        String unitOut = spOut.getSelectedItem().toString();

        //Lenght
        if (unitIn.equals("Kilometer")) {
            Log.d("Penis", unitIn);
            if (unitOut.equals("Meter")) {

                Log.d("Penis", unitOut);
            }
        }

        //Temp
        if (unitIn.equals("Celsius")) {
            if (unitOut.equals("Fahrenheit")) {
                Log.d("Penis", unitOut);
            }
        }

        //Weight
        if (unitIn.equals("Tonne")) {
            if (unitOut.equals("Fahrenheit")) {
                Log.d("Penis", unitOut);
            }
        }

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
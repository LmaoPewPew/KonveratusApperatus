package com.example.konveratusapperatus;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
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
                R.id.nav_lenght, R.id.nav_temp, R.id.nav_weight)
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
            double value = calculate(li, spLi, spLo);
            numLo.setText(Double.toString(value));
        }
        catch(Exception e) {
            Log.d("Exeption","Keine Zahl eingegeben");
            numLo.setText("Ausgabe");
        }
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
            double value = calculate(ti, spTi, spTo);
            numTo.setText(Double.toString(value));
        }
        catch(Exception e) {
            Log.d("Exeption","Keine Zahl eingegeben");
            numLo.setText("Ausgabe");
        }
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
            double value = calculate(wi, spWi, spWo);
            numWo.setText(Double.toString(value));
        }
        catch(Exception e) {
            Log.d("Exeption","Keine Zahl eingegeben");
            numLo.setText("Ausgabe");
        }
 }

    // Hier wird gerechnet
    public double calculate (double num, Spinner spIn, Spinner spOut) {
        //Spinner
        String unitIn = spIn.getSelectedItem().toString();
        String unitOut = spOut.getSelectedItem().toString();
        Log.d("Unit", unitIn);
        Log.d("Unit", unitOut);

        //Lenght
        // KM
        if (unitIn.equals("Kilometer")) {
            if (unitOut.equals("Meter")) {
                return num *= 1000;
            } else if (unitOut.equals("Centimeter")) {
                return num *= 100000;
            } else if (unitOut.equals("Milimeter")) {
                return num *= 1000000;
            } else if (unitOut.equals("Meilen")) {
                return num *= 0.621371;
            } else if (unitOut.equals("Fuß")) {
                return num *= 3280.84;
            } else if (unitOut.equals("Inch")) {
                return num *= 39370;
            } else
                return num;

        }// M
        else if (unitIn.equals("Meter")) {
            if (unitOut.equals("Kilometer")) {
                return num /= 1000;
            } else if (unitOut.equals("Centimeter")) {
                return num *= 100;
            } else if (unitOut.equals("Milimeter")) {
                return num *= 1000;
            } else if (unitOut.equals("Meilen")) {
                return num /= 1609 ;
            } else if (unitOut.equals("Fuß")) {
                return num *= 3.281;
            } else if (unitOut.equals("Inch")) {
                return num *= 39.37;
            } else
                return num;

        }// CM
        else if (unitIn.equals("Centimeter")) {
            if (unitOut.equals("Meter")) {
                return num /= 100;
            } else if (unitOut.equals("Kilometer")) {
                return num /= 100000;
            } else if (unitOut.equals("Milimeter")) {
                return num *= 10;
            } else if (unitOut.equals("Meilen")) {
                return num /= 160934;
            } else if (unitOut.equals("Fuß")) {
                return num *= 3280.84;
            } else if (unitOut.equals("Inch")) {
                return num *= 2.54;
            } else
                return num;

        }// MM
        else if (unitIn.equals("Milimeter")) {
            if (unitOut.equals("Meter")) {
                return num /= 1000;
            } else if (unitOut.equals("Centimeter")) {
                return num /= 10;
            } else if (unitOut.equals("Kilometer")) {
                return num /= 1000000;
            } else if (unitOut.equals("Meilen")) {
                return num /= 1.609e+6;
            } else if (unitOut.equals("Fuß")) {
                return num /= 305 ;
            } else if (unitOut.equals("Inch")) {
                return num /= 25.4;
            } else
                return num;

        }// Mile
        else if (unitIn.equals("Meilen")) {
            if (unitOut.equals("Meter")) {
                return num *= 1609;
            } else if (unitOut.equals("Centimeter")) {
                return num *= 160934;
            } else if (unitOut.equals("Milimeter")) {
                return num *= 1.609e+6;
            } else if (unitOut.equals("Kilometer")) {
                return num *= 1.609;
            } else if (unitOut.equals("Fuß")) {
                return num *= 5280;
            } else if (unitOut.equals("Inch")) {
                return num *= 63360;
            } else
                return num;

        }// Feet
        else if (unitIn.equals("Fuß")) {
            if (unitOut.equals("Meter")) {
                return num /= 3.281;
            } else if (unitOut.equals("Centimeter")) {
                return num *= 30.48;
            } else if (unitOut.equals("Milimeter")) {
                return num *= 305;
            } else if (unitOut.equals("Meilen")) {
                return num /= 5280;
            } else if (unitOut.equals("Kilometer")) {
                return num /= 3281;
            } else if (unitOut.equals("Inch")) {
                return num *= 12;
            } else
                return num;

        }//Inch
        else if (unitIn.equals("Inch")) {
            if (unitOut.equals("Meter")) {
                return num /= 39.37;
            } else if (unitOut.equals("Centimeter")) {
                return num *= 2.54;
            } else if (unitOut.equals("Milimeter")) {
                return num *= 25.4;
            } else if (unitOut.equals("Meilen")) {
                return num /= 63360;
            } else if (unitOut.equals("Fuß")) {
                return num /= 12;
            } else if (unitOut.equals("Inch")) {
                return num *= 1;
            } else
                return num;
        }
        //Temp

        //Celsius
        else if (unitIn.equals("Celsius")) {
            if (unitOut.equals("Fahrenheit")) {
                return num = (num * 9/5) + 32;
            }
            else if (unitOut.equals("Kelvin")) {
                return num += 273.15;
            }
        }
        //Fahrenheit
        else if (unitIn.equals("Fahrenheit")){
            if (unitOut.equals("Celsius")){
                return num = (num - 32) * 5/9;
            }
            else if (unitOut.equals("Kelvin")){
                return num = (num - 32) * 5/9 + 273.15;
            }
        }
        //Kelvin
        else if (unitIn.equals("Kelvin")){
            if (unitOut.equals("Celsius")){
                return num-= 273.15;
            }
            else if (unitOut.equals("Fahrenheit")){
                return num = (num - 273.15) * 9/5 + 32;
            }
        }
        //Weight

        //Tonne
        else if (unitIn.equals("Tonne")) {
            if (unitOut.equals("Kilogramm")) {
                return num *= 1000;
            }
            else if (unitOut.equals("gramm")){
                return num *= 1000000;
            }
            else if (unitOut.equals("Ton (us)")){
                return num *= 1.102;
            }
            else if (unitOut.equals("Pounds")){
                return num *= 2205;
            }
        }
        //Kilogramm
        else if (unitIn.equals("Kilogramm")){
            if (unitOut.equals("Tonne")){
                return num /= 1000;
            }
            else if (unitOut.equals("gramm")){
                return num *= 1000;
            }
            else if (unitOut.equals("Ton (us)")){
                return num /= 907;
            }
            else if (unitOut.equals("Pounds")){
                return num *= 2.205;
            }
        }
        //Gramm
        else if (unitIn.equals("gramm")){
            if(unitOut.equals("Tonne")){
                return num /= 1000000;
            }
            else if (unitOut.equals("Kilogramm")){
                return num /= 1000;
            }
            else if (unitOut.equals("Ton (us)")){
                return num /=  907185;
            }
            else if (unitOut.equals("Pounds")){
                return num /= 454;
            }
        }
        //Ton (us)
        else if (unitIn.equals("Ton (us)")){
            if(unitOut.equals("Tonne")){
                return num /= 1.102;
            }
            else if (unitOut.equals("Kilogramm")){
                return num *= 907;
            }
            else if (unitOut.equals("gramm")){
                return num *= 907185;
            }
            else if (unitOut.equals("Pounds")){
                return num *= 2000;
            }
        }
        //Pounds
        else if (unitIn.equals("Pounds")){
            if(unitOut.equals("Tonne")){
                return num /= 2205;
            }
            else if (unitOut.equals("Kilogramm")){
                return num /= 2.205;
            }
            else if (unitOut.equals("Ton (us)")){
                return num /= 2000;
            }
            else if (unitOut.equals("gramm")){
                return num *= 454;
            }
        }
        return num;
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
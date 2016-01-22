package com.example.sandy.popesimulator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.BigInteger;


public class MainActivity extends AppCompatActivity {
    //Using big decimal because Java is incompetent of adding simple decimals
    //Important numbers
    private BigDecimal money = new BigDecimal("0");

    private BigDecimal incrementRate = new BigDecimal("0.01");
    private BigDecimal religion = new BigDecimal("0");
    private BigDecimal taxes = new BigDecimal("0");

    private TextView moneyTView;
    private TextView splashTView;

    private Upgrades upgrades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moneyTView = (TextView) findViewById(R.id.moneyText);
        splashTView = (TextView) findViewById(R.id.splashText);

        upgrades = new Upgrades(this);
        setupButtonListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //@Override
    public void makeMoney(View v){
        money = money.add(incrementRate);
        moneyTView.setText("£" + money);
        splashTView.setText(SplashTextMemer.getSplashText());
    }

    public void increaseIncrementRate(BigDecimal integer){
        incrementRate = incrementRate.add(integer);
    }

    public void increaseReligion(BigDecimal integer){
        religion = religion.add(integer);
    }

    public void increaseTaxes(BigDecimal integer){
        taxes = taxes.add(integer);
    }


    //This sucks but there is no other alternative
    public void setupButtonListeners(){
        ImageButton upgBurnHeretics = (ImageButton) findViewById(R.id.upgBurnHeretic);
        ImageButton upgPreach = (ImageButton) findViewById(R.id.upgPreach);
        ImageButton upgSocialMedia = (ImageButton) findViewById(R.id.upgSocialMedia);

        upgBurnHeretics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upgrades.burnHereticsUpgrade();
            }
        });

        upgPreach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upgrades.preachUpgrade();
            }
        });

        upgSocialMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upgrades.socialMediaUpgrade();
            }
        });
    }



}

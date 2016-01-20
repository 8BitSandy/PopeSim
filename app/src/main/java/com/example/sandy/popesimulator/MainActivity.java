package com.example.sandy.popesimulator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {
    //Using big decimal because Java is incompetent of adding simple decimals
    private BigDecimal money = new BigDecimal("0");
    private BigDecimal incrementRate = new BigDecimal("0.01");
    private TextView moneyTView;
    private TextView splashTView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moneyTView = (TextView) findViewById(R.id.moneyText);
        splashTView = (TextView) findViewById(R.id.splashText);
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
}

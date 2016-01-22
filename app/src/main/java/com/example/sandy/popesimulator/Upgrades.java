package com.example.sandy.popesimulator;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

/**
 * Created by Christopher on 21/01/2016.
 */
public class Upgrades {
    private  MainActivity act;

    public Upgrades(MainActivity m){
        this.act = m;
    }

    //upgrades
    public void burnHereticsUpgrade(){
        String religionRaw= (String) ((TextView)act.findViewById(R.id.upgBurnHereticReligion)).getText();
        String incrementRateRaw= (String) ((TextView)act.findViewById(R.id.upgBurnHereticPrayRate)).getText();
        String taxesRaw= (String) ((TextView)act.findViewById(R.id.upgBurnHereticSalary)).getText();

        increaseRates(religionRaw, incrementRateRaw, taxesRaw);
    }

    public void preachUpgrade(){
        String religionRaw= (String) ((TextView)act.findViewById(R.id.upgPreachReligion)).getText();
        String incrementRateRaw= (String) ((TextView)act.findViewById(R.id.upgPreachPrayRate)).getText();
        String taxesRaw= (String) ((TextView)act.findViewById(R.id.upgPreachSalary)).getText();

        increaseRates(religionRaw, incrementRateRaw, taxesRaw);
    }

    public void socialMediaUpgrade(){
        String religionRaw= (String) ((TextView)act.findViewById(R.id.upgSocialMediaReligion)).getText();
        String incrementRateRaw= (String) ((TextView)act.findViewById(R.id.upgSocialMediaPrayrate)).getText();
        String taxesRaw= (String) ((TextView)act.findViewById(R.id.upgSocialMediaSalary)).getText();

        increaseRates(religionRaw, incrementRateRaw, taxesRaw);
    }




    //Shortcut functions
    private void increaseRates(String r, String p, String t){
        BigDecimal religion = new BigDecimal(r.substring(r.lastIndexOf("+") + 1));;
        BigDecimal incrementRate = new BigDecimal(p.substring(p.lastIndexOf("£") + 1));;
        BigDecimal taxes = new BigDecimal(t.substring(t.lastIndexOf("£") + 1));;

        act.increaseReligion(religion);
        act.increaseIncrementRate(incrementRate);
        act.increaseTaxes(taxes);
    }
}

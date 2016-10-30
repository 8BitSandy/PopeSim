package com.example.sandy.popesimulator;

/**
 * Created by Christopher on 20/01/2016.
 */
public class SplashTextMemer {
    private static String[] memes = {"Moses is bae - Hebrews the best coffee","Are you Abel to pray?","Prayz 4 Dayz","So broke call me St. Nickeless","Hoping for a good poping", "To the pope-mobile!", "Get busy prayin, or get busy dieing","These nuns ain't loyal","#GodRapedMary","Marry had a little bam!", "Pope's gf? A bird of pray"};

    public static String getSplashText(){
        int random = (int) Math.round(Math.random()* (memes.length-1));

        return memes[random];
    }
}

package com.and.game;

import android.app.Activity;
import android.os.Bundle;

public class andActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("hossam");
        setContentView(R.layout.main);
    }
}
package com.example.yashnanavati.trial_1;

/**
 * Created by Yash Nanavati on 4/8/2017.
 */

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class NextActivity extends Activity {

    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.next_activity);
        tv1 = (TextView) findViewById(R.id.textView1);
    }
}

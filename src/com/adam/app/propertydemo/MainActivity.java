/**
 * ===========================================================================
 * Copyright Adam Sample code
 * All Rights Reserved
 * ===========================================================================
 * 
 * File Name: MainActivity.java
 * Brief: 
 * 
 * Author: AdamChen
 * Create Date: 2018/6/20
 */

package com.adam.app.propertydemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Properties;

public class MainActivity extends Activity {
    
    //Text view
    private TextView mShowInfo;
    
    //Edit view
    private EditText mEditInfo;
    

    private Properties mProp;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mShowInfo = (TextView)this.findViewById(R.id.show);
        mEditInfo = (EditText)this.findViewById(R.id.edit);
        
        //load property
        this.mProp = Utils.loadConfig(this.getApplicationContext());
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Hide soft keyboard
      View v = this.getCurrentFocus();
      
      if (v != null) {
          InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
          imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
      }
      
        return true;
    }

    /**
     * 
     * <h1>onReadProp</h1>
     *      This method is called when the button is pressed.
     * @param v
     * @return void
     *
     */
    public void onReadProp(View v) {
        Utils.Info(this, "onReadProp enter");
        //Get property
        String str = this.mProp.getProperty(Utils.KEY_DEMO, "Deafult string");
        Utils.Info(this, "The text: " + str);
        
        this.mShowInfo.setText(str);
    }
    
    /**
     * 
     * <h1>onWriteProp</h1>
     *      This method is called when the button is pressed.
     * @param v
     * @return void
     *
     */
    public void onWriteProp(View v) {
        Utils.Info(this, "onWriteProp enter");
        

        String info = this.mEditInfo.getText().toString();
        
        Utils.Info(this, "The info: " + info);
        
        //Set property
        this.mProp.setProperty(Utils.KEY_DEMO, info);
        Utils.saveConfig(this.getApplicationContext(), mProp);
        
        //clear edit view
        this.mEditInfo.setText("");
        
        //Show toast
        Toast.makeText(this, "save property", Toast.LENGTH_SHORT).show();
    }
}

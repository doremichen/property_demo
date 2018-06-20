/**
 * ===========================================================================
 * Copyright Adam Sample code
 * All Rights Reserved
 * ===========================================================================
 * 
 * File Name: Utils.java
 * Brief: 
 * 
 * Author: AdamChen
 * Create Date: 2018/6/20
 */

package com.adam.app.propertydemo;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * <h1>Utils</h1>
 * 
 * @autor AdamChen
 * @since 2018/6/20
 */
public final class Utils {

    private static final String TAG = "Demo";
    
    //Property key
    public static final String KEY_DEMO ="test.Key";
    
    private static Properties sProp = new Properties();
    
    //property file
    private static final String FILE_NAME = "Demo.property";
    
    
    
    /**
     * Prevents this class from being instantiated.
     */
    private Utils() {}
    
    public static void Info(Object obj, String str) {
        Log.i(TAG, "[" + obj.getClass().getSimpleName() + "]" + ": " + str);
    }
    
    public static void Info(Class<?> clazz, String str) {
        Log.i(TAG, "[" + clazz.getSimpleName() + "]" + ": " + str);
    }
    
    /**
     * 
     * <h1>loadConfig</h1>
     *     load property from file
     * @param context TODO
     * @param file
     * @return
     * @return Properties
     *
     */
    public static Properties loadConfig(Context context) {
        FileInputStream input = null;
        try {
            input = context.openFileInput(FILE_NAME);
            sProp.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            
        }
        return sProp;
        
    }
    
    /**
     * 
     * <h1>saveConfig</h1>
     *
     * @param context
     * @param prop
     * @return void
     *
     */
    public static void saveConfig(Context context, Properties prop) {
        
        FileOutputStream out = null;
        
        try {
            out = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            prop.store(out, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            
        }
        
    }

}

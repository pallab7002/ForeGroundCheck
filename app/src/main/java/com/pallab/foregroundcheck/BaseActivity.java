package com.pallab.foregroundcheck;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Admin on 23-05-2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    //isAppInForeGround maintains the state of the app whether the app is in foreground / background.
    public static boolean isAppInForeGround = false;
    //isCurrentActivityInForeGround indicates Current Activity is in Foreground  .
    private static boolean isCurrentActivityInForeGround = false;
    //isChangeInActivityForeGround indicates Activity navigation foreground change i.e. Navigating between different activities.
    private static boolean isChangeInActivityForeGround = false;

    @Override
    protected void onResume() {
        super.onResume();
        if (!isAppInForeGround)
        {
            isAppInForeGround = true;
            isChangeInActivityForeGround = false;
            OnEnterForeGround();
        }
        else
        {
            isChangeInActivityForeGround = true;
        }
        isCurrentActivityInForeGround = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (!isCurrentActivityInForeGround || !isChangeInActivityForeGround)
        {
            OnEnterBackGround();
        }
        isCurrentActivityInForeGround = false;
    }

    private void OnEnterBackGround() {
        isAppInForeGround = false;
        Toast.makeText(getApplicationContext(),"App in Background", Toast.LENGTH_SHORT).show();

        //perform whatever you need to do when app goes to background

    }

    private void OnEnterForeGround() {
        Toast.makeText(getApplicationContext(),"App in ForeGround", Toast.LENGTH_SHORT).show();

        //perform whatever you need to do when app comes from foreground from background
    }
}

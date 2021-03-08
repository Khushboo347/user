package com.example.user;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

/*---------------------------------HOME PAGE-----------------------------------*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener { 
    LinearLayout fee,maintainance,pass,medical,booking,mess,driver;
    DrawerLayout drawerLayout;
    //NavigationView navigationView;
    //private Object ActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        drawerLayout = findViewById(R.id.drawer_layout);
       // navigationView = findViewById(R.id.nav_view);
        
        //ActionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout);
        
        fee = (LinearLayout) findViewById(R.id.fee);
        maintainance = (LinearLayout) findViewById(R.id.maintainance);
        pass = (LinearLayout) findViewById(R.id.pass);
        medical = (LinearLayout) findViewById(R.id.medical);
        booking = (LinearLayout) findViewById(R.id.booking);
        mess = (LinearLayout) findViewById(R.id.mess);
        driver = (LinearLayout) findViewById(R.id.driver);

        fee.setOnClickListener(this);
        maintainance.setOnClickListener(this);
        pass.setOnClickListener(this);
        medical.setOnClickListener(this);
        booking.setOnClickListener(this);
        mess.setOnClickListener(this);
        driver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i ;

        switch (v.getId()) {
            case R.id.fee:
                i = new Intent(this,Fee.class);startActivity(i);break;
            case R.id.maintainance:
                i = new Intent(this,Maintainance.class);startActivity(i);break;
            case R.id.pass:
                i = new Intent(this,Pass.class);startActivity(i);break;
            case R.id.medical:
                i = new Intent(this,Medical.class);startActivity(i);break;
            case R.id.booking:
                i = new Intent(this,Booking.class);startActivity(i);break;
            case R.id.mess:
                i = new Intent(this,Mess.class);startActivity(i);break;
            case R.id.driver:
                i = new Intent(this,Driver.class);startActivity(i);break;
            default:break;
        }

    }
    /*-----------------------------DRAWER FUNCTIONS------------------------------*/
    public void ClickMenu(View view){
        //Open Drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer Layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        //Close drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Closer drawer layout
        //Check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            //when drawer is open
            // closer drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        //Recreate activity
        recreate();
    }

    public void ClickFee(View view){
        //Redirect activity to dashboard
        redirectActivity(this,Fee.class);
    }

    public void ClickMaintainance(View view){
        //Redirect activity to maintainance
        redirectActivity(this,Maintainance.class);
    }

    public void ClickMedical(View view){
        //Redirect activity to medical
        redirectActivity(this,Medical.class);
    }

    public void ClickPass(View view){
        //Redirect activity to pass
        redirectActivity(this,Pass.class);
    }

    public void ClickBooking(View view){
        //Redirect activity to booking
        redirectActivity(this,Booking.class);
    }

    public void ClickMess(View view){
        //Redirect activity to mess
        redirectActivity(this,Mess.class);
    }

    public void ClickDriver(View view){
        //Redirect activity to driver
        redirectActivity(this,Driver.class);
    }


    public void ClickLogout(View view){
        logout(this);
    }

    public static void logout(final Activity activity) {
        //Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //set title
        builder.setTitle("Logout");
        //set message
        builder.setMessage("Are you sure you wanna logout?");
        //Positive yes button
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                //Finish activity
                activity.finishAffinity();
                //Exit app
                //System.exit(0);
                dialog.dismiss();
            }
        });
        //Negative no button
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Dismiss dialog
                dialog.dismiss();
            }
        });
        //Show dialog
        builder.show();
    }

    public static void redirectActivity(Activity activity,Class aClass) {
        //Initialize intent
        Intent intent = new Intent(activity,aClass);
        //set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause(){
        super.onPause();
        //Close drawer
        closeDrawer(drawerLayout);
    }
}

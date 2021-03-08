package com.example.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Medical extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){
        //Open drawer
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        //Close Drawer
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        //Redirect activity to home
        MainActivity.redirectActivity(this, MainActivity.class);
    }

    public void ClickFee(View view){
        //Redirect activity to dashboard
        MainActivity.redirectActivity(this,Fee.class);
    }

    public void ClickMaintainance(View view){
        //Redirect activity to dashboard
        MainActivity.redirectActivity(this,Maintainance.class);
    }

    public void ClickPass(View view){
        //Redirect activity to dashboard
        MainActivity.redirectActivity(this,Pass.class);
    }

    public void ClickBooking(View view){
        //Redirect activity to dashboard
        MainActivity.redirectActivity(this,Booking.class);
    }

    public void ClickMess(View view){
        //Redirect activity to dashboard
        MainActivity.redirectActivity(this,Mess.class);
    }

    public void ClickDriver(View view){
        //Redirect activity to dashboard
        MainActivity.redirectActivity(this,Driver.class);
    }

    public void ClickMedical(View view){
        //Recreate activity
        recreate();

    }

    public void ClickLogout(View view){
        //Close app
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        MainActivity.closeDrawer(drawerLayout);
    }
}

package com.example.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Maintainance extends AppCompatActivity {
    private  static final String[] YEAR = new String[]{
            "1"
    };

    DrawerLayout drawerLayout;
    Button submit;
    TextInputEditText main_query;
    Db DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintainance2);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        submit = (Button) findViewById(R.id.submit);
        main_query= (TextInputEditText) findViewById(R.id.main_query);
        DB = new Db(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = main_query.getText().toString();

                if(query.equals("")) {
                    Toast.makeText(Maintainance.this, "Field is empty", Toast.LENGTH_SHORT).show();
                }
                    Boolean insert = DB.insertData(query);
                if(insert == true){
                    Toast.makeText(Maintainance.this, "Message sent", Toast.LENGTH_SHORT).show();
                }
            }
        });

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

    public void ClickMedical(View view){
        //Redirect activity to dashboard
        MainActivity.redirectActivity(this,Medical.class);
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

    public void ClickMaintainance(View view){
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

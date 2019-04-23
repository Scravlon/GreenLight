package com.scravlon.greenlight;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int MY_PERMISSIONS_REQUEST_COARSE_LOCATION = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*For simplicity, force user number and password as followings*/
        final String loginNumber = "7163333333";
        final String password = "Buffalo1";
        final EditText editnumber = findViewById(R.id.edit_number);
        final EditText editpass = findViewById(R.id.edit_password);
        Button butLogin = findViewById(R.id.but_login);
        requestLocationService();
        butLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernumber = editnumber.getText().toString();
                String userpass = editpass.getText().toString();
                if(usernumber.equals(loginNumber) && userpass.equals(password)){
                    Toast.makeText(MainActivity.this, "Welcome Bryan!", Toast.LENGTH_SHORT).show();
                    changeIntent();
                } else{
                    Toast.makeText(MainActivity.this, "Wrong credential!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    /**
     * Request the location service from the user, required Android a6.0 and higher
     *
     * Reference: https://developer.android.com/training/permissions/requesting
     */
    private void requestLocationService() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_REQUEST_COARSE_LOCATION);
            }
        } else {
        }

    }

    /**
     * Handle the Location request
     * @param requestCode: Code of request
     * @param permissions: permission
     * @param grantResults: result
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_COARSE_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                }
                return;
            }
        }
    }


    /**
     * Update the activity to the sub Main activity
     */
    private void changeIntent(){
        Intent intent = new Intent(this,subMainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

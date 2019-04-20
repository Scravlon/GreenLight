package com.scravlon.greenlight;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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

        butLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernumber = editnumber.getText().toString();
                String userpass = editpass.getText().toString();
                if(usernumber.equals(loginNumber) && userpass.equals(password)){
                    changeIntent();
                } else{
                    Toast.makeText(MainActivity.this, "Wrong credential!", Toast.LENGTH_SHORT).show();
                }

            }
        });

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

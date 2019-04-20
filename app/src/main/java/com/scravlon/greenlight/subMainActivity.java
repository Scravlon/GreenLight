package com.scravlon.greenlight;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;

public class subMainActivity extends FragmentActivity implements homeFragment.OnFragmentInteractionListener, qrFragment.OnFragmentInteractionListener, locationFragment.OnFragmentInteractionListener
, educationFragment.OnFragmentInteractionListener, moneyFragment.OnFragmentInteractionListener {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        Fragment fragment = null;
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new homeFragment();
                    break;
                case R.id.navigation_money:
                    fragment = new moneyFragment();
                    break;
                case R.id.navigation_qr:
                    fragment = new qrFragment();
                    break;
                case R.id.navigation_location:
                    fragment = new locationFragment();

                    break;
                case R.id.navigation_education:
                    fragment = new educationFragment();
                    break;


            }

            return loadFragment(fragment);
        }
    };

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_main);

        loadFragment(new homeFragment());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}

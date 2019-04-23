package com.scravlon.greenlight;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link locationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link locationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class locationFragment extends Fragment implements OnMapReadyCallback {
    private static final String MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey";
    private MapView mapView;
    private GoogleMap gmap;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public locationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter a1.
     * @param param2 Parameter a2.
     * @return A new instance of fragment locationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static locationFragment newInstance(String param1, String param2) {
        locationFragment fragment = new locationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_location, container, false);
        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
        }

        mapView = (MapView) v.findViewById(R.id.mapView);
        mapView.onCreate(mapViewBundle);
        mapView.getMapAsync(this);
        // Inflate the layout for this fragment
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gmap = googleMap;
        gmap.setMinZoomPreference(10);
        LatLng ny = new LatLng(42.8919625, -78.8654158);
        gmap.moveCamera(CameraUpdateFactory.newLatLng(ny));

        //Moura New York Style Deli
        LatLng firstMachine = new LatLng(42.980843, -78.8089263);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(firstMachine);
        gmap.addMarker(markerOptions);
        //Mayor office
        LatLng secondMachine = new LatLng(42.89527210009785, -78.84615787538661);
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.position(secondMachine);
        markerOptions2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        gmap.addMarker(markerOptions2);
        //Greyhound Bus Station
        LatLng secondMachine1 = new LatLng(42.883241, -78.872147);
        MarkerOptions markerOptions21 = new MarkerOptions();
        markerOptions21.position(secondMachine1);
        gmap.addMarker(markerOptions21);
        //Buffalo Niagara International Airport
        LatLng secondMachine2 = new LatLng(42.934401, -78.731873);
        MarkerOptions markerOptions22 = new MarkerOptions();
        markerOptions22.position(secondMachine2);
        gmap.addMarker(markerOptions22);
        //42.934401, -78.731873

        //Abbott Road Plaza
        //42.886074, -78.874728
        LatLng secondAbbot = new LatLng(42.831360, -78.805505);
        MarkerOptions secondAbbotMarker = new MarkerOptions();
        secondAbbotMarker.position(secondAbbot);
        gmap.addMarker(secondAbbotMarker);

        LatLng sec12 = new LatLng(42.886074, -78.874728);
        MarkerOptions mko2 = new MarkerOptions();
        mko2.position(sec12);
        mko2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        gmap.addMarker(mko2);

        LatLng as1 = new LatLng(42.901436, -78.868948);
        MarkerOptions sa1 = new MarkerOptions();
        sa1.position(as1);
        gmap.addMarker(sa1);

        LatLng sec122 = new LatLng(42.892527, -78.837772);
        MarkerOptions mko22 = new MarkerOptions();
        mko22.position(sec122);
        mko22.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        gmap.addMarker(mko22);


    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}

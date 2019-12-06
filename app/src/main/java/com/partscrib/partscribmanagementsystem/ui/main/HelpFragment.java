package com.partscrib.partscribmanagementsystem.ui.main;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.partscrib.partscribmanagementsystem.R;

public class HelpFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap mMap;
    MapView mMapView;



    private HelpViewModel mViewModel;

    public static HelpFragment newInstance() {
        return new HelpFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.help_fragment, container, false);
        mViewModel = ViewModelProviders.of(this).get(HelpViewModel.class);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);


        SupportMapFragment mapFragment = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.mapView);
        if (mapFragment !=null){
            mapFragment.onCreate(null);
            mapFragment.onResume();
            mapFragment.getMapAsync(this);

        }


    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());

        mMap = googleMap;

        LatLng Humber = new LatLng(43.724330436, -79.605497578);
        mMap.addMarker(new MarkerOptions()
                .position(Humber)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.humber))
                .title("Welcome to Humber College"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Humber, (float) 6.0));
        mMap.setMinZoomPreference(2.0f);
        mMap.setMaxZoomPreference(30.0f);
        mMap.setTrafficEnabled(true);
    }

}

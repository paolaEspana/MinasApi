package com.example.paola.minasapi;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{
    private GoogleMap mMap;
    private Marker miPunto;
    private LatLng punto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public LatLng getPunto() {
        return punto;
    }

    public void setPunto(LatLng punto) {
        this.punto = punto;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        double longitud = (Double) getIntent().getExtras().getDouble("longitud");
        double latitud = (Double) getIntent().getExtras().getDouble("latitud");
        String nombre = (String) getIntent().getExtras().getString("ubicacion");
        LatLng punto = new LatLng(latitud,longitud);

        mMap = googleMap;

        miPunto = mMap.addMarker(new MarkerOptions()
                .position(punto)
                .title("Mina en: "+nombre)

        .draggable(true)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        //zoom
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(punto, 13);
        googleMap.animateCamera(cameraUpdate);

        miPunto.showInfoWindow();

        miPunto.setTag(0);
    }

}

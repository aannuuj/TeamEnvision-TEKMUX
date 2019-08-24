package org.envision.trash_it;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;

public class Trash extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {


    public static Trash newInstance() {

        return new Trash();
    }


    MapView mapView;
    GoogleMap gmap;

    DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trash, container, false);
        mapView = (MapView) view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);



        return view;
    }


    @Override
    public boolean onMarkerClick(final Marker marker)
    {

        new BottomDialog.Builder(getContext())
                .setTitle("Click the Button for Bin's details !")
                .setContent(marker.getTitle())
                .setPositiveText("DETAILS")
                .setPositiveBackgroundColorResource(R.color.colorPrimary)
                //.setPositiveBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary)
                .setPositiveTextColorResource(android.R.color.white)
                //.setPositiveTextColor(ContextCompat.getColor(this, android.R.color.colorPrimary)
                .onPositive(new BottomDialog.ButtonCallback() {
                    @Override
                    public void onClick(BottomDialog dialog) {

                        Intent intent=new Intent(getActivity(),BinActivity.class);
                        intent.putExtra("Location",marker.getTitle());
                        startActivity(intent);
                    }
                }).show();

        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gmap = googleMap;

        if(checkAccessCoarseLocationPermission() || checkAccessFineLocationPermission())
            gmap.setMyLocationEnabled(true);
        gmap.getUiSettings().setMyLocationButtonEnabled(true);


        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(12.823105,80.0430913))      // Sets the center of the map to Mountain View
                .zoom(17f)                   // Sets the zoom
                .bearing(80)                // Sets the orientation of the camera to east
                .tilt(70)                   // Sets the tilt of the camera to 30 degrees
                .build();

        gmap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));




        addCustomMarkers();



    }


    void addCustomMarkers()
    {
        if (gmap == null) {
            return;
        }
        gmap.addMarker(new MarkerOptions()
                .position(new LatLng(12.8247121,80.0448488))
                .title("Tech Park"));

        gmap.addMarker(new MarkerOptions()
                .position(new LatLng(12.824779, 80.046642))
                .title("TP Ganeshan Auditorium")
        );
        gmap.addMarker(new MarkerOptions()
                .position(new LatLng(12.823192, 80.044569))
                .title("Java")
        );
        gmap.setOnMarkerClickListener(this);
    }

    private boolean checkAccessCoarseLocationPermission()
    {
        String permission = android.Manifest.permission.ACCESS_COARSE_LOCATION;
        int res = getContext().checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }
    private boolean checkAccessFineLocationPermission()
    {
        String permission = android.Manifest.permission.ACCESS_FINE_LOCATION;
        int res = getContext().checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume()
    {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

}


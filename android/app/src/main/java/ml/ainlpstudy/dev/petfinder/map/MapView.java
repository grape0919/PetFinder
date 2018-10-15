package ml.ainlpstudy.dev.petfinder.map;

import android.content.Context;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapView extends com.google.android.gms.maps.MapView implements OnMapReadyCallback {
    public MapView(Context context) {
        super(context);
    }

    /*public MapView(Activity ac) {
        super(ac);
    }*/

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng SEOUL = new LatLng(37.56, 126.97);

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 15));

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        markerOptions.snippet("한국의 수도");
        googleMap.addMarker(markerOptions);
    }
}

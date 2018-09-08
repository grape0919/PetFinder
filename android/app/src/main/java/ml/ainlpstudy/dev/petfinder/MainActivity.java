package ml.ainlpstudy.dev.petfinder;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private BluetoothHelper btService = null;
    private static final int REQUEST_CONNECT_DEVICE = 5;
    private static final int REQUEST_ENABLE_BT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btService = new BluetoothHelper(this);

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(final GoogleMap map) {

        LatLng SEOUL = new LatLng(37.56, 126.97);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        markerOptions.snippet("한국의 수도");
        map.addMarker(markerOptions);

        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(10));
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CONNECT_DEVICE:
                Toast.makeText(this.getApplicationContext(), "블루투스 연결", Toast.LENGTH_LONG);
                if (resultCode == Activity.RESULT_OK) {
                    btService.getDeviceInfo(data);
                }
                break;
            case REQUEST_ENABLE_BT:
                Toast.makeText(this.getApplicationContext(), "블루투스 검사", Toast.LENGTH_LONG);
                if (resultCode == Activity.RESULT_OK) {
                    Toast.makeText(this.getApplicationContext(), "블루투스 켜짐", Toast.LENGTH_LONG);
                    btService.scanDevice();
                } else {
                    Toast.makeText(this.getApplicationContext(), "블루투스 꺼짐", Toast.LENGTH_LONG);
                }
                break;
        }
    }
}

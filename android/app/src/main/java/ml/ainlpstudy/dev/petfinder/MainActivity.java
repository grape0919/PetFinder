package ml.ainlpstudy.dev.petfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.MapFragment;

import ml.ainlpstudy.dev.petfinder.heart.HeartView;
import ml.ainlpstudy.dev.petfinder.map.MapView;

public class MainActivity extends AppCompatActivity{

    private BluetoothHelper btService = null;
    private static final int REQUEST_CONNECT_DEVICE = 5;
    private static final int REQUEST_ENABLE_BT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btService = new BluetoothHelper(this);

        MapView mapview;
        mapview = new MapView(this);
        MapFragment mapFragment = (MapFragment)getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(mapview);


        HeartView heartView ;
        heartView = (HeartView) findViewById(R.id.heart_view);
        heartView.init();
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

package com.example.moqtt;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.BreakIterator;
import java.util.Properties;

import io.moquette.BrokerConstants;
import io.moquette.server.config.MemoryConfig;

public class MainActivity extends AppCompatActivity {
    private static  io.moquette.server.Server server = new io.moquette.server.Server();
    private String TAG;
    private int serverStartedOrStoped;
    static String Uri = "tcp://192.168.0.106:1883";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "Server Started", Toast.LENGTH_LONG).show();
        io.moquette.server.Server server = new io.moquette.server.Server();
        try {
            MemoryConfig memoryConfig = new MemoryConfig(new Properties());
            memoryConfig.setProperty(BrokerConstants.PERSISTENT_STORE_PROPERTY_NAME, Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator + BrokerConstants.DEFAULT_MOQUETTE_STORE_MAP_DB_FILENAME);
            server.startServer(memoryConfig);
            server = new io.moquette.server.Server();
            server.startServer();
    //        url.setText(Uri);
            Toast.makeText(MainActivity.this, "Server Started", Toast.LENGTH_LONG).show();
            Log.d(TAG,"Server Started");
        }
        catch (IOException e) { e.printStackTrace(); }
        catch (Exception e){ e.printStackTrace();
        }
    }
}

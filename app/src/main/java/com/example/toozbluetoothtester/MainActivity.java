package com.example.toozbluetoothtester;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import tooz.bto.toozifier.Toozifier;
import tooz.bto.toozifier.ToozifierFactory;
import tooz.bto.toozifier.error.ErrorCause;
import tooz.bto.toozifier.registration.RegistrationListener;

public class MainActivity extends AppCompatActivity {
    Toozifier toozifier = ToozifierFactory.getInstance();

    private RegistrationListener registrationListener = new RegistrationListener() {
        @Override
        public void onRegisterSuccess() {
            Log.w("Tooz", "Successful Register");
            ((TextView) findViewById(R.id.connect_to_tooz_button)).setText("Connected!");

        }

        @Override
        public void onRegisterFailure(@NonNull ErrorCause errorCause) {
            Log.w("Tooz", "Failed to register. Error string: " + errorCause.toString());
        }

        @Override
        public void onDeregisterSuccess() {
            Log.w("Tooz", "Successful Deregister");
            ((TextView) findViewById(R.id.connect_to_tooz_button)).setText("Connect to Tooz!");
        }

        @Override
        public void onDeregisterFailure(@NonNull ErrorCause errorCause) {
            Log.w("Tooz", "Failed Deregister");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button connectButton = findViewById(R.id.connect_to_tooz_button);
        final Button sendFrameOneButton = findViewById(R.id.btn_send_frame_1);
        final Button sendFrameTwoButton = findViewById(R.id.btn_send_frame_2);
        final Button sendFrameThreeButton = findViewById(R.id.btn_send_frame_3);
        final Button sendFrameFourButton = findViewById(R.id.btn_send_frame_4);
        final Button sendFrameFiveButton = findViewById(R.id.btn_send_frame_5);
        final Button customBluetoothButton = findViewById(R.id.btn_custom_bluetooth);

        Bitmap frameOne = Bitmap.createBitmap(400, 640, Bitmap.Config.ARGB_8888);
        Canvas frameOneCanvas = new Canvas(frameOne);
        frameOneCanvas.drawColor(Color.rgb(255, 255, 255));


        Bitmap frameTwo = Bitmap.createBitmap(400, 640, Bitmap.Config.ARGB_8888);
        Canvas frameTwoCanvas = new Canvas(frameTwo);
        frameTwoCanvas.drawColor(Color.rgb(255, 0, 0));


        Bitmap frameThree = Bitmap.createBitmap(400, 640, Bitmap.Config.ARGB_8888);
        Canvas frameThreeCanvas = new Canvas(frameThree);
        frameThreeCanvas.drawColor(Color.rgb(255, 0, 0));


        Bitmap frameFour = Bitmap.createBitmap(400, 640, Bitmap.Config.ARGB_8888);
        Canvas frameFourCanvas = new Canvas(frameFour);
        frameFourCanvas.drawColor(Color.rgb(0, 0, 255));


        Bitmap frameFive = Bitmap.createBitmap(400, 640, Bitmap.Config.ARGB_8888);
        Canvas frameFiveCanvas = new Canvas(frameFive);
        frameFiveCanvas.drawColor(Color.rgb(255, 255, 255));
        frameFive.setPixel(1, 0, Color.rgb(255, 0, 0));




        connectButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //On pressing button, try to connect to Tooz.
                if(!toozifier.isRegistered()) {
                    toozifier.register(getApplicationContext(), "Tooz Bluetooth Tester", registrationListener);
                }
            }
        });
        sendFrameOneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(toozifier.isRegistered()) {
                    toozifier.sendFrame(frameOne, 1000);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                    String currentDateandTime = sdf.format(new Date());
                    Log.w("Time Frame 1 (All White) Was Sent: ", currentDateandTime);
                }
            }
        });
        sendFrameTwoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(toozifier.isRegistered()) {
                    toozifier.sendFrame(frameTwo, 1000);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                    String currentDateandTime = sdf.format(new Date());
                    Log.w("Time Frame 2 (All Red) Was Sent: ", currentDateandTime);
                }
            }
        });
        sendFrameThreeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(toozifier.isRegistered()) {
                    toozifier.sendFrame(frameThree, 1000);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                    String currentDateandTime = sdf.format(new Date());
                    Log.w("Time Frame 3 Was Sent: ", currentDateandTime);
                }
            }
        });
        sendFrameFourButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(toozifier.isRegistered()) {
                    toozifier.sendFrame(frameFour, 2000);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                    String currentDateandTime = sdf.format(new Date());
                    Log.w("Time Frame 4 Was Sent: ", currentDateandTime);
                }
            }
        });
        sendFrameFiveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(toozifier.isRegistered()) {
                    toozifier.sendFrame(frameFive, 1000);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                    String currentDateandTime = sdf.format(new Date());
                    Log.w("Time Frame 5 Was Sent: ", currentDateandTime);
                }
            }
        });
        customBluetoothButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HackBluetoothPacketsActivity.class);
                startActivity(intent);

            }
        });
    }
}
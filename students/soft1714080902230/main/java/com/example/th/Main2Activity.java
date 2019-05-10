package com.example.th;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;


public class Main2Activity extends AppCompatActivity {




    private SensorManager mSensorManager;
    private Sensor mSensor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final MyImageView image = (MyImageView) findViewById(R.id.zz_view);
        Button button_save = (Button) findViewById(R.id.button_save);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Matrix max = new Matrix();
             image.setDrawingCacheEnabled(true);
             final Bitmap bmp =((BitmapDrawable) ((MyImageView)image).getDrawable()).getBitmap();
             imageE.saveImage(bmp);
            }});






///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensorManager.registerListener(listener, mSensor, SensorManager.SENSOR_DELAY_NORMAL);



        Button button_get = (Button) findViewById(R.id.button_load);
        button_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageURL("https://raw.githubusercontent.com/alicekagiyama/png-from-pixiv/master/zz_p"+new Random().nextInt(6) +".png");
            }
        });









        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

        @Override
        protected void onDestroy() {
        if (mSensorManager != null) { mSensorManager.unregisterListener(listener); }super.onDestroy(); }

        private SensorEventListener listener = new SensorEventListener()
        {
             public void onSensorChanged(SensorEvent event)
            {
             if (event.sensor.getType() == Sensor.TYPE_LIGHT)
            { changeWindowBrightness((int)event.values[0]); }
            }
            public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        };


    public void changeWindowBrightness(int brightness) {
    Window window = this.getWindow();
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    if (brightness == -1)
         { layoutParams.screenBrightness = WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE; }
    else
         { layoutParams.screenBrightness = (brightness <= 0 ? 1 : brightness) / 255f; }
    window.setAttributes(layoutParams); }


}

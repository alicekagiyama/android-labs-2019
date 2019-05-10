package com.example.th;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class imageE {



    public static void saveImage(Bitmap bmp) {
        File appDir  = new File(Environment.getExternalStorageDirectory(), "/DCIM/Camera/");
        if (!appDir.exists()) {
         appDir.mkdir();
        }
        String fileName = System.currentTimeMillis()+ ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

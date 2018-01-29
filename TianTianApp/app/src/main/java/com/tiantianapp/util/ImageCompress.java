package com.tiantianapp.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.util.Log;

import com.tiantianapp.app.App;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2018/1/6 0006.
 */

public class ImageCompress {
    public  static String compress(String srcPath) {
        int sizeKB=100;  // 最大 600kB
        float hh =  720;
        float ww = 480;
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, opts);
        opts.inJustDecodeBounds = false;
        int w = opts.outWidth;
        int h = opts.outHeight;
        int size = 0;
        if (w <= ww && h <= hh) {
            size = 1;
        } else {
            double scale = w >= h ? w / ww : h / hh;
            double log = Math.log(scale) / Math.log(2);
            double logCeil = Math.ceil(log);
            size = 2;
        }
        opts.inSampleSize = size;

        bitmap = BitmapFactory.decodeFile(srcPath, opts);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {

            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);
            Log.d("cachecachecache",bitmap+"\n"+quality+"\n"+baos);
            System.out.println("CompressFormat"+baos.toByteArray().length);
            while (baos.toByteArray().length > sizeKB * 1024) {
                baos.reset();
                quality -= 20;
                bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);

                System.out.println(baos.toByteArray().length);
            }
            File file=new File(App.getInstanse().getCacheDir(),System.currentTimeMillis()+".jpg") ;
            baos.writeTo(new FileOutputStream( file ));
            return file.getCanonicalPath();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                baos.flush();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 读取照片exif信息中的旋转角度
     *
     * @param path 照片路径
     * @return角度
     */
    public static int readPictureDegree(String path) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }
}

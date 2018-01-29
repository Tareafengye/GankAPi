package com.tiantianapp.util;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import com.tiantianapp.app.App;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Administrator on 2018/1/6 0006.
 */

public class PhotoUtil {

    public static String getCment(Intent data) {
        String urlName = "";
        String picture_name;
        String fileName;
        picture_name = android.text.format.DateFormat.format(
                "yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA))
                + ".jpg";
        Bundle bundle = data.getExtras();
        Bitmap bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式
        File file = new File("/sdcard/Image/");
        file.mkdirs();// 创建文件夹io
        fileName = "/sdcard/Image/" + picture_name;
        FileOutputStream b = null;
        try {
            if (b == null) {
                b = new FileOutputStream(fileName);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
                File file1Nmae = new File(ImageCompress.compress(fileName));
                Uri uri = Uri.fromFile(file1Nmae);
                urlName = Utils.getRealFilePath(App.getInstanse(), uri);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return urlName;
    }

}

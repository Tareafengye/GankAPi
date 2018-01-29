package com.tiantianapp.activity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.baoyz.actionsheet.ActionSheet;
import com.tiantianapp.R;
import com.tiantianapp.base.BaseActivity;
import com.tiantianapp.itface.PermissionCallBack;
import com.tiantianapp.photo.activity.PhotoPickerActivity;
import com.tiantianapp.rxjava.BasicResponse;
import com.tiantianapp.rxjava.DefaultObserver;
import com.tiantianapp.rxjava.IdeaApi;
import com.tiantianapp.util.ByAlert;
import com.tiantianapp.util.ImageCompress;
import com.tiantianapp.util.LogUtil;
import com.tiantianapp.util.PhotoUtil;
import com.tiantianapp.util.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class PressImaActivity extends BaseActivity {
    // 使用相机拍照
    private static final int CAPTURE_CODE = 110;
    private static final int PICK_PHOTO = 1;
    int selectedMode = 0;//0单选1多选
    private String filePostName = null;
    private Button btn_add_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_press_ima);
        setBarColor(this, 112);
        takePic();
    }

    /**
     * 打开相机权限
     */
    private void takePic() {
        String[] perms = {Manifest.permission.CAMERA};
        baseRequestPermission(perms, new PermissionCallBack() {

            @Override
            public void permGrant(String[] permsGranted) {
                Toast.makeText(PressImaActivity.this, "已授权", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void permDeny(String[] permsDenied) {
                Toast.makeText(PressImaActivity.this, "未授权", Toast.LENGTH_SHORT).show();
            }
        }, "调用拍照功能需要获取权限，是否跳转权限设置？");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_image:
                getActionSheet();
                break;
        }
    }

    /**
     *
     */
    public void getActionSheet() {
        ActionSheet.createBuilder(PressImaActivity.this, getSupportFragmentManager())
                .setCancelButtonTitle("取消")
                .setOtherButtonTitles("打开相册", "拍照")
                .setCancelableOnTouchOutside(true)
                .setListener(new ActionSheet.ActionSheetListener() {
                    @Override
                    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {
                    }

                    @Override
                    public void onOtherButtonClick(ActionSheet actionSheet, int index) {
                        if (index == 1) {
                            String sdStatus = Environment.getExternalStorageState();
                            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
                                return;
                            }
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// 启动系统相机
                            startActivityForResult(intent, CAPTURE_CODE);
                        } else {
                            if (index == 0) {
                                Intent intent = new Intent(PressImaActivity.this, PhotoPickerActivity.class);
                                intent.putExtra(PhotoPickerActivity.EXTRA_SHOW_CAMERA, false);//显示相机
                                intent.putExtra(PhotoPickerActivity.EXTRA_SELECT_MODE, selectedMode);
                                intent.putExtra(PhotoPickerActivity.EXTRA_MAX_MUN, 0);//选择图片张数
                                startActivityForResult(intent, PICK_PHOTO);
                            }
                        }
                    }
                })
                .show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURE_CODE && resultCode == RESULT_OK) { // 如果返回数据
            LogUtil.d("utilsName:\t" + PhotoUtil.getCment(data));
            filePostName = PhotoUtil.getCment(data);
        }
        if (requestCode == PICK_PHOTO && resultCode == RESULT_OK) {
            ArrayList<String> result = data.getStringArrayListExtra(PhotoPickerActivity.KEY_RESULT);
            String file_result = result.get(0).toString();
            File file1Nmae = new File(ImageCompress.compress(file_result));
            Uri uri = Uri.fromFile(file1Nmae);
            filePostName = Utils.getRealFilePath(PressImaActivity.this, uri);
        }
    }

}

package com.tiantianapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tiantianapp.R;
import com.tiantianapp.base.BaseActivity;
import com.tiantianapp.calculator.Add;
import com.tiantianapp.calculator.Delete;
import com.tiantianapp.calculator.Div;
import com.tiantianapp.calculator.Mulitply;
import com.tiantianapp.itface.Calculate;

public class CalculatorActivity extends BaseActivity {
    private float x, y;
    private String text = "";
    private int tagremeber = 0;
    private EditText ed_idcar;
    private boolean eqstatus = false;
    private boolean zestatus = false;
    private int count = 0;
    private Calculate cl;
    private Button c_0;
    private Button c_1;
    private Button c_2;
    private Button c_3;
    private Button c_4;
    private Button c_5;
    private Button c_6;
    private Button c_7;
    private Button c_8;
    private Button c_9;
    private Button c_point;
    private Button c_add;
    private Button c_delete;
    private Button c_X, c_div, c_equal, c_c, c_xx, c_ce, c_aord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        init();

    }

    public void init() {
        //其中1-10为数字  11-20位运算符
        c_0.setTag(20);
        c_1.setTag(1);
        c_2.setTag(2);
        c_3.setTag(3);
        c_4.setTag(4);
        c_5.setTag(5);
        c_6.setTag(6);
        c_7.setTag(7);
        c_8.setTag(8);
        c_9.setTag(9);
        c_add.setTag(10);
        c_delete.setTag(11);
        c_X.setTag(12);
        c_div.setTag(13);
        c_c.setTag(14);
        c_xx.setTag(15);
        c_ce.setTag(16);
        c_aord.setTag(17);
        c_equal.setTag(18);
        c_point.setTag(19);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.c_0:
                getOnClick(view);
                break;
            case R.id.c_1:
                getOnClick(view);
                break;
            case R.id.c_2:
                getOnClick(view);
                break;
            case R.id.c_3:
                getOnClick(view);
                break;
            case R.id.c_4:
                getOnClick(view);
                break;
            case R.id.c_5:
                getOnClick(view);
                break;
            case R.id.c_6:
                getOnClick(view);
                break;
            case R.id.c_7:
                getOnClick(view);
                break;
            case R.id.c_8:
                getOnClick(view);
                break;
            case R.id.c_9:
                getOnClick(view);
                break;
            case R.id.c_point:
                getOnClick(view);
                break;
            case R.id.c_add:
                getOnClickAdd(view);
                break;
            case R.id.c_delete:
                getOnClickAdd(view);
                break;
            case R.id.c_X:
                getOnClickAdd(view);
                break;
            case R.id.c_div:
                getOnClickAdd(view);
                break;
            case R.id.c_equal:
                getOnClickAdd(view);
                break;
            case R.id.c_c:
                getOnClickSetzero(view);
                break;
            case R.id.c_xx:
                getOnClickSetzero(view);
                break;
            case R.id.c_ce:
                getOnClickSetzero(view);
                break;
            case R.id.c_aord:
                getOnClickSetzero(view);
                break;


        }
    }

    //运算符类按钮加上运算法类的监听
    //清除等按钮
    public void getOnClickSetzero(View view) {
        int tag = (Integer) view.getTag();

        switch (tag) {
            //全部清除
            case 14:
                x = 0;
                y = 0;
                text = "0.0";
                zestatus = true;
                break;
            case 15:
                try {
                    text = text.substring(0, text.length() - 1);
                } catch (Exception e) {
                }

                break;
            case 16:
                x = 0;
                text = "0.0";
                zestatus = true;
                break;
            case 17:
                count++;
                if (count != 0 && count % 2 == 0) {
                    text = text.substring(1);
                } else if (count % 2 == 1) {
                    text = "-" + text;
                }
                break;
        }
        ed_idcar.setText(text);
        ed_idcar.setSelection(text.length());
    }

    public void getOnClickAdd(View view) {
        int tag = (Integer) view.getTag();
        //当单击运算按钮不为=时
        if (tag != 18) {
            //保存x并清除文本域
            try {
                x = Float.parseFloat(text);
                tagremeber = tag;
                text = "";
                ed_idcar.setText(text);
                ed_idcar.setSelection(text.length());
            } catch (Exception e) {
            }

        }
        //点击=运算符时
        else if (tag == 18) {

            if (!TextUtils.isEmpty(text)) {
                y = Float.parseFloat(text);
            }
            switch (tagremeber) {
                case 10:
                    cl = new Add();
                    break;
                case 11:
                    cl = new Delete();
                    break;
                case 12:
                    cl = new Mulitply();
                    break;
                case 13:
                    cl = new Div();
                    break;
            }
            try {
                float result = cl.calculate(x, y);
                text = String.valueOf(result);
                ed_idcar.setText(text);
                ed_idcar.setSelection(text.length());
                //表示当前状态为结果状态，下次点击数字时会自动清除这次结果
                eqstatus = true;
            } catch (Exception e) {
            }

        }
    }

    public void getOnClick(View view) {
        int tag = (Integer) view.getTag();
        if (eqstatus) {
            text = "";
            ed_idcar.setSelection(text.length());
            eqstatus = false;
        }

        if (zestatus) {
            text = "";
            ed_idcar.setSelection(text.length());
            zestatus = false;
        }

        switch (tag) {

            case 20:
                text = text + "0";
                break;
            case 1:
                text = text + "1";
                break;
            case 2:
                text = text + "2";
                break;
            case 3:
                text = text + "3";
                break;
            case 4:
                text = text + "4";
                break;
            case 5:
                text = text + "5";
                break;
            case 6:
                text = text + "6";
                break;
            case 7:
                text = text + "7";
                break;
            case 8:
                text = text + "8";
                break;
            case 9:
                text = text + "9";
                break;
            case 19:
                text = text + ".";
        }
        ed_idcar.setText(text);
        ed_idcar.setSelection(text.length());
    }
}

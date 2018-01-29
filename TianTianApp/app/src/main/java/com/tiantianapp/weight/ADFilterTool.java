package com.tiantianapp.weight;

import android.content.Context;
import android.content.res.Resources;

import com.tiantianapp.R;

/**
 * Created by Administrator on 2018/1/4 0004.
 */

public class ADFilterTool {
    public static String getClearAdDivJs(Context context){
        String js = "javascript:";
        Resources res = context.getResources();
        String[] adDivs = res.getStringArray(R.array.adBlockDiv);
        for(int i=0;i<adDivs.length;i++){
            js += "var adDiv"+i+"= document.getElementById('"+adDivs[i]+"');document.getElementsByClassName('"+adDivs[i]+"');if(adDiv"+i+" != null)adDiv"+i+".parentNode.removeChild(adDiv"+i+");";
        }
        return js;
    }
}

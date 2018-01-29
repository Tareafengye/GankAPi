/**
 * 
 */
package com.tiantianapp.util;

import android.widget.Toast;

import com.tiantianapp.app.App;

/**
 * @author wu
 * 2016.9.4
 */
public class ByAlert {
	public static void alert(Object info) {
		if (info != null) {
			if (info.equals("用户ID缺失") || info.equals("UID不能为空")) {
				Toast.makeText(App.app, "亲,你还未登录,登录后更精彩",
						3).show();
			} else {
				Toast.makeText(App.app, info+"", 3).show();
			}
		}
	}
}

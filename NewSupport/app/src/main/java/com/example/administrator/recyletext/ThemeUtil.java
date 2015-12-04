package com.example.administrator.recyletext;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by smallnew on 2015/12/3.
 */
public class ThemeUtil {
    private static int sTheme = R.style.AppTheme;
    ;

    static void loadTheme(Activity activity, boolean reload) {
        activity.finish();
        sTheme = R.style.AppThemeDark;
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    static void setTheme(Activity activity) {
        activity.setTheme(sTheme);
    }

}

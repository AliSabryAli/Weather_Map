package com.ali.weathermap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class Navigator {
    public static void navigate(Activity from, Class to, boolean finish) {
        from.startActivity(new Intent(from, to));
        if (finish) {
            from.finish();
        }
    }
}

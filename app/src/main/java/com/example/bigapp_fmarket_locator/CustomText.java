package com.example.bigapp_fmarket_locator;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by meltemyildirim on 2/1/17.
 */

public class CustomText extends TextView {
    public CustomText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public CustomText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public CustomText(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attrs) {
        // Just Change your font name
        Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "PrinsesstartaBoldDEMO.ttf");
        setTypeface(myTypeface);
    }
}
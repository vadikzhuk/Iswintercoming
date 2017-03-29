package com.example.android.iswintercoming;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * This is custom TextView for displaying text in custom font by default
 */

public class TextViewGot extends TextView {

    public TextViewGot(Context context) {
        this(context, null, 0);
    }

    public TextViewGot(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public TextViewGot(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont(context);
    }

    private void setFont(Context context) {
        Typeface face = Typefaces.get(context, context.getText(R.string.got_font).toString());
        setTypeface(face);
    }

}

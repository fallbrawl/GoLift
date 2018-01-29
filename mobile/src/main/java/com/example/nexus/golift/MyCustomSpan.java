package com.example.nexus.golift;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;

/**
 * Created by nexus on 1/29/18.
 */

public class MyCustomSpan implements LineBackgroundSpan {
    private int color;
    private int xOffset;
    private float radius = 3;

    MyCustomSpan(int color, int xOffset){
        this.color = color;
        this.xOffset = xOffset;
    }

    @Override
    public void drawBackground(Canvas canvas, Paint paint, int left, int right, int top, int baseline,
                               int bottom, CharSequence text, int start, int end, int lnum) {
        int oldColor = paint.getColor();
        if (color != 0) {
            paint.setColor(color);
        }
        int x = ((left + right) / 2);
        /*This is the x-coordinate right
    below the date. If we add to x, we will draw the
    circle to the right of the date and vice versa if we subtract from x.*/
        canvas.drawCircle(x + xOffset, bottom + radius, radius, paint);
        paint.setColor(oldColor);
    }
}

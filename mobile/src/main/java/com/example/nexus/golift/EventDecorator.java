package com.example.nexus.golift;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.style.LineBackgroundSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by nexus on 1/25/18.
 */

class EventDecorator implements DayViewDecorator {

    //Note that negative values indicate a relative offset to the LEFT
    private static final int[] xOffsets = new int[]{0,-10,10,-20};
    private int color;
    private HashSet<CalendarDay> dates;
    private float dotRadius;
    private int spanType;

    public EventDecorator(int color, int spanType) {
        this.color = color;

        this.dates = new HashSet<>();
        this.spanType = spanType;
    }
    /*Note! I added this method so that I can add dates after object creation!*/
    public boolean addDate(CalendarDay day){
        return dates.add(day);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        LineBackgroundSpan span = new MyCustomSpan(color, xOffsets[spanType]);
        view.addSpan(span);
    }
}
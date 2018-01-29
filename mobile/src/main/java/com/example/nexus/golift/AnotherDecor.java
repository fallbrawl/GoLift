package com.example.nexus.golift;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by nexus on 1/29/18.
 */

public class AnotherDecor implements DayViewDecorator {

    private final HashSet<CalendarDay> dates;
    private Context mContext;

    public AnotherDecor(Collection<CalendarDay> dates, Context context) {

        this.dates = new HashSet<>(dates);
        mContext = context;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new MyCustomSpan(6, ContextCompat.getColor(mContext, R.color.colorAccent)));
    }
}

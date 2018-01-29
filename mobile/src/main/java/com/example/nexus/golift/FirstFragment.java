package com.example.nexus.golift;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by nexus on 1/24/18.
 */

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.calendar, container, false);
        MaterialCalendarView materialCalendarView = new MaterialCalendarView(getContext());
        HashMap<Integer, CalendarDay> days = new HashMap<>();
        days.put(1, CalendarDay.from(2018, 1, 20));
        days.put(2, CalendarDay.from(2018, 1, 22));
        days.put(3, CalendarDay.from(2018, 1, 26));

        EventDecorator[] decoratorArray = new EventDecorator[4]; //Max 4 dots
        for (int i = 0; i < decoratorArray.length; i++)
            decoratorArray[i] = new EventDecorator(R.color.colorAccent, i);

/*dayInstanceMap contains all the mappings.*/
        for (Map.Entry<Integer, CalendarDay> entry : days.entrySet()) {
            CalendarDay currDay = entry.getValue();
            Integer currDayCount = entry.getKey();
            for (int i = 0; i < currDayCount; i++)
                decoratorArray[i].addDate(currDay);
        }

        EventDecorator eventDecorator = new EventDecorator(R.color.colorAccent, 1);

        eventDecorator.addDate(CalendarDay.from(2018, 1, 20));
        materialCalendarView.addDecorator(eventDecorator);


        return view;
    }
}

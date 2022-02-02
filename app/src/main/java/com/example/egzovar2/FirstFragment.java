package com.example.egzovar2;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    LineChart lineChart;
    LineData lineData;
    LineDataSet lineDataSet;
    int x1, x2, y1, y2;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        lineChart = view.findViewById(R.id.lineChart);

        Bundle bundle = this.getArguments();

        if (bundle != null) {
            x1 = getArguments().getInt("x1");
            x2 = getArguments().getInt("x2");
            y1 = getArguments().getInt("y1");
            y2 = getArguments().getInt("y2");
        }

        lineChart();
        return view;
    }

    public void lineChart() {

        ArrayList points = new ArrayList<>();
        points.add(new Entry(x1, y1));
        points.add(new Entry(x2, y2));

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setAxisMinimum(0f);
        xAxis.setAxisMaximum(50f);
        YAxis yAxis = lineChart.getAxisLeft();
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(50f);

        lineDataSet = new LineDataSet(points, "Linijine diagrama");
        lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);
        lineDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        lineDataSet.setValueTextColor(Color.BLACK);
        lineDataSet.setValueTextSize(18f);
    }
}
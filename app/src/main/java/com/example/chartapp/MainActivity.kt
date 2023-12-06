package com.example.chartapp

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pieChart: PieChart = findViewById(R.id.chart)

        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(30f, "Категория 1"))
        entries.add(PieEntry(20f, "Категория 2"))
        entries.add(PieEntry(15f, "Категория 3"))
        entries.add(PieEntry(10f, "Категория 4"))
        entries.add(PieEntry(8f, "Категория 5"))
        entries.add(PieEntry(7f, "Категория 6"))
        entries.add(PieEntry(5f, "Категория 7"))
        entries.add(PieEntry(5f, "Категория 8"))

        val dataSet = PieDataSet(entries, "Распределение")

        dataSet.colors = listOf(
            Color.rgb(255, 0, 0),
            Color.rgb(255, 165, 0),
            Color.rgb(255, 255, 0),
            Color.rgb(0, 255, 0),
            Color.rgb(0, 0, 255),
            Color.rgb(75, 0, 130),
            Color.rgb(238, 130, 238),
            Color.rgb(128, 128, 128)
        )

        val data = PieData(dataSet)

        pieChart.data = data
        pieChart.description.isEnabled = false
        pieChart.animateY(1400, Easing.EaseInOutQuad)
        pieChart.animateXY(1400, 1400, Easing.EaseInOutQuad, Easing.EaseInOutQuad)

        pieChart.invalidate()
    }
}

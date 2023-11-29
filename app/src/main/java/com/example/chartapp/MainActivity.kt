package com.example.chartapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pieChart: PieChart = findViewById(R.id.chart)
        val headerTextView: TextView = findViewById(R.id.header)

        val entries: List<PieEntry> = listOf(
            PieEntry(29.8f, "JavaScript"),
            PieEntry(19.64f, "Python"),
            PieEntry(17.78f, "Java"),
            PieEntry(12.21f, "C#"),
            PieEntry(9.38f, "PHP"),
            PieEntry(9.14f, "C/C++"),
            PieEntry(4.37f, "Ruby")
        )

        val dataSet = PieDataSet(entries, "Most Demanded Programming Languages")
        dataSet.colors = ColorTemplate.COLORFUL_COLORS.toList()

        val data = PieData(dataSet)
        pieChart.data = data

        pieChart.description.text = "Programming languages"
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(android.R.color.white)
        pieChart.setTransparentCircleColor(android.R.color.white)
        pieChart.setTransparentCircleAlpha(110)

        pieChart.animateXY(1400, 1400, Easing.EaseInOutQuad)

        headerTextView.text = getString(R.string.most_demanded_programming_languages)

        pieChart.invalidate()
    }
}

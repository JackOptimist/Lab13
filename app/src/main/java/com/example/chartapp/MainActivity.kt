package com.example.chartapp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.PercentFormatter

class MainActivity : AppCompatActivity() {

    private lateinit var pieChart: PieChart
    private lateinit var barChart: BarChart
    private lateinit var lineChart: LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pieChart = findViewById(R.id.chart_pie)
        barChart = findViewById(R.id.chart_bar)
        lineChart = findViewById(R.id.chart_line)

        configurePieChart(pieChart)

        configureBarChart(barChart)

        configureLineChart(lineChart)

        barChart.visibility = View.VISIBLE
        lineChart.visibility = View.VISIBLE
    }

    private fun configurePieChart(chart: PieChart) {
        chart.setUsePercentValues(true)
        chart.description.isEnabled = false
        chart.setExtraOffsets(5f, 10f, 5f, 5f)

        val entries = mutableListOf<PieEntry>()
        entries.add(PieEntry(25f, "Label 1"))
        entries.add(PieEntry(35f, "Label 2"))
        entries.add(PieEntry(40f, "Label 3"))

        val dataSet = PieDataSet(entries, "Pie Chart")
        dataSet.colors = mutableListOf(Color.RED, Color.GREEN, Color.BLUE)

        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter(chart))
        chart.data = data
        chart.invalidate()
    }

    private fun configureBarChart(chart: BarChart) {
        chart.description.isEnabled = false
        chart.setDrawValueAboveBar(true)
        chart.setMaxVisibleValueCount(50)
        chart.setPinchZoom(false)
        chart.setDrawGridBackground(false)

        val entries = mutableListOf<BarEntry>()
        entries.add(BarEntry(1f, 30f, "Label1"))
        entries.add(BarEntry(2f, 50f, "Label2"))
        entries.add(BarEntry(3f, 25f, "Label3"))

        val dataSet = BarDataSet(entries, "Bar Chart")
        dataSet.colors = mutableListOf(Color.RED, Color.GREEN, Color.BLUE)

        val data = BarData(dataSet)
        chart.data = data
        chart.invalidate()
    }

    private fun configureLineChart(chart: LineChart) {
        chart.description.isEnabled = false
        chart.setDrawGridBackground(false)
        chart.isDragEnabled = true
        chart.setScaleEnabled(true)
        chart.isPinchZoomEnabled

        val entries = mutableListOf<Entry>()
        entries.add(Entry(1f, 30f))
        entries.add(Entry(2f, 50f))
        entries.add(Entry(3f, 25f))

        val dataSet = LineDataSet(entries, "Line Chart")
        dataSet.color = Color.BLUE
        dataSet.valueTextColor = Color.BLACK

        val data = LineData(dataSet)
        chart.data = data
        chart.invalidate()
    }
}

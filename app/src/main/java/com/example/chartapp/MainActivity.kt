package com.example.chartapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BubbleChart
import com.github.mikephil.charting.data.BubbleData
import com.github.mikephil.charting.data.BubbleDataSet
import com.github.mikephil.charting.data.BubbleEntry


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bubbleChart = findViewById<BubbleChart>(R.id.chart_bubble)

        val entries = ArrayList<BubbleEntry>()
        entries.add(BubbleEntry(0f, 30f, 10f))
        entries.add(BubbleEntry(1f, 20f, 8f))
        entries.add(BubbleEntry(2f, 25f, 12f))
        val dataSet = BubbleDataSet(entries, "Bubble Chart")
        dataSet.color = R.color.colorPrimary
        val bubbleData = BubbleData(dataSet)
        bubbleChart.data = bubbleData
        bubbleChart.description.isEnabled = false
        bubbleChart.setTouchEnabled(true)
        bubbleChart.isDragEnabled = true
        bubbleChart.setScaleEnabled(true)
        bubbleChart.invalidate()
    }
}

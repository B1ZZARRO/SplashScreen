package com.example.splashscreen.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.splashscreen.MainActivity
import com.example.splashscreen.R
import kotlinx.android.synthetic.main.fragment_diagram.*
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue


class DiagramFragment : Fragment() {

    var profit : Int = 0
    var costs : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diagram, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()

        val pieData: MutableList<SliceValue> = ArrayList()
        pieData.add(SliceValue(profit.toFloat(), Color.GREEN).setLabel("Прибыль: ${profit}"))
        pieData.add(SliceValue(costs.toFloat(), Color.RED).setLabel("Расходы: ${costs}"))

        val pieChartData = PieChartData(pieData)
        pieChartData.setHasLabels(true)
        pieChartData.setHasCenterCircle(true).centerText1 = "Фиксируем прибыль"
        pieChartData.setHasCenterCircle(true).centerText1FontSize = 20
        pieChartData.setHasCenterCircle(true).centerText1Color = Color.parseColor("#0097A7")
        chart.pieChartData = pieChartData
    }

    private  fun loadData() {
        val mainActivity = this.activity as MainActivity
        val sharedPreferences = mainActivity.getSharedPreferences(
            "sharedPrefs",
            Context.MODE_PRIVATE
        )
        val savedInt = sharedPreferences.getInt("int_KEY", 0)
        val savedInt1 = sharedPreferences.getInt("int1_KEY", 0)
        profit = savedInt!!
        costs = savedInt1!!
    }

}


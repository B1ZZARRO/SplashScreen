package com.example.splashscreen.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.splashscreen.MainActivity
import com.example.splashscreen.R
import kotlinx.android.synthetic.main.fragment_money.*

class MoneyFragment : Fragment() {

    var profit : Int = 0
    var costs : Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_money, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_profit.setOnClickListener {
            profit = edt_money.text.toString().toInt()
            saveData()
            edt_money.text.clear()
        }
        btn_costs.setOnClickListener {
            costs = edt_money.text.toString().toInt()
            saveData()
            edt_money.text.clear()
        }
    }

    private fun saveData() {
        val mainActivity = this.activity as MainActivity
        val insertedText = profit
        val insertedText1 = costs
        val sharedPreferences = mainActivity.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putInt("int_KEY", insertedText)
            putInt("int1_KEY", insertedText1)
        }.apply()
    }
}
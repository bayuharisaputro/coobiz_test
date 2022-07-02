package com.example.coobiz_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_b_m_i.*
import kotlinx.android.synthetic.main.fragment_b_m_i.ll_result
import kotlinx.android.synthetic.main.fragment_b_m_i.txt_index_result
import kotlinx.android.synthetic.main.fragment_smallest_number.*

class BMIFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b_m_i, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        calculateBMI()
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

        @JvmStatic
        fun newInstance(): BMIFragment{
            val fragment = BMIFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
    private fun calculateBMI(){
        bt_calculate.setOnClickListener {
            if(et_weight.text.isEmpty() || et_height.text.isEmpty()) {
                Toast.makeText(context, "Must fill height or weight first", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val weight = et_weight.text.toString().toDouble()
            val height = et_height.text.toString().toDouble()/100
            val result = String.format("%.1f", weight.div(height * height)).toDouble()
            if(result < 18.5) txt_index_result.text = "$result (Underweight)"
            else if(result in 18.0..24.9) txt_index_result.text = "$result (Normal Weight)"
            else if(result in 25.0..29.9) txt_index_result.text = "$result (Pre-Obesity)"
            else if(result in 30.0..34.9) txt_index_result.text = "$result (Obesity Class I)"
            else if(result in 35.0..39.9) txt_index_result.text = "$result (Obesity Class II)"
            else if(result > 40) txt_index_result.text = "$result (Obesity Class III)"
            else txt_index_result.text = "Please Try Again"
            et_weight.clearFocus()
            et_height.clearFocus()
            ll_result.visibility = View.VISIBLE
        }
    }
}
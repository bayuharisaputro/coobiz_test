package com.example.coobiz_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_b_m_i.*
import kotlinx.android.synthetic.main.fragment_smallest_number.*
import kotlinx.android.synthetic.main.fragment_smallest_number.ll_result
import kotlinx.android.synthetic.main.fragment_smallest_number.txt_index_result

class SmallestNumberFragment : Fragment() {
    private val arrayNumber :Array<Int> = arrayOf(5408,6604,32158,84984,8774,34871)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_smallest_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        findSmallestNumber()
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

        @JvmStatic
        fun newInstance(): SmallestNumberFragment{
            val fragment = SmallestNumberFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
    private fun findSmallestNumber(){
        arrayNumber.sort()
        bt_find.setOnClickListener {
            if(et_n.text.isEmpty()) {
                Toast.makeText(context, "Must fill N index", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(et_n.text.toString().toInt() > 6 ) {
                Toast.makeText(context, "Max N is 6", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(et_n.text.toString().toInt() < 1 ) {
                Toast.makeText(context, "Min N is 1", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val index = (et_n.text.toString().toInt()) - 1
            txt_index_result.text = arrayNumber[index].toString()
            et_n.clearFocus()

            ll_result.visibility = View.VISIBLE
        }
    }
}
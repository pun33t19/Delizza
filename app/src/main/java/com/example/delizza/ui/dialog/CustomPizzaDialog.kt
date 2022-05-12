package com.example.delizza.ui.dialog

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.delizza.R
import com.example.delizza.databinding.CustomPizzaDialogLayoutBinding
import com.example.delizza.model.PizzaItem
import com.example.delizza.viewmodel.PizzaViewModel

class CustomPizzaDialog(context: Context) :DialogFragment() {

    private lateinit var _binding:CustomPizzaDialogLayoutBinding
    private val viewModel:PizzaViewModel by viewModels()
    private var pizzaList:List<PizzaItem> = listOf()
    private val priceMap = mutableMapOf<String,Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= CustomPizzaDialogLayoutBinding.inflate(layoutInflater)
        return _binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val defaultCrust=arguments?.getString("defaultCrust")!!.toInt()
        val defaultSize=arguments?.getString("defaultSize")!!.toInt()

        priceMap.put("defaultCrust",defaultCrust)
        priceMap.put("defaultSize",defaultSize)

        Log.d("map",priceMap.toString())



        viewModel.pizzaList.observe(this){
            Log.d("LIST_CUSTOM_PIZZA",it.toString())
            viewModel.changePrice(it[arguments?.getString("position")!!.toInt()].crusts[priceMap["defaultCrust"]!!].sizes[priceMap["defaultSize"]!!].price)

        }

        when(defaultCrust){
            1->{
                _binding.handTossed.isChecked=true
            }
            2->{
                _binding.cheeseBurst.isChecked=true
            }
        }

        when(defaultSize){
            1->{
                _binding.regular.isChecked=true
            }
            2->{
                _binding.medium.isChecked=true
            }
            3->{
                _binding.large.isChecked=true
            }
        }

        Log.d("position", arguments?.getString("position")!!)
        Log.d("PIZZA_LIST",pizzaList.toString())

            viewModel.getPizza()
//        viewModel.changePrice(pizzaList[arguments?.getString("position")!!.toInt()].crusts[priceMap["defaultCrust"]!!].sizes[priceMap["defaultSize"]!!].price)

        viewModel.price.observe(this){
            _binding.priceText.text= it.toString()
        }

        _binding.sizeRadioGroup.setOnCheckedChangeListener { radioGroup, i ->

            val button=radioGroup.findViewById<RadioButton>(i)

            if (button.isChecked) {
                when (i) {
                    R.id.regular -> {

                        priceMap["defaultSize"] = 1

                    }
                    R.id.medium -> {

                        priceMap["defaultSize"] = 2

                    }
                    R.id.large -> {

                        priceMap["defaultSize"] = 3

                    }
                }
            }
            Log.d("map",priceMap.toString())
          //  viewModel.changePrice(pizzaList[arguments?.getString("position")!!.toInt()].crusts[priceMap["defaultCrust"]!!].sizes[priceMap["defaultSize"]!!].price)
        }

        _binding.crustRadioGroup.setOnCheckedChangeListener { radioGroup, i ->

            val button=radioGroup.findViewById<RadioButton>(i)

            if (button.isChecked) {
                when (i) {
                    R.id.hand_tossed -> {

                        priceMap["defaultCrust"] = 1

                    }
                    R.id.cheese_burst -> {

                        priceMap["defaultCrust"] = 2

                    }
                }
            }

            Log.d("map",priceMap.toString())
         //   viewModel.changePrice(pizzaList[arguments?.getString("position")!!.toInt()].crusts[priceMap["defaultCrust"]!!].sizes[priceMap["defaultSize"]!!].price)
        }


        _binding.addButton.setOnClickListener {

        }


    }
}
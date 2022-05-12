package com.example.delizza.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.delizza.MainActivity
import com.example.delizza.R
import com.example.delizza.adapters.PizzaItemAdapter
import com.example.delizza.databinding.FragmentHomeBinding
import com.example.delizza.decoration.RecyclerViewMargin
import com.example.delizza.viewmodel.PizzaViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeFragment : Fragment() {

    private lateinit var _binding:FragmentHomeBinding
    val binding get() = _binding


    private val viewModel:PizzaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater)

        (activity as MainActivity).findViewById<BottomNavigationView>(R.id.bottom_nav).visibility=View.VISIBLE
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.drinksRecyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        viewModel.pizzaList.observe(this){
            Log.d("LIST_TAG",it.toString())

            //item decoration class to add custom margins to recycler view
            binding.drinksRecyclerView.addItemDecoration(RecyclerViewMargin(60))
            val pizzaAdapter=PizzaItemAdapter(it)
            binding.drinksRecyclerView.adapter=pizzaAdapter
        }


    }

}
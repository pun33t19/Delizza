package com.example.delizza.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.delizza.R
import com.example.delizza.databinding.FragmentHomeBinding
import com.example.delizza.viewmodel.PizzaViewModel


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
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pizzaList.observe(this){
            Log.d("LIST_TAG",it.toString())
        }

    }

}
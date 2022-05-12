package com.example.delizza.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.delizza.MainActivity
import com.example.delizza.R
import com.example.delizza.databinding.FragmentSinglePizzaBinding
import com.example.delizza.ui.dialog.CustomPizzaDialog
import com.google.android.material.bottomnavigation.BottomNavigationView


class SinglePizzaFragment : Fragment() {

    private lateinit var _binding: FragmentSinglePizzaBinding
    val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSinglePizzaBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).findViewById<BottomNavigationView>(R.id.bottom_nav).visibility =
            View.GONE

        binding.itemTitle.text = arguments?.getString("name")
        binding.itemDesc.text = arguments?.getString("description")


        val bundle=Bundle()
        bundle.putString("defaultCrust",arguments?.getString("defaultCrust"))
        bundle.putString("defaultSize",arguments?.getString("defaultSize"))
        bundle.putString("position",arguments?.getString("position"))

        Log.d("crust and size",arguments?.getString("defaultCrust") +" "+arguments?.getString("defaultSize"))

        binding.purchaseButton.setOnClickListener {

            val dialog = CustomPizzaDialog(requireContext())
            dialog.arguments=bundle
            dialog.isCancelable = true
            dialog.show(requireActivity().supportFragmentManager,"TAG")
        }

    }


}
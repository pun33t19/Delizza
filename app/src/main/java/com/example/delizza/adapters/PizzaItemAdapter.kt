package com.example.delizza.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.delizza.R
import com.example.delizza.databinding.PizzaItemLayoutBinding
import com.example.delizza.model.PizzaItem
import com.example.delizza.ui.HomeFragmentDirections

class PizzaItemAdapter(val pizzaItemList:List<PizzaItem>):RecyclerView.Adapter<PizzaItemAdapter.PizzaItemViewHolder>() {



    class PizzaItemViewHolder(val itemBinding:PizzaItemLayoutBinding) :RecyclerView.ViewHolder(itemBinding.root){
        fun bind(item:PizzaItem){
            itemBinding.itemName.text=item.name
            itemBinding.descriptionText.text=item.description
            if(item.isVeg)
                Glide.with(itemBinding.root.context).load(R.drawable.veg).into(itemBinding.typeIndicatorImage)
            else
                Glide.with(itemBinding.root.context).load(R.drawable.non_veg).into(itemBinding.typeIndicatorImage)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaItemViewHolder {

        val inflater=LayoutInflater.from(parent.context)
        return PizzaItemViewHolder(PizzaItemLayoutBinding.inflate(inflater))
    }

    override fun onBindViewHolder(holder: PizzaItemViewHolder, position: Int) {
        val pizzaItem=pizzaItemList[position]

        holder.bind(pizzaItem)

        val bundle= bundleOf("name" to pizzaItem.name,"description" to pizzaItem.description,"defaultCrust" to pizzaItem.defaultCrust)


        holder.itemView.setOnClickListener {
            holder.itemView.findNavController().navigate(R.id.action_homeFragment_to_singlePizzaFragment,bundle)
        }
    }

    override fun getItemCount(): Int {
        return pizzaItemList.size
    }
}
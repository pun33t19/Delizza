package com.example.delizza.model

data class PizzaItem(val id:Int,val name:String,val isVeg:Boolean,val description:String,val defaultCrust:Int,val crusts:ArrayList<CrustItems>)

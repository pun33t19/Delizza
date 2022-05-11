package com.example.delizza.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//base url custom rest api
private const val BASE_URL="https://pizza-api-new.herokuapp.com"

    //initialising the moshi converter factory to be used for parsing the Json response
    private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

    //Retrofit initialisation block
    private val retroFit=Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

    //an interface for all the api specific methods along with the endpoints
    interface PizzaApiService {

        @GET("pizza")
        fun getPizzas(): String

    }

    //using singleton pattern to initialise retrofit object only once lazily

    object PizzaApi{
        val retroFitService:PizzaApiService by lazy {
            retroFit.create(PizzaApiService::class.java)
        }
    }








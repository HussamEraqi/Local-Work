package com.example.bottomnavview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.bottomnavview.databinding.FragmentCategoryBinding

import com.example.bottomnavview.remote.EndPoints
import com.example.bottomnavview.remote.RetrofitBuilder
import kotlinx.coroutines.launch
import java.io.IOException


class CategoryFragment : Fragment() {

    private lateinit var binding : FragmentCategoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(layoutInflater,container,false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        getCategories()
    }

    private fun getCategories() {

        try {
            lifecycleScope.launch {
                val api = RetrofitBuilder.retrofit.create(EndPoints::class.java)
                val response = api.getCatagories()
                when(response.code()){
                    200 -> {
                        val listOfCategories = response.body()

                    }
                }
            }

        }catch (e : IOException){
            Log.i("exception",e.message.toString())
        }
    }


}
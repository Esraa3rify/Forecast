package com.example.ui.weather.future.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ui.R

class FutureDetailsWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = FutureDetailsWeatherFragment()
    }

    private lateinit var viewModel: FutureDetailsWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_future_details_weather, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FutureDetailsWeatherViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
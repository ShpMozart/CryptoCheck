package com.example.woc.title

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.woc.R
import com.example.woc.databinding.FragmentTitleBinding




class title : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentTitleBinding = DataBindingUtil.inflate(
            inflater,com.example.woc.R.layout.fragment_title,
            container,false)


        binding.bitcoinimg.setOnClickListener{
            findNavController().navigate(titleDirections.actionTitle2ToBtc())
        }
        binding.etheriumimg.setOnClickListener {
            findNavController().navigate(titleDirections.actionTitle2ToEth())
        }
        binding.rippleimg.setOnClickListener {
            findNavController().navigate(titleDirections.actionTitle2ToXrp())
        }






        return binding.root
    }

}
package com.lloydna.easysell.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lloydna.easysell.R
import com.lloydna.easysell.databinding.EsAboutUsFragmentBinding

class ESAboutUsFragment : Fragment() {

    lateinit var binding: EsAboutUsFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EsAboutUsFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

}
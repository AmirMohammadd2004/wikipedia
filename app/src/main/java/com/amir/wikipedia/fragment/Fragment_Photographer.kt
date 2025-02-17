package com.amir.wikipedia.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.amir.wikipedia.R
import com.amir.wikipedia.databinding.FragmentPhotographerBinding
import com.bumptech.glide.Glide
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class Fragment_Photographer : Fragment() {

    lateinit var binding: FragmentPhotographerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPhotographerBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        Glide.with(requireContext())
            .load(R.drawable.img_photographer)
            .transform(RoundedCornersTransformation(25,5))
            .into(binding.imagPhotographer)
    }
}
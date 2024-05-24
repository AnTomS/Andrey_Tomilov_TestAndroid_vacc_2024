package com.atom.andreytomilovtestandroidvacc2024.ui.coffeedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.atom.andreytomilovtestandroidvacc2024.databinding.FragmentCoffeDetailBinding

class CoffeeDetailFragment : Fragment() {

    private var _binding: FragmentCoffeDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val coffeeDetailViewModel =
            ViewModelProvider(this).get(CoffeeDetailViewModel::class.java)

        _binding = FragmentCoffeDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
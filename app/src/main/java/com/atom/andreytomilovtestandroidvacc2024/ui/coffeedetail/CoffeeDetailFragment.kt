package com.atom.andreytomilovtestandroidvacc2024.ui.coffeedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.atom.andreytomilovtestandroidvacc2024.databinding.FragmentCoffeeDetailBinding

class CoffeeDetailFragment : Fragment() {

    private var _binding: FragmentCoffeeDetailBinding? = null
    private val binding get() = _binding!!

 //   private val args: CoffeeDetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val coffeeDetailViewModel =
            ViewModelProvider(this).get(CoffeeDetailViewModel::class.java)

        _binding = FragmentCoffeeDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
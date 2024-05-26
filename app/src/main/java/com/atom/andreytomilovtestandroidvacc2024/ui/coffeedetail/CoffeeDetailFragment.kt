package com.atom.andreytomilovtestandroidvacc2024.ui.coffeedetail

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.atom.andreytomilovtestandroidvacc2024.App
import com.atom.andreytomilovtestandroidvacc2024.databinding.FragmentCoffeeDetailBinding
import com.atom.andreytomilovtestandroidvacc2024.domain.dto.Coffee
import com.bumptech.glide.Glide
import javax.inject.Inject

class CoffeeDetailFragment : Fragment() {

    private var _binding: FragmentCoffeeDetailBinding? = null
    private val binding get() = _binding!!

    private val args: CoffeeDetailFragmentArgs by navArgs()

    @Inject
    lateinit var coffeeDetailViewModel: CoffeeDetailViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("CoffeeDetailFragment", "onAttach")
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("CoffeeDetailFragment", "onCreateView")
        val appComponent = (requireActivity().application as App).appComponent
        appComponent.inject(this)
        _binding = FragmentCoffeeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("CoffeeDetailFragment", "onViewCreated")
        binding.toolbar.setNavigationOnClickListener { goBack() }
        observeViewModel()

        val coffeeId = args.id
        Log.d("CoffeeDetailFragment", "Selected coffee ID to viewmodel: $coffeeId")
        coffeeDetailViewModel.setSelectedCoffeeId(coffeeId)
    }

    private fun observeViewModel() {
        coffeeDetailViewModel.selectedCoffee.observe(viewLifecycleOwner) { coffee ->
            coffee?.let {
                bindCoffeeDetails(coffee)
                Log.d("CoffeeDetailFragment", "Selected coffee ID changed observe: ${coffee.id}")
            }
        }
    }

    private fun goBack() {
        Log.d("CoffeeDetailFragment", "Go back")
        requireActivity().onBackPressed()
    }

    private fun bindCoffeeDetails(coffee: Coffee) {
        Log.d("CoffeeDetailFragment", "Binding coffee details: $coffee")
        binding.textViewName.text = coffee.name
        binding.textViewPrice.text = coffee.price
        binding.textViewCupVolume.text = coffee.cupVolume
        binding.textViewDescription.text = coffee.description
        Glide.with(binding.root)
            .load(coffee.image)
            .into(binding.imageView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("CoffeeDetailFragment", "onDestroyView")
        _binding = null
    }
}
package com.atom.andreytomilovtestandroidvacc2024.ui.menu

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.atom.andreytomilovtestandroidvacc2024.App
import com.atom.andreytomilovtestandroidvacc2024.data.network.ResultState
import com.atom.andreytomilovtestandroidvacc2024.databinding.FragmentMenuBinding
import com.atom.andreytomilovtestandroidvacc2024.domain.dto.Coffee
import javax.inject.Inject

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var menuViewModel: MenuViewModel

    private lateinit var menuAdapter: MenuAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("MenuFragment", "onAttach")
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("MenuFragment", "onCreateView")

        val appComponent = (requireActivity().application as App).appComponent
        appComponent.inject(this)

        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val root: View = binding.root

        menuAdapter = MenuAdapter { coffee ->
            Log.d("MenuFragment", "Coffee item clicked: ${coffee.id}")
            // findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToDetailFragment(coffee.id))
        }

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = menuAdapter
        }

        menuViewModel.coffees.observe(viewLifecycleOwner) { result ->
            Log.d("MenuFragment", "Coffees data observed: $result")
            when (result) {
                is ResultState.Success -> {
                    menuAdapter.setItems(result.data as List<Coffee>)
                    Log.d("MenuFragment", "Coffees loaded: ${result.data.size}")
                }
                is ResultState.Failure -> showError(result.exception)
                is ResultState.Loading -> showLoading()
            }
        }

        menuViewModel.fetchCoffees()

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("MenuFragment", "onViewCreated")
    }

    private fun showError(exception: Throwable) {
        Log.e("MenuFragment", "Error loading coffees", exception)

    }

    private fun showLoading() {
        Log.d("MenuFragment", "Loading coffees")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("MenuFragment", "onDestroyView")
        _binding = null
    }
}
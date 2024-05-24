package com.atom.andreytomilovtestandroidvacc2024.ui.menu

import android.content.Context
import android.os.Bundle
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

    private lateinit var adapter: MenuAdapter


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val appComponent = (requireActivity().application as App).appComponent
        appComponent.inject(this)


        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val root: View = binding.root

        adapter = MenuAdapter { coffee ->

//            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToDetailFragment(coffee.id))
        }

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = adapter
        }

        menuViewModel.coffees.observe(viewLifecycleOwner) { result ->
            when (result) {
               is ResultState.Success -> {
                   adapter.setItems(result.data as List<Coffee>)
               }
                is ResultState.Failure ->  showError(result.exception)
                is ResultState.Loading -> showLoading()
            }
        }


        menuViewModel.fetchCoffees()


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun showError(exception: Throwable) {
        // Обработка ошибок
    }

    private fun showLoading() {
        // Отображение загрузки
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
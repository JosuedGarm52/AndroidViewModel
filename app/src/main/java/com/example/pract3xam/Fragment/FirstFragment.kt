package com.example.pract3xam.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pract3xam.Adapter.PruebaAdapter
import com.example.pract3xam.Application.PruebaApplication
import com.example.pract3xam.Prueba.Prueba
import com.example.pract3xam.ViewModel.FirstFragmentViewModel
import com.example.pract3xam.ViewModel.FirstFragmentViewModelFactory
import com.example.pract3xam.databinding.FragmentFirstBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val firstFragmentViewModel : FirstFragmentViewModel by viewModels{
        FirstFragmentViewModelFactory( (requireActivity().application as PruebaApplication).repository )
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Crear el adaptador dentro del ciclo de vida del fragmento
        val adapter = PruebaAdapter { prueba ->
            onItemClick(prueba)
        }

        // Asignar el adaptador al RecyclerView
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        firstFragmentViewModel.pruebaKardex.observe(viewLifecycleOwner, Observer {prueba ->
            prueba?.let{
                adapter.submitList(it)
            }
        })
    }

    private fun onItemClick(it: Prueba) {
        Log.d("FirstFragment", "onItem clic")
        Toast.makeText(requireContext(), "Clic a ${it.ID}", Toast.LENGTH_SHORT).show()

        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(it.ID)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.pract3xam.Fragment

import android.content.ContentValues
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.pract3xam.Application.PruebaApplication
import com.example.pract3xam.Prueba.Prueba
import com.example.pract3xam.R
import com.example.pract3xam.ViewModel.SecondFragmentViewModel
import com.example.pract3xam.ViewModel.SecondFragmentViewModelFactory
import com.example.pract3xam.databinding.FragmentSecondBinding
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val secondFragmentViewModel: SecondFragmentViewModel by viewModels(){
        SecondFragmentViewModelFactory( (requireActivity().application as PruebaApplication).repository )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    val args: SecondFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(args.ID == 0){
            binding.btnGuardar.text = "Editar"
        }
        // Add options menu to the toolbar
        binding.btnGuardar.setOnClickListener{
            val id = binding.edtID.text.toString().toInt()
            val Cuerpo = binding.edtCuerpo.text.toString()

            val values = ContentValues().apply {
                put("ID", id )
                put("Cuerpo", Cuerpo)
            }


            val materia_kardex = Prueba(id,Cuerpo)
            secondFragmentViewModel.insertMateria(materia_kardex)


            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
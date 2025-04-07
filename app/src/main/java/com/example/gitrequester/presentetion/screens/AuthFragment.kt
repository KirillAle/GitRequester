package com.example.gitrequester.presentetion.screens

import com.example.gitrequester.data.AuthState
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.gitrequester.databinding.AuthFragmentBinding
import com.example.gitrequester.viewModels.AuthViewModel


class AuthFragment : Fragment() {

    private var _binding: AuthFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AuthFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSignIn.setOnClickListener {
            val token = binding.EditTextToken.text.toString()
            viewModel.onSignButtonPressed(token)
        }
        viewModel.authState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is AuthState.Loading -> {
                    Toast.makeText(requireContext(), "Loading...", Toast.LENGTH_LONG).show()
                    Log.d("AUTH_STATE", "State is Loading")
                }

                is AuthState.Success -> {
                    val action = AuthFragmentDirections
                        .actionAuthFragmentToRepositoriesListFragment(
                            state.repositories.toList().toTypedArray()
                        )
                    findNavController().navigate(action)
                    Log.d("AUTH_STATE", "State is Success with ${state.repositories.size} items")
                }
                is AuthState.Error -> {
                    Log.d("AUTH_STATE", "State is Error: ${state.message}")
                }

                else -> {
                    Toast.makeText(requireContext(), "Неизвестное состояние", Toast.LENGTH_LONG)
                        .show()
                    Log.d("AUTH_STATE", "State is something else: ${state::class}")
                }


            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
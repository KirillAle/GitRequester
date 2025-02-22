package com.example.gitrequester

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
    ): View? {
        _binding = AuthFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSignIn.setOnClickListener {
            val token = binding.EditTextToken.text.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}
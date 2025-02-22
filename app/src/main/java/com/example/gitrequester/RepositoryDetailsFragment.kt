package com.example.gitrequester

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gitrequester.databinding.RepositoryDitailsFragmentBinding

class RepositoryDetailsFragment : Fragment() {

    private lateinit var binding: RepositoryDitailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RepositoryDitailsFragmentBinding.inflate(inflater, container, false)

        val args = RepositoryDetailsFragmentArgs.fromBundle(requireArguments())

        binding.textViewRepoName.text = args.repoName
        binding.textViewRepoDescription.text = args.repoDescription?.ifEmpty {"Описание отсутствует"}
        binding.textViewRepoLanguage.text = args.repoLanguage?.ifEmpty { "Язык не указан" }


        return binding.root
    }
}
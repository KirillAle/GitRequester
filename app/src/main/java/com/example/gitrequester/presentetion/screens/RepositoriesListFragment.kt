package com.example.gitrequester.presentetion.screens

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitrequester.data.Repository
import com.example.gitrequester.RepositoryAdapter
import com.example.gitrequester.databinding.RepositoriesListFragmentBinding

class RepositoriesListFragment: Fragment() {

    private var _binding: RepositoriesListFragmentBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<RepositoriesListFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RepositoriesListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repositories = args.repositories.toList()
        (arguments?.getParcelableArray("repositories") as? Array<Parcelable>)
            ?.filterIsInstance<Repository>() ?: emptyList()
        println("Repos: $repositories")



        val adapter = RepositoryAdapter(repositories) { repository ->
            val action = RepositoriesListFragmentDirections
                .actionRepositoriesListFragmentToRepositoryDetailsFragment(
                    repoName = repository.name,
                    repoDescription = repository.description ?: "",  // Если null → пустая строка
                    repoLanguage = repository.language ?: ""         // Если null → пустая строка
                )
            findNavController().navigate(action)
        }
        binding.recyclerViewRepositories.layoutManager = LinearLayoutManager(requireContext())
    }


}
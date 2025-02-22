package com.example.gitrequester

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitrequester.databinding.RepositoriesListFragmentBinding

class RepositoriesListFragment: Fragment() {

    private var _binding: RepositoriesListFragmentBinding? = null
    private val binding get() = _binding!!


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

        val repositories = listOf(
            Repository("Repo 1", "Описание первого репозитория", "Kotlin"),
            Repository("Repo 2", null, "Java"),
            Repository("Repo 3", "Тестовый репозиторий", null),
            Repository("Repo 4", "Описание 4-го репозитория", "Kotlin"),
            Repository("Repo 5", null, "Java"),
            Repository("Repo 6", "Тестовый репозиторий", null)
        )

        val adapter = RepositoryAdapter(repositories) { repository ->
            val action = RepositoriesListFragmentDirections
                .actionRepositoriesListFragmentToRepositoryDetailsFragment(
                    repoName = repository.name,
                    repoDescription = repository.description ?: "",  // Если null → пустая строка
                    repoLanguage = repository.language ?: ""         // Если null → пустая строка
                )
            findNavController().navigate(action)
        }
        binding.recyclerViewRepositories.adapter = adapter
    }


}
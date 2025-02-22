package com.example.gitrequester

import androidx.recyclerview.widget.RecyclerView
import com.example.gitrequester.databinding.RepositiryItemBinding

class RepositoryViewHolder(private val binding: RepositiryItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(repository: Repository, onClick: (Repository) -> Unit) {
        binding.textViewRepoName.text = repository.name
        binding.textViewRepoDescription.text = repository.description ?: "NO DESCRIPTION"
        binding.textViewRepoLanguage.text = repository.language ?: "NO LANGUAGE"


        binding.root.setOnClickListener{ onClick(repository) }
    }


}
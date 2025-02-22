package com.example.gitrequester

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gitrequester.databinding.RepositiryItemBinding

class RepositoryAdapter(
    private val repositories: List<Repository>,
    private val onClick: (Repository) -> Unit
) : RecyclerView.Adapter<RepositoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val binding = RepositiryItemBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(repositories[position], onClick)
    }

    override fun getItemCount(): Int = repositories.size

}

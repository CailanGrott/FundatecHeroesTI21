package br.com.fundatec.fundatecheroesti21.character.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.fundatecheroesti21.character.domain.CharacterModel
import br.com.fundatec.fundatecheroesti21.databinding.CharacterListItemBinding

class CharacterListAdapter : RecyclerView.Adapter<CharacterViewHolder>() {
    private val list: MutableList<CharacterModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            CharacterListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun add(items: List<CharacterModel>) {
        list.addAll(items)
        notifyDataSetChanged()
    }
}
package br.com.fundatec.fundatecheroesti21.character.view

import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.fundatecheroesti21.character.domain.CharacterModel
import br.com.fundatec.fundatecheroesti21.databinding.CharacterListItemBinding

class CharacterViewHolder(private val binding: CharacterListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(character: CharacterModel) {
        binding.tvName.text = character.name
    }
}
package br.com.fundatec.fundatecheroesti21.characterRegister.view

import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.fundatecheroesti21.character.data.local.CharacterModel
import br.com.fundatec.fundatecheroesti21.characterRegister.domain.CharacterRegisterModel
import br.com.fundatec.fundatecheroesti21.databinding.CharacterListItemBinding
import com.bumptech.glide.Glide

class CharacterViewHolder(private val binding: CharacterListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(character: CharacterModel) {
        binding.tvName.text = character.name
        Glide.with(binding.root.context)
            .load(character.image)
            .into(binding.imgHeroe)
    }
}
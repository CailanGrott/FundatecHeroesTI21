package br.com.fundatec.fundatecheroesti21.home.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import br.com.fundatec.fundatecheroesti21.character.CharacterFragment

class HomeViewPager(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "Fragment $position"
    }

    override fun getItem(position: Int): Fragment {
        return CharacterFragment.newInstance("Fragment $position")
    }
}
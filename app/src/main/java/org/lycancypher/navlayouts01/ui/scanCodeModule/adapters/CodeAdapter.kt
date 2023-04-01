package org.lycancypher.navlayouts01.ui.scanCodeModule.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.lycancypher.navlayouts01.ui.scanCodeModule.view.CodeFragment

class CodeAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> CodeFragment(position)
            else -> CodeFragment(position)
        }
    }
}
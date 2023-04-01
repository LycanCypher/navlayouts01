package org.lycancypher.navlayouts01.ui.scanCodeModule.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.lycancypher.navlayouts01.R
import org.lycancypher.navlayouts01.databinding.FragmentCodeBinding

class CodeFragment(private val pos: Int) : Fragment() {
    private lateinit var binding: FragmentCodeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_code, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (pos != 0) {
            binding.code.setImageResource(R.drawable.code128_2)
        } else {
            binding.code.setImageResource(R.drawable.qr_xamp)
        }
    }
}
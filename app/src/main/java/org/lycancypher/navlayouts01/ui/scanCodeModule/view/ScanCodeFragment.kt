package org.lycancypher.navlayouts01.ui.scanCodeModule.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import org.lycancypher.navlayouts01.R
import org.lycancypher.navlayouts01.databinding.FragmentScanCodeBinding
import org.lycancypher.navlayouts01.ui.scanCodeModule.adapters.CodeAdapter

class ScanCodeFragment : Fragment() {
    private lateinit var binding: FragmentScanCodeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_scan_code, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            pager.adapter = CodeAdapter(requireActivity().supportFragmentManager, lifecycle)

            TabLayoutMediator(tablayout, pager) { tab, position ->
                tab.text = when (position) {
                    0 -> "QR"
                    else -> "128-CODE"
                }
            }.attach()
        }


    }
}
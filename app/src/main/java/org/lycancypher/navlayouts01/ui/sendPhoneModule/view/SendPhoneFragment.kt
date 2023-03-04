package org.lycancypher.navlayouts01.ui.sendPhoneModule.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import org.lycancypher.navlayouts01.BR
import org.lycancypher.navlayouts01.R
import org.lycancypher.navlayouts01.databinding.FragmentSendPhoneBinding
import org.lycancypher.navlayouts01.ui.sendPhoneModule.view.adapters.OnClickListener

class SendPhoneFragment : Fragment(), OnClickListener {
    private lateinit var binding: FragmentSendPhoneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_send_phone, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        binding.setVariable(BR.listener, this)
    }

    override fun onClick() {
        val action = SendPhoneFragmentDirections.actionSendPhoneFragmentToSendCodeFragment()
        findNavController().navigate(action)
    }
}
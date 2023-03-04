package org.lycancypher.navlayouts01.ui.sendCodeModule.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.lycancypher.navlayouts01.BR
import org.lycancypher.navlayouts01.R
import org.lycancypher.navlayouts01.common.utils.Constants.RIGHT_CODE
import org.lycancypher.navlayouts01.databinding.FragmentSendCodeBinding
import org.lycancypher.navlayouts01.ui.sendCodeModule.view.adapters.OnClickListener

class SendCodeFragment : Fragment(), OnClickListener {
    private lateinit var binding: FragmentSendCodeBinding

    private var code = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_send_code, container, false)
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
        with(binding) {
            code = "${etOne.text}" + "${etTwo.text}" + "${etThree.text}" + "${etFour.text}"
        }

        val action = if (code == RIGHT_CODE) {
            SendCodeFragmentDirections.actionSendCodeFragmentToHomeFragment()
        } else {
            SendCodeFragmentDirections.actionSendCodeFragmentToRegisterUserFragment()
        }
        findNavController().navigate(action)

    }
}
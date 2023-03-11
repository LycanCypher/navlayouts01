package org.lycancypher.navlayouts01.bottomSheets.selectSex.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.lycancypher.navlayouts01.BR
import org.lycancypher.navlayouts01.R
import org.lycancypher.navlayouts01.bottomSheets.selectSex.view.adapters.OnClickListener
import org.lycancypher.navlayouts01.databinding.FragmentSelectSexBinding

class SelectSexFragment(
    private val listener: org.lycancypher.navlayouts01.ui.registerUserModule.view.adapters.OnClickListener
    ) : BottomSheetDialogFragment(), OnClickListener {
    private lateinit var binding: FragmentSelectSexBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_select_sex, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    override fun onStart() {
        super.onStart()

        val behavior = BottomSheetBehavior.from(requireView().parent as View)
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        behavior.isDraggable = false

        val view: FrameLayout =
            dialog?.findViewById(com.google.android.material.R.id.design_bottom_sheet)!!
        view.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
    }

    private fun setupViewModel() {
        binding.setVariable(BR.listener, this)
    }

    override fun onClickMujer() {
        listener.fillSexEditText(getString(R.string.txt_mujer))
        dismiss()
    }

    override fun onClickHombre() {
        listener.fillSexEditText(getString(R.string.txt_hombre))
        dismiss()
    }
}
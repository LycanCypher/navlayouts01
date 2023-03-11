package org.lycancypher.navlayouts01.ui.registerUserModule.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.MaterialDatePicker
import org.lycancypher.navlayouts01.BR
import org.lycancypher.navlayouts01.R
import org.lycancypher.navlayouts01.bottomSheets.selectSex.view.SelectSexFragment
import org.lycancypher.navlayouts01.common.utils.DateTimeUtils
import org.lycancypher.navlayouts01.databinding.FragmentRegisterUserBinding
import org.lycancypher.navlayouts01.mainModule.view.adapters.OnMainClickListener
import org.lycancypher.navlayouts01.ui.registerUserModule.view.adapters.OnClickListener

class RegisterUserFragment : Fragment(), OnClickListener {
    private lateinit var binding: FragmentRegisterUserBinding

    private val constraintsBuilder =
        CalendarConstraints.Builder()
            .setValidator(
                DateValidatorPointBackward.before(DateTimeUtils.getDate()))

    private val datePicker =
        MaterialDatePicker.Builder.datePicker()
            .setTitleText("Seleccione la fecha")
            .setCalendarConstraints(constraintsBuilder.build())
            .setSelection(DateTimeUtils.getDate())
            .build()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_register_user, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()

        datePicker.addOnPositiveButtonClickListener {
            binding.etFechaNac.setText(DateTimeUtils.parseDate(datePicker.selection))
        }
    }

    private fun setupViewModel() {
        binding.setVariable(BR.listener, this)
    }

    override fun onClickSex() {
        (activity as OnMainClickListener).showBottomDialog(SelectSexFragment(this))
        Log.i("SELECCION", "Seleccion de sexo")
    }

    override fun onClickFechNac() {
        datePicker.show(requireActivity().supportFragmentManager, "tag")
        Log.i("SELECCION", "Seleccion de fecha de nac")
    }

    override fun fillSexEditText(string: String) {
        binding.etSexo.setText(string)
    }
}
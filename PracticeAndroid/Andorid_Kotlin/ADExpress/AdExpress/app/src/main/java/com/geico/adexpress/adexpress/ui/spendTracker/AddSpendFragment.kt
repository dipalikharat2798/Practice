package com.geico.adexpress.adexpress.ui.spendTracker

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.geico.adexpress.adexpress.R
import com.geico.adexpress.adexpress.databinding.FragmentAddSpendBinding

class AddSpendFragment:BaseFragment(R.layout.fragment_add_spend) {
    private lateinit var binding: FragmentAddSpendBinding
    private var amount: Int = 0
    private var description: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddSpendBinding.bind(view)

        binding.editTextAmount.addTextChangedListener {
            amount = it.toString().trim().toIntOrNull() ?: 0
            binding.buttonAdd.enabled(Validator.validateInput(amount, description))
        }

        binding.editTextDescription.addTextChangedListener {
            description = it?.toString()?.trim() ?: ""
            binding.buttonAdd.enabled(Validator.validateInput(amount, description))
        }

        binding.buttonAdd.setOnClickListener {
            addSpend()
        }
    }

   // @SuppressLint("SetTextI18n")

    private fun addSpend() {
        viewModel.addSpend(amount, description)
        binding.textViewSuccessMessage.text="Spend Added"
      //  findNavController().navigateUp()
    }
}
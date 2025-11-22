package com.kay.tipcalculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var etBillAmount: EditText
    private lateinit var seekBarTip: SeekBar
    private lateinit var tvTipPercent: TextView
    private lateinit var tvTipAmount: TextView
    private lateinit var tvTotalAmount: TextView
    private lateinit var tvTipDescription: TextView
    private lateinit var seekBarSplit: SeekBar
    private lateinit var tvSplitCount: TextView
    private lateinit var tvPerPersonAmount: TextView
    private lateinit var btnTip10: TextView
    private lateinit var btnTip15: TextView
    private lateinit var btnTip18: TextView
    private lateinit var btnTip20: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        etBillAmount = findViewById(R.id.etBillAmount)
        seekBarTip = findViewById(R.id.seekBarTip)
        tvTipPercent = findViewById(R.id.tvTipPercent)
        tvTipAmount = findViewById(R.id.tvTipAmount)
        tvTotalAmount = findViewById(R.id.tvTotalAmount)
        tvTipDescription = findViewById(R.id.tvTipDescription)
        seekBarSplit = findViewById(R.id.seekBarSplit)
        tvSplitCount = findViewById(R.id.tvSplitCount)
        tvPerPersonAmount = findViewById(R.id.tvPerPersonAmount)
        btnTip10 = findViewById(R.id.btnTip10)
        btnTip15 = findViewById(R.id.btnTip15)
        btnTip18 = findViewById(R.id.btnTip18)
        btnTip20 = findViewById(R.id.btnTip20)

        // Set default tip percentage
        seekBarTip.progress = 15
        tvTipPercent.text = getString(R.string.tip_percent_format, 15)
        updateTipDescription(15)

        // Set default split count
        seekBarSplit.progress = 1
        tvSplitCount.text = getString(R.string.split_count_format, 1)

        // Set up tip preset buttons
        btnTip10.setOnClickListener { setTipPercent(10) }
        btnTip15.setOnClickListener { setTipPercent(15) }
        btnTip18.setOnClickListener { setTipPercent(18) }
        btnTip20.setOnClickListener { setTipPercent(20) }

        // Listen for SeekBar changes
        seekBarTip.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvTipPercent.text = getString(R.string.tip_percent_format, progress)
                updateTipDescription(progress)
                calculateTip()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Listen for bill amount changes
        etBillAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                calculateTip()
            }
        })

        // Listen for split count changes
        seekBarSplit.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val splitCount = if (progress == 0) 1 else progress
                tvSplitCount.text = getString(R.string.split_count_format, splitCount)
                calculateTip()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun calculateTip() {
        // Get bill amount, handle empty or invalid input
        val billAmountText = etBillAmount.text.toString()
        if (billAmountText.isEmpty()) {
            tvTipAmount.text = ""
            tvTotalAmount.text = ""
            tvPerPersonAmount.text = ""
            return
        }

        val billAmount = billAmountText.toDoubleOrNull()
        if (billAmount == null) {
            tvTipAmount.text = ""
            tvTotalAmount.text = ""
            tvPerPersonAmount.text = ""
            return
        }

        // Calculate tip and total
        val tipPercent = seekBarTip.progress
        val tipAmount = billAmount * tipPercent / 100
        val totalAmount = billAmount + tipAmount

        // Calculate per person amount
        val splitCount = if (seekBarSplit.progress == 0) 1 else seekBarSplit.progress
        val perPersonAmount = totalAmount / splitCount

        // Format and display results
        val currencyFormatter = NumberFormat.getCurrencyInstance()
        tvTipAmount.text = currencyFormatter.format(tipAmount)
        tvTotalAmount.text = currencyFormatter.format(totalAmount)
        tvPerPersonAmount.text = currencyFormatter.format(perPersonAmount)
    }

    private fun updateTipDescription(tipPercent: Int) {
        val description = when (tipPercent) {
            in 0..9 -> getString(R.string.tip_poor)
            in 10..14 -> getString(R.string.tip_acceptable)
            in 15..19 -> getString(R.string.tip_good)
            in 20..24 -> getString(R.string.tip_great)
            else -> getString(R.string.tip_amazing)
        }
        tvTipDescription.text = description
    }

    private fun setTipPercent(percent: Int) {
        seekBarTip.progress = percent
    }
}







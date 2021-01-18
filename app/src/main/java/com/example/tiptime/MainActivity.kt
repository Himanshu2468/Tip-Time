@file:Suppress("Annotator", "Annotator", "Annotator", "Annotator", "Annotator")

package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Calculatebutton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip()
    {
    val cost=binding.Costservice.text.toString().toDoubleOrNull()
        if(cost==null)
        {
            binding.tipcal.text=""
            return
        }

        val tipPercent= when(binding.Selectedoptionradio.checkedRadioButtonId)
        {
            R.id.amazingsixpercent-> 0.20
            R.id.good-> 0.18
            else -> 0.15
        }
        var tip=tipPercent*cost
        val roundup= binding.roundup.isChecked
        if(roundup)
        {
            tip =kotlin.math.ceil(tip)
        }
     val formattedTip= NumberFormat.getCurrencyInstance().format(tip)
        binding.tipcal.text=getString(R.string.tip_amount,formattedTip)
    }
}
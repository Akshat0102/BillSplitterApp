package com.example.billsplitter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.billsplitter.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.splitButton.setOnClickListener { splitBill() }
    }

    private fun splitBill() {

        val bill = binding.billValueEditText.text.toString().toDoubleOrNull()

        val friends = binding.numberOfFriendsEditText.text.toString().toIntOrNull()

        if (bill == null) {
            Toast.makeText(this, "Bill can't be empty", Toast.LENGTH_SHORT).show()
            return
        } else if (bill == 0.0) {
            Toast.makeText(this, "Bill can't be zero", Toast.LENGTH_SHORT).show()
            return
        }

        if (friends == null) {
            Toast.makeText(this, "Number of friends can't be empty", Toast.LENGTH_SHORT).show()
            return
        } else if (friends == 0) {
            Toast.makeText(this, "Number of friends can't be zero or decimal", Toast.LENGTH_SHORT).show()
            return
        }

        val amount = bill / friends

        val formatAmount = NumberFormat.getCurrencyInstance().format(amount)
        binding.amountPerPerson.text = getString(R.string.amount_per, formatAmount)
    }
}
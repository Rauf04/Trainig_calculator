package com.example.trainingcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.trainingcalc.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
        private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn0.setOnClickListener { setTextFields("0") }
        binding.btn1.setOnClickListener { setTextFields("1") }
        binding.btn2.setOnClickListener { setTextFields("2") }
        binding.btn3.setOnClickListener { setTextFields("3") }
        binding.btn4.setOnClickListener { setTextFields("4") }
        binding.btn5.setOnClickListener { setTextFields("5") }
        binding.btn6.setOnClickListener { setTextFields("6") }
        binding.btn7.setOnClickListener { setTextFields("7") }
        binding.btn8.setOnClickListener { setTextFields("8") }
        binding.btn9.setOnClickListener { setTextFields("9") }
        binding.btnMinus.setOnClickListener { setTextFields("-") }
        binding.btnPlus.setOnClickListener { setTextFields("+") }
        binding.btnMlt.setOnClickListener { setTextFields("*") }
        binding.btnDivis.setOnClickListener { setTextFields("-") }
        binding.btnOpenbrack.setOnClickListener { setTextFields("(") }
        binding.btnClosebrack.setOnClickListener { setTextFields(")") }
        binding.btnDot.setOnClickListener { setTextFields(".") }

        binding.btnAc.setOnClickListener {
            binding.mathOperation.text = ""
            binding.resultText.text = ""
        }

        binding.btnBack.setOnClickListener {
            val str = binding.mathOperation.text.toString()
            if (str.isNotEmpty())
                binding.mathOperation.text = str.substring(0,str.length-1)
            binding.resultText.text = ""
        }

        binding.btnEqual.setOnClickListener {
            try {
                val ex = ExpressionBuilder(binding.mathOperation.text.toString()).build()
                val result = ex.evaluate()

                val LongRes = result.toLong()
                if (result == LongRes.toDouble())
                    binding.resultText.text = LongRes.toString()
                else
                    binding.resultText.text = result.toString()
            } catch (e:Exception){
                Log.d("Error","Message: ${e.message}")
            }

        }

    }
    fun setTextFields (str:String){
        binding.mathOperation.append(str)
    }
}
package com.example.atv2mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.ArithmeticException

class ActivityCalculadora : AppCompatActivity() {

    private var tvInput: TextView? = null
    var lastNumeric : Boolean = false
    var lastDot : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

       tvInput = findViewById(R.id.tvInput)

    }
    fun onDigit(view: View){
        tvInput?.append((view as Button).text)
        lastNumeric = true

        //Toast.makeText(this, "$view", Toast.LENGTH_SHORT).show()
    }

    fun onClear(view: View){
        tvInput?.text = ""
        lastNumeric = false
        lastDot = false
    }

    fun onDecimalPoint(view: View){
        if (lastNumeric && !lastDot){
            tvInput?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    /*
    fun onEqual(view: View){
        if (lastNumeric){
            var tvValue = tvInput.text.toString()

            try {
                if(tvValue.contains("-")){
                    val splitValue = tvValue.split("-")

                    var one = splitValue[0]
                    var two = splitValue[1]

                    tvInput.text = (one.toDouble()-two.toDouble()).toString()
                }
            }catch (e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }*/

    fun onEqual(view: View){
        if(lastNumeric){
            var tvValue = tvInput?.text.toString()

            var prefix = ""

            try {
                if (tvValue.startsWith("-")){
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }

                if (tvValue.contains("-")){
                    val splitValue = tvValue.split("-")

                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    tvInput?.text = removeZero((one.toDouble()-two.toDouble()).toString())
                }
                else if (tvValue.contains("+")){
                    val splitValue = tvValue.split("+")

                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    tvInput?.text = removeZero((one.toDouble() + two.toDouble()).toString())
                }
                else if (tvValue.contains("/")){
                    val splitValue = tvValue.split("/")

                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    tvInput?.text = removeZero((one.toDouble() / two.toDouble()).toString())
                }else if (tvValue.contains("*")){
                    val splitValue = tvValue.split("*")

                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    tvInput?.text = removeZero((one.toDouble() * two.toDouble()).toString())
                }

            }catch (e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }

    fun onOperator(view: View){
        tvInput?.text?.let {
            if (lastNumeric && !isOperatorAdded(it.toString())){
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }else if(!lastNumeric && !isOperatorAdded(it.toString()) &&
                (view as Button).text.toString() == "-" &&
                !tvInput?.text.toString().contains("-")){
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDot = true
            }
        }
    }

    private fun removeZero(result: String): String{
        var value = result

        if (result.contains(".0"))
            value = result.substring(0,result.length - 2)

        return value
    }


    private fun isOperatorAdded(value:String): Boolean{
        return if (value.startsWith("-")){
            false
        }else{
            value.contains("/") || value.contains("*")
                    || value.contains("+") || value.contains("-")
        }
    }
}
package com.example.calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder



class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*Number Buttons*/

        button1.setOnClickListener {
            evaluateExpression("1", clear = true)
        }

        button2.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        button3.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        button4.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        button5.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        button6.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        button7.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        button8.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        button9.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        button0.setOnClickListener {
            evaluateExpression("0", clear = true)
        }

        buttonPlus.setOnClickListener {
            evaluateExpression("+", clear = true)
        }

        buttonMoins.setOnClickListener {
            evaluateExpression("-", clear = true)
        }

        buttonFois.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        buttonDivision.setOnClickListener {
            evaluateExpression("/", clear = true)
        }


        buttonClear.setOnClickListener {
            expression.text = ""
            résultat.text = ""
        }

        buttonEgale.setOnClickListener {
            val text = expression.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                résultat.text = longResult.toString()
            } else {
                résultat.text = result.toString()
            }
        }


    }

    fun evaluateExpression(string: String, clear: Boolean) {
        if(clear) {
            résultat.text = ""
            expression.append(string)
        } else {
            expression.append(résultat.text)
            expression.append(string)
            résultat.text = ""
        }
    }
}
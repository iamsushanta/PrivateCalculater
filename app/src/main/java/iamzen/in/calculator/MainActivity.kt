package iamzen.`in`.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val calculatorViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        calculatorViewModel.stringNewNumber.observe(this, {
            stringNumber -> newNumber.setText(stringNumber)
        })

        calculatorViewModel.stringResult.observe(this,{
            stringResult -> result.setText(stringResult)
        })

        calculatorViewModel.stringOperation.observe(this,{
            stringOperation -> operation.text = stringOperation
        })

        val listener = View.OnClickListener { v ->

            calculatorViewModel.digitPressed((v as Button).text.toString())

        }

        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
        buttonDot.setOnClickListener(listener)

        val opListener = View.OnClickListener { v ->
            calculatorViewModel.operandPressed((v as Button).text.toString())
           
        }

        buttonEquals.setOnClickListener(opListener)
        buttonDivide.setOnClickListener(opListener)
        buttonMultiply.setOnClickListener(opListener)
        buttonMinus.setOnClickListener(opListener)
        buttonPlus.setOnClickListener(opListener)

        buttonNeg.setOnClickListener {
            calculatorViewModel.negPressed()
          
        }

    }



}

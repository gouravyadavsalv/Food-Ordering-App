package com.example.foa

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var pizza: CheckBox? = null
    var coffe: CheckBox? = null
    var burger: CheckBox? = null
    var buttonOrder: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addListenerOnButtonClick()
    }

    fun addListenerOnButtonClick() {
        //Getting instance of CheckBoxes and Button from the activty_main.xml file
        pizza = findViewById<View>(R.id.checkBox) as CheckBox
        coffe = findViewById<View>(R.id.checkBox2) as CheckBox
        burger = findViewById<View>(R.id.checkBox3) as CheckBox
        buttonOrder = findViewById<View>(R.id.button) as Button

        //Applying the Listener on the Button click
        buttonOrder!!.setOnClickListener {
            var totalamount = 0
            val result = StringBuilder()
            result.append("Selected Items:")
            if (pizza!!.isChecked) {
                result.append("\nPizza 100Rs")
                totalamount += 100
            }
            if (coffe!!.isChecked) {
                result.append("\nCoffe 50Rs")
                totalamount += 50
            }
            if (burger!!.isChecked) {
                result.append("\nBurger 120Rs")
                totalamount += 120
            }
            result.append(
                """
                    
                    Total: ${totalamount}Rs
                    """.trimIndent()
            )
            //Displaying the message on the toast
            Toast.makeText(applicationContext, result.toString(), Toast.LENGTH_LONG).show()
        }
    }
}